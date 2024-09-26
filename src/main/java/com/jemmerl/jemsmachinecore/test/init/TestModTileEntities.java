package com.jemmerl.jemsmachinecore.test.init;

import com.jemmerl.jemsmachinecore.JemsMachineCore;
import com.jemmerl.jemsmachinecore.test.tileentity.TestTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TestModTileEntities {

    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, JemsMachineCore.MOD_ID);

    public static RegistryObject<TileEntityType<TestTileEntity>> TEST_TILE_ENTITY =
            TILE_ENTITIES.register("test_tile_entity", () -> TileEntityType.Builder.create(
                    TestTileEntity::new, TestModBlocks.TEST_BLOCK.get()).build(null));


    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}
