package com.komarov.lost.floraAndFauna.animals.herbivores;

import com.komarov.lost.floraAndFauna.animals.AnimalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Mouse extends Herbivore{
    protected String EMOJI = "\uD83D\uDC01"; // 🐁
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
    }

    public double getSatiety() {
        return this.satiety;
    }

    public void setSatiety(double value) {
        this.satiety = value;
    }

    @Override
    public double getMaxSatiety() {
        return MAX_SATIETY;
    }

    @Override
    public boolean isHungry() {
        return hungry;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    @Override
    public String toString() {
        char status = isHungry() ? 'h' : 'f';
        return EMOJI + " " + status + getSatiety();
    }

    public AnimalType getAnimalType() {
        return AnimalType.MOUSE;
    }
}
