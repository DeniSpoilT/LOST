package com.komarov.lost.floraAndFauna.animals;


import com.komarov.lost.floraAndFauna.Eateble;
import com.komarov.lost.island.Cell;
import com.komarov.lost.island.Island;


public abstract class Animal {

    public int coordinateX;
    public int coordinateY;

    int weight;   // Animal weight
    int maxPopulationOnArea; // The maximum population of animals of this species per area
    int speed; // Animal speed
    int satiety; // How many kilograms of food does an animal need for full saturation
    int MAX_SATIETY;
    boolean hungry; // The flag of satiety, if true, the animal is hungry

    //    protected abstract  reproduce(Animal animal);
    protected abstract void selectDirection();

    protected void move(){

    }

    public void eat() {
        Eateble food = getFood();
        if (food != null) {
            this.satiety += food.getCaloric();
            System.out.println("eating");
        }
    }

    public Cell getPosition(){
        return Island.ISLAND.getCell(coordinateX,coordinateY);
    }

    public abstract Eateble getFood();

    public abstract boolean findFood();



}
