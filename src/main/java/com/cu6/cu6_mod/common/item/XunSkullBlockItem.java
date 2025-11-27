package com.cu6.cu6_mod.common.item;

import com.cu6.cu6_mod.common.block.XunSkullBlock;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Equipable;

public class XunSkullBlockItem extends BlockItem implements Equipable {
    public XunSkullBlockItem(XunSkullBlock block, Properties properties) {
        super(block, properties);
    }

    @Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }

}
