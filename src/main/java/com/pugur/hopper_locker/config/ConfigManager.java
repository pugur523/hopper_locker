package com.pugur.hopper_locker.config;

import java.io.*;
import java.util.Objects;
import java.util.Properties;

public class ConfigManager {

    private static final String CONFIG_FILE_NAME = "config/hopper_locker.conf";
    public static Properties properties;
    private static File configFile;
    public static boolean hopperLock = false;

    public static void init() {
        properties = new Properties();
        configFile = new File(CONFIG_FILE_NAME);

        loadConfig();
    }

    private static void loadConfig() {
        try {
            if (!configFile.exists()) {
                createDefaultConfig();

            } else {
                InputStream inputStream = new FileInputStream(configFile);
                properties.load(inputStream);
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (Objects.equals(properties.getProperty("hopperLock"), "true")) hopperLock = true;
    }

    private static void createDefaultConfig() {
        properties.setProperty("hopperLock", "false");

        saveConfig();
    }

    public static void saveConfig() {
        try {
            OutputStream outputStream = new FileOutputStream(configFile);
            properties.store(outputStream, null);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

