package cybermods.cyberextras.util;

import cybermods.cyberextras.Cyberextras;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {

        public static class Blocks{

            public static final TagKey<Block> NEEDS_EYE_TOOL = createTag("needs_eye_tool");
            public static final TagKey<Block> INCORRECT_FOR_EYE_TOOL = createTag("incorrect_for_eye_tool");

            private static TagKey<Block> createTag(String name){
                return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Cyberextras.MOD_ID, name));

            }

        }


        public static class Items{

            private static TagKey<Item> createTag(String name){
                return TagKey.of(RegistryKeys.ITEM, Identifier.of(Cyberextras.MOD_ID, name));


        }



    }

}
