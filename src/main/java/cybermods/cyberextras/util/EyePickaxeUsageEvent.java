package cybermods.cyberextras.util;


import cybermods.cyberextras.Cyberextras;
import cybermods.cyberextras.item.custom.EyePickaxeItem;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;


import java.util.HashSet;
import java.util.Set;


public class EyePickaxeUsageEvent implements PlayerBlockBreakEvents.Before {


    // Done with the help of https://github.com/CoFH/CoFHCore/blob/c23d117dcd3b3b3408a138716b15507f709494cd/src/main/java/cofh/core/event/AreaEffectEvents.java
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();




    @Override
    public boolean beforeBlockBreak(World world, PlayerEntity player, BlockPos pos,
                                    BlockState stated, @Nullable BlockEntity blockEntity) {
        {
            ItemStack mainHandItem = player.getMainHandStack();




            if (mainHandItem.getItem() instanceof EyePickaxeItem hammer && player instanceof ServerPlayerEntity serverPlayer) {


                if (HARVESTED_BLOCKS.contains(pos)) {
                    return true;
                }


                for (BlockPos position : EyePickaxeItem.BLOCKS_TO_BE_CHECKED(1, pos, serverPlayer)) {
                    if (pos == position || !hammer.isCorrectForDrops(mainHandItem, world.getBlockState(position))) {


                        continue;
                    }




                    HARVESTED_BLOCKS.add(position);
                    serverPlayer.interactionManager.tryBreakBlock(position);
                    HARVESTED_BLOCKS.remove(position);
                    //limit = 1;
                }
                // serverPlayer.interactionManager.tryBreakBlock(position);


            }
        }


        return true;
    }




}
