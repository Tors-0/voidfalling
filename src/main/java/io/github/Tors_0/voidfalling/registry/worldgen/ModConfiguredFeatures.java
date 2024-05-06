package io.github.Tors_0.voidfalling.registry.worldgen;

import io.github.Tors_0.voidfalling.Voidfalling;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public interface ModConfiguredFeatures {
	RegistryKey<ConfiguredFeature<?, ?>> CRYSTALLIZED_VOID_GEODE =
		RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, Voidfalling.getIdentifier("crystallized_void_geode"));
}
