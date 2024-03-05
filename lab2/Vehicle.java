package lab2;
// Dancă Gabriel E2

public class Vehicle {
    private String model;
    Depot depotVehicle;
    private int startingDepot;
    private int visitedClients;

    Vehicle(String name,int start,int clients,Depot depou){
        this.model = name;
        this.startingDepot = start;
        this.visitedClients = clients;
        depou.addVehicle(this);
        this.depotVehicle = depou;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", startingDepot=" + startingDepot +
                '}';
    }

    public String getName() {
        return model;
    }

    public void setName(String name) {
        this.model = name;
    }

    public int getStartingDepot() {
        return startingDepot;
    }

    public void setStartingDepot(int startingDepot) {
        this.startingDepot = startingDepot;
    }
    public String getDepot(){
        return this.depotVehicle.getDepotName();
    }

}
