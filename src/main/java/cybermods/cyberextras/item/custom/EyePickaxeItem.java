package cybermods.cyberextras.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class EyePickaxeItem extends PickaxeItem {



    public EyePickaxeItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }



    public static List<BlockPos> BLOCKS_TO_BE_CHECKED(int range, BlockPos initialblockpos, ServerPlayerEntity player) {
        List<BlockPos> positions = new ArrayList<>();
        HitResult hit = player.raycast(20, 0, false);
        int limit = 0;

        if(hit.getType() == HitResult.Type.BLOCK){
            for(int x = -range; x<= range; x++){
                for(int y = -range; y<= range; y++){
                    for(int z = -range; z<= range; z++){
                        BlockState state = player.getWorld().getBlockState(new BlockPos(initialblockpos.getX() + x, initialblockpos.getY() + y, initialblockpos.getZ() + z));


                                positions.add(new BlockPos(initialblockpos.getX() + x, initialblockpos.getY() + y, initialblockpos.getZ() + z));








        }
                    }
                }
            }
        return positions;
        }


    }



