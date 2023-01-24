package com.komarov.lost.floraAndFauna.animals.predators;
import com.komarov.lost.Utills.Utills;
import com.komarov.lost.floraAndFauna.Eateble;
import com.komarov.lost.floraAndFauna.animals.Animal;
import com.komarov.lost.floraAndFauna.animals.AnimalType;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Predator extends Animal {
    @Override
    public synchronized Eateble getFood() {
        Animal prey = hunting();
        if (prey != null) {
            if (getChanceOfEatingPrey().containsKey(prey.getAnimalType())) {
                if (huntWasSucces(prey.getAnimalType())) {
                    getPosition().getAnimalsOnCell().remove(prey);
                }
            } else {
                prey = null;
            }
        }
        return (Eateble) prey;
    }

    public Animal hunting() {
        Animal prey = null;
        if (findFood()) {
            prey = getPosition().getAnimalsOnCell().stream()
                    .filter(animal -> animal instanceof Eateble)
                    .findAny().orElse(null);
        }
        return prey;
    }

    protected abstract Map<AnimalType, Integer> getChanceOfEatingPrey();

    private boolean huntWasSucces(AnimalType type) {
        return Utills.rollTheDice(100) > getChanceByTypeOfPrey(type);
    }

    @Override
    public boolean findFood() {
        return getPosition().getAnimalsOnCell().stream()
                .filter(animal -> animal instanceof Eateble)
                .collect(Collectors.toList()).size() > 0;
    }

    public abstract int getChanceByTypeOfPrey(AnimalType type);
}