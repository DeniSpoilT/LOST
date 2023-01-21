package com.komarov.lost.floraAndFauna.plants;

import com.komarov.lost.floraAndFauna.Eateble;
import lombok.Getter;


public class Plant implements Eateble {
    private final static String PLANT_EMOJI = "\uD83C\uDF3F"; // 🌿
    @Getter
    private static final int MAX_POPULATION_ON_AREA = 200;
    @Getter
    private static final int WEIGHT = 1;

    @Override
    public String toString() {
        return PLANT_EMOJI;
    }

    @Override
    public int getWeight() {
        return WEIGHT;
    }
}
