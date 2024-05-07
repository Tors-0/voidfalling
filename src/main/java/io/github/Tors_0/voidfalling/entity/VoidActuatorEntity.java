package io.github.Tors_0.voidfalling.entity;

import io.github.Tors_0.voidfalling.registry.ModEntities;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class VoidActuatorEntity extends PersistentProjectileEntity {
	public VoidActuatorEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
		super(entityType, world);
	}

	public VoidActuatorEntity(double x, double y, double z, World world) {
		super(ModEntities.VOID_ACTUATOR, x, y, z, world);
	}

	@Override
	protected ItemStack asItemStack() {
		return null;
	}

	@Override
	public void tick() {
		BlockPos pos = this.getBlockPos();

		if (pos.getY() < this.getWorld().getBottomY()) this.discard();

		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				world.setBlockState(pos.add(i, -1, j), Blocks.AIR.getDefaultState());
			}
		}

		this.move(MovementType.SELF, new Vec3d(0,-1,0));

		super.baseTick();
	}
}
