package com.cu6.cu6_mod.common.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class BatItem extends Item {
    public BatItem(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable EquipmentSlot getEquipmentSlot(ItemStack stack) {
        return EquipmentSlot.HEAD;
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlot armorType, LivingEntity entity) {
        return EquipmentSlot.HEAD.isArmor();
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        var itemstack = player.getItemInHand(usedHand);
            player.playSound(SoundEvents.BAT_HURT,1,1);
            player.heal(2.0f);
            player.getCooldowns().addCooldown(itemstack.getItem(), 100);
            return InteractionResultHolder.success(itemstack);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {

        if (!level.isClientSide && entity instanceof Player player) {
            ItemStack headItem = player.getItemBySlot(EquipmentSlot.HEAD);

            if (headItem == stack) {

                if (level.getGameTime() % 100 == 0) {

                    if (player.getHealth() > 2.0F) {
                        player.hurt(player.damageSources().magic(), 1.0F);
                    }

                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 120, 1));
                }
            }
        }

        super.inventoryTick(stack, level, entity, slotId, isSelected);
    }
}
