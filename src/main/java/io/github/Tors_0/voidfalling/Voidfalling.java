package io.github.Tors_0.voidfalling;

import io.github.Tors_0.voidfalling.registry.*;
import io.github.Tors_0.voidfalling.registry.worldgen.ModBiomes;
import io.github.Tors_0.voidfalling.registry.worldgen.ModDimensions;
import io.github.Tors_0.voidfalling.registry.worldgen.ModFeatures;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Voidfalling implements ModInitializer {
	public static final String ID = "voidfalling";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(ID);

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Hello Quilt world from {}!", mod.metadata().name());

		// create blocks and items (must be registered before we can modify worldgen)
		ModBlocks.register();
		ModItems.register();

		ModEntities.initialize();

		// add modded worldgen features
		// yippee :D
		ModBiomes.register();
		ModDimensions.register();
		ModFeatures.place();
	}

	public static Identifier getIdentifier(String name) {
		return new Identifier(ID, name);
	}
}
