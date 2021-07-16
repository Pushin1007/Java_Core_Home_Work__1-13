package hw8;

public class Treadmill implements Obstacle {
    private int obstacleDist;

    public Treadmill(int obstacleDist) {
        this.obstacleDist = obstacleDist;
    }

    public int getObstacleDist() {
        return obstacleDist;
    }
    @Override
    public boolean possibility(JumpableRunnable j) {
        return this.obstacleDist>j.getMaxRun();
    }


}
