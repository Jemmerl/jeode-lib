package com.jemmerl.jemsmachinecore.core.inventory;

import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class JMCOutputSlotHandler extends JMCBasicSlotHandler {

    public JMCOutputSlotHandler(int slotLimit) {
        super(slotLimit);
    }

    @Override
    public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
        return false;
    }
}
