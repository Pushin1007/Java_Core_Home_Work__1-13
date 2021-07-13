package hw6;

import hw6.animals.*;
//import hw6.animals.Cat;
//import hw6.animals.Dog;

public class Main {
    public static void main(String[] args) {
        Cat catBarsik = new Cat("Барсик", "Белый", 3);
        Cat catMursik = new Cat("Мурзик", "Черный", 1);
        Animal dogSharik = new Dog("Шарик", "Рыжий", 7);

        catBarsik.info();
        catMursik.info();
        dogSharik.info();

        catBarsik.run(199);
        catBarsik.swim(3); //проверка кота на плавучесть
        catMursik.run(-5); //проверка на отрицательную дистанцию
        dogSharik.run(100);
        dogSharik.swim(8);

//4. * Добавить подсчет созданных котов, собак и животных.
        Animal.printAnimals();
        Cat.printCats();
        Dog.printDogs();


    }
}
