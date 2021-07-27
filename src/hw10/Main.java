package hw10;


import java.util.*;

public class Main {


    public static void main(String[] args) {
        //1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        // Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        // Посчитать, сколько раз встречается каждое слово.

        String[] words = { //массив слов
                "должны", "массив", "сколько", "раз", "слово", "список", "слово", "cоздать", "должны", "должны", "массив", "должны", "вывести"};
        Map<String, Integer> mapWords = new HashMap<>();// создание мар


        for (int i = 0; i < words.length; i++) { // наполнение мар: ключи - уникальные слова, значение - сколько раз встречаются в массиве
            mapWords.put(words[i], mapWords.getOrDefault(words[i], 0) + 1);
        }

        System.out.println("Список уникальных слов: ");
        System.out.println(mapWords.keySet());//Выводим множество уникальных слов

//        for (Map.Entry<String, Integer> entry : mapWords.entrySet()) { //Выводим сколько раз встречаются в массиве постаринке
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
        System.out.println();
        mapWords.forEach((key, value) -> System.out.println("Слово " + key + " встречается " + value + " раз"));//Выводим сколько раз встречаются в массиве с помощью лямбда выражения


        //2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
        // В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get()
        // искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов,
        // тогда при запросе такой фамилии должны выводиться все телефоны.

        PhoneBook phonebook = new PhoneBook(); //создаем новую телефонную книгу

        phonebook.add("Sasin", 5553322); //заносим абнентов в справочник
        phonebook.add("Sasin", 5554425);
        phonebook.add("Savin", 5268915);
        phonebook.add("Kozin", 5553322);
        phonebook.add("Mirchuk", 5553322);
        phonebook.add("Gololobov", 4586599);
        phonebook.add("Kozin", 3332233);

        System.out.println(phonebook.get("Kozin")); //поиск телефона по имени абонента
        System.out.println(phonebook.get("K")); //поиск телефона если нет абонента

        phonebook.printSubscriberNumber("Sasin"); //печать телефонных номеров абонента
        phonebook.printSubscriberNumber("Pushin");

        System.out.println("End");

    }


}
