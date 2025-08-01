package cybermods.cyberextras.datagen;

import cybermods.cyberextras.block.ModBlocks;
import cybermods.cyberextras.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.util.Identifier;

import java.util.Optional;

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
        itemModelGenerator.register(ModItems.MUSIC_DISC_BLANK, Models.GENERATED);
        itemModelGenerator.register(ModItems.BITER_BUCKET, Models.GENERATED);

        itemModelGenerator.register(ModItems.RAW_BITER, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_BITER, Models.GENERATED);


        itemModelGenerator.register(ModItems.AUDIO_LOG_025_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUSIC_DISC_NYAN_CAT, Models.GENERATED);

        itemModelGenerator.register(ModItems.BITER_SPAWN_EGG
        , new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
    }
}
