package lab2;
// Dancă Gabriel E2


import java.util.ArrayList;
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

    public ArrayList<Vehicle> getVehicleListList() {
        return vehicleList;
    }

    public void setCarsList(ArrayList<Vehicle> carsList) {
        this.vehicleList = carsList;
    }

    public void addVehicle(Vehicle car){
        vehicleList.add(car);
    }

    public String getDepotName(){
        return this.depotName;
    }
}
