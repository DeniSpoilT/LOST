package com.komarov.lost.floraAndFauna.plants;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Plant {
    static final int maxPopulationOnArea = 100;
    final private int weight = 50;
}
