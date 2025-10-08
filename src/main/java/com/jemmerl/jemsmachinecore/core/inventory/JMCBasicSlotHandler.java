package com.jemmerl.jemsmachinecore.core.inventory;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;

import javax.annotation.Nonnull;
import java.util.HashSet;
import java.util.Set;

// Individual item handlers for each slot
public class JMCBasicSlotHandler implements IItemHandler {

    @Nonnull
    private ItemStack item = ItemStack.EMPTY;

    private int slotLimit;
    private Set<Item> slotValidItems;

    public JMCBasicSlotHandler(int slotLimit, Set<Item> slotValidItems) {
        this.slotLimit = slotLimit;
        this.slotValidItems = slotValidItems;
    }

    public JMCBasicSlotHandler(Set<Item> slotValidItems) {
        this.slotLimit = 0;
        this.slotValidItems = slotValidItems;
    }

    public JMCBasicSlotHandler(int slotLimit) {
        this.slotLimit = slotLimit;
        this.slotValidItems = new HashSet<>();
    }

    public JMCBasicSlotHandler() {
        this(0);
    }


    @Override
    public int getSlots() {
        return 1; // There is only one slot instance for this item handler
    }

    @Nonnull
    @Override
    public ItemStack getStackInSlot(int slot) {
        return item;
    }

    public void setItemStack(ItemStack stack) {
        item = stack;
    }

    @Override
    public int getSlotLimit(int slot) {
        return (slotLimit > 0) ? slotLimit : item.getMaxStackSize();
    }

    public JMCBasicSlotHandler setSlotLimit(int limit) {
        this.slotLimit = Math.min(1, limit);
        return this;
    }

    @Override
    public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
        return slotValidItems.isEmpty() || slotValidItems.contains(stack.getItem());
    }

    public Set<Item> getSlotValidItems() {
        return slotValidItems;
    }

    public JMCBasicSlotHandler setSlotValidItems(Set<Item> validItems) {
        slotValidItems = validItems;
        return this;
    }

    @Nonnull
    @Override
    public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
        if (stack.isEmpty()) {
            return ItemStack.EMPTY;
        }

        if (!isItemValid(slot, stack)) {
            return stack;
        }

        int limit = getStackLimit(stack);
        if (!item.isEmpty()) {
            if (!ItemHandlerHelper.canItemStacksStack(stack, item)) {
                return stack;
            }
            limit -= item.getCount();
        }

        if (limit <= 0) {
            return stack;
        }

        boolean reachedLimit = stack.getCount() > limit;
        if (!simulate) {
            if (item.isEmpty()) {
                item = reachedLimit ? ItemHandlerHelper.copyStackWithSize(stack, limit) : stack;
            } else {
                item.grow(reachedLimit ? limit : stack.getCount());
            }
            //onContentsChanged(slot);
        }

        return reachedLimit ? ItemHandlerHelper.copyStackWithSize(stack, stack.getCount()- limit) : ItemStack.EMPTY;
    }

    @Nonnull
    @Override
    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        if ((amount == 0) || item.isEmpty()) {
            return ItemStack.EMPTY;
        }

        ItemStack existing = item.copy();
        int toExtract = Math.min(amount, item.getMaxStackSize());
        if (existing.getCount() <= toExtract) {
            if (!simulate) {
                item = ItemStack.EMPTY;
                return existing;
            } else {
                return existing.copy();
            }
        }
        else {
            if (!simulate) {
                item = ItemHandlerHelper.copyStackWithSize(item, item.getCount() - toExtract);
                //onContentsChanged(slot);
            }
            return ItemHandlerHelper.copyStackWithSize(existing, toExtract);
        }
    }

    private int getStackLimit(@Nonnull ItemStack stack) {
        return Math.min(slotLimit, stack.getMaxStackSize());
    }


}
