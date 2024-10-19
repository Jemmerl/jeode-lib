package com.jemmerl.jemsmachinecore.test.block;

import com.jemmerl.jemsmachinecore.core.block.JMCMachineBlock;
import com.jemmerl.jemsmachinecore.test.tileentity.TestTileTE;

public class TestBlock extends JMCMachineBlock {

    public TestBlock(Properties properties) {
        super(properties, TestTileTE::new);
    }


}
