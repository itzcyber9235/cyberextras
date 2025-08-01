package cybermods.cyberextras.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModfoodComponents {

    public static final FoodComponent RAW_BITER = new
            FoodComponent.Builder().nutrition(2).saturationModifier(0.1F).build();

    public static final FoodComponent COOKED_BITER =
            new FoodComponent.Builder().nutrition(8).saturationModifier(0.8F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1800, 0), 1.0f).build();
}
