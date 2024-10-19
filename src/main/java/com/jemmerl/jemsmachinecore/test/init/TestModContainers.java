package com.jemmerl.jemsmachinecore.test.init;

import com.jemmerl.jemsmachinecore.JemsMachineCore;
import com.jemmerl.jemsmachinecore.test.inventory.container.Test4Container;
import com.jemmerl.jemsmachinecore.test.inventory.container.Test6Container;
import com.jemmerl.jemsmachinecore.test.inventory.container.TestContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TestModContainers {

    public static DeferredRegister<ContainerType<?>> CONTAINERS =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, JemsMachineCore.MOD_ID);

    public static final RegistryObject<ContainerType<TestContainer>> TEST_CONTAINER =
            CONTAINERS.register("test_container",
                    () -> IForgeContainerType.create(((windowId, inv, data) -> {
                        BlockPos pos = data.readBlockPos();
                        World world = inv.player.getEntityWorld();
                        return new TestContainer(windowId, world, pos, inv, inv.player);
                    })));

    public static final RegistryObject<ContainerType<Test4Container>> TEST_4_CONTAINER =
            CONTAINERS.register("test_4_container",
                    () -> IForgeContainerType.create(((windowId, inv, data) -> {
                        BlockPos pos = data.readBlockPos();
                        World world = inv.player.getEntityWorld();
                        return new Test4Container(windowId, world, pos, inv, inv.player);
                    })));

    public static final RegistryObject<ContainerType<Test6Container>> TEST_6_CONTAINER =
            CONTAINERS.register("test_6_container",
                    () -> IForgeContainerType.create(((windowId, inv, data) -> {
                        BlockPos pos = data.readBlockPos();
                        World world = inv.player.getEntityWorld();
                        return new Test6Container(windowId, world, pos, inv, inv.player);
                    })));

    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }
}
