package com.jemmerl.jemsmachinecore.lib.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class JMCTileEntityUtil {

    public static JMCTileEntity getJMCTileEntity(IBlockReader worldIn, BlockPos posIn) {
        TileEntity tileentity = worldIn.getTileEntity(posIn);
        if (tileentity instanceof JMCTileEntity) {
            return (JMCTileEntity) tileentity;
        }
        return null;
    }
}
