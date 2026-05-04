package com.monkey.heavythrow.entity;

import com.monkey.heavythrow.HeavyThrow;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.item.ItemEntity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HeavyProjectile extends ThrowableProjectile implements ItemSupplier {

    private List<LivingEntity> targets = new ArrayList<>();
    private LivingEntity currentTarget = null;
    private int currentTargetIndex = 0;
    private int flightTicks = 0;
    private int hitCount = 0;
    private ItemStack savedMace = ItemStack.EMPTY;
    private Player owner;

    public HeavyProjectile(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
        this.setNoGravity(true);
    }

    public HeavyProjectile(Level world, Player owner, ItemStack mace, List<LivingEntity> targets) {
        super(HeavyThrow.HEAVY_PROJECTILE, world);
        this.owner = owner;
        this.setOwner(owner);
        this.savedMace = mace.copy();
        this.targets = new ArrayList<>(targets);
        this.targets.sort(Comparator.comparingDouble(e -> e.distanceToSqr(owner)));
        this.setPos(owner.getX(), owner.getEyeY() - 0.2, owner.getZ());
        if (!this.targets.isEmpty()) {
            this.currentTarget = this.targets.get(0);
        }
        this.setDeltaMovement(owner.getLookAngle().scale(1.5));
        this.setNoGravity(true);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        // 不需要同步数据
    }

    @Override
    public void tick() {
        if (!this.level().isClientSide()) {
            // 玩家死亡处理
            if (owner == null || !owner.isAlive() || owner.isRemoved()) {
                if (!savedMace.isEmpty()) {
                    if (owner != null && owner.isAlive()) {
                        owner.getInventory().add(savedMace);
                    } else {
                        this.level().addFreshEntity(new ItemEntity(this.level(), this.getX(), this.getY(), this.getZ(), savedMace));
                    }
                }
                this.discard();
                return;
            }

            flightTicks++;

            targets.removeIf(e -> !e.isAlive());

            if (currentTarget != null && !currentTarget.isAlive()) {
                currentTargetIndex++;
                if (currentTargetIndex < targets.size()) {
                    currentTarget = targets.get(currentTargetIndex);
                } else {
                    currentTarget = null;
                }
            }

            if (currentTarget != null) {
                Vec3 targetPos = currentTarget.getBoundingBox().getCenter();
                Vec3 direction = targetPos.subtract(this.position()).normalize();
                double speed = Math.min(4.0 + hitCount * 0.6, 10.0);
                this.setDeltaMovement(direction.scale(speed));
            }

            if (currentTarget != null && this.getBoundingBox().intersects(currentTarget.getBoundingBox())) {
                float seconds = flightTicks / 20.0f;
                float damage = 8.0f * (float) Math.pow(1.2, seconds);
                currentTarget.hurt(this.damageSources().mobAttack(owner), damage);
                currentTarget.playSound(SoundEvents.PLAYER_HURT, 1.0F, 1.0F);

                hitCount++;
                currentTargetIndex++;

                if (currentTargetIndex < targets.size()) {
                    currentTarget = targets.get(currentTargetIndex);
                } else {
                    // 所有目标击杀完毕，返回重锤
                    if (owner != null && !savedMace.isEmpty()) {
                        if (!owner.getInventory().add(savedMace)) {
                            owner.drop(savedMace, false);
                        }
                    }
                    this.discard();
                    return;
                }
            }

            // 超时返回
            if (flightTicks > 600) {
                if (owner != null && !savedMace.isEmpty()) {
                    if (!owner.getInventory().add(savedMace)) {
                        owner.drop(savedMace, false);
                    }
                }
                this.discard();
                return;
            }
        }

        // 移动
        this.setPos(this.getX() + this.getDeltaMovement().x,
                this.getY() + this.getDeltaMovement().y,
                this.getZ() + this.getDeltaMovement().z);
    }

    @Override
    public ItemStack getItem() {
        return savedMace.isEmpty() ? new ItemStack(Items.MACE) : savedMace;
    }
}