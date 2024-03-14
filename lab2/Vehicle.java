package lab2;
// Dancă Gabriel E2

import java.util.Objects;

public abstract class Vehicle {
    protected String name;
    protected Depot depot;

    protected Vehicle() {}
    /*protected Vehicle(String name) {
        this.name = name;
    }*/

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", depot=" + depot +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vehicle vehicle = (Vehicle) obj;
        return Objects.equals(name, vehicle.name) && Objects.equals(depot, vehicle.depot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, depot);
    }
}


