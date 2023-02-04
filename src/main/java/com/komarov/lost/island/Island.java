package com.komarov.lost.island;

import com.komarov.lost.Utills.Utills;
import lombok.Getter;

import java.util.Arrays;

public class Island {
    private static Island ISLAND;
    @Getter
    private final int horizontalIslandSize = 3;
    @Getter
    private final int verticalIslandSize = 3;
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

    public void growPlants() {
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
                currentCell.animalsReproduce();
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

    public static synchronized boolean checkLife() {
        return Arrays.stream(getInstance().island)
                .flatMap(Arrays::stream)
                .flatMap(cell -> cell.getAnimalsOnCell().stream())
                .toList().size() > 0;
    }

    public Cell getCell(int coordinateX, int coordinateY) {
        return island[coordinateX][coordinateY];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < island.length; x++) {
            for (int y = 0; y < island[0].length; y++) {
                Cell current = island[x][y];
                if (current.getAnimalsOnCell().size() > 0) {
                    sb.append(current + "\n");
                }
            }
        }
        System.out.println("*********************************************************************");
        return sb.toString();
    }
}