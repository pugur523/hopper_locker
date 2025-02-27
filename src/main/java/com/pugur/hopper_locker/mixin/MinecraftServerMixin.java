package com.pugur.hopper_locker.mixin;

import com.pugur.hopper_locker.config.ConfigManager;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {

    @Inject(method = "stop", at = @At("HEAD"))
    private void onServerStop(CallbackInfo ci) {
        ConfigManager.saveConfig();
    }
}