package lab2;
// Dancă Gabriel E2


import java.util.Arrays;
import java.util.Objects;

public class Depot {
    private String name;
    private Vehicle[] vehicles;

    public Depot() {}
    public Depot(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setVehicles(Vehicle... vehicles) {
        this.vehicles = vehicles;
        for (Vehicle v : vehicles) {
            v.setDepot(this);
        }
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }

    @Override
    public String toString() {
        StringBuilder names = new StringBuilder();
        for (Vehicle v : vehicles) {
            names.append(v.getName());
            names.append(", ");
        }

        names.delete(names.length()-2, names.length());
        return "Depot{" +
                "name='" + name + '\'' +
                ", vehicles=" + names.toString() +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Depot depot = (Depot) obj;
        return Objects.equals(name, depot.name) && Arrays.equals(vehicles, depot.vehicles);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(vehicles);
        return result;
    }
}