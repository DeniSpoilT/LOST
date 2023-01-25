package com.komarov.lost.floraAndFauna.animals.herbivores;

import com.komarov.lost.floraAndFauna.animals.AnimalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Duck extends Herbivore {
    protected String EMOJI = "\uD83E\uDD86"; // 🦆

    final static int MAX_POPULATION_ON_AREA = 200;
    final static double MAX_SATIETY = 0.15d;
    @Getter
    int speed;
    @Getter
    double weight;

    public Duck() {
        satiety = getMaxSatiety() / 2;
        hungry = getSatiety() < getMaxSatiety();
        speed = 4;
        weight = 1.0d;
    }

    @Override
    public synchronized void eat() {
        //add method findCaterpillar
        super.eat();
    }

    @Override
    public double getMaxSatiety() {
        return MAX_SATIETY;
    }

    @Override
    public String toString() {
        char status = isHungry() ? 'h' : 'f';
        return EMOJI + " " + status + getSatiety();
    }

    public AnimalType getAnimalType() {
        return AnimalType.DUCK;
    }
}
