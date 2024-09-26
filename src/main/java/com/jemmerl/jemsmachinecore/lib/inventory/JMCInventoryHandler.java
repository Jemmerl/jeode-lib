package com.jemmerl.jemsmachinecore.lib.inventory;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class JMCInventoryHandler extends ItemStackHandler {

    private final int size;
    private final List<Set<Item>> slotValidItems;
    private final int[] slotStackLimits;

    public JMCInventoryHandler(int size) {
        super(size);
        this.size = size;
        slotValidItems = new ArrayList<>(size);
        slotStackLimits = new int[size];
    }

    @Override
    protected void onContentsChanged(int slot) {
        ;
    } //markDirty()

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
}
