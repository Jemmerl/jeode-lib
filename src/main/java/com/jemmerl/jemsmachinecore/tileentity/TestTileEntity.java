package com.jemmerl.jemsmachinecore.tileentity;

import com.jemmerl.jemsmachinecore.init.JMCTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestTileEntity extends TileEntity {

    private final ItemStackHandler itemStackHandler = createStackHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemStackHandler);

    private final List<Set<Item>> slotValidItems;
    private final int[] slotStackLimits;

    public TestTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);

        int slots = 2;

        slotValidItems = new ArrayList<>(slots);
        for (int i = 0; i < slots; i++) {
            slotValidItems.add(new HashSet<>());
        }

        slotStackLimits = new int[slots];
        for (int i = 0; i < slots; i++) {
            slotStackLimits[i] = 1;
        }
    }

    public TestTileEntity() {
        this(JMCTileEntities.TEST_TILE_ENTITY.get());
    }

    private ItemStackHandler createStackHandler() {
        return new ItemStackHandler(2) {
            @Override
            protected void onContentsChanged(int slot) {
                markDirty();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                Set<Item> validItems = slotValidItems.get(slot);
                return (validItems.isEmpty() || validItems.contains(stack.getItem()));
            }

            @Override
            public int getSlotLimit(int slot) {
                int slotLimit = slotStackLimits[slot];
                return (slotLimit == 0) ? super.getSlotLimit(slot) : slotLimit;
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if (!isItemValid(slot, stack)) {
                    return stack;
                }
                return super.insertItem(slot, stack, simulate);
            }
        };
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
