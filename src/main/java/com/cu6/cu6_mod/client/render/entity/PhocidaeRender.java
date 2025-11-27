package com.cu6.cu6_mod.client.render.entity;

import com.cu6.cu6_mod.Cu6Mod;
import com.cu6.cu6_mod.client.model.PhocidaeModel;
import com.cu6.cu6_mod.common.entity.PhocidaeEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PhocidaeRender extends MobRenderer<PhocidaeEntity, PhocidaeModel<PhocidaeEntity>> {
    public PhocidaeRender(EntityRendererProvider.Context context) {
        super(context,new PhocidaeModel<>(context.bakeLayer(PhocidaeModel.LAYER_LOCATION)), 1.0f);
    }

    @Override
    public ResourceLocation getTextureLocation(PhocidaeEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(Cu6Mod.MOD_ID, "textures/entity/phocidae.png");
    }

    @Override
    public void render(PhocidaeEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if (entity.isBaby()){
            poseStack.scale(0.5f,0.5f,0.5f);
        }else {
            poseStack.scale(1f,1f,1f);
        }
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
