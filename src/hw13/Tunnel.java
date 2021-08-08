package hw13;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    static Semaphore semaphore;// создаем пропускной режим

    Tunnel(int length) {
        this.length = length;
        this.description = "Тоннель " + this.length + " метров";
    }

    static {
        semaphore = new Semaphore(MainClass.CARS_COUNT / 2); // ограничиваем вьезд в тоннель
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
            semaphore.acquire(); // выдаем пропуск на вьезд
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // возвращаем пропуск для следущего потока
            System.out.println(c.getName() + " закончил этап: " + description);
        }
    }
}
