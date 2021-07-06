package hw5;

public class Main {
    public static void main(String[] args) {
        //Employee employee1 = new Employee(); // после создания своего конструктора, втроенный конструктор не работает
        Employee employee1 = new Employee("Мирчук", "Кузнец", "+7-911-456-48-55", 10000, 73);


        Employee[] employees = { //4. Создать массив из 5 сотрудников.
                new Employee("Мирчук", "Кузнец", "+7-911-456-48-55", 100000, 73),
                new Employee("Сасин", "Столяр", "vova@mail.ru", "+7-911-556-48-55", 108000, 35),
                new Employee("Савин", "Художник", "sas@mail.ru", "+7-925-546-56-88", 110000, 45),
                new Employee("Касьян", "Оператор ЧПУ", "kas@mail.ru", "+7-925-546-53-88", 100000, 38),
                new Employee("Семянников", "Логист", "sem@mail.ru", "+7-911-555-52-81", 105000, 34)
        };


        //employee1.info();// проверка метода

        //5.С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40) {
                //employees[i].info(); //первый вариант вывода
                System.out.println(employees[i].toString()); //Второй вариант вывода
            }
        }
    }
}
