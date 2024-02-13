import java.awt.*;

public class Scania extends Truck {
    private int platformAngle;
    private final int increaseAmount =1;
    public Scania(){
        super("Scania truck", 2, Color.cyan, 200, true);
        this.platformAngle =0;
        stopEngine();
    }

    public int getPlatformAngle() {
        return platformAngle;
    }
    public void setPlatformAngle(int n) {
        platformAngle=n;
    }

    public void increasePlatformAngle() {
        if(getCurrentSpeed() == 0) {
            platformAngle = Math.min(70, platformAngle + increaseAmount);
            setPlatformAngle(70);
        }
        if(platformAngle==70) {
            rampOpen=true;
        }
        else{
            throw new RuntimeException("truck must be still.");
        }
    }

    public void decreasePlatformAngle() {
        if(getCurrentSpeed() == 0) {
            platformAngle= Math.max(0, platformAngle - increaseAmount);
            setPlatformAngle(0);
            if(platformAngle!=70) {
                rampOpen=false;
            }
        }
        else {
            throw new RuntimeException("truck must be still.");
        }
    }
}
