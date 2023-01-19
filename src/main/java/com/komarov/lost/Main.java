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
    public synchronized static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);

        Thread growthPlantsThread = new Thread(new SimulationPlantsGrowth());
        Thread animalsLiveThread = new Thread(new SimulationAnimalLive());
        Thread report = new Thread(new SimulationReport());
        Thread nightSimulation = new Thread(new SimulationNight());

        service.schedule(growthPlantsThread, 1, TimeUnit.SECONDS);
        service.schedule(animalsLiveThread, 5, TimeUnit.SECONDS);
        service.schedule(nightSimulation, 10, TimeUnit.SECONDS);
//        service.schedule(report, 1, TimeUnit.SECONDS);
        Island island = Island.getInstance();
        
        while (true) {
            System.out.println(island);
            Thread.sleep(2000);
        }

    }
}