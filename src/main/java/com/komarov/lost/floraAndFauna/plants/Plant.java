package com.komarov.lost.floraAndFauna.plants;

import lombok.Getter;


public class Plant {
    public final static String PLANT_EMOJI = "\uD83C\uDF3F"; // 🌿
    @Getter
    static final int maxPopulationOnArea = 100;
    @Getter
    static final private int weight = 5;

    public Plant() {

    }

    @Override
    public String toString() {
        return PLANT_EMOJI;
    }
}
