package io.github.Tors_0.voidfalling.registry;

import io.github.Tors_0.voidfalling.Voidfalling;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public interface ModBiomeTags {
	TagKey<Biome> HAS_CRYSTALLIZED_VOID_GEODE = TagKey.of(Registry.BIOME_KEY, Voidfalling.getIdentifier("has_crystallized_void_geode"));
}
