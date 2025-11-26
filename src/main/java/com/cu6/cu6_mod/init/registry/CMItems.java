package com.cu6.cu6_mod.init.registry;

import com.cu6.cu6_mod.Cu6Mod;
import com.cu6.cu6_mod.common.item.MonsterItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CMItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems( Cu6Mod.MOD_ID);

        public static final DeferredItem<Item> monster = ITEMS.register("monster",()-> new MonsterItem(new Item.Properties().stacksTo(2).food(CMFoods.monster)));

    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }
}
