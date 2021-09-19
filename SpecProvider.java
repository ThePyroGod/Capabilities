package com.thepyrogod.blitz.common.capabilities;

import com.thepyrogod.blitz.Blitz;

import net.minecraft.core.Direction;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = Blitz.MOD_ID, bus = Bus.FORGE)
public class SpecProvider implements ICapabilitySerializable<Tag>{

public static final ResourceLocation SPEC_CAP = new ResourceLocation(Blitz.MOD_ID, "spec");
	
	@SubscribeEvent
	public static void attachCapability(final AttachCapabilitiesEvent<Entity> event) {
	    if (!(event.getObject() instanceof Player)) return;

	    Spec backend = new Spec(100);
	    LazyOptional<ISpec> optionalStorage = LazyOptional.of(() -> backend);

	    ICapabilityProvider provider = new ICapabilityProvider() {

			@Override
			public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
				if (cap == CapabilitySpec.ENERGY) {
	                return optionalStorage.cast();
	            }
	            return LazyOptional.empty();
			}
	    };

	    event.addCapability(SPEC_CAP, provider);
	    event.addListener(optionalStorage::invalidate);
	}

	@Override
	public Tag serializeNBT() {
		if(CapabilitySpec.ENERGY == null)
			return null;
		else
			return (Tag) CapabilitySpec.ENERGY;
	}

	@Override
	public void deserializeNBT(Tag nbt) {
	}

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		return null;
	}
}
