package io.github.Tors_0.voidfalling.registry;

import io.github.Tors_0.voidfalling.Voidfalling;
import io.github.Tors_0.voidfalling.block.voided.VoidedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import java.util.LinkedHashMap;
import java.util.Map;

public interface ModBlocks {
	Map<Block, Identifier> BLOCKS = new LinkedHashMap<>();

//	Block MOD_BLOCK = createBlock("mod_block", new ModBlock(QuiltBlockSettings.of(Material.SOME_MATERIAL, MapColor.SOME_COLOR).strength(-1.0F, 3600000.0F).sounds(BlockSoundGroup.COPPER)), true);

	Block VOIDED_BLOCK = createBlock("voided", new VoidedBlock(QuiltBlockSettings.of(Material.PORTAL, MapColor.BLACK).strength(30, 3600000).sounds(BlockSoundGroup.STONE)), true);

	static void register() {
		BLOCKS.keySet().forEach(block -> Registry.register(Registry.BLOCK, BLOCKS.get(block), block));
	}

	private static <T extends Block> T createBlock(String name, T block, boolean createItem) {
		BLOCKS.put(block, Voidfalling.getIdentifier(name));
		if (createItem) {
			ModItems.ITEMS.put(new BlockItem(block, new QuiltItemSettings()), BLOCKS.get(block));
		}
		return block;
	}
}
