package hw10;

import java.util.*;

public class PhoneBook {

    private HashMap<String, List<Integer>> phonebook; // создание мар


    public PhoneBook() { //конструктор телефонной книги
        this.phonebook = new HashMap<String, List<Integer>>();
    }

    public void add(String name, Integer number) {//метод добавления нового абонента
        List<Integer> num = new ArrayList<Integer>(); //создаем новый список телефонов абонента

        if (this.phonebook.containsKey(name)) {// если такой ключ(абонент) есть
            num = this.phonebook.get(name); //сознанный список равен староми списку
            num.add(number);//добавляем новый номер
            this.phonebook.put(name, num);//добавляем абонента в мар
        } else {
            num.add(number); // оставляем "чистый" список
            this.phonebook.put(name, num); //добавляем абонента в мар
        }
    }


    public List<Integer> get(String name) { //метод поиска телефонов по имени абонента
        return this.phonebook.get(name);
    }

    public void printSubscriberNumber(String name) { //метод печати телефонных номеров абонента
        if (this.phonebook.get(name) != null) {
            System.out.println("Абонент " + name + " имеет телефонные номера " + this.phonebook.get(name));
        } else {
            System.out.println("Абонент " + name + " не занесен в телефонную книгу или не имеет телефонного номера");
        }

    }
}



