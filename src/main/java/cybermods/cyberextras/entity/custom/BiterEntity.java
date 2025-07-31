package cybermods.cyberextras.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.AnimalMateGoal;
import net.minecraft.entity.ai.goal.AttackGoal;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

public class BiterEntity extends FishEntity {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;


    public BiterEntity(EntityType<? extends FishEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new EscapeDangerGoal(this, 5.0));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 0, false));
    }

    public static DefaultAttributeContainer.Builder createAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.7);

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
    protected SoundEvent getFlopSound() {
        return null;
    }



    @Override
    public ItemStack getBucketItem() {
        return null;
    }
}
