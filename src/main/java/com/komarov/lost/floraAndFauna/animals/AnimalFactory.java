package com.komarov.lost.floraAndFauna.animals;

import com.komarov.lost.Utills.Utills;
import com.komarov.lost.floraAndFauna.animals.herbivores.*;
import com.komarov.lost.floraAndFauna.animals.predators.*;

import java.util.Arrays;

public class AnimalFactory {
    public Animal createAnimal(AnimalType type) {

        Animal animal = null;

        animal = switch (type) {
            case BUFFALO -> new Buffalo();
            case CATERPILLAR -> new Caterpillar();
            case DEER -> new Deer();
            case DUCK -> new Duck();
            case GOAT -> new Goat();
            case HOG -> new Hog();
            case HORSE -> new Horse();
            case MOUSE -> new Mouse();
            case RABBIT -> new Rabbit();
            case SHEEP -> new Sheep();
            case BEAR -> new Bear();
            case EAGLE -> new Eagle();
            case FOX -> new Fox();
            case SNAKE -> new Snake();
            case WOLF -> new Wolf();
        };
        return animal;
    }

    public AnimalType getRandomAnimalType() {
        return AnimalType.values()[Utills.rollTheDice(14)];
    }
}