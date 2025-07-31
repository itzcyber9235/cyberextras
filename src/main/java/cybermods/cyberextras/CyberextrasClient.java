package cybermods.cyberextras;

import cybermods.cyberextras.entity.ModEntities;
import cybermods.cyberextras.entity.client.BiterModel;
import cybermods.cyberextras.entity.client.BiterRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class CyberextrasClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityModelLayerRegistry.registerModelLayer(BiterModel.BITER, BiterModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.BITER, BiterRenderer::new);
    }
}
