package com.komarov.lost.floraAndFauna.animals.herbivores;

import com.komarov.lost.floraAndFauna.animals.Animal;
import com.komarov.lost.floraAndFauna.animals.AnimalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Mouse extends Herbivore{
    protected String EMOJI = "\uD83D\uDC01"; // 🐁
    public int id;
    final static int MAX_POPULATION_ON_AREA = 500;
    final static double MAX_SATIETY = 0.01;
    @Getter
    int speed;
    @Getter
    double weight;

    public Mouse() {
        satiety = getMaxSatiety() / 2;
        hungry = getSatiety() < getMaxSatiety();
        speed = 1;
        weight = 0.05d;
        this.id = ++Animal.id;
    }

    @Override
    public double getMaxSatiety() {
        return MAX_SATIETY;
    }

    @Override
    public String toString() {
        char status = isHungry() ? 'h' : 'f';
        return EMOJI + " " + status + getSatiety() + " " + id;
    }

    public AnimalType getAnimalType() {
        return AnimalType.MOUSE;
    }
}
