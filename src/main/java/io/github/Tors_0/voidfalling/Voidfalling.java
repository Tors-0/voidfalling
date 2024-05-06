package io.github.Tors_0.voidfalling;

import io.github.Tors_0.voidfalling.registry.ModBiomes;
import io.github.Tors_0.voidfalling.registry.ModBlocks;
import io.github.Tors_0.voidfalling.registry.ModDimensions;
import io.github.Tors_0.voidfalling.registry.ModItems;
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

		ModBiomes.register();
		ModDimensions.register();
		ModBlocks.register();
		ModItems.register();
	}

	public static Identifier getIdentifier(String name) {
		return new Identifier(ID, name);
	}
}
