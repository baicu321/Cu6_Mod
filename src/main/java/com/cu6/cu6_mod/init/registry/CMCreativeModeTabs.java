package com.cu6.cu6_mod.init.registry;

import com.cu6.cu6_mod.Cu6Mod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CMCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Cu6Mod.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVE_TAB = TABS.register("cu6_group", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.tab.cu6"))
            .icon(() -> CMItems.monster.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(CMItems.monster.get());

            })
            .build());
    public static void register(IEventBus bus){
        TABS.register(bus);
    }
}
