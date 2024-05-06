package io.github.Tors_0.voidfalling.registry;

import io.github.Tors_0.voidfalling.Voidfalling;
import io.github.Tors_0.voidfalling.block.crystallized_void.BuddingCrystallizedVoidBlock;
import io.github.Tors_0.voidfalling.block.crystallized_void.CrystallizedVoidClusterBlock;
import io.github.Tors_0.voidfalling.block.voided.VoidedBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import java.util.LinkedHashMap;
import java.util.Map;

public interface ModBlocks {
	// TODO add custom geodes (guide: https://github.com/TheDeathlyCow/more-geodes/blob/main/src/main/resources/data/geodes/worldgen/configured_feature/echo_geode.json)
	Map<Block, Identifier> BLOCKS = new LinkedHashMap<>();

//	Block MOD_BLOCK = createBlock("mod_block", new ModBlock(QuiltBlockSettings.of(Material.SOME_MATERIAL, MapColor.SOME_COLOR).strength(-1.0F, 3600000.0F).sounds(BlockSoundGroup.COPPER)), true);

	Block VOIDED_BLOCK = createBlock("voided", new VoidedBlock(QuiltBlockSettings.of(Material.PORTAL, MapColor.BLACK).strength(30, 3600000).sounds(BlockSoundGroup.STONE)), true);

	Block BUDDING_CRYSTALLIZED_VOID = createBlock(
		"budding_crystallized_void",
		new BuddingCrystallizedVoidBlock(QuiltBlockSettings.of(Material.AMETHYST).ticksRandomly().strength(1.5F).sounds(BlockSoundGroup.AMETHYST_BLOCK).requiresTool().luminance(state -> 10)),
		true
	);
	Block CRYSTALLIZED_VOID_CLUSTER = createBlock(
		"crystallized_void_cluster",
		new CrystallizedVoidClusterBlock(
			7, 3, QuiltBlockSettings.of(Material.AMETHYST).nonOpaque().ticksRandomly().sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(1.5F).luminance(state -> 5)
		),
		true
	);
	Block LARGE_CRYSTALLIZED_VOID_BUD = createBlock(
		"large_crystallized_void_bud",
		new CrystallizedVoidClusterBlock(5, 3, QuiltBlockSettings.copy(CRYSTALLIZED_VOID_CLUSTER).sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).luminance(state -> 4)),
		true
	);
	Block MEDIUM_CRYSTALLIZED_VOID_BUD = createBlock(
		"medium_crystallized_void_bud",
		new CrystallizedVoidClusterBlock(4, 3, QuiltBlockSettings.copy(CRYSTALLIZED_VOID_CLUSTER).sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).luminance(state -> 2)),
		true
	);
	Block SMALL_CRYSTALLIZED_VOID_BUD = createBlock(
		"small_crystallized_void_bud",
		new CrystallizedVoidClusterBlock(3, 4, QuiltBlockSettings.copy(CRYSTALLIZED_VOID_CLUSTER).sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).luminance(state -> 1)),
		true
	);

	static void register() {
		BLOCKS.keySet().forEach(block -> Registry.register(Registry.BLOCK, BLOCKS.get(block), block));
	}

	private static <T extends Block> T createBlock(String name, T block, boolean createItem) {
		BLOCKS.put(block, Voidfalling.getIdentifier(name));
		if (createItem) {
			ModItems.ITEMS.put(new BlockItem(block, new QuiltItemSettings().group(ItemGroup.BUILDING_BLOCKS)), BLOCKS.get(block));
		}
		return block;
	}
}
