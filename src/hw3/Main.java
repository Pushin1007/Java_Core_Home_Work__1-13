package hw3;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        // 1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
        // При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
        // После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
        System.out.println("Игра угадай число. У вас есть 3 попытки угадать загаданное компьютером  число от 0 до 9");
        int att; // переменная хотения играть 0 или 1
        do {//цикл если игрок захочет сыграть не один раз
            int number = random.nextInt(10);//в каждой игре загадывается новое число
            game(number);
            System.out.printf("Загаданное число %d \n", number);
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет.");
            att = sc.nextInt();// считываем хочет ли игрок играть дальше
        } while (att == 1);
        System.out.println("Спасибо за игру.");

// 2. * Создать массив из слов
//String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
// "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
// "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
//При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
// сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь.
// Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
//apple – загаданное
//apricot - ответ игрока
//ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
//Для сравнения двух слов посимвольно можно пользоваться:
//String str = "apple";
//char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
//Играем до тех пор, пока игрок не отгадает слово.
//Используем только маленькие буквы.

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String randomWord = words[random.nextInt(words.length)];//Один раз загадываем слово, т.к. в задании нет задачи цикличности повтора игры
//        System.out.println(randomWord);
        System.out.println(" Введите слово на англиском языке. Используйте только строчные буквы.\n Подсказака: это фрукт или овощ. \n");
        compareWords(randomWord);
    }


    public static void game(int number) {//метод игры за 3 попытки для  задания №1
        for (int i = 1; i <= 3; i++) {
            System.out.printf("Попытка № %d Введите целое число от 0 до 9:  ", i);
            int numberUser = sc.nextInt(); //считываем введеное игроком число
            if (number == numberUser) {// сравниваем загаданное число и введеное пользователем
                System.out.println("Поздравляем. Вы угадали.");
                return;
            } else if (number < numberUser)
                System.out.println("Ваше число больше чем загаданное");
            else {
                System.out.println("Ваше число меньше чем загаданное");
            }
        }
    }

    public static void compareWords(String randomWord) {//метод посимвольного сравнения для  задания №2
                String userWord = sc.next();

        while (!randomWord.equals(userWord)) { //Если слова не совпадают, то запускаем цикл
            int length; //переменная длины слова
            if (randomWord.length() < userWord.length()) {//проверяем какое слово длинее, загаданное или введенное
                length = randomWord.length();
            } else {
                length = userWord.length();
            }System.out.println("\n Посмотрите сколько букв совпало:");
            for (int i = 0; i < 15; i++) { //выводим 15 знаков
                if (i < length && userWord.charAt(i) == randomWord.charAt(i)) {
                    System.out.print(randomWord.charAt(i)); // если знак совпадает выводим его
                } else {
                    System.out.print("#");// если знак  не совпадает выводим #
                }
            }

            System.out.println("\n Введите слово снова:");
            userWord = sc.next();
        }
        System.out.println("Поздравляю Вы угадали слово");

    }

}

