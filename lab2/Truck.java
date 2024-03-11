package lab2;

public class Truck extends Vehicle{
    private int capacity;

    private String name;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    Truck(int cap,String n) {
        this.capacity = cap;
        this.name = n;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
