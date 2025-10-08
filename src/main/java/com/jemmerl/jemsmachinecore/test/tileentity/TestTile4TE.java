package com.jemmerl.jemsmachinecore.test.tileentity;

import com.jemmerl.jemsmachinecore.core.inventory.JMCBasicSlotHandler;
import com.jemmerl.jemsmachinecore.core.inventory.JMCOutputSlotHandler;
import com.jemmerl.jemsmachinecore.core.tileentity.JMCBasicMachineTE;
import com.jemmerl.jemsmachinecore.test.init.TestModTileEntities;
import com.jemmerl.jemsmachinecore.test.inventory.container.Test4Container;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nullable;

public class TestTile4TE extends JMCBasicMachineTE {

    public TestTile4TE(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn, 2);
        inventoryHandler.addSlot(new JMCBasicSlotHandler(64));
        inventoryHandler.addSlot(new JMCOutputSlotHandler(64));
    }

    public TestTile4TE() {
        this(TestModTileEntities.TEST_TILE_4_ENTITY.get());
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("tileentity.jmc_test.test_te_rot4");
    }

    @Nullable
    @Override
    public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return new Test4Container(i, world, pos, playerInventory, playerEntity);
    }

}
