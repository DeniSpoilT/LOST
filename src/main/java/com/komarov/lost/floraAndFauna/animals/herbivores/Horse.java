package com.komarov.lost.floraAndFauna.animals.herbivores;

import com.komarov.lost.floraAndFauna.animals.Animal;
import com.komarov.lost.floraAndFauna.animals.AnimalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Horse extends Herbivore{
    protected String EMOJI = "\uD83D\uDC0E"; // 🐎
    public int id;
    final static int MAX_POPULATION_ON_AREA = 20;
    final static int MAX_SATIETY = 60;
    @Getter
    int speed;
    @Getter
    double weight;

    public Horse() {
        satiety = getMaxSatiety() / 2;
        hungry = getSatiety() < getMaxSatiety();
        speed = 4;
        weight = 400.0d;
        this.id = ++Animal.id;
    }

    @Override
    public synchronized void eat() {
        for (int i = 0; i < 12; i++) {
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
        return EMOJI + " " + status + (int) getSatiety() + " " + id;
    }

    public AnimalType getAnimalType() {
        return AnimalType.HORSE;
    }
}
