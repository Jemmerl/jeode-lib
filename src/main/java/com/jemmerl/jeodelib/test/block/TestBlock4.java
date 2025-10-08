package com.jemmerl.jeodelib.test.block;

import com.jemmerl.jeodelib.machine.block.JMC4WayMachineBlock;
import com.jemmerl.jeodelib.test.tileentity.TestTile4TE;

public class TestBlock4 extends JMC4WayMachineBlock {

    public TestBlock4(Properties properties) {
        super(properties, TestTile4TE::new);
    }


}
