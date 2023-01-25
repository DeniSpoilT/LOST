package com.komarov.lost.floraAndFauna.animals.herbivores;

import com.komarov.lost.floraAndFauna.animals.AnimalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Goat extends Herbivore {
    protected String EMOJI = "\uD83D\uDC10"; // 🐐
    final static int MAX_POPULATION_ON_AREA = 140;
    final static int MAX_SATIETY = 10;
    @Getter
    int speed;
    @Getter
    double weight;

    public Goat() {
        satiety = getMaxSatiety() / 2;
        hungry = getSatiety() < getMaxSatiety();
        speed = 3;
        weight = 60.0d;
    }

    @Override
    public synchronized void eat() {
        for (int i = 0; i < 6; i++) {
            super.eat();
        }
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
    public String toString() {
        char status = isHungry() ? 'h' : 'f';
        return EMOJI + " " + status + (int) getSatiety();
    }

    public AnimalType getAnimalType() {
        return AnimalType.GOAT;
    }
}
