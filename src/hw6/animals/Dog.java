package hw6.animals;

public class Dog extends Animal {
    static int numberOfDog = 0; //переменная подсчета собак
    private final int maxDistRunDog = 500; //максимальный пробег собаки
    private final int maxDistSwim = 10; //максимальная дистанция плавания собаки

    public Dog(String name, String color, int age) {
        super(name, color, age); //вызываем родительский конструктор
        numberOfDog++; // при создании собаки увеличиваем переменную на 1
    }

    @Override
    public void run(int dist) {// Вариант использования метода бега родителя
        maxDistRun = maxDistRunDog;
        super.run(dist);
    }

    @Override
    public void swim(int dist) { // 3. Есть ограничения на плавание собаки  10м
        if (dist <= maxDistSwim && dist > 0) {
            System.out.println(name + " проплыл " + dist + " метров.");
        } else {
            System.out.println(name + " не сможет проплыть " + dist + " метров.");
        }
    }

    public static void printDogs() {//Статический метод подсчета собак
        System.out.println("Cоздано " + numberOfDog + " собак");
    }
}
