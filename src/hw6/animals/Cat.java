package hw6.animals;

public class Cat extends Animal {
    private final int maxDistRunCat = 200; // максимальный пробег кота
    static int numberOfCat = 0; // переменная подсчета котов

    public Cat(String name, String color, int age) {
        super(name, color, age);
        numberOfCat++; // при создании кота увеличиваем переменную на 1
    }

    @Override
    public void run(int dist) { //Вариант использования метода бега родителя
        maxDistRun = maxDistRunCat;
        super.run(dist);
    }

    @Override
    public void swim(int dist) {  // Метод плавания кота.
        System.out.println(name + " не умеет плавать.");
    }

    public static void printCats() {//Статический метод подсчета котов
        System.out.println("Cоздано " + numberOfCat + " котов");
    }

}
