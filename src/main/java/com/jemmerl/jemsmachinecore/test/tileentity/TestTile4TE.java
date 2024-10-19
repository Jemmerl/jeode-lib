package com.jemmerl.jemsmachinecore.test.tileentity;

import com.jemmerl.jemsmachinecore.core.inventory.JMCSlotHandler;
import com.jemmerl.jemsmachinecore.core.tileentity.BasicMachineTE;
import com.jemmerl.jemsmachinecore.test.init.TestModTileEntities;
import com.jemmerl.jemsmachinecore.test.inventory.container.Test4Container;
import com.jemmerl.jemsmachinecore.test.inventory.container.TestContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntityType;

import javax.annotation.Nullable;
import java.util.*;

public class TestTile4TE extends BasicMachineTE {

    private final int numSlots = 2;

    public TestTile4TE(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn, 2);
        inventoryHandler.addSlot(new JMCSlotHandler(64));
        inventoryHandler.addSlot(new JMCSlotHandler(1, new HashSet<>(Arrays.asList(Items.PUMPKIN_PIE))));
    }

    public TestTile4TE() {
        this(TestModTileEntities.TEST_TILE_4_ENTITY.get());
    }

    @Nullable
    @Override
    public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return new Test4Container(i, world, pos, playerInventory, playerEntity);
    }

    // ADD SLOTS IN THE TE

//    @Override
//    public List<Set<Item>> getSlotValidItems() {
//        return slotValidItems;
//    }
//
//    @Override
//    public int[] getSlotStackLimits() {
//        return slotStackLimits;
//    }

    private List<Set<Item>> buildSlotValidItems() {
        List<Set<Item>> slotValidItems = new ArrayList<>(numSlots);
        for (int i = 0; i < numSlots; i++) {
            slotValidItems.add(new HashSet<>());
        }
        return slotValidItems;
    }

    private int[] buildSlotStackLimits() {
        int[] slotStackLimits = new int[numSlots];
        for (int i = 0; i < numSlots; i++) {
            slotStackLimits[i] = 1;
        }
        return slotStackLimits;
    }

}
