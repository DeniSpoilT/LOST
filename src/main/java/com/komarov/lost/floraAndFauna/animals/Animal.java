package com.komarov.lost.floraAndFauna.animals;

import com.komarov.lost.floraAndFauna.Eateble;
import com.komarov.lost.island.Cell;
import com.komarov.lost.island.Island;

public abstract class Animal {
    protected static int id = 0;
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
        System.out.println(this.toString() + " new coordinate" + this.getCoordinateX() + ":" + this.getCoordinateY());
    }

    protected synchronized Direction selectDirection() {
        Direction direction = new DirectionChooser(this).chooseDirection();
        System.out.println(this.toString() + " go to the " + direction.toString());
        return direction;
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
        if (food == null){
            System.out.println(this.toString() + " did not find food");
        }
        if (food != null && satiety < getMaxSatiety()) {
            satiety += food.getCaloric();
            System.out.println(this.toString() + " ate the " + food.toString());
            if (satiety >= getMaxSatiety()) {
                satiety = getMaxSatiety();
                hungry = false;
            }
        }
    }

    public synchronized Cell getPosition() {
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