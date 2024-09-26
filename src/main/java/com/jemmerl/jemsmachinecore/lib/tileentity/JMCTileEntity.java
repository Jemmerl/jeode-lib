package com.jemmerl.jemsmachinecore.lib.tileentity;

import com.jemmerl.jemsmachinecore.lib.inventory.JMCInventoryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

public class JMCTileEntity extends TileEntity {

    private final ItemStackHandler itemStackHandler = getItemStackHandler(2);
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemStackHandler);

    public JMCTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    private ItemStackHandler getItemStackHandler(int size) {
        return new JMCInventoryHandler(size);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return handler.cast();
        return super.getCapability(cap);
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        itemStackHandler.deserializeNBT(nbt.getCompound("inv"));
        super.read(state, nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("inv", itemStackHandler.serializeNBT());
        return super.write(compound);
    }
}
