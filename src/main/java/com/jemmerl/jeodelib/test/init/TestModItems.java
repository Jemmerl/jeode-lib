package com.jemmerl.jeodelib.test.init;

import com.jemmerl.jeodelib.JeodeLib;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TestModItems {
    public static final DeferredRegister<Item> ITEMS
            = DeferredRegister.create(ForgeRegistries.ITEMS, JeodeLib.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}

