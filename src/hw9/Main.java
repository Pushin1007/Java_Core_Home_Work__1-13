package hw9;

public class Main {
    public static void main(String[] args) {

    String[][] arr = {// Правильный масив
            {"25", "56", "56", "89"},
            {"2", "55", "45", "29"},
            {"152", "251", "55", "22"},
            {"5", "543", "22", "12"}

    };

//        String[][] arr = { //неправильный массив - неправильный размер
//                {"25", "56", "56", "89"},
//                {"2", "56", "45", "29"},
//                {"5", "543", "56", "22"},
//                {"25", "56", "258", "99", "56"}
//        };
//        String[][] arr3 = { //неправильный массив - присутствуют символы
//                {"25", "56", "56", "89"},
//                {"2", "ha", "45", "29"},
//                {"5", "543", "gg", "22"},
//                {"25", "56", "258", "hh"}
//        };

    //3. В методе main() вызвать полученный метод,
    // обработать возможные исключения MyArraySizeException и MyArrayDataException и вывести результат расчета.

    try {
        System.out.println(summArr(arr));
    } catch (MyArraySizeException e) {
        System.out.println(e.getMessage());
        System.out.println("В Вашем массиве их " + e.getLen() + ".\nУкажите правильный массив!");
    } catch (MyArrayDataException e) {
        System.out.println("Элемент находящийся в  " + e.getI() + "-й строке " + " и  " + e.getJ() + "-м столбце массива " + " содержит символ или текст вместо числа.");
        System.out.println("Укажите правильный массив! \nПримечание!!! Счет начинается с 0.");
    }

}

    //1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
    // При подаче массива другого размера необходимо бросить исключение MyArraySizeException.

    /**
    *Метод определения  суммы массива
    **/
    public static int summArr(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int s = 0;
        //2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
        //  Если в каком-то элементе массива преобразование не удалось
        //  (например, в ячейке лежит символ или текст вместо числа), должно быть брошено
        // исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
        if (array.length != 4) {
            throw new MyArraySizeException("Строк должно быть ровно 4", array.length);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Столбцов должно быть ровно 4.", array[i].length);
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
                s += Integer.parseInt(array[i][j]);
            }
        }

        return s;
    }

    ;

}



