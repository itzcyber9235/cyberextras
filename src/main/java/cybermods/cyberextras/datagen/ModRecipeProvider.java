package cybermods.cyberextras.datagen;

import cybermods.cyberextras.block.ModBlocks;
import cybermods.cyberextras.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmokingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;



public class ModRecipeProvider extends FabricRecipeProvider {

    public static final List<ItemConvertible> EYE_SMELTABLES = List.of(ModItems.COMPACTED_EYE_DUST);
    public static final List<ItemConvertible> BITER_SMELTABLES = List.of(ModItems.RAW_BITER);

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        offerSmelting(exporter, EYE_SMELTABLES, RecipeCategory.MISC,
                ModItems.EYE_INGOT, 0.7f, 200, "eye");

        offerBlasting(exporter, EYE_SMELTABLES, RecipeCategory.MISC,
                ModItems.EYE_INGOT, 1.0f, 100, "eye");

        offerSmelting(exporter, BITER_SMELTABLES, RecipeCategory.FOOD,
                ModItems.COOKED_BITER, 1.0f, 200, "biter");
        offerFoodCookingRecipe(exporter, "smoking",
                RecipeSerializer.SMOKING, SmokingRecipe::new, 100, ModItems.RAW_BITER, ModItems.COOKED_BITER, 0.2f);

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


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MUSIC_DISC_BLANK)
                .pattern("FFF")
                .pattern("F F")
                .pattern("FFF")
                .input('F', Items.DISC_FRAGMENT_5)
                .criterion(hasItem(Items.DISC_FRAGMENT_5), conditionsFromItem(Items.DISC_FRAGMENT_5))
                .offerTo(exporter);


        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AUDIO_LOG_025_DISC, 1)
                .input(ModItems.MUSIC_DISC_BLANK)
                .input(Items.BLAZE_POWDER)
                .criterion(hasItem(ModItems.MUSIC_DISC_BLANK), conditionsFromItem(ModItems.MUSIC_DISC_BLANK))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MUSIC_DISC_NYAN_CAT, 1)
                .input(ModItems.MUSIC_DISC_BLANK)
                .input(Items.COOKIE)
                .criterion(hasItem(ModItems.MUSIC_DISC_BLANK), conditionsFromItem(ModItems.MUSIC_DISC_BLANK))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MUSIC_DISC_POOL_BROOM, 1)
                .input(ModItems.MUSIC_DISC_BLANK)
                .input(Items.BRUSH)
                .criterion(hasItem(ModItems.MUSIC_DISC_BLANK), conditionsFromItem(ModItems.MUSIC_DISC_BLANK))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MUSIC_DISC_FIRST_CLASS, 1)
                .input(ModItems.MUSIC_DISC_BLANK)
                .input(Items.BOOK)
                .criterion(hasItem(ModItems.MUSIC_DISC_BLANK), conditionsFromItem(ModItems.MUSIC_DISC_BLANK))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MUSIC_DISC_BOUNCY_MUSHROOMS, 1)
                .input(ModItems.MUSIC_DISC_BLANK)
                .input(Items.RED_MUSHROOM)
                .criterion(hasItem(ModItems.MUSIC_DISC_BLANK), conditionsFromItem(ModItems.MUSIC_DISC_BLANK))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MUSIC_DISC_SERIOUS_SILLY, 1)
                .input(ModItems.MUSIC_DISC_BLANK)
                .input(Items.MAGENTA_DYE)
                .criterion(hasItem(ModItems.MUSIC_DISC_BLANK), conditionsFromItem(ModItems.MUSIC_DISC_BLANK))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MUSIC_DISC_DARK_FLAME, 1)
                .input(ModItems.MUSIC_DISC_BLANK)
                .input(Items.SOUL_TORCH)
                .criterion(hasItem(ModItems.MUSIC_DISC_BLANK), conditionsFromItem(ModItems.MUSIC_DISC_BLANK))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MUSIC_DISC_BLANK, 2)
                .input(ModItems.MUSIC_DISC_BLANK)
                .input(Items.ECHO_SHARD)
                .criterion(hasItem(ModItems.MUSIC_DISC_BLANK), conditionsFromItem(ModItems.MUSIC_DISC_BLANK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.MUSIC_DISC_BLANK) + "_duplicator"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BITER_BUCKET, 1)
                .input(ModItems.RAW_BITER)
                .input(Items.WATER_BUCKET)
                .criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.COD_BUCKET, 1)
                .input(Items.COD)
                .input(Items.WATER_BUCKET)
                .criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SALMON_BUCKET, 1)
                .input(Items.SALMON)
                .input(Items.WATER_BUCKET)
                .criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.PUFFERFISH_BUCKET, 1)
                .input(Items.PUFFERFISH)
                .input(Items.WATER_BUCKET)
                .criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET))
                .offerTo(exporter);
    }
}


