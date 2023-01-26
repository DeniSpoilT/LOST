package com.komarov.lost.simulation;

import com.komarov.lost.island.Island;

public class SimulationAnimalLive implements Runnable {
    Island island = Island.getInstance();

    @Override
    public void run() {

        try {
            island.dayComing();
        } catch (Exception ex) {//
            throw ex;
        }

    }
}
