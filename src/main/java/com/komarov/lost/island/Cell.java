package com.komarov.lost.island;
import com.komarov.lost.Utills.Utills;
import com.komarov.lost.floraAndFauna.animals.Animal;
import com.komarov.lost.floraAndFauna.animals.AnimalFactory;
import com.komarov.lost.floraAndFauna.plants.Plant;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
public class Cell {
    AnimalFactory animalFactory = new AnimalFactory();
    private int coordinateX;
    private int coordinateY;
    @Getter
    private volatile List<Animal> animalsOnCell;
    @Getter
    private volatile List<Plant> plantsOnCell;


    public Cell(int coordinateX, int coordinateY) {
        setCoordinateX(coordinateX);
        setCoordinateY(coordinateY);
        animalsOnCell = Stream.generate(() ->
                        animalFactory.createAnimal(animalFactory.getRandomAnimalType()))
                .limit(Utills.rollTheDice(5))
                .peek(animal -> animal.setCoordinateX(coordinateX))
                .peek(animal -> animal.setCoordinateY(coordinateY))
                .collect(Collectors.toList());
        plantsOnCell = Utills.fillListPlants(Utills.rollTheDice(100));
    }

    public void removePlantFromCell(Plant plant) {
        plantsOnCell.remove(plant);
    }

    public void addPlants(int number) {
        if (plantsOnCell.size() < Plant.getMAX_POPULATION_ON_AREA()) {
            plantsOnCell.addAll(Utills.fillListPlants(number));
        }
    }

    public synchronized void animalsEat() {
        List copy = animalsOnCell;
        for (int i = copy.size() - 1; i > -1; i--) {
            animalsOnCell.get(i).eat();
        }
    }

    public synchronized void animalsStarving() {
        List copy = animalsOnCell;
        for (int i = copy.size() - 1; i > -1; i--) {
            animalsOnCell.get(i).starving();
        }
    }

    public synchronized void animalsLeavingTheCell() {
        List copy = animalsOnCell;
        for (int i = copy.size() - 1; i > -1; i--) {
            animalsOnCell.get(i).move();
        }
    }

    public synchronized void removeDeadAnimals() {
        animalsOnCell.removeIf(animal -> animal.getSatiety() < animal.getMaxSatiety()/4);
    }

    @Override
    public String toString() {
        return "coordinates " + coordinateX + "/" + coordinateY + "\n" +
                "animalsOnCell: " + animalsOnCell.toString() + "\n" +
                "plantsOnCell: " + Plant.EMOJI + plantsOnCell.size() + "\n" +
                "--------------------------------------------------------";
    }
}