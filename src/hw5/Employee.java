package hw5;

public class Employee {// 1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
     private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee (String name, String position, String email, String phone, int salary, int age) { //2. Конструктор класса должен заполнять эти поля при создании объекта.
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public Employee (String name, String position, String phone, int salary, int age) { //2.а перегруженный конструктор, например сотрудник с возрастом более 70 может и не иметь почту
        this.name = name;
        this.position = position;
        this.email = "Электрической почты нет";
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void info() { //3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
        System.out.printf("%s %s %s %s %d %d \n", name, position, email, phone, salary, age);
            }


    public String toString() {// второй вариант вывода информации об объекте в консоль.
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public int getAge() {//Геттер возраста
        return age;
    }

}
