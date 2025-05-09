package cybermods.cyberextras.datagen;

import cybermods.cyberextras.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {


    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
getOrCreateTagBuilder(ItemTags.SWORDS).add(ModItems.EYE_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES).add(ModItems.EYE_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS).add(ModItems.EYE_SHOVEL);
    }
}
