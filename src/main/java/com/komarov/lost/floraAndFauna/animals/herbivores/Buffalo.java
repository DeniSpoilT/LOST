package com.komarov.lost.floraAndFauna.animals.herbivores;

import com.komarov.lost.floraAndFauna.Eateble;
import com.komarov.lost.floraAndFauna.animals.Animal;
import com.komarov.lost.floraAndFauna.plants.Plant;
import lombok.*;

@Getter @EqualsAndHashCode
public class Buffalo extends Animal implements Herbivore {

    protected String EMOJI = "\uD83D\uDC03"; // 🐃

    final static int MAX_POPULATION_ON_AREA = 10;
    final static int MAX_SATIETY = 100;

    final int speed = 3;
    final int weight = 700;
//    @Setter @Getter
//    protected int satiety = MAX_SATIETY / 2;
//    @Setter
//    boolean hungry = this.satiety < MAX_SATIETY;

    public Buffalo(int x, int y) {
        coordinateX = x;
        coordinateY = y;
    }

    @Override
    protected void selectDirection() {
    }


    @Override
    public synchronized Eateble getFood() {
        Plant plant = null;
        if (findFood()) {
            plant = getPosition().getPlantsOnCell().get(0);
            getPosition().removePlantFromCell(plant);
        }
        return plant;
    }
    @Override
    public boolean findFood(){
        System.out.println(getPosition());
        return getPosition().getPlantsOnCell().size() > 0;
    }
    @Override
    public synchronized void starving(){
        satiety = satiety - (MAX_SATIETY/4);
    }

    @Override
    public String toString() {
        char status = isHungry() ? 'h' : 'f';
        return EMOJI + " " + status + this.satiety;
  }
}
