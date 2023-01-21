package com.komarov.lost;
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

        service.scheduleWithFixedDelay(growthPlantsThread, 1, 2, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(animalsLiveThread, 1, 2, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(nightSimulation, 4, 12, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(report, 1, 2, TimeUnit.SECONDS);

    }
}