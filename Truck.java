import java.awt.*;

abstract class Truck extends Car {
    protected final Boolean hasRamp;
    protected Boolean rampOpen;


    public Truck(String model, int nrDoors, Color color, double enginePower, boolean hasRamp) {
        super(model, nrDoors, color, enginePower);
        this.hasRamp=hasRamp;
        this.rampOpen = false;
    }

    @Override
    public void gas(double amount){
        if (amount < 0){
            throw new RuntimeException("no negative amounts!!!");
        }
        else if (rampOpen && hasRamp) {
            throw new RuntimeException("no driving when the platform is raised!");
        }

        else {
            incrementSpeed(speedInterval(amount));
        }
    }
}
