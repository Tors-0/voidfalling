package io.github.Tors_0.voidfalling.item;

import io.github.Tors_0.voidfalling.registry.ModBlockTags;
import io.github.Tors_0.voidfalling.registry.ModToolMaterials;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.tag.BlockTags;

public class VoidBreakerItem extends MiningToolItem {
	public VoidBreakerItem(float toolBaseDamage, float attackSpeed, Settings settings) {
		super(toolBaseDamage, attackSpeed, ModToolMaterials.VOID, BlockTags.PICKAXE_MINEABLE, settings);
	}
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.damage(1, attacker, (e) -> {
			e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
		});
		return true;
	}
}
