package com.komarov.lost.floraAndFauna.plants;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Plant {
    public final static String PLANT_EMOJI = "\uD83C\uDF3F"; // 🌿
    static final int maxPopulationOnArea = 100;
    final private int weight = 50;
}
