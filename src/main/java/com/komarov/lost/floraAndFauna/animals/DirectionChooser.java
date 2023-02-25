package com.komarov.lost.floraAndFauna.animals;

import com.komarov.lost.floraAndFauna.animals.herbivores.Buffalo;
import com.komarov.lost.island.Island;

public class DirectionChooser {
    Island island = Island.getInstance();
    int maxX = island.getHorizontalIslandSize() - 1;
    int maxY = island.getVerticalIslandSize() - 1;
    int currentX;
    int currentY;
    Direction currentDirection = Direction.NOT_MOVE;

    public DirectionChooser(Animal animal) {
        this.currentX = animal.getCoordinateX();
        this.currentY = animal.getCoordinateY();
    }

    public synchronized Direction chooseDirection() {
        if (currentX > 0 && currentY > 0 && currentX < maxX && currentY < maxY) {
            return Direction.getRandomDirection();
        } else if ((currentY == 0) && (currentX == 0)) {
            return Direction.getRandomNMEastSouth();
        } else if (currentX == maxX && currentY == maxY) {
            return Direction.getRandomNMWestNorth();
        } else if (currentX == 0 || currentY == 0) {
            return getDirectionIfXorYIsZero();
        } else if (currentX == maxX || currentY == maxY) {
            return getDirectionIfXorYIsMax();
        }
        return currentDirection;
    }

    private Direction getDirectionIfXorYIsMax() {
        if (currentX == maxX) {
            return Direction.getRandomNotMNorthSouthWest();
        } else {
            return Direction.getRandomNMNorthWestEast();
        }
    }


    private Direction getDirectionIfXorYIsZero() {
        if (currentX == 0) {
            return getDirectionIfXIsZero();
        } else {
            return getDirectionIfYIsZero();
        }
    }

    private Direction getDirectionIfXIsZero() {
        if (currentY == maxY) {
            return Direction.getRandomNMEastNorth();
        } else {
            return Direction.getRandomNMNorthSouthEast();
        }
    }

    private Direction getDirectionIfYIsZero() {
        if (currentX == maxX) {
            return Direction.getRandomNMWestSouth();
        } else {
            return Direction.getRandomNMSouthWestEast();
        }
    }


    public static void main(String[] args) {
        Animal animal = new Buffalo();
        animal.setCoordinateX(1);
        animal.setCoordinateY(2);
        System.out.println(new DirectionChooser(animal).chooseDirection());
        System.out.println(new DirectionChooser(animal).chooseDirection());
        System.out.println(new DirectionChooser(animal).chooseDirection());
        System.out.println(new DirectionChooser(animal).chooseDirection());
        System.out.println(new DirectionChooser(animal).chooseDirection());
        System.out.println(new DirectionChooser(animal).chooseDirection());
        System.out.println(new DirectionChooser(animal).chooseDirection());
        System.out.println(new DirectionChooser(animal).chooseDirection());
        System.out.println(new DirectionChooser(animal).chooseDirection());
        System.out.println(new DirectionChooser(animal).chooseDirection());
    }
}