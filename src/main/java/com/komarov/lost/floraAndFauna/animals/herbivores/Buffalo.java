package com.komarov.lost.floraAndFauna.animals.herbivores;

import com.komarov.lost.floraAndFauna.Eateble;
import com.komarov.lost.floraAndFauna.animals.Animal;
import com.komarov.lost.floraAndFauna.plants.Plant;
import lombok.*;

@Getter
public class Buffalo extends Animal implements Herbivore {

    public final static String BUFFALO_EMOJI = "\uD83D\uDC03"; // 🐃

    final static int MAX_POPULATION_ON_AREA = 10;
    final static int MAX_SATIETY = 100;

    final int speed = 3;
    final int weight = 700;
    @Setter
    int satiety = MAX_SATIETY / 2;
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
    public void eat() {
        if (satiety<MAX_SATIETY) {
            super.eat();
        }
    }

    @Override
    public Eateble getFood() {
        Plant plant = null;
        if (findFood()) {
            plant = getPosition().getPlantsOnCell().get(0);
            getPosition().removePlantFromCell(plant);
            System.out.println("getting");
        }
        return plant;
    }
    @Override
    public boolean findFood(){
        System.out.println("finding");
        System.out.println(getPosition());
        return getPosition().getPlantsOnCell().size() > 0;
    }

    @Override
    public String toString() {
        char status = this.isHungry() ? 'h' : 'f';
        return BUFFALO_EMOJI + " " + status;
    }
}
