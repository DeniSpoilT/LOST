package com.komarov.lost.simulation;

import com.komarov.lost.island.Island;

public class SimulationPlantsGrowth implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Island island = Island.ISLAND;
                island.fillPlants();
                Thread.sleep(1000);
            } catch (Exception exception) {
                System.out.println("Error");
            }
        }
    }


}
