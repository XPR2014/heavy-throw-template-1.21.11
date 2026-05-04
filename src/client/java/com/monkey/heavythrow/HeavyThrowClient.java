package com.monkey.heavythrow;

import com.monkey.heavythrow.entity.HeavyProjectile;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;

public class HeavyThrowClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(HeavyThrow.HEAVY_PROJECTILE,
				context -> new ThrownItemRenderer<HeavyProjectile>(context, 1.0F, true));
	}
}