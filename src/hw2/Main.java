package hw2;

import java.util.Arrays;
import java.util.Random;

public class Main {
    static Random random = new Random();

    public static void main(String[] args) {
//     1. Задать целочисленный массив, состоящий из элементов 0 и 1.
//    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//       С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {// Создаем рамдомный массив из 1 и 0 длиной 10
            array[i] = random.nextInt(2);
        }

        System.out.println(Arrays.toString(array));// Выводим в консоль исходный массив. Задание №1

        for (int i = 0; i < array.length; i++) {// Меняем 0 на 1, и 1 на 0.
            switch (array[i]) {
                case 0:
                    array[i] = 1;
                    break;
                case 1:
                    array[i] = 0;
                    break;
            }
        }
        System.out.println(Arrays.toString(array)); // Выводим в консоль измененный массив. Задание №1

// 2.Задать пустой целочисленный массив размером 8.
// С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] array2 = new int[8];
        for (int i = 0; i < array2.length; i++) {// Заполняем цикл согласно зависимости
            array2[i] = i * 3;
        }
        System.out.println(Arrays.toString(array2));// Выводим в консоль готовый массив . Задание №2

//3.Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
// пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}; // Исходный массив . Задание №3
        for (int i = 0; i < array3.length; i++) {//  Ищем цифры меньше 6 и обрабатываем цикл
            if (array3[i] < 6) {
                array3[i] = array3[i] * 2;
            }
        }
        System.out.println(Arrays.toString(array3)); // Выводим в консоль готовый массив . Задание №3

//4.Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
// и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int a = 6; //размер массива
        int[][] array4 = new int[a][a];
        for (int i = 0; i < array4.length; i++) {
            for (int j = 0; j < array4[i].length; j++) {
                if (i == j) {
                    array4[i][j] = 1;// Заполняем диагональ единицами
                } else if (i + j == array4.length - 1) {
                    array4[i][j] = 1; // Заполняем вторую диагональ единицами
                } else {
                    array4[i][j] = random.nextInt(30);// Остальные ячейки заполняем рандомно
                }
                System.out.printf("%3d", array4[i][j]); // Выводим в консоль ячейки. Задание №4
            }
            System.out.println();//пробел между строками

        }
// 5.** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
//      int[] array5 = {2,53,45,56,5265,52,66,556,566,655,58,972,34}; // тестовый массив

        int[] array5 = new int[10]; //длина цикла
        for (int i = 0; i < array5.length; i++) {// Заполняем цикл произвольными  от 0 до 499
            array5[i] = random.nextInt(500);
        }

        System.out.println(Arrays.toString(array5));// Выводим исходный массив  в консоль. Задание №5

        System.out.println(maxNumArr(array5)); // выводим макс число массива.  Задание №5
        System.out.println(minNumArr(array5));// выводим мин число массива.  Задание №5

        int[] array6 = {3,2,3,5,2,4,1,1,1,3,1,1,10,1};// тестовый цикл для задания №6

        System.out.println(checkBalance(array6)); // ответ на вопрос: Делится ли массив на равные части? Задание №6

        int[] array7 = {1,2,3,4,5,6,7,8,9,10};// тестовый массив для задания №7
        System.out.println(Arrays.toString(moovArr (array7, 2)));// выводим итоговый сдвинутый массив. Задание №7
    }


    public static int maxNumArr(int[] arr) {// метод вычисление максимального числа из массива
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int minNumArr(int[] arr) {// метод вычисление минимального числа из массива
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    // 6.** Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
    // граница показана символами ||, эти символы в массив не входят.

    public static int sumArr(int[] arr) { //подсчет суммы массива
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    public static boolean checkBalance(int[] arr) { // метод возврящает булево значение делится ли массив на равные части?

        for (int i = 0, a = 0; i < arr.length; i++) {//поочередно складываем элементы массива
            a = a + arr[i];
            if (a == sumArr(arr) / 2) {//ждем наступления условия что сумма равна половине суммы массива
                return true;
            }
        }
        return false;//Если  условие внутри цикла не сработало
    }
//7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
// при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
// Для усложнения задачи нельзя пользоваться вспомогательными массивами.
// Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
// при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.

    public static int[] moovArr(int[] arr, int n) {// Метод смещения массива
        int a;
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                a = arr[arr.length - 1];
                for (int j = (arr.length - 1); j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = a;
            }
            return arr;
        } else if (n < 0) {
            for (int i = 1; i <= n * (-1); i++) {
                a = arr[0];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = a;
            }
            return arr;
        }
        return arr;
    }


}


