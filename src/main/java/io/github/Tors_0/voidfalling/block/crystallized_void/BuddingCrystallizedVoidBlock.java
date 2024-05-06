package io.github.Tors_0.voidfalling.block.crystallized_void;

import io.github.Tors_0.voidfalling.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.random.RandomGenerator;

public class BuddingCrystallizedVoidBlock extends CrystallizedVoidBlock {
	public BuddingCrystallizedVoidBlock(Settings settings) {
		super(settings);
	}
	@Override
	public PistonBehavior getPistonBehavior(BlockState state) {
		return PistonBehavior.DESTROY;
	}

	@Override
	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, RandomGenerator random) {
		if (random.nextInt(5) == 0) {
			Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
			BlockPos blockPos = pos.offset(direction);
			BlockState blockState = world.getBlockState(blockPos);
			Block block = null;
			if (canGrowIn(blockState)) {
				block = ModBlocks.SMALL_CRYSTALLIZED_VOID_BUD;
			} else if (blockState.isOf(ModBlocks.SMALL_CRYSTALLIZED_VOID_BUD) && blockState.get(CrystallizedVoidClusterBlock.FACING) == direction) {
				block = ModBlocks.MEDIUM_CRYSTALLIZED_VOID_BUD;
			} else if (blockState.isOf(ModBlocks.MEDIUM_CRYSTALLIZED_VOID_BUD) && blockState.get(CrystallizedVoidClusterBlock.FACING) == direction) {
				block = ModBlocks.LARGE_CRYSTALLIZED_VOID_BUD;
			} else if (blockState.isOf(ModBlocks.LARGE_CRYSTALLIZED_VOID_BUD) && blockState.get(CrystallizedVoidClusterBlock.FACING) == direction) {
				block = ModBlocks.CRYSTALLIZED_VOID_CLUSTER;
			}

			if (block != null) {
				BlockState blockState2 = block.getDefaultState()
					.with(CrystallizedVoidClusterBlock.FACING, direction)
					.with(CrystallizedVoidClusterBlock.WATERLOGGED, Boolean.valueOf(blockState.getFluidState().getFluid() == Fluids.WATER));
				world.setBlockState(blockPos, blockState2);
			}
		}
	}

	public static boolean canGrowIn(BlockState state) {
		return state.isAir() || state.isOf(Blocks.WATER) && state.getFluidState().getLevel() == 8;
	}
}
