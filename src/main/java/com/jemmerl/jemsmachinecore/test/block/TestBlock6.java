package com.jemmerl.jemsmachinecore.test.block;

import com.jemmerl.jemsmachinecore.core.block.JMC4WayMachineBlock;
import com.jemmerl.jemsmachinecore.core.block.JMC6WayMachineBlock;
import com.jemmerl.jemsmachinecore.core.block.JMCMachineBlock;
import com.jemmerl.jemsmachinecore.test.tileentity.TestTile6TE;
import com.jemmerl.jemsmachinecore.test.tileentity.TestTileTE;

public class TestBlock6 extends JMC6WayMachineBlock {

    public TestBlock6(Properties properties) {
        super(properties, TestTile6TE::new);
    }


}
