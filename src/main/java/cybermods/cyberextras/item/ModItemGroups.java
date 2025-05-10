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

    public static ItemGroup NANABA_PLAYTIME = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Cyberextras.MOD_ID,"cyber_extras"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.EYE_INGOT))
                    .displayName(Text.translatable("itemgroup.cyberextras.cyber_extras"))
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

    public static void registerItemGroups(){
        Cyberextras.LOGGER.info("Registering Item Groups for " + Cyberextras.MOD_ID);

    }
}
