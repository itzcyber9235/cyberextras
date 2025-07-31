package cybermods.cyberextras.block;

import cybermods.cyberextras.Cyberextras;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

public static final Block EYE_BLOCK = registerBlock("eye_block",
       new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.SCULK)));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Cyberextras.MOD_ID, name)
        ,block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, Identifier.of(Cyberextras.MOD_ID, name)
        , new BlockItem(block, new Item.Settings()));


    }

    public static void registerModBlocks(){
        Cyberextras.LOGGER.info("registering mod blocks for "+ Cyberextras.MOD_ID);
    }
}
