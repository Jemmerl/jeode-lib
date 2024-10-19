package com.jemmerl.jemsmachinecore.test.init;

import com.jemmerl.jemsmachinecore.JemsMachineCore;
import com.jemmerl.jemsmachinecore.test.tileentity.TestTile4TE;
import com.jemmerl.jemsmachinecore.test.tileentity.TestTile6TE;
import com.jemmerl.jemsmachinecore.test.tileentity.TestTileTE;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TestModTileEntities {

    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, JemsMachineCore.MOD_ID);

    public static RegistryObject<TileEntityType<TestTileTE>> TEST_TILE_ENTITY =
            TILE_ENTITIES.register("test_tile_entity", () -> TileEntityType.Builder.create(
                    TestTileTE::new, TestModBlocks.TEST_BLOCK.get()).build(null));

    public static RegistryObject<TileEntityType<TestTile4TE>> TEST_TILE_4_ENTITY =
            TILE_ENTITIES.register("test_tile_4_entity", () -> TileEntityType.Builder.create(
                    TestTile4TE::new, TestModBlocks.TEST_BLOCK_4.get()).build(null));

    public static RegistryObject<TileEntityType<TestTile6TE>> TEST_TILE_6_ENTITY =
            TILE_ENTITIES.register("test_tile_6_entity", () -> TileEntityType.Builder.create(
                    TestTile6TE::new, TestModBlocks.TEST_BLOCK_6.get()).build(null));


    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}
