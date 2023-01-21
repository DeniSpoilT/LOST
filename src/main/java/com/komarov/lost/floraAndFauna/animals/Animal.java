package com.komarov.lost.floraAndFauna.animals;


import com.komarov.lost.floraAndFauna.Eateble;
import com.komarov.lost.island.Cell;
import com.komarov.lost.island.Island;
import lombok.Getter;
import lombok.Setter;


public abstract class Animal {

    protected int coordinateX;
    protected int coordinateY;

    protected int weight;   // Animal weight
    protected int maxPopulationOnArea; // The maximum population of animals of this species per area
    protected int speed; // Animal speed
    @Setter
    @Getter
    protected int satiety = getMaxSatiety() / 2; // How many kilograms of food does an animal need for full saturation

    @Getter
    protected boolean hungry = getSatiety() < getMaxSatiety(); // The flag of satiety, if true, the animal is hungry

//    protected reproduce(Animal animal) {
//        if (this.getClass() == animal.getClass()) {
//            if (this.getSatiety() > getMaxSatiety() / 2 && animal.getSatiety() > getMaxSatiety()/2) {
//                AnimalFactory animalFactory = new AnimalFactory();
//                this.getPosition().getAnimalsOnCell()
//                        .add(animalFactory.createAnimal(AnimalFactory.AnimalType(this.getClass()), getPosition().getCoordinateX(), getPosition().getCoordinateY()));
//            }
//        }
//
//    }

    protected abstract void selectDirection();

    protected void move() {

    }

    public synchronized void eat() {
        Eateble food = getFood();
        if (food != null && satiety < getMaxSatiety()) {
            satiety += food.getCaloric();
        } else {
            this.hungry = false;
        }
    }

    public Cell getPosition() {
        return Island.getInstance().getCell(coordinateX, coordinateY);
    }

    public abstract void setCoordinateX(int coordinateX);

    public int getCoordinateX() {
        return this.coordinateX;
    }

    public abstract void setCoordinateY(int coordinateY);

    public int getCoordinateY() {
        return this.coordinateY;
    }

    public abstract Eateble getFood();

    public abstract boolean findFood();

    public abstract void starving();

    public abstract int getMaxSatiety();

}
