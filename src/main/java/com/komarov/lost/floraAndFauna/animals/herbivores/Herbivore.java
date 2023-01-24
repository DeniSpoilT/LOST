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
    public abstract AnimalType getAnimalType();
}