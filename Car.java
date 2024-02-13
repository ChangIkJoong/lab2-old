import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Car implements Movable {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name

    protected Point2D.Double position;

    protected Point direction;

    public Car(String model, int nrDoors, Color color, double enginePower){
        this.modelName = model;
        this.nrDoors = nrDoors;
        this.setColor(color);
        this.enginePower = enginePower;
        this.stopEngine();

        this.position=new Point2D.Double(10,0);
        this.direction=new Point(0, 1);
    }


    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }


    protected double speedFactor() {
        return enginePower * 0.01;
    }


    protected void incrementSpeed(double amount){
        currentSpeed = speedValidation(getCurrentSpeed() + speedFactor() * amount);
    }
    protected void decrementSpeed(double amount){
        currentSpeed = speedValidation(getCurrentSpeed() - speedFactor() * amount);
    }

    public void gas(double amount){
        incrementSpeed(speedInterval(amount));
    }
    public void brake(double amount){
        decrementSpeed(speedInterval(amount));
    }

    private double speedValidation(double amount) {
        return Math.max(0, Math.min(amount, enginePower));
    }

    protected double speedInterval(double amount) {
        return Math.max(0, Math.min(1, amount));
    }



    public void move() {
        double xTraverse = (currentSpeed * direction.getX());
        double yTraverse = (currentSpeed * direction.getY());

        //if (orientation.getY() != 0) {
        position.y = (yTraverse + position.y);
        //}

        //else if (orientation.getX() != 0) {
        position.x = (xTraverse + position.x);
        //}
    }

    public Point2D getPos() {
        return this.position;
    }

    public void turnLeft() {
        if (direction.getY() != 0) {
            direction.x = (int) direction.getY();
            direction.y =0;
        }
        else if (direction.getX() != 0) {
            direction.y = (int) -direction.getX();
            direction.x=0;
        }

    }

    public void turnRight() {
        if (direction.getY() != 0) {
            direction.x = (int) -direction.getY();
            direction.y=0;
        }
        else if (position.getX() != 0) {
            direction.y = (int) direction.getX();
            direction.x=0;
        }
    }

}


