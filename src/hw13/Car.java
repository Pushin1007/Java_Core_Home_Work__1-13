package hw13;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private static AtomicInteger winner;
    private static CyclicBarrier cbStart;
    private static CountDownLatch cdlFinish;


    static {
        winner = new AtomicInteger(0);
        cdlFinish = MainClass.cdlFinish;
        cbStart = MainClass.cbStart;
    }

    String getName() {
        return name;
    }

    int getSpeed() {
        return speed;
    }

    Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cbStart.await(); //блокируем поток, пока не наберется нужное количество потоков
        } catch (Exception e) {
            e.printStackTrace();
        }
        final ArrayList<Stage> stages = race.getStages(); // стартуем

        for (Stage stage : stages) {
            stage.go(this);
        }
        cdlFinish.countDown(); // уменьшение счетчика финиша машин

        if (winner.incrementAndGet() == 1) {
            System.out.println(this.name + " ПОБЕДИЛ В ГОНКЕ!!!");
        }

    }
}
