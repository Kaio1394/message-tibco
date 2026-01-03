package br.com.app.messagetibco.config;

import java.io.InputStream;
import java.util.Properties;

public class AppConfig {

    private static final Properties PROPS = new Properties();

    static {
        try (InputStream is = AppConfig.class
                .getResourceAsStream("/config/application.properties")) {

            PROPS.load(is);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar application.properties", e);
        }
    }

    private AppConfig() {}

    public static String get(String key) {
        return PROPS.getProperty(key);
    }

    public static void set(String key, String value) {
        PROPS.setProperty(key, value);
    }
}