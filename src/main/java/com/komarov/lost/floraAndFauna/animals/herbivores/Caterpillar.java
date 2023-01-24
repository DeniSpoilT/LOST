package com.komarov.lost.floraAndFauna.animals.herbivores;
import com.komarov.lost.floraAndFauna.animals.AnimalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Caterpillar extends Herbivore{
    public final static String EMOJI = "\uD83D\uDC1B"; // 🐛
    final static int MAX_POPULATION_ON_AREA = 200;
    final static int MAX_SATIETY = 5;
    @Getter
    int speed = 0;
    @Getter
    double weight = 0.01d;

    public double getSatiety() {
        return this.satiety;
    }
    public void setSatiety(double value){
        this.satiety = value;
    }

    @Override
    public synchronized void starving() {
        setSatiety(getSatiety() - (getMaxSatiety() / 5));
        if (getSatiety()<0){
            setSatiety(0);
        }
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

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.CATERPILLAR;
    }
}
