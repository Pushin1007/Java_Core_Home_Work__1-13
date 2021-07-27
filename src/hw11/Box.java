package hw11;

import java.util.*;

public class Box<T extends Fruit> {//б. Класс Box, в который можно складывать фрукты.
    // Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;


    private List<T> fruitList; //в. Для хранения фруктов внутри коробки можно использовать ArrayList;


    public Box() {
        this.fruitList = new ArrayList<>();
    }

    public float getWeight() {//г. Метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта
        // и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
        float totalWeight = 0.0f;
        for (T t : this.fruitList) { // Первый вариант
            totalWeight += t.getWeight();
        }
        return totalWeight;
        //           return fruitList.size() * fruitList.get(0).getWeight();// Второй вариант
    }

    public boolean compare(Box box) {//д. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку
        // с той, которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
        // Можно сравнивать коробки с яблоками и апельсинами;
        return Math.abs(this.getWeight() - box.getWeight()) < 0.00001;
    }


    public void moveFruit(Box<T> box) {//е. Метод, который позволяет пересыпать фрукты из текущей коробки в другую.
// Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
// Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
        if (this != box) {
            this.fruitList.addAll(box.fruitList); // Первый вариант
//        for (T t : box.fruitList) { // Второй вариант
//            this.fruitList.add(t);
//        }
            box.fruitList.clear();
        }


    }

    public void addFruit(T fruit) {//ж. Метод добавления фрукта в коробку.
        fruitList.add(fruit);
    }


}
