package lab2;
// Dancă Gabriel E2


import java.util.ArrayList;
import java.util.Objects;

public class Depot {
    private ArrayList<Vehicle> vehicleList = new ArrayList<>();
    private int number;
    private String depotName;

    Depot(int depotNum,String name){
        this.number = depotNum;
        this.depotName = name;
    }

    @Override
    public String toString() {
        return "Depot{" +
                "vehicleList=" + vehicleList +
                ", number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Depot depot = (Depot) o;
        return number == depot.number && Objects.equals(vehicleList, depot.vehicleList) && Objects.equals(depotName, depot.depotName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleList, number, depotName);
    }

    public ArrayList<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setCarsList(ArrayList<Vehicle> carsList) {
        this.vehicleList = carsList;
    }

    public void addVehicle(Vehicle car){
        vehicleList.add(car);
        System.out.println("Vehiculul adaugat este:" + car.getName());
        System.out.println(vehicleList);
    }

    public String getDepotName(){
        return this.depotName;
    }
}
