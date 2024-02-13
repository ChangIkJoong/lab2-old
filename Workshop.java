import java.util.ArrayList;
public class Workshop <T extends Car> {

    protected ArrayList<T> carList = new ArrayList<>();
    private final int size;

    private String name;
    public Workshop(String name, ArrayList<T> carlist, int size){
        this.name=name;
        carList = new ArrayList<>();
        carList.addAll(carlist);
        this.size = size;
    }

    public void addCar(T a){
        if(carList.size() < size) {
            carList.add(a);
        }
        else throw new RuntimeException("over capacity");
    }
    public T releaseCar(){
        return carList.removeLast();
    }

}