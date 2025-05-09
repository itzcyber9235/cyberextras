package cybermods.cyberextras.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.List;

public class EyeShovelItem extends ShovelItem {
    public EyeShovelItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    public static List<BlockPos> BLOCKS_TO_BE_HARVESTED(int range, BlockPos initialblockpos, ServerPlayerEntity player) {
        List<BlockPos> positions = new ArrayList<>();
        HitResult hit = player.raycast(20, 0, false);

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


