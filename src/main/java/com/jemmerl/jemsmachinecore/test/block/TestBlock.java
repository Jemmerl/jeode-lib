package com.jemmerl.jemsmachinecore.test.block;

import com.jemmerl.jemsmachinecore.lib.block.JMCMachineBlock;
import com.jemmerl.jemsmachinecore.test.init.TestModTileEntities;
import com.jemmerl.jemsmachinecore.test.tileentity.TestTileEntity;

public class TestBlock extends JMCMachineBlock {

    public TestBlock(Properties properties) {
        super(properties, TestTileEntity::new);
    }


}
