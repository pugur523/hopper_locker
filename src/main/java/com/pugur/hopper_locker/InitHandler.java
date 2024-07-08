package com.pugur.hopper_locker;

import com.pugur.hopper_locker.command.HopperLockCommand;
import com.pugur.hopper_locker.config.ConfigManager;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;

public class InitHandler {
    void initialize() {
        ConfigManager.init();
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            HopperLockCommand.register(dispatcher);
        });
    }
}
