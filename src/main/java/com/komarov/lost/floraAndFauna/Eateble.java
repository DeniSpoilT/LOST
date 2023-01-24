package com.komarov.lost.floraAndFauna;

public interface Eateble {
    default double getCaloric(){
        return getWeight();
    }
    double getWeight();
}