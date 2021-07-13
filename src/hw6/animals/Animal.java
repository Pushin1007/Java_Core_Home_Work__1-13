package hw6.animals;

public abstract class Animal { //1. Создать классы Собака и Кот с наследованием от класса Животное.
    String name;
    String color;
    int age;
    int maxDistRun; //максимальная дистанция пробега животного
    static int numberOfAnimal = 0; // переменная подсчета животных

    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
        numberOfAnimal++; // при создании животного увеличиваем переменную на 1
    }

    public void info() { // инфо о животном
        System.out.printf(" %s %s %d \n", name, color, age);
    }

    //2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
    // Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');

    public void run(int dist) { //решенный метод

        if (dist <= maxDistRun && dist > 0) {
            System.out.println(name + " пробежал " + dist + " метров.");
        } else {
            System.out.println(name + " не сможет пробежать " + dist + " метров.");
        }
    }

    public abstract void swim(int dist);// не доделанный метод. Переопределим в наследованных классах

    public static void printAnimals() {// Статический метод. Подсчет животных
        System.out.println("Cоздано " + numberOfAnimal + " животных");
    }
}
