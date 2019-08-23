package com.mcbodik.travbot.settings;

import com.mcbodik.travbot.villages.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VillagesLoader {

    private final static String FILE_PATH = "./config";
    private final static String FILE_NAME = "village.txt";

    private final static String VILLAGE_NAME_DIVIDER = "=";
    private final static String BUILDINGS_DIVIDER = ";";
    private final static String BUILDING_LEVEL_DIVIDER = "->";

    private final static String KEY_VILLAGE = "village";
    private final static String KEY_RESOURCES = "resources";
    private final static String KEY_BUILDINGS = "buildings";
    private final static String KEY_ALL = "all";


    public static void loadVillages() throws IOException {

        try (BufferedReader br = Files.newBufferedReader(Paths.get(FILE_PATH, FILE_NAME))) {
            String line;
            VillageModel villageModel = null;
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split(VILLAGE_NAME_DIVIDER);
                if (splitLine[0].equals(KEY_VILLAGE)) {
                    villageModel = new VillageModel();
                    villageModel.setName(splitLine[1]);
                    VillagesConfig.addVillage(villageModel);
                }

                if (villageModel == null) continue;

                if (splitLine[0].equals(KEY_RESOURCES)) {
                    if (splitLine[1].equals(KEY_ALL)) {
                        villageModel.setResourcesStrategy(ResourcesStrategy.ALL);//TODO another strategies
                    }
                }

                if (splitLine[0].equals(KEY_BUILDINGS)) {
                    String[] buildings = splitLine[1].split(BUILDINGS_DIVIDER); //don't put ';' at the end of line

                    String[] buildAndLevel;
                    BuildingPlan buildingPlan;

                    for (String building : buildings) {
                        buildingPlan = new BuildingPlan();
                        buildAndLevel = building.split(BUILDING_LEVEL_DIVIDER);
                        buildingPlan.setBuilding(null); //todo
                        if (buildAndLevel.length > 1) {
                            buildingPlan.setLevel(Integer.parseInt(buildAndLevel[1]));
                        }
                    }
                }
            }
        }
    }
}
