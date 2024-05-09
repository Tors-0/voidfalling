package io.github.Tors_0.voidfalling.mixin;

import io.github.Tors_0.voidfalling.registry.worldgen.ModDimensions;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;
import org.quiltmc.loader.impl.lib.sat4j.core.Vec;
import org.quiltmc.qsl.worldgen.dimension.api.QuiltDimensions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

	public LivingEntityMixin(EntityType<?> type, World world) {
		super(type, world);
	}

	@Inject(method = "tickInVoid", at = @At(value = "HEAD"))
	private void voidfalling$sendToVoid(CallbackInfo ci) {
		if (this.getWorld() instanceof ServerWorld && this.isPlayer()) {
			if (this.getWorld().getRegistryKey().equals(World.OVERWORLD)) {
				ServerWorld voidDimension = this.getServer().getWorld(ModDimensions.VOID_KEY);
				if (voidDimension == null) return;
				ServerPlayerEntity player = QuiltDimensions.teleport(this, voidDimension,
					new TeleportTarget(Vec3d.ZERO.subtract(0, 64, 0), Vec3d.ZERO, this.getYaw(), this.getPitch()));
				if (player != null) {
					player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 320, 5, false, false, false));
				}
			} else if (this.getWorld().getRegistryKey().equals(ModDimensions.VOID_KEY)) {
				int posOffset = -50 + (int) (Math.random() * 100);
				ServerPlayerEntity player = QuiltDimensions.teleport(this, (ServerWorld) this.getWorld(),
					new TeleportTarget(
						new Vec3d(this.getPos().x + posOffset, this.getWorld().getTopY(), this.getPos().z - posOffset),
						this.getVelocity(), this.getYaw(), this.getPitch()));
				if (player != null) {
					player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 260, 5, false, false, false));
				}
			}
		}
	}
}
