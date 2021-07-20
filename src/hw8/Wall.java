package hw8;

public class Wall implements Obstacle {
    private int obstacleHeigt;

    public Wall(int obstacleHeigt) {
        this.obstacleHeigt = obstacleHeigt;
    }

    public int getObstacleHeigt() {
        return obstacleHeigt;
    }

    @Override
    public boolean possibility(JumpableRunnable j) {
                return this.obstacleHeigt>j.getMaxJump();
    }

}