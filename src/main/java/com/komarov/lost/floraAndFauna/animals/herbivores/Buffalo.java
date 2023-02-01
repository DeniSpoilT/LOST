package com.komarov.lost.floraAndFauna.animals.herbivores;

import com.komarov.lost.floraAndFauna.animals.Animal;
import com.komarov.lost.floraAndFauna.animals.AnimalType;
import lombok.*;

@EqualsAndHashCode
public class Buffalo extends Herbivore {
    protected String EMOJI = "\uD83D\uDC03"; // 🐃
    public int id;
    final static int MAX_POPULATION_ON_AREA = 10;
    final static int MAX_SATIETY = 100;
    @Getter
    int speed;
    @Getter
    double weight;

    public Buffalo() {
        satiety = getMaxSatiety() / 2;
        hungry = getSatiety() < getMaxSatiety();
        speed = 3;
        weight = 700.0d;
        this.id = ++Animal.id;
    }

    @Override
    public synchronized void eat() {
        for (int i = 0; i < 20; i++) {
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
        return EMOJI + " " + status + (int) getSatiety() + " " + this.id;
    }

    public AnimalType getAnimalType() {
        return AnimalType.BUFFALO;
    }

}
