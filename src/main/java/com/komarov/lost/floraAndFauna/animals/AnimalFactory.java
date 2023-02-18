package com.komarov.lost.floraAndFauna.animals;

import com.komarov.lost.Utills.Utills;
import com.komarov.lost.floraAndFauna.animals.herbivores.*;
import com.komarov.lost.floraAndFauna.animals.predators.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class AnimalFactory {
    private static final Logger log = LoggerFactory.getLogger(AnimalFactory.class);

    public Animal createAnimal(AnimalType type) {
        log.info("Creating animal = " + type);
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

    public static void main(String[] args) {
        AnimalFactory af = new AnimalFactory();
        Animal animal = af.createAnimal(af.getRandomAnimalType());
    }

    public AnimalType getRandomAnimalType() {
        return AnimalType.values()[Utills.rollTheDice(14)];
    }
}