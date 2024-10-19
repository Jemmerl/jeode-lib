package com.jemmerl.jemsmachinecore.test.inventory.container;

import com.jemmerl.jemsmachinecore.core.inventory.JMCSlot;
import com.jemmerl.jemsmachinecore.core.inventory.container.BaseContainer;
import com.jemmerl.jemsmachinecore.core.tileentity.BasicMachineTE;
import com.jemmerl.jemsmachinecore.test.init.TestModBlocks;
import com.jemmerl.jemsmachinecore.test.init.TestModContainers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;

public class Test6Container extends BaseContainer {

    private final BasicMachineTE tileEntity;

    public Test6Container(int windowID, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        super(TestModContainers.TEST_6_CONTAINER, windowID, world, pos, playerInventory, playerEntity);

        this.tileEntity = (BasicMachineTE) world.getTileEntity(pos);
        // Build slots from TE
        if (tileEntity != null) {
            tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(itemHandler -> {
                addSlot(new JMCSlot(itemHandler, 0, 80, 31));
                addSlot(new JMCSlot(itemHandler, 1, 80, 53));
            });
        }

    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(worldPosCallable, playerIn, TestModBlocks.TEST_BLOCK_6.get());
    }
}
