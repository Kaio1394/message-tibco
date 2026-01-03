package br.com.app.messagetibco.dto;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public final class ModelMapperConfig {

    private static final ModelMapper INSTANCE = new ModelMapper();

    static {
        INSTANCE.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
    }

    private ModelMapperConfig() {}

    public static ModelMapper getInstance() {
        return INSTANCE;
    }
}
