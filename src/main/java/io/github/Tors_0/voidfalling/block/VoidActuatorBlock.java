package io.github.Tors_0.voidfalling.block;

import io.github.Tors_0.voidfalling.entity.VoidActuatorEntity;
import net.minecraft.block.Block;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class VoidActuatorBlock extends Block {
	public VoidActuatorBlock(Settings settings) {
		super(settings);
	}

	public void activate(World world, BlockPos pos) {
		if (world instanceof ServerWorld) {
			VoidActuatorEntity entity = new VoidActuatorEntity(pos.getX() +.5f, pos.getY(), pos.getZ() +.5f, world);
			world.spawnEntity(entity);
		}
	}
}
