package com.komarov.lost.floraAndFauna.animals;
import com.komarov.lost.Utills.Utills;
import com.komarov.lost.floraAndFauna.animals.herbivores.Buffalo;
import com.komarov.lost.floraAndFauna.animals.herbivores.Caterpillar;
import com.komarov.lost.floraAndFauna.animals.herbivores.Deer;
import com.komarov.lost.floraAndFauna.animals.predators.Bear;

public class AnimalFactory {
    public Animal createAnimal(AnimalType type) {

        Animal animal = null;

        switch (type) {
            case BUFFALO:
                animal = new Buffalo();
                break;
            case CATERPILLAR:
                animal = new Caterpillar();
                break;
            case BEAR:
                animal = new Bear();
                break;
            case DEER:
                animal = new Deer();
                break;
        }
        return animal;
    }

    public AnimalType getRandomAnimalType() {
        AnimalType type = null;
        AnimalType[] animalTypes = {AnimalType.BUFFALO, AnimalType.CATERPILLAR, AnimalType.DEER, AnimalType.BEAR};
        return animalTypes[Utills.rollTheDice(3)];
    }
}