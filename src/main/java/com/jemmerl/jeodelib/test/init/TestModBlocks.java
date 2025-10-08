package com.jemmerl.jeodelib.test.init;

import com.jemmerl.jeodelib.JeodeLib;
import com.jemmerl.jeodelib.test.block.TestBlock;
import com.jemmerl.jeodelib.test.block.TestBlock4;
import com.jemmerl.jeodelib.test.block.TestBlock6;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class TestModBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, JeodeLib.MOD_ID);

    public static final RegistryObject<Block> TEST_BLOCK = registerBlock("test_block",
            () -> new TestBlock(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)), ItemGroup.MISC);
    public static final RegistryObject<Block> TEST_BLOCK_4 = registerBlock("four_way_machine_test",
            () -> new TestBlock4(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)), ItemGroup.MISC);
    public static final RegistryObject<Block> TEST_BLOCK_6 = registerBlock("six_way_machine_test",
            () -> new TestBlock6(AbstractBlock.Properties.from(Blocks.IRON_BLOCK)), ItemGroup.MISC);

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, ItemGroup itemGroup) {
        RegistryObject<T> registeredBlock = BLOCKS.register(name, block);
        registerBlockItem(name, registeredBlock, 64, itemGroup);
        return registeredBlock;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, int stackSize, ItemGroup itemGroup) {
        TestModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(itemGroup).maxStackSize(stackSize)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
