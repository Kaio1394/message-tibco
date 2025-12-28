package br.com.app.messagetibco.config;

import lombok.AllArgsConstructor;

import java.util.Locale;
import java.util.ResourceBundle;

public final class I18n {

    private static final ResourceBundle BUNDLE =
            ResourceBundle.getBundle(
                    "br.com.app.messagetibco.properties.messages",
                    Locale.getDefault()
            );

    private I18n() {}

    public static String get(String key) {
        return BUNDLE.getString(key);
    }

    public static ResourceBundle getBundle() {
        return BUNDLE;
    }
}