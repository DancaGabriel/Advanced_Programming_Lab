package lab2;
// Dancă Gabriel E2

import java.util.Objects;

public abstract class Vehicle {
    protected String model;
    Depot depotVehicle;
    protected int startingDepot;
    protected int visitedClients;

    Vehicle(){}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return startingDepot == vehicle.startingDepot && visitedClients == vehicle.visitedClients && Objects.equals(model, vehicle.model) && Objects.equals(depotVehicle, vehicle.depotVehicle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, depotVehicle, startingDepot, visitedClients);
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


