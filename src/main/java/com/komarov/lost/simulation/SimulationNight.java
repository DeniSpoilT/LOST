package com.komarov.lost.simulation;

import com.komarov.lost.island.Island;

public class SimulationNight implements Runnable{
    Island island = Island.getInstance();
    @Override
    public void run() {
        island.nightComing();
    }
}
