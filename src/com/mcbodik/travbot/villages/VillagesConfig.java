package com.mcbodik.travbot.villages;

import java.util.*;

public class VillagesConfig {

    private static Map<String, VillageModel> villages = new HashMap<>();

    public static void addVillage(VillageModel village) {
        villages.put(village.getName(), village);
    }

    public static VillageModel getVillageByName(String village) {
        return villages.get(village);
    }

    public static List<VillageModel> getVillages() {
        return new ArrayList<>(villages.values());
    }

}
