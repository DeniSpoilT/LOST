package com.komarov.lost;

import com.komarov.lost.floraAndFauna.animals.herbivores.Buffalo;
import com.komarov.lost.floraAndFauna.plants.Plant;


public class Main {
    public static void main(String[] args) {

        Buffalo buffalo = new Buffalo();
        System.out.println(Buffalo.BUFFALO_EMOJI + " " + buffalo);
        System.out.println();
               buffalo.eat(new Plant());
               buffalo.eat(new Plant());
        System.out.println(buffalo);

    }
}