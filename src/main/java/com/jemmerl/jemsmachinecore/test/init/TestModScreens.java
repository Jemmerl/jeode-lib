package com.jemmerl.jemsmachinecore.test.init;

import com.jemmerl.jemsmachinecore.test.client.gui.screen.Test4Screen;
import com.jemmerl.jemsmachinecore.test.client.gui.screen.Test6Screen;
import com.jemmerl.jemsmachinecore.test.client.gui.screen.TestScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@OnlyIn(Dist.CLIENT)
public class TestModScreens {
    public static void registerScreens(final FMLClientSetupEvent event) {
        ScreenManager.registerFactory(TestModContainers.TEST_CONTAINER.get(), TestScreen::new);
        ScreenManager.registerFactory(TestModContainers.TEST_4_CONTAINER.get(), Test4Screen::new);
        ScreenManager.registerFactory(TestModContainers.TEST_6_CONTAINER.get(), Test6Screen::new);
    }
}
