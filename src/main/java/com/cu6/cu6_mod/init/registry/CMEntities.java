package com.cu6.cu6_mod.init.registry;

import com.cu6.cu6_mod.Cu6Mod;
import com.cu6.cu6_mod.client.render.entity.PhocidaeRender;
import com.cu6.cu6_mod.common.entity.PhocidaeEntity;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CMEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE,Cu6Mod.MOD_ID);

    public static final Supplier<EntityType<PhocidaeEntity>> PHOCIDAE = ENTITY_TYPES.register("phocidae",
            () -> EntityType.Builder.of(PhocidaeEntity::new, MobCategory.CREATURE)
                    .sized(2f,1.5f)
                    .build("phocidae"));




    public static void register(IEventBus bus){
        ENTITY_TYPES.register(bus);
    }

    @OnlyIn(Dist.CLIENT)
    public static void onClientSetup() {
        EntityRenderers.register(CMEntities.PHOCIDAE.get(), PhocidaeRender::new);
    }

}
