package com.komarov.lost.floraAndFauna.animals.herbivores;

import com.komarov.lost.floraAndFauna.animals.Animal;
import lombok.*;


@Getter
public class Buffalo extends Animal implements Herbivore {

    public final static String BUFFALO_EMOJI = "\uD83D\uDC03"; // 🐃

    static int population;
    final static int maxPopulationOnArea = 10;
    final static int maxSatiety = 100;

    final int speed = 3;
    final int weight = 700;
    @Setter
    int satiety = maxSatiety / 2;
    @Setter
    boolean hungry = true;

    public Buffalo(int x, int y) {
        coordinateX = x;
        coordinateY = y;
    }


    @Override
    protected void selectDirection() {
    }


    @Override
    public void getFood(Object ob) {

    }


    @Override
    public String toString() {
        char status = this.isHungry() ? 'h' : 'f';
        return BUFFALO_EMOJI + " " + status;
    }
}
