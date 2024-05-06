package io.github.Tors_0.voidfalling.registry;

import io.github.Tors_0.voidfalling.Voidfalling;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

public interface ModBlockTags {
	TagKey<Block> NEEDS_VOID_TOOL = TagKey.of(Registry.BLOCK_KEY, Voidfalling.getIdentifier("needs_void_tool"));
}
