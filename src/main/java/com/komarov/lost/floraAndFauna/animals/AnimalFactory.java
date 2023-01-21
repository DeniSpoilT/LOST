package com.komarov.lost.floraAndFauna.animals;

import com.komarov.lost.Utills.Utills;
import com.komarov.lost.floraAndFauna.animals.herbivores.Buffalo;

public class AnimalFactory {

    public Animal createAnimal(AnimalType type) {

        Animal animal = null;

        switch (type){
            case BUFFALO:
                animal = new Buffalo();
            break;
        }

        return animal;
    }

    public AnimalType getRandomAnimalType(){
        AnimalType type = null;
        switch (Utills.rollTheDice(0)){
            case 0:
                type = AnimalType.BUFFALO;
                break;
        }
        return type;
    }

    public enum AnimalType {
        BUFFALO
    }
}
