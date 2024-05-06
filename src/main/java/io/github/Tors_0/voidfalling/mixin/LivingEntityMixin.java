package io.github.Tors_0.voidfalling.mixin;

import io.github.Tors_0.voidfalling.Voidfalling;
import io.github.Tors_0.voidfalling.registry.worldgen.ModDimensions;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Heightmap;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;
import org.quiltmc.qsl.worldgen.dimension.api.QuiltDimensions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
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
		if (this.isPlayer() && this.getWorld() instanceof ServerWorld && this.getWorld().getRegistryKey().equals(World.OVERWORLD)) {
			ServerWorld voidDimension = this.getServer().getWorld(ModDimensions.WORLD_KEY);
			if (voidDimension == null) return;
			ServerPlayerEntity player = QuiltDimensions.teleport(this, voidDimension,
				new TeleportTarget(new Vec3d(this.getX(), 0, this.getZ()).multiply(16), Vec3d.ZERO, this.getYaw(), this.getPitch()));
			if (player != null) {
				player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 220, 5, false, false, false));
			}
		}
	}
}
