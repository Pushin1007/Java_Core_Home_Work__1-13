package hw1;

public class Main {
    //1. Создать пустой проект в IntelliJ IDEA и прописать метод main().
    public static void main(String[] args) {
        //2. Создать переменные всех пройденных типов данных и инициализировать их значения.
        byte aa = 5 + 7;
        short ff = 125;
        int bb = 15243825;
        long cc = 12548L;
        float dd = 12.25f;
        double e = -145.4475;
        boolean g = false;
        String r = "FirsApp";


        System.out.println(math(5.58f, 125.23f, 25.85f, 52.24f));
        System.out.println(compare(10, 3));
        whatIsNumber(12);
        System.out.println(negNumBool(-12));
        helloName("Dmitriy");
        leapYear(1983);
        leapYear(700);
        leapYear(800);
        leapYear(2000);
    }

    public static float math(float a, float b, float c, float d) {
        /*3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
        где a, b, c, d – аргументы этого метода, имеющие тип float.*/
        return a * (b + (c / d));

    }

    public static boolean compare(int a, int b) {
        /*4. Написать метод, принимающий на вход два целых числа и проверяющий, что
        их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.*/
        boolean c;
        if (a + b >= 10 && a + b <= 20) {
            c = true;
        } else {
            c = false;
        }
        return c;
    }

    public static void whatIsNumber(int a) {
        /*5. Написать метод, которому в качестве параметра передается целое число,
        метод должен напечатать в консоль, положительное ли число передали или отрицательное.
         Замечание: ноль считаем положительным числом.*/
        if (a >= 0) {
            System.out.println("Number " + a + "  is positive.");
        } else {
            System.out.println("Number " + a + "  is negative.");
        }
    }

    public static boolean negNumBool(int a) {
        /*6. Написать метод, которому в качестве параметра передается целое число.
        Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.*/
        boolean c;
        if (a < 0) {
            c = true;
        } else {
            c = false;
        }
        return c;
    }

    public static void helloName(String name) {
        /*7. Написать метод, которому в качестве параметра передается строка,обозначающая имя.
         Метод должен вывести в консоль сообщение «Привет, указанное_имя!».*/
        System.out.println("Hello, " + name + ".");
    }
    public static void leapYear(int year) {
        /*8. *Написать метод, который определяет, является ли год високосным,и выводит сообщение в консоль.
         Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.*/
        if (year % 4 != 0) {
            System.out.println("Год " + year  +   " не высокостный");
        }
        else if(year % 100 != 0){
            System.out.println("Год " + year  +   " высокостный");
        }
        else if(year % 400 == 0){
            System.out.println("Год " + year  +   " высокостный");
        }
        else {
            System.out.println("Год " + year  +   " не высокостный");
        }
    }

}

