package hw13;


/*
1. Перенести приведенный в методичке код в новый проект, где мы организуем гонки.
2. Все участники должны стартовать одновременно, несмотря на разное время подготовки.
В тоннель не может одновременно заехать больше половины участников (условность).
3. Попробуйте все это синхронизировать.
4. Первый участник, пересекший финишную черту, объявляется победителем (в момент пересечения этой самой черты). Победитель должен быть только один (ситуация с 0 или 2+ победителями недопустима).
Когда все завершат гонку, нужно выдать объявление об окончании.
5. Можно корректировать классы (в том числе конструктор машин) и добавлять объекты классов из пакета java.util.concurrent.
 */

import java.util.concurrent.*;

public class MainClass {

    static final int CARS_COUNT = 4;  //количество машин учавствующих в гонке
    static final CountDownLatch cdlFinish = new CountDownLatch(CARS_COUNT);
    static final CyclicBarrier cbStart = new CyclicBarrier(CARS_COUNT, () -> System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!")); // синхронизация старта всех машин в одной точке. Как только заданное количество потоков заблокировалось , с них одновременно снимаем блокировку.

    public static void main(String[] args) throws InterruptedException {

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road(60), new Tunnel(80), new Road(40));  //создаем трассу

        Car[] cars = new Car[CARS_COUNT]; //создаем массив машин

        for (int i = 0; i < cars.length; i++) {
            final int randomSpeed = 20 + (int) (Math.random() * 10);// рандомная скорость
            cars[i] = new Car(race, randomSpeed);
        }
        for (int i = 0; i < cars.length; i++) {// каждая машина едет в своем потоке
            new Thread(cars[i]).start();
        }

        cdlFinish.await(); // ожидаем когда все выполнят все препятствия
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
