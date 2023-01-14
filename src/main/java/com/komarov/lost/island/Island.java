package com.komarov.lost.island;


import com.komarov.lost.Utills.Utills;
import lombok.Getter;

public class Island {
    public static final Island ISLAND;

    static {
        ISLAND = new Island(1,1);
    }

    @Getter
    private final Cell[][] island;

    public Island(int horizontalIslandSize, int verticalIslandSize) {
        island = new Cell[horizontalIslandSize][verticalIslandSize];
        for (int x = 0; x < island.length; x++) {
            for (int y = 0; y < island[0].length; y++) {
                island[x][y] = new Cell(x, y);
            }
        }
    }

    public void fillPlants(){
        for (int x = 0; x < island.length; x++) {
            for (int y = 0; y < island[0].length; y++) {
               island[x][y].addPlants(Utills.rollTheDice(10));
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


