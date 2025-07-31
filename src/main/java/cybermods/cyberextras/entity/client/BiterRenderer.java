package cybermods.cyberextras.entity.client;


import cybermods.cyberextras.Cyberextras;
import cybermods.cyberextras.entity.custom.BiterEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class BiterRenderer extends MobEntityRenderer<BiterEntity, BiterModel<BiterEntity>> {


    public BiterRenderer(EntityRendererFactory.Context context) {
        super(context, new BiterModel<>(context.getPart(BiterModel.BITER)), 0.5f);
    }

    @Override
    public Identifier getTexture(BiterEntity entity) {
        return Identifier.of(Cyberextras.MOD_ID, "textures/entity/biter/biter.png");
    }

    @Override
    public void render(BiterEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if (livingEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);


            super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
        }
    }
}
