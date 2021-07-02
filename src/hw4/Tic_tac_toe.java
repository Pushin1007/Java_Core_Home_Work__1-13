package hw4;

import java.util.Random;
import java.util.Scanner;

public class Tic_tac_toe {

    static final int SIZE = 3;//Размер поля
    static final int DOTS_TO_WIN = 3;// количество фишек для победы
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '-';

    static char[][] map;

    static final Scanner sc = new Scanner(System.in);
    static final Random random = new Random();

    public static void main(String[] args) {
        int att; // переменная хотения играть 0 или 1
        do {//цикл если игрок захочет сыграть не один раз
            initMap(); // делаем чистое поле
            printMap(); // печатаем чистое поле

            while (true) { //игровой цикл
                humanTurn();// ход игрока
                printMap(); // распечатаем куда сходил
                if (checkWin(DOT_X)) {
                    System.out.println("Вы победили!!!");
                    break;
                }
                if (mapFull()) {// проверка на заполненность поля, есть ли кудато ходить
                    System.out.println("Ничья");
                    break;
                }

                aiTurn(); //ход компьютера
                printMap();// распечатаем куда сходил
                if (checkWin(DOT_O)) {
                    System.out.println("Победил компьютер");
                    break;
                }
                if (mapFull()) {// проверка на заполненность поля, есть ли кудато ходить
                    System.out.println("Ничья");
                    break;
                }
            }

            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет.");
            att = sc.nextInt();// считываем хочет ли игрок играть дальше
        } while (att == 1);
        System.out.println("Спасибо за игру.");
    }


    public static void initMap() { // формирование чистого поля
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {// печать поля
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%d ", i + 1);
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%d ", i + 1);
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%c ", map[i][j]);
            }
            System.out.println();
        }
    }

    public static void humanTurn() {//ход игрока
        int x;
        int y;
        do {
            System.out.println("Введите координаты. В формате: Столбец Строка");
            y = sc.nextInt() - 1;//считывание  столбца
            x = sc.nextInt() - 1;//считывание строки

            if (!isCellValid(x, y)) {
                System.out.println("Ячейка занята или введенные координаты выходят за пределы игрового поля.");
            }
        } while (!isCellValid(x, y));
        map[x][y] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {// проверка валидности ввода
        if (y < 0 || x < 0 || y >= SIZE || x >= SIZE) {//проверка не выходят ли значения за игровое поле
            return false;
        }
        return map[x][y] == DOT_EMPTY; // проверка не занята ли ячейка
    }

    public static boolean mapFull() {// проверка на заполненность поля, есть ли кудато ходить
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        } return true;
    }

    public static boolean checkWin(char c) {//проверка победы по 4 линиям
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {


                for (int k = 0; k < DOTS_TO_WIN; k++) {//проверка горизонтальной линии
                    if (j + k < SIZE && map[i][j + k] == c) {
                        if (k == (DOTS_TO_WIN - 1)) {
                            return true;
                        }
                    } else {
                        break;
                    }
                }

                for (int k = 0; k < DOTS_TO_WIN; k++) {//проверка Вертикальной линии
                    if (i + k < SIZE && map[i + k][j] == c) {
                        if (k == (DOTS_TO_WIN - 1)) {
                            return true;
                        }
                    } else {
                        break;
                    }
                }

                for (int k = 0; k < DOTS_TO_WIN; k++) {//проверка Диагонали
                    if ((i + k) < SIZE && (j + k) < SIZE && map[i + k][j + k] == c) {
                        if (k == (DOTS_TO_WIN - 1)) {
                            return true;
                        }
                    } else {
                        break;
                    }
                }

                for (int k = 0; k < DOTS_TO_WIN; k++) {//проверка 2-й Диагонали
                    if ((j + k) < SIZE && (i - k) >= 0 && map[i - k][j + k] == c) {
                        if (k == (DOTS_TO_WIN - 1)) {
                            return true;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return false;
    }


    public static void aiTurn() {//Ход компьютера метод "Выиграть"

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (checkWin(DOT_O)) {
                        return;
                    } else {
                        map[i][j] = DOT_EMPTY;
                    }
                }
            }
        }
        aiNoTotLose();
    }

    public static void aiNoTotLose() {//Ход компьютера метод "не проиграть"

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWin(DOT_X)) {
                        map[i][j] = DOT_O;
                        return;
                    } else {
                        map[i][j] = DOT_EMPTY;
                    }
                }
            }
        }
        aiRand();
    }

    public static void aiRand() {//ход компьютера "Куда попало"
        int x;
        int y;
        do {
            y = random.nextInt(SIZE); //генерация строки
            x = random.nextInt(SIZE);//генерация столбца

        } while (!isCellValid(x, y));
        map[x][y] = DOT_O;
    }

}
