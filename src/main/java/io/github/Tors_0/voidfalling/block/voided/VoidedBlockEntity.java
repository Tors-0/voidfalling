package io.github.Tors_0.voidfalling.block.voided;

import io.github.Tors_0.voidfalling.registry.ModBlockEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.EndPortalBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class VoidedBlockEntity extends EndPortalBlockEntity {
	protected VoidedBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
		super(type, pos, state);
	}
	public VoidedBlockEntity(BlockPos pos, BlockState state) {
		this(ModBlockEntities.VOIDED_BLOCK_ENTITY, pos, state);
	}
	public boolean shouldDrawSide(Direction direction) {
		return Block.shouldDrawSide(this.getCachedState(), this.world, this.getPos(), direction, this.getPos().offset(direction));
	}
}
