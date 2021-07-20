package hw8;

public class Cat implements JumpableRunnable {

    private String name;
    private int maxRun;
    private int maxJump;


    public Cat(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }


    @Override
    public void run(Treadmill tr) {
        if (tr.getObstacleDist() <= maxRun) {
            System.out.println("Cat " + name + " was able to run " + tr.getObstacleDist() + "m.");

        } else {
            System.out.println("Cat " + name + " wasn't able to run " + tr.getObstacleDist() + "m.");

        }
    }

    @Override
    public void jump(Wall wall) {

        if (wall.getObstacleHeigt() <= maxJump) {
            System.out.println("Cat " + name + " was able to jump " + wall.getObstacleHeigt() + "cm.");

        } else {
            System.out.println("Cat " + name + " wasn't able to jump " + wall.getObstacleHeigt() + "cm.");


        }
    }

    public int getMaxJump() {
        return maxJump;
    }

    public int getMaxRun() {
        return maxRun;
    }
}


