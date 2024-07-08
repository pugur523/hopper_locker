package com.pugur.hopper_locker.mixin;

import com.pugur.hopper_locker.config.ConfigManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HopperBlock;
import net.minecraft.block.entity.HopperBlockEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HopperBlockEntity.class)
public class HopperBlockEntityMixin {

    @Inject(
            at=@At("HEAD"),
            method="serverTick",
            cancellable = true
    )
    private static void onTick(World world, BlockPos pos, BlockState state, HopperBlockEntity blockEntity, CallbackInfo ci) {
        if (ConfigManager.hopperLock) {
            ci.cancel();
        }
    }
}
