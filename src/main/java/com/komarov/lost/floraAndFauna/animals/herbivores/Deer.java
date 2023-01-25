package com.komarov.lost.floraAndFauna.animals.herbivores;

import com.komarov.lost.floraAndFauna.animals.AnimalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Deer extends Herbivore {
    protected String EMOJI = "\uD83E\uDD8C"; // 🦌

    final static int MAX_POPULATION_ON_AREA = 20;
    final static int MAX_SATIETY = 50;
    @Getter
    int speed;
    @Getter
    double weight;

    public Deer() {
        satiety = getMaxSatiety() / 2;
        hungry = getSatiety() < getMaxSatiety();
        speed = 4;
        weight = 300.0d;
    }

    @Override
    public synchronized void eat() {
        for (int i = 0; i < 8; i++) {
            super.eat();
        }
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

    public AnimalType getAnimalType() {
        return AnimalType.DEER;
    }
}
