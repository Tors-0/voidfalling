package io.github.Tors_0.voidfalling.block;

import io.github.Tors_0.voidfalling.entity.VoidActuatorEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class VoidActuatorBlock extends Block {
	public VoidActuatorBlock(Settings settings) {
		super(settings);
	}

	public void activate(World world, BlockPos activatePos, BlockPos thisPos) {
		if (world instanceof ServerWorld) {
			if (!thisPos.equals(activatePos)) {
				BlockState block = world.getBlockState(thisPos);
				world.removeBlock(thisPos, true);
				world.setBlockState(activatePos, block, VoidActuatorBlock.NOTIFY_LISTENERS);
			}
			VoidActuatorEntity entity = new VoidActuatorEntity(activatePos.getX() +.5f, activatePos.getY(), activatePos.getZ() +.5f, world);
			world.spawnEntity(entity);
		}
	}
}
