package com.komarov.lost.floraAndFauna.animals.predators;

import com.komarov.lost.Utills.Utills;
import com.komarov.lost.floraAndFauna.Eateble;
import com.komarov.lost.floraAndFauna.animals.Animal;
import com.komarov.lost.floraAndFauna.animals.AnimalType;

import java.util.Map;
import java.util.stream.Collectors;

public abstract class Predator extends Animal {
    @Override
    public synchronized Eateble getFood() {
        Animal prey = hunting();
        if (prey != null) {
            if (getChanceOfEatingPrey().containsKey(prey.getAnimalType())) {
                if (huntWasSucces(prey.getAnimalType())) {
                    getPosition().getAnimalsOnCell().remove(prey);
                }
            } else {
                prey = null;
            }
        }
        return (Eateble) prey;
    }

    public synchronized Animal hunting() {
        Animal prey = null;
        if (findFood()) {
            prey = getPosition().getAnimalsOnCell().stream()
                    .filter(animal -> animal instanceof Eateble)
                    .findAny().orElse(null);
            getPosition().getAnimalsOnCell().remove(prey);
        }
        return prey;
    }

    protected abstract Map<AnimalType, Integer> getChanceOfEatingPrey();

    private boolean huntWasSucces(AnimalType type) {
        return Utills.rollTheDice(100) > 100 - getChanceByTypeOfPrey(type);
    }

    @Override
    public synchronized boolean findFood() {
        return getPosition().getAnimalsOnCell().stream()
                .filter(animal -> animal instanceof Eateble)
                .collect(Collectors.toList()).size() > 0;
    }
    @Override
    public synchronized void starving() {
        setSatiety(getSatiety() - (getMaxSatiety() / 4));
        if (getSatiety() < 0) {
            setSatiety(0);
        }
        hungry = getSatiety() < getMaxSatiety();
    }

    @Override
    public boolean isHungry() {
        return hungry;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public double getSatiety() {
        return this.satiety;
    }

    public void setSatiety(double value) {
        this.satiety = value;
    }

    public abstract int getChanceByTypeOfPrey(AnimalType type);
}