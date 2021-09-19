package com.thepyrogod.blitz.common.capabilities;

import com.thepyrogod.blitz.Blitz;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = Blitz.MOD_ID, bus = Bus.MOD)
public class SpecHandler {
	public static final ResourceLocation SPEC_CAP = new ResourceLocation(Blitz.MOD_ID, "spec");
	
	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.register(ISpec.class);
	}
}
