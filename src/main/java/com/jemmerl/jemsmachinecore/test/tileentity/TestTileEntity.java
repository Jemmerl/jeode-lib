package com.jemmerl.jemsmachinecore.test.tileentity;

import com.jemmerl.jemsmachinecore.core.tileentity.BasicMachineEntity;
import com.jemmerl.jemsmachinecore.lib.inventory.JMCInventoryHandler;
import com.jemmerl.jemsmachinecore.test.init.TestModTileEntities;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestTileEntity extends BasicMachineEntity {

    private final int slots = 2;

    private final JMCInventoryHandler inventoryHandler;

    public TestTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
        this.inventoryHandler = new JMCInventoryHandler(slots);
    }

    public TestTileEntity() {
        this(TestModTileEntities.TEST_TILE_ENTITY.get());
    }

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
        List<Set<Item>> slotValidItems = new ArrayList<>(slots);
        for (int i = 0; i < slots; i++) {
            slotValidItems.add(new HashSet<>());
        }
        return slotValidItems;
    }

    private int[] buildSlotStackLimits() {
        int[] slotStackLimits = new int[slots];
        for (int i = 0; i < slots; i++) {
            slotStackLimits[i] = 1;
        }
        return slotStackLimits;
    }

}
