package cybermods.cyberextras.entity.goals;

import cybermods.cyberextras.entity.custom.BiterEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.ZombieEntity;

public class BiterAttackGoal extends MeleeAttackGoal {


        private final BiterEntity biter;
        private int ticks;

        public BiterAttackGoal(BiterEntity biter, double speed, boolean pauseWhenMobIdle) {
            super(biter, speed, pauseWhenMobIdle);
            this.biter  = biter;
        }

        public void start() {
            super.start();
            this.ticks = 0;
        }

        public void stop() {
            super.stop();
            this.biter.setAttacking(false);
        }

        public void tick() {
            super.tick();
            ++this.ticks;
            if (this.ticks >= 5 && this.getCooldown() < this.getMaxCooldown() / 2) {
                this.biter.setAttacking(true);
            } else {
                this.biter.setAttacking(false);
            }

        }
    }


