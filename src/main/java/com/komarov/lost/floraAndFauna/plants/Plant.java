package com.komarov.lost.floraAndFauna.plants;
import com.komarov.lost.floraAndFauna.Eateble;
import lombok.Getter;

public class Plant implements Eateble {
    public final static String EMOJI = "\uD83C\uDF3F"; // 🌿
    @Getter
    private static final int MAX_POPULATION_ON_AREA = 200;
    @Getter
    private static final double WEIGHT = 1.0d;

    @Override
    public String toString() {
        return EMOJI;
    }
    @Override
    public double getWeight() {
        return WEIGHT;
    }
}