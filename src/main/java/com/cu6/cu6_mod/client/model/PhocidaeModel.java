package com.cu6.cu6_mod.client.model;

import com.cu6.cu6_mod.client.animation.PhocidaeAnimations;
import com.cu6.cu6_mod.common.entity.PhocidaeEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class PhocidaeModel <T extends PhocidaeEntity> extends HierarchicalModel<T> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("modid", "phocidae"), "main");
	private final ModelPart phocidae;
	private final ModelPart hand;
	private final ModelPart hand1;
	private final ModelPart hand2;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart tail;
	private final ModelPart tail1;
	private final ModelPart tail2;

	public PhocidaeModel(ModelPart root) {
		this.phocidae = root.getChild("phocidae");
		this.hand = this.phocidae.getChild("hand");
		this.hand1 = this.hand.getChild("hand1");
		this.hand2 = this.hand.getChild("hand2");
		this.body = this.phocidae.getChild("body");
		this.head = this.phocidae.getChild("head");
		this.tail = this.phocidae.getChild("tail");
		this.tail1 = this.tail.getChild("tail1");
		this.tail2 = this.tail.getChild("tail2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition phocidae = partdefinition.addOrReplaceChild("phocidae", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -4.0F));

		PartDefinition hand = phocidae.addOrReplaceChild("hand", CubeListBuilder.create(), PartPose.offset(-30.0F, 0.0F, 0.0F));

		PartDefinition hand1 = hand.addOrReplaceChild("hand1", CubeListBuilder.create().texOffs(102, 17).addBox(-1.0F, -1.0F, -8.0F, 10.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(13.0F, -10.0F, 0.0F));

		PartDefinition hand2 = hand.addOrReplaceChild("hand2", CubeListBuilder.create().texOffs(102, 0).addBox(-4.0F, -5.0F, -7.0F, 10.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(50.0F, -6.0F, -1.0F));

		PartDefinition body = phocidae.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -27.0F, -16.0F, 24.0F, 27.0F, 27.0F, new CubeDeformation(0.0F))
		.texOffs(0, 54).addBox(-10.0F, -28.0F, 11.0F, 28.0F, 28.0F, 21.0F, new CubeDeformation(0.0F))
		.texOffs(98, 54).addBox(-7.0F, -23.0F, 32.0F, 22.0F, 23.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head = phocidae.addOrReplaceChild("head", CubeListBuilder.create().texOffs(98, 95).addBox(-4.0F, -20.0F, -30.0F, 16.0F, 16.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tail = phocidae.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(3.0F, 0.0F, 30.0F));

		PartDefinition tail1 = tail.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(102, 34).addBox(3.0F, -9.0F, 20.0F, 7.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tail2 = tail.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(0, 103).addBox(-8.0F, -9.0F, 20.0F, 7.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

    @Override
    public void setupAnim(PhocidaeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);
        this.animateWalk(PhocidaeAnimations.walk, limbSwing, limbSwingAmount, 1f, 2.5f);
        this.animate(entity.idleAnimationState, PhocidaeAnimations.idle, 1f);
    }

    private void applyHeadRotation(float headYaw, float headPitch){
        headYaw = Mth.clamp(headYaw, -20.0F, 20.0F);
        headPitch = Mth.clamp(headPitch, -25.0F, 30.0F);

        this.head.xRot = headPitch * ((float)Math.PI / 180F);
        this.head.yRot = headYaw * ((float)Math.PI / 180F);

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
        phocidae.render(poseStack, buffer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return phocidae;
    }
}