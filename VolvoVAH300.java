import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayDeque;
import java.util.Deque;

public class VolvoVAH300 extends Truck {
    protected final Deque<Car> cargo;
    protected static final int loadCapacity = 8;

    public VolvoVAH300(){
        super("VolvoVAH300",2, Color.GREEN, 200, true);
        rampOpen=false;
        this.cargo=new ArrayDeque<>();
    }
    public void openRamp() {
        if(getCurrentSpeed() == 0) {
            this.rampOpen=true;
            }
        else{
            throw new RuntimeException("Transport must be still.");
        }
    }
     public void closeRamp() {
            if(getCurrentSpeed() == 0) {
                this.rampOpen=true;
            }
            else {
                throw new RuntimeException("Transport must be still.");
            }
     }

        @Override
        public void move() {
            if(rampOpen) {
                double xTraverse = (currentSpeed * orientation.getX());
                double yTraverse = (currentSpeed * orientation.getY());
                position.y = (yTraverse + position.y);
                position.x = (xTraverse + position.x);
            }
        }
        @Override
        public void gas(double amount) {
            if (rampOpen) {
                incrementSpeed(speedInterval(amount));
            }
            else {
                throw new RuntimeException("Ramp not closed.");
            }
        }

    public void loadCar(Car newCar) {
        if(!rampOpen && currentSpeed==0 && cargo.size() < loadCapacity ) {
            newCar.position=this.position;
            cargo.push(newCar);
        }
    }

    public Car unloadCar() {
        if (!rampOpen && currentSpeed == 0 && !cargo.isEmpty()) {
            throw new RuntimeException("Transport stack is either empty, or ramp is closed.");
        }
        Car unloadCar = cargo.pop();
        unloadCar.position= new Point2D.Double(this.position.x, this.position.y);
        return unloadCar;
    }
}
