package cybermods.cyberextras.util;

import cybermods.cyberextras.item.custom.EyePickaxeItem;
import cybermods.cyberextras.item.custom.EyeShovelItem;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class EyeShovelUsageEvent implements PlayerBlockBreakEvents.Before {

    // Done with the help of https://github.com/CoFH/CoFHCore/blob/c23d117dcd3b3b3408a138716b15507f709494cd/src/main/java/cofh/core/event/AreaEffectEvents.java
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();


    @Override
    public boolean beforeBlockBreak(World world, PlayerEntity player, BlockPos pos,
                                    BlockState stated, @Nullable BlockEntity blockEntity) {
        {
            ItemStack mainHandItem = player.getMainHandStack();


            if (mainHandItem.getItem() instanceof EyeShovelItem hammer && player instanceof ServerPlayerEntity serverPlayer) {

                    if (HARVESTED_BLOCKS.contains(pos)) {
                        return true;
                    }

                    for (BlockPos position : EyeShovelItem.BLOCKS_TO_BE_HARVESTED(1, pos, serverPlayer)) {
                        if (pos == position || !hammer.isCorrectForDrops(mainHandItem, world.getBlockState(position))) {

                            continue;
                        }
                        HARVESTED_BLOCKS.add(position);
                        serverPlayer.interactionManager.tryBreakBlock(position);
                        HARVESTED_BLOCKS.remove(position);



                    }


                }
            }

            return true;
        }


        }
