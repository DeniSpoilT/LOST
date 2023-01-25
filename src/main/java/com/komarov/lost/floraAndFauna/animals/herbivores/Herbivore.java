package com.komarov.lost.floraAndFauna.animals.herbivores;
import com.komarov.lost.floraAndFauna.Eateble;
import com.komarov.lost.floraAndFauna.animals.Animal;
import com.komarov.lost.floraAndFauna.animals.AnimalType;
import com.komarov.lost.floraAndFauna.plants.Plant;

public abstract class Herbivore extends Animal implements Eateble {

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
    public boolean findFood() {
        return getPosition().getPlantsOnCell().size() > 0;
    }
    @Override
    public synchronized void starving() {
        setSatiety(getSatiety() - (getMaxSatiety() / 4));
        if (getSatiety() < 0) {
            setSatiety(0);
        }
        hungry = getSatiety() < getMaxSatiety();
    }

    protected abstract void setSatiety(double satiety);

    public abstract AnimalType getAnimalType();
}