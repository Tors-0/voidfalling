package io.github.Tors_0.voidfalling.registry.worldgen;

import net.minecraft.world.gen.GenerationStep;
import org.quiltmc.qsl.worldgen.biome.api.BiomeModifications;

public class ModFeatures {
	public static void place() {
		BiomeModifications.addFeature(
			biomeSelectionContext -> biomeSelectionContext.getBiomeKey().equals(ModBiomes.VOIDLANDS),
			GenerationStep.Feature.UNDERGROUND_DECORATION,
			ModPlacedFeatures.CRYSTALLIZED_VOID_GEODE
		);
	}
}
