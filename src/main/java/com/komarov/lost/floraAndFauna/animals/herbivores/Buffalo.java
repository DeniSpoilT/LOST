package com.komarov.lost.floraAndFauna.animals.herbivores;

import com.komarov.lost.floraAndFauna.Eateble;
import com.komarov.lost.floraAndFauna.animals.Animal;
import com.komarov.lost.floraAndFauna.plants.Plant;
import lombok.*;


public class Buffalo extends Animal implements Herbivore {

    protected String EMOJI = "\uD83D\uDC03"; // 🐃

    final static int MAX_POPULATION_ON_AREA = 10;
    final static int MAX_SATIETY = 100;

    final int SPEED = 3;
    final int WEIGHT = 700;

    public int getSatiety(){
        return this.satiety;
    }
    @Override
    protected void selectDirection() {
    }

    @Override
    public synchronized void eat(){
        for (int i = 0; i < 10; i++) {
            super.eat();
        }
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
        return getPosition().getPlantsOnCell().size() > 0;
    }
    @Override
    public synchronized void starving(){
        setSatiety(getSatiety() - (getMaxSatiety()/4));
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

  public void setCoordinateX(int coordinateX){
        this.coordinateX = coordinateX;
  }


    public void setCoordinateY(int coordinateY){
        this.coordinateY = coordinateY;
    }

}
