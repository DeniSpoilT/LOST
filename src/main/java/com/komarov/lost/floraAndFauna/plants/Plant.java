package com.komarov.lost.floraAndFauna.plants;

import com.komarov.lost.floraAndFauna.Eateble;
import lombok.Getter;


public class Plant implements Eateble {
    public final static String PLANT_EMOJI = "\uD83C\uDF3F"; // 🌿
    @Getter
    static final int MAX_POPULATION_ON_AREA = 100;
    @Getter
    static final private int WEIGHT = 5;

    public Plant() {
    }

    @Override
    public String toString() {
        return PLANT_EMOJI;
    }

    @Override
    public int getWeight() {
        return WEIGHT;
    }
}
