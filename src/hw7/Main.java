package hw7;

public class Main {
    public static void main(String[] args) {

        Plate plate = new Plate(); //ставим тарелку
        plate.setFood(69);// добавляем в тарелку еду


        Cat [] cats = {// приглашаем (создаем) массив котов
                new Cat("Barsik", 5),
                new Cat("Mursik", 25),
                new Cat("Felix", 15),
                new Cat("Rigik", 30),
                new Cat("Matroskin", 17)
        };

        for( Cat cat : cats){
            cat.eat(plate);//каждому коту поесть из тарелки
            cat.printSatiety(); // сообщить сыт ли он
        }
        plate.info();
    }
}
