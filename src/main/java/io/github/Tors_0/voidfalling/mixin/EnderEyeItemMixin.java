package io.github.Tors_0.voidfalling.mixin;

import io.github.Tors_0.voidfalling.block.VoidActuatorBlock;
import io.github.Tors_0.voidfalling.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.item.EnderEyeItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(EnderEyeItem.class)
public abstract class EnderEyeItemMixin {
	@Inject(method = "useOnBlock", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/block/pattern/BlockPattern$Result;getFrontTopLeft()Lnet/minecraft/util/math/BlockPos;"), locals = LocalCapture.CAPTURE_FAILSOFT, cancellable = true)
	private void voidfalling$hijackTheEndPortal(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir, World world, BlockPos blockPos, BlockState blockState, BlockState blockState2, BlockPattern.Result result) {
		BlockPos centerBlockPos = result.getFrontTopLeft().add(-2, 0, -2);
		BlockState state;
		if ((state = world.getBlockState(centerBlockPos)).isOf(ModBlocks.VOID_ACTUATOR)) {
			((VoidActuatorBlock)state.getBlock()).activate(world, centerBlockPos);
			cir.setReturnValue(ActionResult.CONSUME); // YES IT WORKS
		}
	}
}
