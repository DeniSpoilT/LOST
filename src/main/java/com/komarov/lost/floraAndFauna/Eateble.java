package com.komarov.lost.floraAndFauna;

public interface Eateble {

    default int getCaloric(){
        return getWeight();
    }

    int getWeight();
}
