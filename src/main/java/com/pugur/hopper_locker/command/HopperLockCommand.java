package com.pugur.hopper_locker.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.pugur.hopper_locker.HopperLocker;
import com.pugur.hopper_locker.config.ConfigManager;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.chunk.ChunkManager;

public class HopperLockCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("hopperlock")
                .then(CommandManager.argument("state", StringArgumentType.word())
                        .suggests((context, builder) -> {
                            builder.suggest("true");
                            builder.suggest("false");
                            return builder.buildFuture();
                        })
                        .executes(HopperLockCommand::update))
                .executes(HopperLockCommand::getState)
        );
    }

    private static int update(CommandContext<ServerCommandSource> context) {
        String state1 = StringArgumentType.getString(context, "state");
        boolean state = false;
        if (state1.equals("true")) state = true;
        else if (!state1.equals("false")) context.getSource().sendMessage(Text.literal("Illegal Argument : Use true or false").formatted(Formatting.DARK_RED));
        context.getSource().sendMessage(Text.literal("HopperLock is Now being " + state).formatted(Formatting.AQUA));
        ConfigManager.hopperLock = state;
        return 1;
    }

    private static int getState(CommandContext<ServerCommandSource> context) {
        context.getSource().sendMessage(Text.literal("HopperLock is " + ConfigManager.hopperLock).formatted(Formatting.GREEN));
        return 1;
    }
}
