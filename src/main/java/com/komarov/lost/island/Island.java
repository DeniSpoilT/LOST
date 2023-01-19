package com.komarov.lost.island;


import com.komarov.lost.Utills.Utills;
import lombok.Getter;

import java.util.Arrays;
import java.util.stream.Stream;

public class Island {
    private static Island ISLAND; // for test

    private final int horizontalIslandSize = 10;
    private final int verticalIslandSize = 10;

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
                island[x][y].addPlants(Utills.rollTheDice(10));
            }
        }
    }

    public void dayComing() {
        for (int x = 0; x < island.length; x++) {
            for (int y = 0; y < island[0].length; y++) {
                Cell currentCell = island[x][y];
                currentCell.animalsEat();
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
        return sb.toString();
    }


}


