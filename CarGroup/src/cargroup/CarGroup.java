package cargroup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class CarGroup {

    public static void carGrouping(String fileName) throws Exception {
        File file = new File(fileName);
        if (file.length() == 0) {
            System.out.println("File is empty");
        } else {
            Car car = new Car();
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String strCars = br.readLine();
            ArrayList<Car> cars = new ArrayList<>();
            String[] strCar = strCars.split(", ");
            for (int i = 0; i < strCar.length; i++) {
                String[] carCar = strCar[i].split(" ");
                Car newCar = new Car(carCar[0], carCar[1]);
                cars.add(newCar);
            }
            ArrayList<Car> sedanCar = car.groupByType(cars, "седан");
            ArrayList<Car> hatchCar = car.groupByType(cars, "хэтчбек");
            ArrayList<Car> crossCar = car.groupByType(cars, "кроссовер");

            car.printCars(sedanCar);
            car.printCars(hatchCar);
            car.printCars(crossCar);
            fr.close();
            br.close();
        }
    }

    public static void main(String[] args) {

        try {
            carGrouping("cars.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
