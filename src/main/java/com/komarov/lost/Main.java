package com.komarov.lost;

import com.komarov.lost.island.Island;
import com.komarov.lost.simulation.SimulationAnimalLive;
import com.komarov.lost.simulation.SimulationNight;
import com.komarov.lost.simulation.SimulationPlantsGrowth;
import com.komarov.lost.simulation.SimulationReport;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public synchronized static void main(String[] args) {

        boolean flag = true;
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

        service.scheduleWithFixedDelay(new SimulationPlantsGrowth(), 1, 2, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(new SimulationAnimalLive(), 2, 10, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(new SimulationNight(), 5, 10, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(new SimulationReport(), 1, 3, TimeUnit.SECONDS);

        while (flag){
            flag = Island.checkLife();
            try {
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        service.shutdownNow();


    }

}