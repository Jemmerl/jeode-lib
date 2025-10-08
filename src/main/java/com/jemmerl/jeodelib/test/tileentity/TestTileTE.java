package com.jemmerl.jeodelib.test.tileentity;

import com.jemmerl.jeodelib.machine.inventory.JMCBasicSlotHandler;
import com.jemmerl.jeodelib.machine.tileentity.JMCBasicMachineTE;
import com.jemmerl.jeodelib.test.init.TestModTileEntities;
import com.jemmerl.jeodelib.test.inventory.container.TestContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nullable;
import java.util.*;

public class TestTileTE extends JMCBasicMachineTE {

    public TestTileTE(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn, 2);
        inventoryHandler.addSlot(new JMCBasicSlotHandler(64));
        inventoryHandler.addSlot(new JMCBasicSlotHandler(1, new HashSet<>(Arrays.asList(Items.BIRCH_PLANKS))));
    }

    public TestTileTE() {
        this(TestModTileEntities.TEST_TILE_ENTITY.get());
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("tileentity.jmc_test.test_te_1");
    }

    @Nullable
    @Override
    public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return new TestContainer(i, world, pos, playerInventory, playerEntity);
    }

}
