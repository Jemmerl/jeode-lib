package com.jemmerl.jemsmachinecore.test.inventory.container;

import com.jemmerl.jemsmachinecore.core.inventory.JMCSlot;
import com.jemmerl.jemsmachinecore.core.inventory.container.BaseContainer;
import com.jemmerl.jemsmachinecore.core.tileentity.BasicMachineEntity;
import com.jemmerl.jemsmachinecore.test.init.TestModContainers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;

public class TestContainer extends BaseContainer {

    private final BasicMachineEntity tileEntity;

    public TestContainer(int windowID, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        super(TestModContainers.TEST_CONTAINER, windowID, world, pos, playerInventory, playerEntity);

        this.tileEntity = (BasicMachineEntity) world.getTileEntity(pos);
        // Build slots from TE
        if (tileEntity != null) {
            tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(itemHandler -> {
                addSlot(new JMCSlot(itemHandler, 0, 80, 31));
                addSlot(new JMCSlot(itemHandler, 1, 80, 53));
            });
        }

    }


}
