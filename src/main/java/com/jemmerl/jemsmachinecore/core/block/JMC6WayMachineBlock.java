package com.jemmerl.jemsmachinecore.core.block;

import com.jemmerl.jemsmachinecore.core.tileentity.JMCTileEntity;
import com.jemmerl.jemsmachinecore.core.util.blockprops.ActiveStatus;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class JMC6WayMachineBlock extends JMCMachineBlock{

    public static final DirectionProperty FACING = BlockStateProperties.FACING;

    public JMC6WayMachineBlock(Properties properties, Supplier<? extends JMCTileEntity> teSupplier) {
        super(properties, teSupplier);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));

    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(STATUS, ActiveStatus.ON).with(FACING, context.getNearestLookingDirection().getOpposite());
    }

}
