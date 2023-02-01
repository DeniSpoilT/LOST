package com.komarov.lost.floraAndFauna.animals.herbivores;

import com.komarov.lost.floraAndFauna.animals.Animal;
import com.komarov.lost.floraAndFauna.animals.AnimalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Hog extends Herbivore {
    protected String EMOJI = "\uD83D\uDC17"; // 🐗
    public int id;
    final static int MAX_POPULATION_ON_AREA = 50;
    final static int MAX_SATIETY = 50;
    @Getter
    int speed;
    @Getter
    double weight;

    public Hog() {
        satiety = getMaxSatiety() / 2;
        hungry = getSatiety() < getMaxSatiety();
        speed = 2;
        weight = 400.0d;
        this.id = ++Animal.id;
    }

    @Override
    public synchronized void eat() {
        //add method eatCaterpillar and eatMouse
        for (int i = 0; i < 9; i++) {
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
        return AnimalType.HOG;
    }
}
