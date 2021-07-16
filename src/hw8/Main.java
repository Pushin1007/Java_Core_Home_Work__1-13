package hw8;

public class Main {
    public static void main(String[] args) {

        JumpableRunnable[] jr = {
                new Cat("Murzik", 200, 20),
                new Cat("Barsik", 500, 57),
                new Human("Vova", 1500, 130),
                new Human("Dima", 3000, 100),
                new Robot("R2D2", 10000, 8),
                new Robot("C-3PO", 10000, 150)
        };
        Obstacle[] obs = {
                new Wall(10),
                new Treadmill(300),
                new Wall(120),
                new Treadmill(2000),
        };
        for (int i = 0; i < jr.length; i++) {
            for (int j = 0; j < obs.length; j++) {
                if ((obs[j] instanceof Wall)) {
                    jr[i].jump((Wall) obs[j]);
                    if (( obs[j]).possibility(jr[i])) {
                        break;
                    }

                } else {
                    jr[i].run((Treadmill) obs[j]);
                    if (( obs[j]).possibility(jr[i])) {
                        break;
                    }
                }

            }
            System.out.println();
        }

    }
}

