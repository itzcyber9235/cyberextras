package cybermods.cyberextras.item;

import cybermods.cyberextras.Cyberextras;
import cybermods.cyberextras.entity.ModEntities;
import cybermods.cyberextras.item.custom.EyePickaxeItem;
import cybermods.cyberextras.item.custom.EyeShovelItem;
import cybermods.cyberextras.item.custom.EyeSwordItem;
import cybermods.cyberextras.sound.ModSounds;
import cybermods.cyberextras.util.ModTags;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item EYE_DUST = registerItem("eye_dust", new Item(new Item.Settings()));

    public static final Item COMPACTED_EYE_DUST = registerItem("compacted_eye_dust", new Item(new Item.Settings()));

    public static final Item EYE_INGOT = registerItem("eye_ingot", new Item(new Item.Settings()));

    public static final Item EYE_SWORD = registerItem("eye_sword", new EyeSwordItem(ModToolMaterials.EYE_MATERIAL, new Item.Settings()
            .attributeModifiers(EyeSwordItem.createAttributeModifiers(ModToolMaterials.EYE_MATERIAL, 3, -2.4f))));
    public static final Item EYE_PICKAXE = registerItem("eye_pickaxe", new EyePickaxeItem(ModToolMaterials.EYE_MATERIAL, new Item.Settings()
            .attributeModifiers(EyePickaxeItem.createAttributeModifiers(ModToolMaterials.EYE_MATERIAL, 1, -2.8f))));
    public static final Item EYE_SHOVEL = registerItem("eye_shovel", new EyeShovelItem(ModToolMaterials.EYE_MATERIAL, new Item.Settings()
            .attributeModifiers(EyeShovelItem.createAttributeModifiers(ModToolMaterials.EYE_MATERIAL, 1, -2.8f))));


    public static final Item AUDIO_LOG_025_DISC = registerItem("audio_log_025_disc",
            new Item(new Item.Settings().jukeboxPlayable(ModSounds.AUDIO_LOG_025_KEY).maxCount(1)));
    public static final Item MUSIC_DISC_NYAN_CAT = registerItem("music_disc_nyan_cat",
            new Item(new Item.Settings().jukeboxPlayable(ModSounds.NYAN_CAT_KEY).maxCount(1)));
    public static final Item MUSIC_DISC_POOL_BROOM = registerItem("music_disc_pool_broom",
            new Item(new Item.Settings().jukeboxPlayable(ModSounds.POOL_BROOM_KEY).maxCount(1)));
    public static final Item MUSIC_DISC_FIRST_CLASS = registerItem("music_disc_first_class",
            new Item(new Item.Settings().jukeboxPlayable(ModSounds.FIRST_CLASS_KEY).maxCount(1)));
    public static final Item MUSIC_DISC_BOUNCY_MUSHROOMS = registerItem("music_disc_bouncy_mushrooms",
            new Item(new Item.Settings().jukeboxPlayable(ModSounds.BOUNCY_MUSHROOMS_KEY).maxCount(1)));
    public static final Item MUSIC_DISC_SERIOUS_SILLY = registerItem("music_disc_serious_silly",
            new Item(new Item.Settings().jukeboxPlayable(ModSounds.SERIOUS_SILLY_KEY).maxCount(1)));
    public static final Item MUSIC_DISC_DARK_FLAME = registerItem("music_disc_dark_flame",
            new Item(new Item.Settings().jukeboxPlayable(ModSounds.DARK_FLAME_KEY).maxCount(1)));

    public static final Item MUSIC_DISC_BLANK = registerItem("music_disc_blank", new Item(new Item.Settings()));


    public static final Item BITER_BUCKET = registerItem("biter_bucket", new EntityBucketItem(ModEntities.BITER, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new Item.Settings().maxCount(1)));

    public static final Item BITER_SPAWN_EGG = registerItem("biter_spawn_egg", new SpawnEggItem(ModEntities.BITER, 0xafeeee, 0xf80000, new Item.Settings()));

    public static final Item RAW_BITER = registerItem("raw_biter", new Item(new Item.Settings().food(ModfoodComponents.RAW_BITER)));
    public static final Item COOKED_BITER = registerItem("cooked_biter", new Item(new Item.Settings().food(ModfoodComponents.COOKED_BITER)));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(Cyberextras.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Cyberextras.LOGGER.info("Registering Mod Items for " + Cyberextras.MOD_ID);


    }
}
