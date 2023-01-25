package com.komarov.lost.floraAndFauna.animals.herbivores;

import com.komarov.lost.floraAndFauna.animals.AnimalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Sheep extends Herbivore {
    protected String EMOJI = "\uD83D\uDC11"; // 🐑
    final static int MAX_POPULATION_ON_AREA = 140;
    final static int MAX_SATIETY = 15;
    @Getter
    int speed;
    @Getter
    double weight;

    public Sheep() {
        satiety = getMaxSatiety() / 2;
        hungry = getSatiety() < getMaxSatiety();
        speed = 3;
        weight = 70.0d;
    }

    @Override
    public synchronized void eat() {
        for (int i = 0; i < 7; i++) {
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
        return AnimalType.SHEEP;
    }
}
