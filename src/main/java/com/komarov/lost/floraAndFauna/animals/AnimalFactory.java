package com.komarov.lost.floraAndFauna.animals;

import com.komarov.lost.Utills.Utills;
import com.komarov.lost.floraAndFauna.animals.herbivores.*;
import com.komarov.lost.floraAndFauna.animals.predators.*;

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
        AnimalType type = null;
        AnimalType[] animalTypes = {AnimalType.BUFFALO, AnimalType.CATERPILLAR, AnimalType.DEER,
                AnimalType.DUCK, AnimalType.GOAT, AnimalType.HOG, AnimalType.HORSE,
                AnimalType.MOUSE, AnimalType.RABBIT, AnimalType.SHEEP, AnimalType.BEAR,
                AnimalType.EAGLE, AnimalType.FOX, AnimalType.SNAKE, AnimalType.WOLF};
        return animalTypes[Utills.rollTheDice(8)];
    }
}