package com.komarov.lost.floraAndFauna.animals;

public abstract class Animal {

    int weight;   // Animal weight
    int population; // The total population of animals of the same species
    int maxPopulationOnArea; // The maximum population of animals of this species per area
    int speed; // Animal speed
    int satiety; // How many kilograms of food does an animal need for full saturation
    boolean hungry; // The flag of satiety, if true, the animal is hungry

//    protected abstract <T> reproduce(<T extends Animal> animal);
    protected abstract void selectDirection();
    protected abstract void move();
}
