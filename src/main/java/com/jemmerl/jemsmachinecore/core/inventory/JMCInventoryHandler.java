package com.jemmerl.jemsmachinecore.core.inventory;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.items.IItemHandlerModifiable;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

// Inv. handler that handles collection of slot inv. handlers and IO handlers
// extends ItemStackHandler
public class JMCInventoryHandler implements IItemHandlerModifiable, INBTSerializable<CompoundNBT> {

    private final List<JMCBasicSlotHandler> slots;
    private final IInventoryCallback inventoryCallback;

    public JMCInventoryHandler(int size) {
        slots = new ArrayList<>(size);
        inventoryCallback = null;
    }

    public JMCInventoryHandler(IInventoryCallback inventoryCallback) {
        slots = new ArrayList<>();
        this.inventoryCallback = inventoryCallback;
    }

    public JMCInventoryHandler(IInventoryCallback inventoryCallback, int size) {
        slots = new ArrayList<>(size);
        this.inventoryCallback = inventoryCallback;
    }

    protected void onContentsChanged(int slot) {
        if (inventoryCallback != null) {
            inventoryCallback.markDirty();
        }
    }

    public void addSlot(JMCBasicSlotHandler newSlot) {
        slots.add(newSlot);
    }

    @Override
    public int getSlots() {
        return slots.size();
    }

    public JMCBasicSlotHandler getSlot(int slot) {
        return slots.get(slot);
    }

    @Nonnull
    @Override
    public ItemStack getStackInSlot(int slot) {
        validateSlotIndex(slot);
        return slots.get(slot).getStackInSlot(slot);
    }

    @Override
    public void setStackInSlot(int slot, @Nonnull ItemStack stack) {
        validateSlotIndex(slot);
        slots.get(slot).setItemStack(stack);
        this.onContentsChanged(slot);
    }

    @Nonnull
    @Override
    public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
        validateSlotIndex(slot);
        if (!simulate) {
            onContentsChanged(slot);
        }
        return slots.get(slot).insertItem(slot, stack, simulate);
    }

    @Nonnull
    @Override
    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        validateSlotIndex(slot);
        if (!simulate) {
            onContentsChanged(slot);
        }
        return slots.get(slot).extractItem(slot, amount, simulate);
    }

    @Override
    public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
        validateSlotIndex(slot);
        return slots.get(slot).isItemValid(0, stack);
    }

    @Override
    public int getSlotLimit(int slot) {
        validateSlotIndex(slot);
        return slots.get(slot).getSlotLimit(0);
    }

    private void validateSlotIndex(int slot) {
        if (slot < 0 || slot >= slots.size())
            throw new RuntimeException("Slot " + slot + " not in valid range - [0," + slots.size() + ")");
    }

    public CompoundNBT serializeNBT()
    {
        ListNBT nbtTagList = new ListNBT();
        int size = slots.size();
        for (int i = 0; i < size; i++)
        {
            ItemStack stack = slots.get(i).getStackInSlot(0);
            if (!stack.isEmpty())
            {
                CompoundNBT itemTag = new CompoundNBT();
                itemTag.putInt("Slot", i);
                stack.write(itemTag);
                nbtTagList.add(itemTag);
            }
        }
        CompoundNBT nbt = new CompoundNBT();
        nbt.put("Items", nbtTagList);
        nbt.putInt("Size", size);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt)
    {
        //setSize(nbt.contains("Size", Constants.NBT.TAG_INT) ? nbt.getInt("Size") : slots.size());
        ListNBT tagList = nbt.getList("Items", Constants.NBT.TAG_COMPOUND);
        for (int i = 0; i < tagList.size(); i++)
        {
            CompoundNBT itemTags = tagList.getCompound(i);
            int slot = itemTags.getInt("Slot");

            validateSlotIndex(slot);
            slots.get(slot).setItemStack(ItemStack.read(itemTags));
        }
        //onLoad();
    }
}
