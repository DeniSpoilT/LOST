package com.komarov.lost.island;

import com.komarov.lost.Utills.Utills;
import lombok.Getter;

public class Island {
    private static Island ISLAND;
    @Getter
    private final int horizontalIslandSize = 30;
    @Getter
    private final int verticalIslandSize = 30;
    @Getter
    private final Cell[][] island;

    public static synchronized Island getInstance() {
        if (ISLAND == null) {
            ISLAND = new Island();
        }
        return ISLAND;
    }

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
                currentCell.animalsLeavingTheCell();
            }
        }
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