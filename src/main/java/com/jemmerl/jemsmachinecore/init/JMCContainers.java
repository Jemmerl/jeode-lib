package com.jemmerl.jemsmachinecore.init;

import com.jemmerl.jemsmachinecore.JemsMachineCore;
import com.jemmerl.jemsmachinecore.inventory.container.TestContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class JMCContainers {

    public static DeferredRegister<ContainerType<?>> CONTAINERS =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, JemsMachineCore.MOD_ID);

    public static final RegistryObject<ContainerType<TestContainer>> TEST_CONTAINER =
            CONTAINERS.register("test_container",
                    () -> IForgeContainerType.create(((windowId, inv, data) -> {
                        BlockPos pos = data.readBlockPos();
                        World world = inv.player.getEntityWorld();
                        return new TestContainer(windowId, world, pos, inv, inv.player);
                    })));

    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }
}
