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
    private final int MAX_ANIMALS_POPULATION_ON_CELL = 100;
    @Getter
    private volatile List<Animal> animalsOnCell;
    @Getter
    private volatile List<Plant> plantsOnCell;


    public Cell(int coordinateX, int coordinateY) {
        setCoordinateX(coordinateX);
        setCoordinateY(coordinateY);
        animalsOnCell = createListAnimals();
        plantsOnCell = Utills.fillListPlants(Utills.rollTheDice(100));
    }

    private List <Animal> createListAnimals(){
        return Stream.generate(() ->
                        animalFactory.createAnimal(animalFactory.getRandomAnimalType()))
                .limit(Utills.rollTheDice(MAX_ANIMALS_POPULATION_ON_CELL))
                .peek(animal -> {animal.setCoordinateX(coordinateX);
                                 animal.setCoordinateY(coordinateY);})
                .collect(Collectors.toList());
    }
    public synchronized void removePlantFromCell(Plant plant) {
        plantsOnCell.remove(plant);
    }

    public synchronized void addPlants(int number) {
        if (plantsOnCell.size() < Plant.getMAX_POPULATION_ON_AREA()) {
            plantsOnCell.addAll(Utills.fillListPlants(number));
        }
    }

    public synchronized void animalsEat() {
        for (int i = animalsOnCell.size() - 1; i > -1; i--) {
            animalsOnCell.get(i).eat();
        }
    }

    public synchronized void animalsReproduce() {
        for (int i = animalsOnCell.size() - 1; i > -1; i--) {
            animalsOnCell.get(i).reproduce();
        }
    }

    public synchronized void animalsStarving() {
        for (int i = animalsOnCell.size() - 1; i > -1; i--) {
            animalsOnCell.get(i).starving();
        }
    }

    public synchronized void animalsLeavingTheCell() {
        for (int i = animalsOnCell.size() - 1; i > -1; i--) {
            animalsOnCell.get(i).move();
        }
    }

    public synchronized void removeDeadAnimals() {
        animalsOnCell.removeIf(animal -> animal.getSatiety() < animal.getMaxSatiety()/4);
    }

    @Override
    public String toString() {
        return "coordinates " + coordinateX + ":" + coordinateY + "\n" +
                "animalsOnCell: " + animalsOnCell.toString() + "\n" +
                "plantsOnCell: " + Plant.EMOJI + plantsOnCell.size() + "\n" +
                "--------------------------------------------------------";
    }
}