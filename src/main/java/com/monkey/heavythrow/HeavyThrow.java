package com.monkey.heavythrow;

import com.monkey.heavythrow.entity.HeavyProjectile;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class HeavyThrow implements ModInitializer {

	public static final String MOD_ID = "heavythrow";
	public static final Identifier ENTITY_ID = Identifier.tryParse(MOD_ID + ":heavy_projectile");

	public static final EntityType<HeavyProjectile> HEAVY_PROJECTILE = Registry.register(
			BuiltInRegistries.ENTITY_TYPE,
			ENTITY_ID,
			EntityType.Builder.<HeavyProjectile>of(HeavyProjectile::new, MobCategory.MISC)
					.sized(0.5F, 0.5F)
					.clientTrackingRange(4)
					.updateInterval(20)
					.build(ResourceKey.create(BuiltInRegistries.ENTITY_TYPE.key(), ENTITY_ID))
	);

	@Override
	public void onInitialize() {
		System.out.println("[HeavyThrow] 模组加载成功！");
	}
}