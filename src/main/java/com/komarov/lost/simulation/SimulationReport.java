package com.komarov.lost.simulation;

import com.komarov.lost.island.Island;

public class SimulationReport implements Runnable{
    Island island = Island.getInstance();
    @Override
    public void run() {
        System.out.println(island);
    }
}
