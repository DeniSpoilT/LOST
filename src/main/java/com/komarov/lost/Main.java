package com.komarov.lost;

import com.komarov.lost.floraAndFauna.animals.Animal;
import com.komarov.lost.island.Island;
import com.komarov.lost.simulation.SimulationPlantsGrowth;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Island island = Island.ISLAND;

        System.out.println(island);
        Animal animal = island.getCell(0,0).getAnimalsOnCell().get(0);

        Thread newthread = new Thread(new SimulationPlantsGrowth());
        newthread.start();
        while(true) {
            System.out.println(island);
            Thread.sleep(3000);
        }



    }
}