package com.jemmerl.jemsmachinecore.test.tileentity;

import com.jemmerl.jemsmachinecore.core.inventory.JMCBasicSlotHandler;
import com.jemmerl.jemsmachinecore.core.tileentity.JMCBasicMachineTE;
import com.jemmerl.jemsmachinecore.test.init.TestModTileEntities;
import com.jemmerl.jemsmachinecore.test.inventory.container.Test6Container;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nullable;
import java.util.*;

public class TestTile6TE extends JMCBasicMachineTE {

    public TestTile6TE(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn, 2);
        inventoryHandler.addSlot(new JMCBasicSlotHandler(60));
        inventoryHandler.addSlot(new JMCBasicSlotHandler(1, new HashSet<>(Arrays.asList(Items.GRASS_BLOCK))));
    }

    public TestTile6TE() {
        this(TestModTileEntities.TEST_TILE_6_ENTITY.get());
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("tileentity.jmc_test.test_te_rot6");
    }

    @Nullable
    @Override
    public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return new Test6Container(i, world, pos, playerInventory, playerEntity);
    }

}
