package io.github.Tors_0.voidfalling.registry;

import com.mojang.datafixers.types.Type;
import io.github.Tors_0.voidfalling.Voidfalling;
import io.github.Tors_0.voidfalling.block.voided.VoidedBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

public interface ModBlockEntities {
	Map<BlockEntityType, Identifier> BLOCK_ENTITIES = new HashMap<>();

	BlockEntityType<VoidedBlockEntity> VOIDED_BLOCK_ENTITY = create("voided", BlockEntityType.Builder.create(VoidedBlockEntity::new, ModBlocks.VOIDED_BLOCK));

	private static <T extends BlockEntity> BlockEntityType<T> create(String id, BlockEntityType.Builder<T> builder) {
		Type<?> type = Util.getChoiceType(TypeReferences.BLOCK_ENTITY, id);
		BlockEntityType<T> blockEntityType = builder.build(type);
		BLOCK_ENTITIES.put(blockEntityType, Voidfalling.getIdentifier(id));
		return blockEntityType;
	}

	static void register() {
		BLOCK_ENTITIES.keySet().forEach(blockEntityType -> {
			Registry.register(Registry.BLOCK_ENTITY_TYPE, BLOCK_ENTITIES.get(blockEntityType), blockEntityType);
		});
	}
}
