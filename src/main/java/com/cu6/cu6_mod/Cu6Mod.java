package com.cu6.cu6_mod;


import com.cu6.cu6_mod.init.registry.CMBlocks;
import com.cu6.cu6_mod.init.registry.CMCreativeModeTabs;
import com.cu6.cu6_mod.init.registry.CMEntities;
import com.cu6.cu6_mod.init.registry.CMItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;


@Mod(Cu6Mod.MOD_ID)
public class Cu6Mod {

    public static final String MOD_ID = "cu6_mod";

    public Cu6Mod(IEventBus bus) {
        CMItems.register(bus);
        CMCreativeModeTabs.register(bus);
        CMEntities.register(bus);
        CMBlocks.register(bus);
    }


}
