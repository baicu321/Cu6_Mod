package com.cu6.cu6_mod.init.registry;

import com.cu6.cu6_mod.Cu6Mod;
import com.cu6.cu6_mod.common.block.XunSkullBlock;
import com.cu6.cu6_mod.common.item.MonsterItem;
import com.cu6.cu6_mod.common.item.XunSkullBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CMItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems( Cu6Mod.MOD_ID);

        public static final DeferredItem<Item> monster = ITEMS.register("monster",()-> new MonsterItem(new Item.Properties().stacksTo(2).food(CMFoods.monster)));
        public static final DeferredItem<Item> phocidae_spawn_egg = ITEMS.register("phocidae_spawn_egg",()-> new DeferredSpawnEggItem(CMEntities.PHOCIDAE,0xfffff,0x4e4e4,new Item.Properties()));
        public static final DeferredItem<Item> xun_block_item = ITEMS.register("xun_block_item",
            () -> new XunSkullBlockItem((XunSkullBlock) CMBlocks.xun.get(),
                    new Item.Properties().stacksTo(1)));




    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }
}
