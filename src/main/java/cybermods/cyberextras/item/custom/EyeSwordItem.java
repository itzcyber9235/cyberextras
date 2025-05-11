package cybermods.cyberextras.item.custom;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;

public class EyeSwordItem extends SwordItem {


    public EyeSwordItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
if(target.getHealth() != 0) {
   attacker.sendMessage(Text.translatable("Your target's health is " + target.getHealth() + target.getAbsorptionAmount()));

}

        return super.postHit(stack, target, attacker);
    }
}
