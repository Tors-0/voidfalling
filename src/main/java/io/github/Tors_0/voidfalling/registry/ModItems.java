package io.github.Tors_0.voidfalling.registry;

import io.github.Tors_0.voidfalling.VoidBreakerItem;
import io.github.Tors_0.voidfalling.Voidfalling;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import java.util.LinkedHashMap;
import java.util.Map;

public interface ModItems {
	public static final Map<Item, Identifier> ITEMS = new LinkedHashMap<>();

	// Item NAME = createItem("name", new ModItem(new QuiltItemSettings()));
	Item CRYSTALLIZED_VOID_SHARD = createItem("crystallized_void_shard", new Item(new QuiltItemSettings().group(ItemGroup.MATERIALS)));
	Item VOID_BREAKER = createItem("void_breaker", new VoidBreakerItem(4f, -2.4f, new QuiltItemSettings().group(ItemGroup.TOOLS)));

	/**
	 * Creates a new item of type T using the constructor from T
	 * @param name String name of the item (used in JSON)
	 * @param item an object of a _Item class that extends net.minecraft.Item
	 * @return A newly created _Item object
	 * @param <T> _Item class that extends net.minecraft.Item
	 */
	private static <T extends Item> T createItem(String name, T item) {
		ITEMS.put(item, new Identifier(Voidfalling.ID, name));
		return item;
	}

	/**
	 * Registers all items into the Minecraft Item Registry
	 */
	public static void register() {
		ITEMS.keySet().forEach(item -> Registry.register(Registry.ITEM, ITEMS.get(item), item));
	}
}
