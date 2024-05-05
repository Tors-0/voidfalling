package io.github.Tors_0.voidfalling;

import io.github.Tors_0.voidfalling.block.renderer.VoidedBlockEntityRenderer;
import io.github.Tors_0.voidfalling.registry.ModBlockEntities;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

public class VoidfallingClient implements ClientModInitializer {
	@Override
	public void onInitializeClient(ModContainer mod) {
		BlockEntityRendererFactories.register(ModBlockEntities.VOIDED_BLOCK_ENTITY, VoidedBlockEntityRenderer::new);
	}
}
