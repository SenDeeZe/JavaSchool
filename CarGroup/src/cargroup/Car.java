package cargroup;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private String type;

    public Car(){

    }

    public Car(String model, String type){
        this.model = model;
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return model +" "+ type;
    }

    public ArrayList<Car> groupByType(List<Car> cars, String type){
        ArrayList<Car> groupedCars = new ArrayList<>();
        for (Car groupedCar : cars) {
            if (groupedCar.getType().equals(type)) {
                groupedCars.add(groupedCar);
            }
        }
        return groupedCars;
    }

    public void printCars(List<Car> cars){
        System.out.println("________start of list______");
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println("________end of list________");
    }
}
