package io.github.Tors_0.voidfalling.block.renderer;

import io.github.Tors_0.voidfalling.block.voided.VoidedBlockEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.EndPortalBlockEntityRenderer;

public class VoidedBlockEntityRenderer extends EndPortalBlockEntityRenderer<VoidedBlockEntity> {
	public VoidedBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
		super(ctx);
	}

	@Override
	protected float getTopYOffset() {
		return 1.0F;
	}

	@Override
	protected float getBottomYOffset() {
		return 0.0F;
	}

	@Override
	protected RenderLayer getLayer() {
		return RenderLayer.getEndGateway();
	}

	@Override
	public int getRenderDistance() {
		return 256;
	}
}
