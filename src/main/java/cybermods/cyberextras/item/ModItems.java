package cybermods.cyberextras.item;

import cybermods.cyberextras.Cyberextras;
import cybermods.cyberextras.item.custom.EyePickaxeItem;
import cybermods.cyberextras.item.custom.EyeShovelItem;
import cybermods.cyberextras.item.custom.EyeSwordItem;
import cybermods.cyberextras.util.ModTags;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
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






    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(Cyberextras.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Cyberextras.LOGGER.info("Registering Mod Items for " + Cyberextras.MOD_ID);


    }
}
