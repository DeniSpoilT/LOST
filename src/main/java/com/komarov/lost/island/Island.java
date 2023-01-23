package com.komarov.lost.island;

import com.komarov.lost.Utills.Utills;
import com.komarov.lost.simulation.SimulationPlantsGrowth;
import lombok.Getter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Island {
    private static Island ISLAND; // for test
    @Getter
    private final int horizontalIslandSize = 3;
    @Getter
    private final int verticalIslandSize = 3;

    public static synchronized Island getInstance() {
        if (ISLAND == null) {
            ISLAND = new Island();
        }
        return ISLAND;
    }

    @Getter
    private final Cell[][] island;

    public Island() {
        island = new Cell[horizontalIslandSize][verticalIslandSize];
        for (int x = 0; x < island.length; x++) {
            for (int y = 0; y < island[0].length; y++) {
                island[x][y] = new Cell(x, y);
            }
        }
    }

    public void fillPlants() {
        for (int x = 0; x < island.length; x++) {
            for (int y = 0; y < island[0].length; y++) {
                island[x][y].addPlants(Utills.rollTheDice(30));
            }
        }
    }

    public void dayComing() {
        for (int x = 0; x < island.length; x++) {
            for (int y = 0; y < island[0].length; y++) {
                Cell currentCell = island[x][y];
                currentCell.animalsEat();
//                currentCell.animalsReproduce();
                currentCell.animalsLeavingTheCell();
            }
        }
    }

    public static void main(String[] args) {
        Island island1 = getInstance();
        System.out.println(island1);
        Thread growthPlantsThread = new Thread(new SimulationPlantsGrowth());
        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
        service.scheduleWithFixedDelay(growthPlantsThread, 1, 1, TimeUnit.MILLISECONDS);
        for (int i = 0; i < 7; i++) {
            island1.dayComing();
            System.out.println(island1);
            System.out.println("*************** Iteration " + i + " ***************");
        }
        island1.nightComing();
        System.out.println(island1);
        service.shutdown();
    }

    public synchronized void nightComing() {
        for (int x = 0; x < island.length; x++) {
            for (int y = 0; y < island[0].length; y++) {
                Cell currentCell = island[x][y];
                currentCell.animalsStarving();
                currentCell.removeDeadAnimals();
            }
        }

    }

    public Cell getCell(int coordinateX, int coordinateY) {
        return island[coordinateX][coordinateY];
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < island.length; x++) {
            for (int y = 0; y < island[0].length; y++) {
                sb.append(island[x][y].toString() + "\n");
            }
        }
        System.out.println("*********************************************************************");
        return sb.toString();
    }


}


