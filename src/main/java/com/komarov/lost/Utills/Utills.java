package com.komarov.lost.Utills;

import com.komarov.lost.floraAndFauna.plants.Plant;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utills {

    private Utills(){
    }

    public static List fillListPlants(int amountOfPlants){
        return Stream.generate(()-> new Plant())
                .limit(amountOfPlants)
                .collect(Collectors.toList());
    }

    public static int rollTheDice(int numberOfFaces){
        return new Random().nextInt(0, numberOfFaces);
    }

}
