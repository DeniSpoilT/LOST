package com.komarov.lost.floraAndFauna.animals.predators;

import com.komarov.lost.floraAndFauna.animals.Animal;
import com.komarov.lost.floraAndFauna.animals.AnimalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode
public class Eagle extends Predator {
    protected String EMOJI = "\uD83E\uDD85"; // 🦅
    public int id;
    final static int MAX_POPULATION_ON_AREA = 20;
    final static int MAX_SATIETY = 1;
    @Getter
    int speed;
    @Getter
    Map chanceOfEatingPrey = new HashMap<AnimalType, Integer>();

    {
        chanceOfEatingPrey.put(AnimalType.FOX, 10);
        chanceOfEatingPrey.put(AnimalType.RABBIT, 90);
        chanceOfEatingPrey.put(AnimalType.MOUSE, 90);
        chanceOfEatingPrey.put(AnimalType.DUCK, 80);
    }

    public Eagle() {
        satiety = getMaxSatiety() / 2;
        hungry = getSatiety() < getMaxSatiety();
        speed = 3;
        this.id = ++Animal.id;
    }

    @Override
    public synchronized void eat() {
        for (int i = 0; i < 3; i++) {
            super.eat();
        }
    }

    @Override
    public int getChanceByTypeOfPrey(AnimalType type) {
        return (int) chanceOfEatingPrey.get(type);
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

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.EAGLE;
    }
}
