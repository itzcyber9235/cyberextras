package cybermods.cyberextras.item;

import cybermods.cyberextras.Cyberextras;
import cybermods.cyberextras.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup EYE_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Cyberextras.MOD_ID,"eye_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.EYE_INGOT))
                    .displayName(Text.translatable("itemgroup.cyberextras.eye_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.EYE_SWORD);
                        entries.add(ModItems.EYE_PICKAXE);
                        entries.add(ModItems.EYE_SHOVEL);
                        entries.add(ModItems.EYE_DUST);
                        entries.add(ModItems.COMPACTED_EYE_DUST);
                        entries.add(ModItems.EYE_INGOT);
                        entries.add(ModBlocks.EYE_BLOCK);
                    })


                    .build());

    public static final ItemGroup CUSTOM_DISCS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Cyberextras.MOD_ID,"custom_discs"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.MUSIC_DISC_BLANK))
                    .displayName(Text.translatable("itemgroup.cyberextras.custom_discs"))
                    .entries((displayContext, entries) -> {
                    entries.add(ModItems.MUSIC_DISC_BLANK);
                    entries.add(ModItems.AUDIO_LOG_025_DISC);
                    entries.add(ModItems.MUSIC_DISC_NYAN_CAT);
                    }).build());

    public static final ItemGroup THE_DEEP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Cyberextras.MOD_ID,"the_deep"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BITER_SPAWN_EGG))
                    .displayName(Text.translatable("itemgroup.cyberextras.the_deep"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.BITER_SPAWN_EGG);
                    }).build());

    public static void registerItemGroups(){
        Cyberextras.LOGGER.info("Registering Item Groups for " + Cyberextras.MOD_ID);

    }
}
