package com.komarov.lost.floraAndFauna.animals;

import com.komarov.lost.floraAndFauna.Eateble;
import com.komarov.lost.island.Cell;
import com.komarov.lost.island.Island;
import lombok.Getter;
import lombok.Setter;

public abstract class Animal {
    protected int coordinateX;
    protected int coordinateY;

    protected int weight;   // Animal weight
    protected int maxPopulationOnArea; // The maximum population of animals of this species per area
    @Setter
    @Getter
    protected int satiety = getMaxSatiety() / 2; // How many kilograms of food does an animal need for full saturation


    public abstract boolean isHungry();

    protected boolean hungry = getSatiety() < getMaxSatiety(); // The flag of satiety, if true, the animal is hungry

    protected synchronized Direction selectDirection() {
        Island island = Island.getInstance();
        int maxX = island.getHorizontalIslandSize() - 1;
        int maxY = island.getVerticalIslandSize() - 1;
        int currentX = getCoordinateX();
        int currentY = getCoordinateY();

        Direction currentDirection = Direction.NOT_MOVE;

        if (currentX > 0 && currentY > 0 && currentX < maxX && currentY < maxY) {

            currentDirection = Direction.getRandomDirection();

        } else if (currentY == 0 || currentY == maxY) {
            if (currentX != 0 && currentX != maxX) {
                if (currentY == 0) {
                    currentDirection =  Direction.getRandomNMSouthWestEast();//south east west
                } else if (currentY == maxY) {
                    currentDirection =  Direction.getRandomNMNorthWestEast();//north east west
                }
            }

        } else if (currentX == 0 || currentX == maxX) {
            if (currentY != 0 && currentY != maxY) {
                if (currentX == 0) {
                    currentDirection =  Direction.getRandomNMNorthSouthEast();
                } else if (currentX == maxX) {
                    currentDirection =  Direction.getRandomNotMNorthSouthWest();
                }
            }

        } else if (currentX == 0) {
            if (currentY == 0) {
                currentDirection =  Direction.getRandomNMEastSouth(); //east south
            } else if (currentY == maxY) {
                currentDirection =  Direction.getRandomNMEastNorth();//east north
            }

        } else if (currentX == maxX) {
            if (currentY == 0) {
                currentDirection =  Direction.getRandomNMWestSouth();//west south
            } else if (currentY == maxY) {
                currentDirection =  Direction.getRandomNMWestNorth();//west north
            }
        }
        return currentDirection;
    }

    public synchronized void move() {
        int count = this.getSPEED();
        for (int i = 0; i < count; i++) {
            getPosition().getAnimalsOnCell().remove(this);
            Animal animal = this;
            setCoordinateToDirection(selectDirection());
            getPosition().getAnimalsOnCell().add(animal);
        }
    }

    private synchronized void setCoordinateToDirection(Direction direction) {
        switch (direction) {
            case NORTH -> this.setCoordinateY(getCoordinateY() - 1);
            case SOUTH -> this.setCoordinateY(getCoordinateY() + 1);
            case WEST -> this.setCoordinateX(getCoordinateX() - 1);
            case EAST -> this.setCoordinateX(getCoordinateX() + 1);
            case NOT_MOVE -> this.setCoordinateX(getCoordinateX());
        }
    }

    public synchronized void eat() {
        Eateble food = getFood();
        if (food != null && satiety < getMaxSatiety()) {
            satiety += food.getCaloric();
        }
    }

    public Cell getPosition() {
        return Island.getInstance().getCell(coordinateX, coordinateY);
    }

    public abstract void setCoordinateX(int coordinateX);

    public int getCoordinateX() {
        return this.coordinateX;
    }

    public abstract void setCoordinateY(int coordinateY);

    public int getCoordinateY() {
        return this.coordinateY;
    }

    public abstract Eateble getFood();

    public abstract int getSPEED();

    public abstract boolean findFood();

    public abstract void starving();

    public abstract int getMaxSatiety();

}
