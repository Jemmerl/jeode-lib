package com.jemmerl.jeodelib.machine.block;

import com.jemmerl.jeodelib.machine.tileentity.JMCTileEntity;
import com.jemmerl.jeodelib.machine.tileentity.JMCTileEntityUtil;
import com.jemmerl.jeodelib.machine.util.blockprops.ActiveStatus;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class JMCMachineBlock extends JMCBasicBlock {

    public static final EnumProperty<ActiveStatus> STATUS = EnumProperty.create("status", ActiveStatus.class);

    private final Supplier<? extends JMCTileEntity> teSupplier;

    public JMCMachineBlock(Properties properties, Supplier<? extends JMCTileEntity> teSupplier) {
        super(properties);
        this.teSupplier = teSupplier;
        this.setDefaultState(this.stateContainer.getBaseState().with(STATUS, ActiveStatus.ON));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(STATUS);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(STATUS, ActiveStatus.ON);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote()) {
            if (!player.isCrouching()) {
                JMCTileEntity tileEntity = JMCTileEntityUtil.getJMCTileEntity(worldIn, pos);
                if (tileEntity != null) {
                    NetworkHooks.openGui(((ServerPlayerEntity) player), (INamedContainerProvider) tileEntity, tileEntity.getPos());
                } else {
                    throw new IllegalStateException("error teehee");
                }
            } else {

            }

        }
        return ActionResultType.SUCCESS;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return teSupplier.get();
    }

}
