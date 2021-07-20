package hw8;

public class Robot implements JumpableRunnable {
    private String model;
    private int maxRun;
    private int maxJump;


    public Robot(String model, int maxRun, int maxJump) {
        this.model = model;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }


    @Override
    public void run(Treadmill tr) {
        if (tr.getObstacleDist() <= maxRun) {
            System.out.println("Robot model " + model + " was able to run " + tr.getObstacleDist() + "m.");

        } else {
            System.out.println("Robot model " + model + " wasn't able to run " + tr.getObstacleDist() + "m.");

        }
    }

    @Override
    public void jump(Wall wall) {
        if (wall.getObstacleHeigt() <= maxJump) {
            System.out.println("Robot model " + model + " was able to jump " + wall.getObstacleHeigt() + "cm.");

        } else {
            System.out.println("Robot model " + model + " wasn't able to jump " + wall.getObstacleHeigt() + "cm.");

        }

    }

    public int getMaxJump() {
        return maxJump;
    }

    public int getMaxRun() {
        return maxRun;
    }
}
