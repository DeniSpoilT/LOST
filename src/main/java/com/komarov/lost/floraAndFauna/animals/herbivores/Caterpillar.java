package com.komarov.lost.floraAndFauna.animals.herbivores;

import com.komarov.lost.floraAndFauna.animals.Animal;
import com.komarov.lost.floraAndFauna.animals.AnimalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Caterpillar extends Herbivore {
    protected String EMOJI = "\uD83D\uDC1B"; // 🐛
    public int id;
    final static int MAX_POPULATION_ON_AREA = 200;
    final static int MAX_SATIETY = 5;
    @Getter
    int speed;
    @Getter
    double weight;

    public Caterpillar() {
        satiety = getMaxSatiety() / 2;
        hungry = getSatiety() < getMaxSatiety();
        speed = 0;
        weight = 0.01d;
        this.id = ++Animal.id;
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
        return AnimalType.CATERPILLAR;
    }
}
