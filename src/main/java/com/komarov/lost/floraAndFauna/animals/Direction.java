package com.komarov.lost.floraAndFauna.animals;
import com.komarov.lost.Utills.Utills;

public enum Direction {
    NOT_MOVE, NORTH, SOUTH, WEST, EAST;

    private static Direction getDirectionToNumber(int number) {
        return Direction.values()[number];
    }

    public static Direction getRandomDirection() {
        return getDirectionToNumber(Utills.rollTheDice(4));
    }

    public static Direction getRandomNotMNorthSouthWest() {
        return getDirectionToNumber(Utills.rollTheDice(3));
    }

    public static Direction getRandomNMNorthSouthEast() {
        int index = Utills.rollTheDice(3);
        if (index == 3) {
            index = 4;
        }
        return getDirectionToNumber(index);
    }

    public static Direction getRandomNMNorthWestEast() {
        int index = Utills.rollTheDice(3);
        if (index == 2) {
            index = 4;
        }
        return getDirectionToNumber(index);
    }

    public static Direction getRandomNMSouthWestEast() {
        int index = Utills.rollTheDice(3);
        if (index == 1) {
            index = 4;
        }
        return getDirectionToNumber(index);
    }

    public static Direction getRandomNMEastSouth() {
        int index = Utills.rollTheDice(2);
        if (index == 1) {
            index = 4;
        }
        return getDirectionToNumber(index);
    }

    public static Direction getRandomNMEastNorth() {
        int index = Utills.rollTheDice(2);
        if (index == 2) {
            index = 4;
        }
        return getDirectionToNumber(index);
    }

    public static Direction getRandomNMWestSouth() {
        int index = Utills.rollTheDice(2);
        if (index == 1) {
            index = 3;
        }
        return getDirectionToNumber(index);
    }

    public static Direction getRandomNMWestNorth() {
        int index = Utills.rollTheDice(2);
        if (index == 2) {
            index = 3;
        }
        return getDirectionToNumber(index);
    }
}