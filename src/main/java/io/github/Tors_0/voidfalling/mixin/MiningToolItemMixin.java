package io.github.Tors_0.voidfalling.mixin;

import io.github.Tors_0.voidfalling.registry.ModBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(MiningToolItem.class)
public abstract class MiningToolItemMixin extends ToolItem {
	public MiningToolItemMixin(ToolMaterial material, Settings settings) {
		super(material, settings);
	}

	@Inject(method = "isSuitableFor", at = @At(value = "HEAD"), cancellable = true)
	private void voidfalling$newMiningLevel(BlockState state, CallbackInfoReturnable<Boolean> cir) {
		int i = this.getMaterial().getMiningLevel();
		if (i < 5 && state.isIn(ModBlockTags.NEEDS_VOID_TOOL)) {
			cir.setReturnValue(false);
		}
	}
}
