package com.thepyrogod.blitz.common.capabilities;

public interface ISpec
{
    int receiveEnergy(int maxReceive, boolean simulate);
    
    int extractEnergy(int maxExtract, boolean simulate);
    
    int getEnergyStored();

    int getMaxEnergyStored();

    boolean canExtract();

    boolean canReceive();
}
