package hw7;

public class Plate {
    private int food=0; //на тарелки изначально еды 0

    public void decreaseFood(Cat cat) { // метод уменьшения еды в тарелке
        if (food >= cat.getAppetite()) {
            this.food -= cat.getAppetite();
            cat.setSatiety(true);
        } else {cat.setSatiety(false);}
    }

    public void info() { // инфа сколько еды в тарелке
        System.out.println("В тарелке осталось : " + food);
    }

    public void setFood(int food) { // метод добавления еды в тарелку
        if (food >= 0) {
            this.food = this.food + food;
            System.out.println("В тарелку положили " + food + " еды");
        } else {
            System.out.println("Нельзя забирать у котиков еду!!! Надо что-то положить в тарелку!");
        }

    }
}
