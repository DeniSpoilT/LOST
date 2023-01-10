package com.komarov.lost.island;


public class Island{

    private Cell[][] island;

    public Island(int verticalIslandSize, int horizontalIslandSize) {
        island = new Cell[verticalIslandSize][horizontalIslandSize];
        for (int x = 0; x < island.length; x++) {
            for (int y = 0; y < island[0].length; y++) {
                island[x][y] = new Cell(x, y);
            }
        }
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


