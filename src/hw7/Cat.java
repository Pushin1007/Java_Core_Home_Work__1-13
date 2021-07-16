package hw7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety; // переменная сытости

    public Cat(String name, int appetite) { //конструктор котов
        this.name = name;
        this.appetite = appetite;
        this.satiety = false; // при создании кота они голодны
    }

    public void eat(Plate plate) { //метод еды котов
        plate.decreaseFood(this);
        if (satiety) {
            System.out.println(name + " поел " + appetite);
        } else {
            System.out.println(name + " не поел. Для него недостаточно еды в тарелке");
        }
    }

    public int getAppetite() { // геттер аппетита
        return appetite;
    }

    public void setSatiety(boolean satiety) { //сеттер  сытости
        this.satiety = satiety;
    }

    public void printSatiety() { //метод сообщения о сытости
        System.out.printf("Сытость кота %s : %b \n", name, satiety);
    }
}
