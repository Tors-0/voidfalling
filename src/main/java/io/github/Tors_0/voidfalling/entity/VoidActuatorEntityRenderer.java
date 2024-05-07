package io.github.Tors_0.voidfalling.entity;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class VoidActuatorEntityRenderer extends ProjectileEntityRenderer<VoidActuatorEntity> {
	public VoidActuatorEntityRenderer(EntityRendererFactory.Context context) {
		super(context);
	}

	@Override
	public void render(VoidActuatorEntity persistentProjectileEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {

	}

	@Override
	public Identifier getTexture(VoidActuatorEntity entity) {
		return null;
	}
}
