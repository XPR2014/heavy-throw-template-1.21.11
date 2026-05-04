package com.monkey.heavythrow.mixin;

import com.monkey.heavythrow.HeavyThrow;
import com.monkey.heavythrow.entity.HeavyProjectile;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(Item.class)
public class MaceItemMixin {

	@Inject(method = "use", at = @At("HEAD"), cancellable = true)
	private void onUse(Level world, Player user, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
		ItemStack stack = user.getItemInHand(hand);

		// 只处理重锤
		if (!(stack.getItem().toString().contains("mace"))) {
			return;
		}

		// 检查附魔
		boolean hasHeavyThrow = false;
		var enchantments = stack.getEnchantments();
		for (var entry : enchantments.entrySet()) {
			String enchantmentId = entry.getKey().getRegisteredName();
			if ("heavythrow:heavy_throw".equals(enchantmentId)) {
				hasHeavyThrow = true;
				break;
			}
		}

		if (hasHeavyThrow && !world.isClientSide()) {
			// 获取周围生物
			AABB box = user.getBoundingBox().inflate(32);
			List<LivingEntity> targets = world.getEntitiesOfClass(LivingEntity.class, box,
					entity -> entity != user && entity.isAlive() && !(entity instanceof Player));

			if (!targets.isEmpty()) {
				// 复制并消耗物品
				ItemStack maceCopy = stack.copy();
				stack.shrink(1);

				// 创建投掷物
				HeavyProjectile projectile = new HeavyProjectile(world, user, maceCopy, targets);
				world.addFreshEntity(projectile);

				cir.setReturnValue(InteractionResult.SUCCESS);
			} else {
				cir.setReturnValue(InteractionResult.PASS);
			}
		}
	}
}