package com.cu6.cu6_mod.init.registry;

import com.cu6.cu6_mod.Cu6Mod;
import com.cu6.cu6_mod.common.block.XunSkullBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CMBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Cu6Mod.MOD_ID);

    public static final DeferredBlock<Block> xun = itemBlock("xun",
            ()-> new XunSkullBlock(BlockBehaviour.Properties.of()));

    private static <T extends Block> DeferredBlock<T> itemBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        itemBlock(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void itemBlock(String name, DeferredBlock<T> block){
        CMItems.ITEMS.register(name,()-> new BlockItem(block.get(),new Item.Properties()));
    }
    public static void register(IEventBus bus){
        BLOCKS.register(bus);
    }
}
