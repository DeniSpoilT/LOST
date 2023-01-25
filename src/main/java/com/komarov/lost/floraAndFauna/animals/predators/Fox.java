package com.komarov.lost.floraAndFauna.animals.predators;

import com.komarov.lost.floraAndFauna.animals.AnimalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode
public class Fox extends Predator {
    protected String EMOJI = "\uD83E\uDD8A"; // 🦊
    final static int MAX_POPULATION_ON_AREA = 30;
    final static int MAX_SATIETY = 2;
    @Getter
    int speed;
    @Getter
    Map chanceOfEatingPrey = new HashMap<AnimalType, Integer>();

    {
        chanceOfEatingPrey.put(AnimalType.RABBIT, 70);
        chanceOfEatingPrey.put(AnimalType.MOUSE, 90);
        chanceOfEatingPrey.put(AnimalType.CATERPILLAR, 40);
        chanceOfEatingPrey.put(AnimalType.DUCK, 60);
    }

    public Fox() {
        satiety = getMaxSatiety() / 2;
        hungry = getSatiety() < getMaxSatiety();
        speed = 2;
    }

    @Override
    public synchronized void eat() {
        for (int i = 0; i < 5; i++) {
            super.eat();
        }
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

    @Override
    public int getChanceByTypeOfPrey(AnimalType type) {
        return (int) chanceOfEatingPrey.get(type);
    }

    public double getSatiety() {
        return this.satiety;
    }

    public void setSatiety(double value) {
        this.satiety = value;
    }

    @Override
    public double getMaxSatiety() {
        return MAX_SATIETY;
    }

    @Override
    public String toString() {
        char status = isHungry() ? 'h' : 'f';
        return EMOJI + " " + status + (int) getSatiety();
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.FOX;
    }
}
