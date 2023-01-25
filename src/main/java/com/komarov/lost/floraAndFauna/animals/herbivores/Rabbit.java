package com.komarov.lost.floraAndFauna.animals.herbivores;

import com.komarov.lost.floraAndFauna.animals.AnimalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Rabbit extends Herbivore{
    protected String EMOJI = "\uD83D\uDC07"; // 🐇
    final static int MAX_POPULATION_ON_AREA = 150;
    final static double MAX_SATIETY = 0.45;
    @Getter
    int speed;
    @Getter
    double weight;

    public Rabbit() {
        satiety = getMaxSatiety() / 2;
        hungry = getSatiety() < getMaxSatiety();
        speed = 2;
        weight = 2.00d;
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
        return AnimalType.RABBIT;
    }
}
