package cybermods.cyberextras.entity.custom;

import cybermods.cyberextras.entity.goals.BiterAttackGoal;
import cybermods.cyberextras.item.ModItems;
import cybermods.cyberextras.sound.ModSounds;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.ai.pathing.SwimNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BiterEntity extends FishEntity{
    protected final SwimNavigation waterNavigation;
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;


    public BiterEntity(EntityType<? extends FishEntity> entityType, World world) {
        super(entityType, world);
        this.setPathfindingPenalty(PathNodeType.WATER, 0.0F);
        this.waterNavigation = new SwimNavigation(this, world);

    }


    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new EscapeDangerGoal(this, 5.0));

        this.goalSelector.add(2, new FleeEntityGoal(this, PlayerEntity.class, 12.0F, 6.0F, 10));
        this.goalSelector.add(2, new FleeEntityGoal(this, PufferfishEntity.class, 12.0F, 6.0F, 10));
        this.goalSelector.add(2, new FleeEntityGoal(this, GuardianEntity.class, 12.0F, 6.0F, 10));
        this.goalSelector.add(2, new FleeEntityGoal(this, ElderGuardianEntity.class, 12.0F, 6.0F, 10));
        this.goalSelector.add(2, new BiterAttackGoal(this, 6, false));
        this.goalSelector.add(3, new SwimAroundGoal(this, 5, 1));

        this.targetSelector.add(0, new ActiveTargetGoal(this, GlowSquidEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal(this, SquidEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal(this, CodEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal(this, SalmonEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal(this, TropicalFishEntity.class, true));
        this.targetSelector.add(4, new ActiveTargetGoal(this, PufferfishEntity.class, true));
        this.targetSelector.add(5, new ActiveTargetGoal(this, GuardianEntity.class, true));
        this.targetSelector.add(5, new ActiveTargetGoal(this, ElderGuardianEntity.class, true));
        this.targetSelector.add(5, new ActiveTargetGoal(this, DrownedEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal(this, CowEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal(this, SheepEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal(this, HorseEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal(this, PigEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal(this, ChickenEntity.class, true));


    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_COD_FLOP;
    }

    public static DefaultAttributeContainer.Builder createAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.7)
                .add(EntityAttributes.GENERIC_WATER_MOVEMENT_EFFICIENCY, 2);



    }

    private void setupAnimationStates(){
if(this.idleAnimationTimeout<=0){
    this.idleAnimationTimeout=37;
    this.idleAnimationState.start(this.age);
} else{
    --this.idleAnimationTimeout;
}
    }

    @Override
    public void tick() {
        super.tick();


        if(this.getWorld().isClient()){
            this.setupAnimationStates();
        }
    }


    @Override
    public ItemStack getBucketItem() {
       return new ItemStack(ModItems.BITER_BUCKET);
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.BITER_HURT;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return ModSounds.BITER_DEATH;
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return ModSounds.BITER_AMBIENT;
    }

    @Override
    protected void dropLoot(DamageSource damageSource, boolean causedByPlayer) {
        super.dropLoot(damageSource, causedByPlayer);
        if(isOnFire()){
            dropItem(ModItems.COOKED_BITER);
        }else{
            dropItem(ModItems.RAW_BITER);
        }

    }
}
