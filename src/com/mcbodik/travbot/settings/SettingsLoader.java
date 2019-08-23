package com.mcbodik.travbot.settings;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SettingsLoader {

    private static final String FILE_PATH = "./config";
    private static final String FILE_NAME = "settings.txt";

    private static final String DIVIDER = "=";

    public static void loadSettings() throws IOException {

        Settings settings = Settings.getInstance();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(FILE_PATH, FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split(DIVIDER);

                SettingsKey key = SettingsKey.getKeyByKeyword(splitLine[0]);
                if (key != null) {
                    settings.set(key, splitLine[1]);
                }
            }
        }
    }
}
