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
    private List<? extends Animal> animalsOnCell;
    @Getter
    private List<Plant> plantsOnCell;

    public Cell(int coordinateX, int coordinateY) {
        setCoordinateX(coordinateX);
        setCoordinateY(coordinateY);
        animalsOnCell = Stream.generate(() ->
                 animalFactory.createAnimal(AnimalFactory.AnimalType.BUFFALO, coordinateX, coordinateY))
                .limit(Utills.rollTheDice(10))
                .collect(Collectors.toList());
        plantsOnCell = Utills.fillListPlants(20);

    }


    @Override
    public String toString() {
        return "coordinates " + coordinateX + "/" + coordinateY + "\n" +
                "animalsOnCell: " + animalsOnCell.toString() + "\n" +
                "plantsOnCell: " + plantsOnCell.toString() + "\n" +
                "--------------------------------------------------------";
    }


}
