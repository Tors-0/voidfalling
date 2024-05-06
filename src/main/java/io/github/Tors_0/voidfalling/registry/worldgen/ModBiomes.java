package io.github.Tors_0.voidfalling.registry.worldgen;

import io.github.Tors_0.voidfalling.Voidfalling;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.OverworldBiomeCreator;

public class ModBiomes {
	public static final RegistryKey<Biome> VOIDLANDS;
	static {
		VOIDLANDS = RegistryKey.of(Registry.BIOME_KEY, Voidfalling.getIdentifier("voidland"));
	}
	public static void register() {
		Registry.register(BuiltinRegistries.BIOME, VOIDLANDS.getValue(), OverworldBiomeCreator.createTheVoid());
	}
}
