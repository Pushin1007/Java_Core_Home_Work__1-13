package hw12;


import java.util.Arrays;

public class Main {
    private static final int SIZE = 10000000;
    private static final int HALF_SIZE = SIZE / 2;

    public static void main(String[] args) {

        oneThread(); // запускаем первый метод
        twoThread();  // запускаем первый метод

    }


    public static void oneThread() {

        float[] arr = new float[SIZE];// 1) Создаем одномерный массив заданной длины

        Arrays.fill(arr, 1.0f); // 2) Заполняем этот массив единицами

        long a = System.currentTimeMillis();// 3) Запоминаем количество времени в милисекундах от даты 1-1-1970 до настоящего времени

        for (int i = 0; i < arr.length; i++) { //4) Проходим по всему массиву и для каждой ячейки считают новое значение по формуле
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (i / 5)) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long b = System.currentTimeMillis();//  5) Запоминаем время окончания метода

        System.out.println("Метод в 1 поток отработал " + (b - a) + " милисекунд"); // 6) В консоль выводится время работы
    }

    public static void twoThread() {

        float[] arr = new float[SIZE];// 1) Создаем одномерный массив заданной длины

        Arrays.fill(arr, 1.0f); // 2) Заполняем этот массив единицами
        long a = System.currentTimeMillis();// 3) Запоминаем количество времени в милисекундах от даты 1-1-1970 до настоящего времени

        float[] tempArr1 = new float[HALF_SIZE]; //4) создаем вспомогательные массивы
        float[] tempArr2 = new float[HALF_SIZE];

        System.arraycopy(arr, 0, tempArr1, 0, HALF_SIZE); // 5) делим массив на 2 вспомогательных
        System.arraycopy(arr, HALF_SIZE, tempArr2, 0, HALF_SIZE);

        Thread t1 = new Thread(() -> { //6) В двух потоках высчитываем новые значения по формуле
            for (int i = 0; i < tempArr1.length; i++) {
                tempArr1[i] = (float) (tempArr1[i] * Math.sin(0.2f + (i / 5)) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < tempArr2.length; i++) {
                tempArr2[i] = (float) (tempArr1[i] * Math.sin(0.2f + ((i + HALF_SIZE) / 5)) * Math.cos(0.2f + ((i + HALF_SIZE) / 5)) * Math.cos(0.4f + ((i + HALF_SIZE) / 2)));
            }
        });

        t1.start(); //8) запускаем вычисления в параллельных потоках
        t2.start();

        try { //9) Ждем выполнения двух потоков
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(tempArr1, 0, arr, 0, HALF_SIZE); // 10) Склеиваем массивы с новыми значениями в большой массив
        System.arraycopy(tempArr2, 0, arr, HALF_SIZE, HALF_SIZE);

        System.out.println("Метод в 2 потока отработал " + (System.currentTimeMillis() - a) + " милисекунд"); // 11) В консоль выводится время работы
    }


}