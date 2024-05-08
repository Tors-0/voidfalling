package io.github.Tors_0.voidfalling.entity;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BeaconBlockEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import static net.minecraft.client.render.block.entity.BeaconBlockEntityRenderer.BEAM_TEXTURE;

public class VoidActuatorEntityRenderer extends ProjectileEntityRenderer<VoidActuatorEntity> {
	public VoidActuatorEntityRenderer(EntityRendererFactory.Context context) {
		super(context);
	}

	@Override
	public void render(VoidActuatorEntity persistentProjectileEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
		var worldTime = persistentProjectileEntity.getWorld().getTime();
		BeaconBlockEntityRenderer.renderBeam(matrixStack, vertexConsumerProvider, BEAM_TEXTURE, f,
			1f, worldTime, 0, (int) persistentProjectileEntity.getStartingY(),
			DyeColor.BLACK.getColorComponents(), .2f, .25f);
	}

	@Override
	public Identifier getTexture(VoidActuatorEntity entity) {
		return null;
	}
}
