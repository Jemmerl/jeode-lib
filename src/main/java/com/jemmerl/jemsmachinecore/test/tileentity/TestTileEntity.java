package com.jemmerl.jemsmachinecore.test.tileentity;

import com.jemmerl.jemsmachinecore.core.inventory.JMCSlotHandler;
import com.jemmerl.jemsmachinecore.core.tileentity.BasicMachineEntity;
import com.jemmerl.jemsmachinecore.test.init.TestModTileEntities;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntityType;

import java.util.*;

public class TestTileEntity extends BasicMachineEntity {

    private final int numSlots = 2;

    public TestTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn, 2);
        inventoryHandler.addSlot(new JMCSlotHandler(64));
        inventoryHandler.addSlot(new JMCSlotHandler(1, new HashSet<>(Arrays.asList(Items.BIRCH_PLANKS))));
    }

    public TestTileEntity() {
        this(TestModTileEntities.TEST_TILE_ENTITY.get());
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
