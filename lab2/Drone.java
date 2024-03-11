package lab2;

public class Drone extends Vehicle{
    private int maximumFlightDuration;

    private String name;

    public Drone(int maximumFlightDuration,String n) {
        this.name = n;
        this.maximumFlightDuration = maximumFlightDuration;
    }

    public int getMaximumFlighDuration() {
        return maximumFlightDuration;
    }

    public void setMaximumFlighDuration(int maximumFlightDuration) {
        this.maximumFlightDuration = maximumFlightDuration;
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
