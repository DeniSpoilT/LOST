package com.komarov.lost.floraAndFauna.animals.herbivores;
import lombok.*;


@EqualsAndHashCode
public class Buffalo extends Herbivore {
    protected String EMOJI = "\uD83D\uDC03"; // 🐃
    final static int MAX_POPULATION_ON_AREA = 10;
    final static int MAX_SATIETY = 100;
    @Getter
    final int SPEED = 3;
    final int WEIGHT = 700;

    public int getSatiety() {
        return this.satiety;
    }

    @Override
    public synchronized void eat() {
        for (int i = 0; i < 10; i++) {
            super.eat();
        }
    }

    @Override
    public synchronized void starving() {
        setSatiety(getSatiety() - (getMaxSatiety() / 4));
    }

    @Override
    public int getMaxSatiety() {
        return MAX_SATIETY;
    }

    @Override
    public boolean isHungry() {
        return this.hungry;
    }

    @Override
    public String toString() {
        char status = isHungry() ? 'h' : 'f';
        return EMOJI + " " + status + getSatiety();
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }


}
