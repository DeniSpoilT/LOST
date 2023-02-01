package com.komarov.lost.floraAndFauna.animals.predators;

import com.komarov.lost.floraAndFauna.animals.Animal;
import com.komarov.lost.floraAndFauna.animals.AnimalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode
public class Wolf extends Predator {
    protected String EMOJI = "\uD83D\uDC3A"; // 🐺
    public int id;
    final static int MAX_POPULATION_ON_AREA = 30;
    final static int MAX_SATIETY = 8;
    @Getter
    int speed;
    @Getter
    Map chanceOfEatingPrey = new HashMap<AnimalType, Integer>();

    {
        chanceOfEatingPrey.put(AnimalType.HORSE, 10);
        chanceOfEatingPrey.put(AnimalType.DEER, 15);
        chanceOfEatingPrey.put(AnimalType.RABBIT, 60);
        chanceOfEatingPrey.put(AnimalType.MOUSE, 80);
        chanceOfEatingPrey.put(AnimalType.GOAT, 60);
        chanceOfEatingPrey.put(AnimalType.SHEEP, 70);
        chanceOfEatingPrey.put(AnimalType.HOG, 15);
        chanceOfEatingPrey.put(AnimalType.BUFFALO, 10);
        chanceOfEatingPrey.put(AnimalType.DUCK, 40);
    }

    public Wolf() {
        satiety = getMaxSatiety() / 2;
        hungry = getSatiety() < getMaxSatiety();
        speed = 3;
        this.id = ++Animal.id;;
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
        return AnimalType.WOLF;
    }
}
