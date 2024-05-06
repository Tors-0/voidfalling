package io.github.Tors_0.voidfalling;

import io.github.Tors_0.voidfalling.registry.ModBlockTags;
import io.github.Tors_0.voidfalling.registry.ModToolMaterials;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;

public class VoidBreakerItem extends MiningToolItem {
	public VoidBreakerItem(float toolBaseDamage, float attackSpeed, Settings settings) {
		super(toolBaseDamage, attackSpeed, ModToolMaterials.VOID, ModBlockTags.NEEDS_VOID_TOOL, settings);
	}
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.damage(1, attacker, (e) -> {
			e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
		});
		return true;
	}
}
