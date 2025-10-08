package com.jemmerl.jeodelib.test.block;

import com.jemmerl.jeodelib.machine.block.JMCMachineBlock;
import com.jemmerl.jeodelib.test.tileentity.TestTileTE;

public class TestBlock extends JMCMachineBlock {

    public TestBlock(Properties properties) {
        super(properties, TestTileTE::new);
    }


}
