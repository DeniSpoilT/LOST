package com.komarov.lost.floraAndFauna.animals.predators;
import com.komarov.lost.floraAndFauna.animals.AnimalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode
public class Bear extends Predator {
    protected String EMOJI = "\uD83D\uDC3B"; // 🐻
    final static int MAX_POPULATION_ON_AREA = 5;
    final static int MAX_SATIETY = 80;
    @Getter
    int speed;
    @Getter
    Map chanceOfEatingPrey = new HashMap<AnimalType, Integer>();
    {
        chanceOfEatingPrey.put(AnimalType.SNAKE, 80);
        chanceOfEatingPrey.put(AnimalType.HORSE, 40);
        chanceOfEatingPrey.put(AnimalType.DEER, 80);
        chanceOfEatingPrey.put(AnimalType.RABBIT, 80);
        chanceOfEatingPrey.put(AnimalType.MOUSE, 90);
        chanceOfEatingPrey.put(AnimalType.GOAT, 70);
        chanceOfEatingPrey.put(AnimalType.SHEEP, 70);
        chanceOfEatingPrey.put(AnimalType.HOG, 50);
        chanceOfEatingPrey.put(AnimalType.BUFFALO, 20);
        chanceOfEatingPrey.put(AnimalType.DUCK, 10);
    }

    public Bear(){
        satiety = getMaxSatiety() / 2;
        hungry = getSatiety() < getMaxSatiety();
        speed = 2;
    }
    @Override
    public boolean isHungry() {
        return hungry;
    }

    @Override
    public AnimalType getAnimalType() {
        return AnimalType.BEAR;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    @Override
    public int getChanceByTypeOfPrey(AnimalType type) {
        return (int) chanceOfEatingPrey.get(type);
    }

    @Override
    public synchronized void starving() {
        setSatiety(getSatiety() - (getMaxSatiety() / 4));
        if (getSatiety() < 0) {
            setSatiety(0);
        }
        hungry = getSatiety() < getMaxSatiety();
    }

    public double getSatiety() {
        return this.satiety;
    }

    public void setSatiety(double value){
        this.satiety = value;
    }
    @Override
    public int getMaxSatiety() {
        return MAX_SATIETY;
    }

    @Override
    public String toString() {
        char status = isHungry() ? 'h' : 'f';
        return EMOJI + " " + status + getSatiety();
    }
}
