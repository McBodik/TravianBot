package com.mcbodik.travbot.settings;

import java.util.HashMap;
import java.util.Map;

public class Settings {

    public static final String FILE_PATH = "";
    public static final String FILE_NAME = "settings.txt";

    public static final String URL = "url";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";

    private static Settings instance = new Settings();
    private Map<String, String> settings = new HashMap<>();

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
