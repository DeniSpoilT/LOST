package com.komarov.lost;
import com.komarov.lost.simulation.SimulationAnimalLive;
import com.komarov.lost.simulation.SimulationNight;
import com.komarov.lost.simulation.SimulationPlantsGrowth;
import com.komarov.lost.simulation.SimulationReport;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public synchronized static void main(String[] args) {

        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);

        service.scheduleWithFixedDelay(new SimulationPlantsGrowth(), 1, 2, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(new SimulationAnimalLive(), 2, 2, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(new SimulationNight(), 6, 6, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(new SimulationReport(), 1, 2, TimeUnit.SECONDS);

    }
}