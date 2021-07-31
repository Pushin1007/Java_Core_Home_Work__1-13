package hw11;

public abstract class Fruit { //а. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
    private float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }
}
