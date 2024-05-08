package io.github.Tors_0.voidfalling.mixin;

import io.github.Tors_0.voidfalling.block.VoidActuatorBlock;
import io.github.Tors_0.voidfalling.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
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
		BlockPos frontTopLeft = result.getFrontTopLeft().add(-3,0,-3);
		BlockState state;
		BlockPos voidBlockPos;
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 3; ++j) {
				if ((state = world.getBlockState(frontTopLeft.add(i, 0, j))).isOf(ModBlocks.VOID_ACTUATOR)) {
					voidBlockPos = frontTopLeft.add(i, 0, j);
					frontTopLeft = frontTopLeft.add(1, 0, 1);
					((VoidActuatorBlock)state.getBlock()).activate(world, frontTopLeft, voidBlockPos);
					cir.setReturnValue(ActionResult.CONSUME); // YES IT WORKS
				}
			}
		}
	}
}
