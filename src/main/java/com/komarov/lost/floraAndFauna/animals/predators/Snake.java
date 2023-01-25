package com.komarov.lost.floraAndFauna.animals.predators;

import com.komarov.lost.floraAndFauna.animals.AnimalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode
public class Snake extends Predator {
    protected String EMOJI = "\uD83D\uDC0D"; // 🐍
    final static int MAX_POPULATION_ON_AREA = 30;
    final static int MAX_SATIETY = 3;
    @Getter
    int speed;
    @Getter
    Map chanceOfEatingPrey = new HashMap<AnimalType, Integer>();

    {
        chanceOfEatingPrey.put(AnimalType.FOX, 15);
        chanceOfEatingPrey.put(AnimalType.RABBIT, 20);
        chanceOfEatingPrey.put(AnimalType.MOUSE, 40);
        chanceOfEatingPrey.put(AnimalType.DUCK, 10);
    }

    public Snake() {
        satiety = getMaxSatiety() / 2;
        hungry = getSatiety() < getMaxSatiety();
        speed = 1;
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
        return EMOJI + " " + status + (int) getSatiety();
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.SNAKE;
    }
}
