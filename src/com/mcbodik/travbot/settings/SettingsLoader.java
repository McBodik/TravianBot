package com.mcbodik.travbot.settings;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SettingsLoader {

    private static final String DIVIDER = "=";

    public static void loadSettings() throws FileNotFoundException, IOException {

        Settings settings = Settings.getInstance();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(Settings.FILE_PATH, Settings.FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split(DIVIDER);

                if (splitLine[0].equals(Settings.URL)) {
                    settings.setUrl(splitLine[1]);
                }

                if (splitLine[0].equals(Settings.LOGIN)) {
                    settings.setLogin(splitLine[1]);
                }

                if (splitLine[0].equals(Settings.PASSWORD)) {
                    settings.setPassword(splitLine[1]);
                }
            }

        }
    }
}
