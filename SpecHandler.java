package com.thepyrogod.blitz.common.capabilities;

import com.thepyrogod.blitz.Blitz;

import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class SpecHandler {
	public static final ResourceLocation SPEC_CAP = new ResourceLocation(Blitz.MOD_ID, "spec");
	
	@SubscribeEvent
	public void onAttachingCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if(!(event.getObject() instanceof Entity)) return;
		
		event.addCapability(SPEC_CAP, (ICapabilityProvider) new Spec(100));
	}
	
	@SubscribeEvent
	public void attachCapability(final AttachCapabilitiesEvent<Entity> event) {
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
}
