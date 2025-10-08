package com.jemmerl.jeodelib.machine.tileentity;

import com.jemmerl.jeodelib.machine.inventory.JMCInventoryHandler;
import com.jemmerl.jeodelib.machine.inventory.IInventoryCallback;
import net.minecraft.block.BlockState;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nonnull;

public abstract class JMCTileEntity extends TileEntity implements IInventoryCallback, INamedContainerProvider {

    protected JMCInventoryHandler inventoryHandler;
    private LazyOptional<IItemHandler> invHandlerCap = LazyOptional.empty();

    public JMCTileEntity(TileEntityType<?> tileEntityTypeIn, int size) {
        super(tileEntityTypeIn);
        inventoryHandler = getItemStackHandler(size);
    }

    private JMCInventoryHandler getItemStackHandler(int size) {
        return new JMCInventoryHandler(this, size);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            //IItemHandler handler = inventoryHandler.getHandler(side);
            invHandlerCap = LazyOptional.of(() -> inventoryHandler);
            return invHandlerCap.cast();
        }
        return super.getCapability(cap);
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        inventoryHandler.deserializeNBT(nbt.getCompound("inv"));
        super.read(state, nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("inv", inventoryHandler.serializeNBT());
        return super.write(compound);
    }
}
