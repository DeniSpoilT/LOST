package com.komarov.lost.simulation;

import com.komarov.lost.island.Island;

public class SimulationPlantsGrowth implements Runnable {
    Island island = Island.getInstance();

    @Override
    public void run() {
        island.fillPlants();
    }


}
