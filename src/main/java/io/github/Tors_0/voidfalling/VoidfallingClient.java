package io.github.Tors_0.voidfalling;

import io.github.Tors_0.voidfalling.registry.ModBlocks;
import net.minecraft.client.render.RenderLayer;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap;

public class VoidfallingClient implements ClientModInitializer {
	@Override
	public void onInitializeClient(ModContainer mod) {
		BlockRenderLayerMap.put(RenderLayer.getCutout(),
			ModBlocks.CRYSTALLIZED_VOID_CLUSTER,
			ModBlocks.LARGE_CRYSTALLIZED_VOID_BUD,
			ModBlocks.MEDIUM_CRYSTALLIZED_VOID_BUD,
			ModBlocks.SMALL_CRYSTALLIZED_VOID_BUD
		);
	}
}
