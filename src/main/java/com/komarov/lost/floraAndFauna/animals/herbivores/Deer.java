package com.komarov.lost.floraAndFauna.animals.herbivores;
import com.komarov.lost.floraAndFauna.animals.AnimalType;
import lombok.Getter;

public class Deer extends Herbivore{
    protected String EMOJI = "\uD83E\uDD8C"; // 🦌

    final static int MAX_POPULATION_ON_AREA = 20;
    final static int MAX_SATIETY = 50;
    @Getter
    int speed;
    @Getter
    double weight;

    public Deer() {
        satiety = getMaxSatiety() / 2;
        hungry = getSatiety() < getMaxSatiety();
        speed = 4;
        weight  = 300.0d;
    }

    public double getSatiety() {
        return this.satiety;
    }

    public void setSatiety(double value){
        this.satiety = value;
    }

    @Override
    public synchronized void eat() {
        for (int i = 0; i < 8; i++) {
            super.eat();
        }
    }

    @Override
    public synchronized void starving() {
        setSatiety(getSatiety() - (getMaxSatiety() / 4));
        if (getSatiety() < 0) {
            setSatiety(0);
        }
        hungry = getSatiety() < getMaxSatiety();
    }

    @Override
    public int getMaxSatiety() {
        return MAX_SATIETY;
    }

    @Override
    public boolean isHungry() {
        return hungry;
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

    public AnimalType getAnimalType() {
        return AnimalType.DEER;
    }
}
