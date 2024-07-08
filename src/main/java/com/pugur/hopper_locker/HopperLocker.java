package com.pugur.hopper_locker;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HopperLocker implements ModInitializer {
    @Override
    public void onInitialize() {
        Logger logger = LoggerFactory.getLogger("Hopper_locker");
        InitHandler initHandler = new InitHandler();
        initHandler.initialize();
        logger.info("Hopper Locker has Initialized!");
    }
}
