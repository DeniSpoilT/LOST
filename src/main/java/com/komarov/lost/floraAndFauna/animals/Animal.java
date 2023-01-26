package com.komarov.lost.floraAndFauna.animals;

import com.komarov.lost.floraAndFauna.Eateble;
import com.komarov.lost.island.Cell;
import com.komarov.lost.island.Island;

public abstract class Animal {
    protected int coordinateX;
    protected int coordinateY;
    protected int weight;
    protected double satiety;

    public abstract boolean isHungry();

    protected boolean hungry;

    public synchronized void move() {
        int count = this.getSpeed();
        for (int i = 0; i < count; i++) {
            getPosition().getAnimalsOnCell().remove(this);
            setCoordinateToDirection(selectDirection());
            getPosition().getAnimalsOnCell().add(this);
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
                    currentDirection = Direction.getRandomNMSouthWestEast();//south east west
                } else if (currentY == maxY) {
                    currentDirection = Direction.getRandomNMNorthWestEast();//north east west
                }
            }

        } else if (currentX == 0 || currentX == maxX) {
            if (currentY != 0 && currentY != maxY) {
                if (currentX == 0) {
                    currentDirection = Direction.getRandomNMNorthSouthEast();
                } else if (currentX == maxX) {
                    currentDirection = Direction.getRandomNotMNorthSouthWest();
                }
            }

        } else if (currentX == 0) {
            if (currentY == 0) {
                currentDirection = Direction.getRandomNMEastSouth(); //east south
            } else if (currentY == maxY) {
                currentDirection = Direction.getRandomNMEastNorth();//east north
            }

        } else if (currentX == maxX) {
            if (currentY == 0) {
                currentDirection = Direction.getRandomNMWestSouth();//west south
            } else if (currentY == maxY) {
                currentDirection = Direction.getRandomNMWestNorth();//west north
            }
        }
        return currentDirection;
    }

    public synchronized void reproduce() {
        AnimalFactory animalFactory = new AnimalFactory();
        if (this.getSatiety() > getMaxSatiety() / 2 && findPair() != null) {
            getPosition().getAnimalsOnCell().add(animalFactory.createAnimal(this.getAnimalType()));
        }
    }

    public synchronized Animal findPair() {
        return getPosition().getAnimalsOnCell().stream()
                .filter(animal -> animal.getAnimalType().equals(this.getAnimalType()))
                .filter(animal -> animal.getSatiety() > animal.getMaxSatiety() / 2)
                .findFirst().orElse(null);
    }

    public synchronized void eat() {
        Eateble food = getFood();
        if (food != null && satiety < getMaxSatiety()) {
            satiety += food.getCaloric();
            if (satiety >= getMaxSatiety()) {
                satiety = getMaxSatiety();
                hungry = false;
            }
        }
    }

    public Cell getPosition() {
        return Island.getInstance().getCell(coordinateX, coordinateY);
    }

    public int getCoordinateX() {
        return this.coordinateX;
    }

    public int getCoordinateY() {
        return this.coordinateY;
    }

    public abstract AnimalType getAnimalType();

    public abstract void setCoordinateX(int coordinateX);

    public abstract void setCoordinateY(int coordinateY);

    public abstract Eateble getFood();

    public abstract int getSpeed();

    public abstract boolean findFood();

    public abstract void starving();

    public abstract double getMaxSatiety();

    public abstract double getSatiety();
}