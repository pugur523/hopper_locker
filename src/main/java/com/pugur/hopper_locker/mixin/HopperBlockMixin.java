package com.pugur.hopper_locker.mixin;

import com.pugur.hopper_locker.config.ConfigManager;
import net.minecraft.block.BlockState;
import net.minecraft.block.HopperBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin (HopperBlock.class)
public class HopperBlockMixin {
    @Inject(
            at=@At("HEAD"),
            method="onEntityCollision",
            cancellable = true
    )
    private void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, CallbackInfo ci) {
        if(ConfigManager.hopperLock) ci.cancel();
    }
}
