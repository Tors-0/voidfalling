package io.github.Tors_0.voidfalling.mixin;

import io.github.Tors_0.voidfalling.Voidfalling;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
	protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
		super(entityType, world);
	}

	@Inject(method = "onDeath", at = @At(value = "HEAD"), cancellable = true)
	private void voidfalling$fallIntoVoid(DamageSource source, CallbackInfo ci) {
		if (source.isOutOfWorld()) {
			Voidfalling.LOGGER.info("fell out of {}!", this.getWorld().getDimension().toString());
			Voidfalling.LOGGER.info("overworld is {}", DimensionTypes.OVERWORLD);
		}
	}
}
