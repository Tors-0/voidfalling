package io.github.Tors_0.voidfalling.registry.worldgen;

import io.github.Tors_0.voidfalling.Voidfalling;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;

public class ModDimensions {
	private static final RegistryKey<DimensionOptions> VOIDED_KEY = RegistryKey.of(Registry.DIMENSION_KEY, Voidfalling.getIdentifier("voiddim"));

	public static RegistryKey<World> VOID_KEY = RegistryKey.of(Registry.WORLD_KEY, VOIDED_KEY.getValue());

	public static void register() {
		VOID_KEY = RegistryKey.of(Registry.WORLD_KEY, Voidfalling.getIdentifier("voiddim"));
	}
}
