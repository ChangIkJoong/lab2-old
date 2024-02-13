import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Car implements Movable {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    public String modelName; // The car model name

    public Point2D.Double coordination = new Point2D.Double(100,100);

    public Point position = new Point(0, 1);

    public Car(String model, int nrDoors, Color color, double enginePower){
        this.modelName = model;
        this.nrDoors = nrDoors;
        this.setColor(color);
        this.enginePower = enginePower;
        this.stopEngine();
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


    //TODO uppgift 4 Sanity Checks

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




    // TODO fix this method according to lab pm

    //TODO Uppgift 2 : Action Interfaces

    public void move() {
        double xTraverse = (currentSpeed * coordination.getX());
        double yTraverse = (currentSpeed * coordination.getY());

        //if (orientation.getY() != 0) {
        coordination.y = (yTraverse + coordination.y);
        //}

        //else if (orientation.getX() != 0) {
        coordination.x = (xTraverse + coordination.x);
        //}
    }

    public Point2D getPos() {
        return this.position;
    }

    public void turnLeft() {
        if (position.getY() != 0) {
            position.x = (int) position.getY();
            position.y =0;
        }
        else if (position.getX() != 0) {
            position.y = (int) -position.getX();
            position.x=0;
        }

    }

    public void turnRight() {
        if (position.getY() != 0) {
            position.x = (int) -position.getY();
            position.y=0;
        }
        else if (position.getX() != 0) {
            position.y = (int) position.getX();
            position.x=0;
        }
    }

    //TODO -- solution for cargame = shit , därför behöver vi dra detta
    // via overloading för vår app :))))))))
    //  skulle annars haft de bara tillgängliga i Scania -> VolvoVAH300
    //  inget som behövt ärvas från car.

}


