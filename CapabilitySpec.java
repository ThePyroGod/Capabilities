package com.thepyrogod.blitz.common.capabilities;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CapabilitySpec {
	
	@CapabilityInject(ISpec.class)
    public static Capability<ISpec> ENERGY = null;

    @SuppressWarnings("removal")
	public static void register()
    {
        CapabilityManager.INSTANCE.register(ISpec.class);
    }
}

