package hw11;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        String[] arr2 = {"Один", "Два", "Три", "Четыре", "Пять"};
        System.out.println(Arrays.toString(arr2));
        changeArr(arr2, 4, 1);
        System.out.println(Arrays.toString(arr2));
        System.out.println(changeArrToArrayList(arr2).size());

        Apple apple1 = new Apple();// Собираем яблоки с дерева
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();


        Orange orange1 = new Orange(); // Собираем апельсины с дерева
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();

        Box<Apple> box1 = new Box<>(); //Делаем коробку  с яблоками 1
        Box<Apple> box2 = new Box<>(); //Делаем коробку  с яблоками 2

        Box<Orange> box3 = new Box<>(); //Делаем коробку с апельсинами 3
        Box<Orange> box4 = new Box<>(); //Делаем коробку с апельсинами 4


        box1.addFruit(apple1);// Кладем яблоки в коробку 1
        box1.addFruit(apple1);
        box1.addFruit(apple3);

        box2.addFruit(apple2);// Кладем яблоки в коробку 2
        box2.addFruit(apple2);
        box2.addFruit(apple3);
        box2.addFruit(apple3);

        System.out.println(box1.getWeight()); //вес кобобки с яблоками 1
        System.out.println(box2.getWeight()); //вес кобобки с яблоками 2

        box3.addFruit(orange3); // Кладем апельсины в коробку 3

        box4.addFruit(orange1); // Кладем апельсины в коробку 4
        box4.addFruit(orange1);
        box4.addFruit(orange2);

        System.out.println(box3.getWeight()); //вес кобобки с апельсинами 3
        System.out.println(box4.getWeight()); //вес кобобки с апельсинами 4

        System.out.println(box1.compare(box4));//сравниваем коробки

        box3.moveFruit(box4); // пересыпаем апельсины из коробки 4 в коробку 3

        System.out.println(box3.getWeight());
        System.out.println(box4.getWeight());


    }


    public static <T> T[] changeArr(T[] array, int i1, int i2) { //1 Метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
        T a;
        if (i1 >= array.length || i2 >= array.length || i1 < 0 || i2 < 0) {
            System.out.println("Введенные номера ячеек не находятся в области массива");
            throw new IllegalArgumentException();
        }
        a = array[i1];
        array[i1] = array[i2];
        array[i2] = a;
        return array;
    }


    public static <T> List<T> changeArrToArrayList(T[] array) { //2 Метод, который преобразует массив в ArrayList;
        List<T> newArrayList = new ArrayList<>();
        Collections.addAll(newArrayList, array);//Первый способ
//        for (T x: array) { // Второй способ
//            newArrayList.add(x);
//        }
        return newArrayList;
    }


}