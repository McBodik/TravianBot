package com.mcbodik.travbot.settings;

public enum SettingsKey {

    URL("url"), LOGIN("login"), PASSWORD("password");

    private String keyword;

    SettingsKey(String key) {
        keyword = key;
    }

    public static SettingsKey getKeyByKeyword(String keyword) {
        for (SettingsKey key : values()) {
            if (key.keyword.equals(keyword)) {
                return key;
            }
        }
        return null;
    }
}
