package cybermods.cyberextras.entity.client;

import cybermods.cyberextras.Cyberextras;
import cybermods.cyberextras.entity.custom.BiterEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class BiterModel<T extends BiterEntity> extends SinglePartEntityModel<T> {
    private final ModelPart Fish;
    private final ModelPart head;

    public static final EntityModelLayer BITER = new EntityModelLayer(Identifier.of(Cyberextras.MOD_ID, "biter"), "main");


    public BiterModel(ModelPart root) {
        this.Fish = root.getChild("Fish");
        this.head = this.Fish.getChild("head");

    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData Fish = modelPartData.addChild("Fish", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData head = Fish.addChild("head", ModelPartBuilder.create().uv(12, 17).cuboid(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(18, 3).cuboid(0.0F, 0.0F, -3.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(18, 0).cuboid(-2.0F, 0.0F, -3.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, -1.0F, -6.0F));

        ModelPartData Nothead = Fish.addChild("Nothead", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, -1.0F, -5.0F));

        ModelPartData body1 = Nothead.addChild("body1", ModelPartBuilder.create().uv(12, 10).cuboid(-2.0F, -2.0F, 1.0F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -1.0F));

        ModelPartData body2 = Nothead.addChild("body2", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -2.0F, 4.0F, 3.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -1.0F));

        ModelPartData tail = Nothead.addChild("tail", ModelPartBuilder.create().uv(0, 10).cuboid(0.0F, -3.0F, -1.0F, 1.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 1.0F, 10.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }
    @Override
    public void setAngles(BiterEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(BiterAnimations.ANIM_BITER_SWIM, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, BiterAnimations.ANIM_BITER_IDLE, ageInTicks, 1f);

    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        Fish.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return Fish;
    }
}
