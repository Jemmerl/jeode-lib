package com.jemmerl.jemsmachinecore.test.block;

import com.jemmerl.jemsmachinecore.core.block.JMC4WayMachineBlock;
import com.jemmerl.jemsmachinecore.core.block.JMCMachineBlock;
import com.jemmerl.jemsmachinecore.test.tileentity.TestTile4TE;
import com.jemmerl.jemsmachinecore.test.tileentity.TestTileTE;

public class TestBlock4 extends JMC4WayMachineBlock {

    public TestBlock4(Properties properties) {
        super(properties, TestTile4TE::new);
    }


}
