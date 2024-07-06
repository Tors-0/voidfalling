package io.github.Tors_0.voidfalling.entity;

import io.github.Tors_0.voidfalling.registry.ModEntities;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class VoidActuatorEntity extends PersistentProjectileEntity {
	private double startingY = 0;
	public VoidActuatorEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
		super(entityType, world);
	}

	public VoidActuatorEntity(double x, double y, double z, World world) {
		super(ModEntities.VOID_ACTUATOR, x, y, z, world);
		this.startingY = y;
	}
	public double getStartingY() {
		return this.startingY;
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putDouble("startingY", this.startingY);
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		this.startingY = nbt.getDouble("startingY");
	}

	@Override
	protected ItemStack asItemStack() {
		return ItemStack.EMPTY;
	}

	@Override
	public void tick() {
		if (!(this.getWorld() instanceof ServerWorld)) return;
		if (this.age % 12 == 0) {
			BlockPos pos = this.getBlockPos();

			if (pos.getY() < this.getWorld().getBottomY()) {
				this.discard();
			}

			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					world.setBlockState(pos.add(i, -1, j), Blocks.AIR.getDefaultState());
				}
			}
			world.createExplosion(this, pos.getX(), pos.getY(), pos.getZ(), 3, Explosion.DestructionType.DESTROY);

			if (this.getWorld() instanceof ServerWorld) {
				((ServerWorld)this.getWorld()).spawnParticles(ParticleTypes.EXPLOSION, this.getX(), this.getY(), this.getZ(), 5, 0.5, 0.5, 0.5, 0);
			}

			this.move(MovementType.SELF, new Vec3d(0, -1, 0));
		}

		super.baseTick();
	}
}
