package com.komarov.lost.floraAndFauna.animals.herbivores;

import com.komarov.lost.floraAndFauna.animals.Animal;
import com.komarov.lost.floraAndFauna.plants.Plant;
import lombok.*;

@Data
@RequiredArgsConstructor
public class Buffalo extends Animal implements Herbivore {
    public final static String BUFFALO_EMOJI = "\uD83D\uDC03";

    static int population;
    final static int maxPopulationOnArea = 0;
    final static int maxSatiety = 100;

    final int speed = 3;
    final int weight = 700;
    int satiety = maxSatiety / 2;
    boolean hungry = true;


    @Override
    protected void selectDirection() {
    }

    @Override
    protected void move() {
    }

    @Override
    public void eat(Plant plant) {
        if (plant != null && this.isHungry()) {
            setSatiety(this.satiety += plant.getWeight());
            setHungry(satiety < maxSatiety);
        } else if (!this.isHungry()) {
            System.out.println("the buffalo is not hungry");
        }
    }
}
