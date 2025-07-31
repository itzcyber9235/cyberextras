package cybermods.cyberextras.entity;

import cybermods.cyberextras.Cyberextras;
import cybermods.cyberextras.entity.custom.BiterEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

public static final EntityType<BiterEntity> BITER = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(Cyberextras.MOD_ID, "biter"),
        EntityType.Builder.create(BiterEntity::new, SpawnGroup.WATER_CREATURE)
                .dimensions(0.5f, 0.25f).build());


    public static void registerModEntities(){
        Cyberextras.LOGGER.info("Registering Mod Entities For CyberExtras");
    }

}
