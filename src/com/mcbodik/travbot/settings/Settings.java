package com.mcbodik.travbot.settings;

import java.util.HashMap;
import java.util.Map;

import static com.mcbodik.travbot.settings.SettingsKey.*;

public class Settings {

    private static Settings instance = new Settings();
    private Map<SettingsKey, String> settings = new HashMap<>();

    private Settings() {
    }

    public static Settings getInstance() {
        return instance;
    }

    public String getUrl() {
        return settings.get(URL);
    }

    public String getLogin() {
        return settings.get(LOGIN);
    }

    public String getPassword() {
        return settings.get(PASSWORD);
    }

    void set(SettingsKey key, String value){
        settings.put(key, value);
    }

    void setUrl(String url) {
        settings.put(URL, url);
    }

    void setLogin(String name) {
        settings.put(LOGIN, name);
    }

    void setPassword(String password) {
        settings.put(PASSWORD, password);
    }
}
