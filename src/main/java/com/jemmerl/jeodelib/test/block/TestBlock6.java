package com.jemmerl.jeodelib.test.block;

import com.jemmerl.jeodelib.machine.block.JMC6WayMachineBlock;
import com.jemmerl.jeodelib.test.tileentity.TestTile6TE;

public class TestBlock6 extends JMC6WayMachineBlock {

    public TestBlock6(Properties properties) {
        super(properties, TestTile6TE::new);
    }


}
