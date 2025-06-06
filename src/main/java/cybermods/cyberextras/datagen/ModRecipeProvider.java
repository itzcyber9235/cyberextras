package cybermods.cyberextras.datagen;

import cybermods.cyberextras.block.ModBlocks;
import cybermods.cyberextras.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;



public class ModRecipeProvider extends FabricRecipeProvider {

    public static final List<ItemConvertible> EYE_SMELTABLES = List.of(ModItems.COMPACTED_EYE_DUST);

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        offerSmelting(exporter, EYE_SMELTABLES, RecipeCategory.MISC,
                ModItems.EYE_INGOT, 0.7f, 200, "eye");

        offerShapelessRecipe(exporter, ModItems.EYE_DUST, Items.ENDER_EYE, "EYE", 2);
        offer2x2CompactingRecipe(exporter, RecipeCategory.MISC, ModItems.COMPACTED_EYE_DUST, ModItems.EYE_DUST);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.EYE_INGOT, RecipeCategory.MISC, ModBlocks.EYE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EYE_SWORD)
                .pattern(" E ")
                .pattern(" E ")
                .pattern(" S ")
                .input('E', ModItems.EYE_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.EYE_INGOT), conditionsFromItem(ModItems.EYE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EYE_PICKAXE)
                .pattern("EEE")
                .pattern(" S ")
                .pattern(" S ")
                .input('E', ModItems.EYE_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.EYE_INGOT), conditionsFromItem(ModItems.EYE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EYE_SHOVEL)
                .pattern(" E ")
                .pattern(" S ")
                .pattern(" S ")
                .input('E', ModItems.EYE_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.EYE_INGOT), conditionsFromItem(ModItems.EYE_INGOT))
                .offerTo(exporter);
    }
}


