package cybermods.cyberextras.datagen;

import cybermods.cyberextras.block.ModBlocks;
import cybermods.cyberextras.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator){

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.EYE_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator){
        itemModelGenerator.register(ModItems.EYE_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMPACTED_EYE_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.EYE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.EYE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EYE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EYE_SHOVEL, Models.HANDHELD);
    }
}
