package net.kyrptonaught.modern_glass_doors.mixin;

import net.kyrptonaught.modern_glass_doors.GlassTrapdoorBlock;
import net.kyrptonaught.modern_glass_doors.ModernGlassDoorsMod;
import net.minecraft.block.BlockState;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(TrapdoorBlock.class)
public abstract class TrapdoorBlockMixin {

    @Inject(method = "onUse", at = @At("HEAD"), cancellable = true)
    private void modern_glass_doors_turnTrapdoorIntoGlassTrapdoor(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> callbackInfoReturnable) {
        ItemStack heldStack = player.getInventory().getMainHandStack();
        if (!(state.getBlock() instanceof GlassTrapdoorBlock) && heldStack.getItem() == Items.GLASS_PANE) {

            BlockState glassDoorState = ModernGlassDoorsMod.copyTrapdoorState(state);
            world.setBlockState(pos, glassDoorState);

            if (!player.isCreative()) heldStack.decrement(1);
            callbackInfoReturnable.setReturnValue(ActionResult.SUCCESS);

        }
    }
}