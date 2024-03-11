package lab2;
// Dancă Gabriel E2

import java.util.Objects;

public class Client {
     private String name;
     private int startingTime,endingTime;
     public enum TYPE{
        PREMIUM,
        REGULAR
    }
    public TYPE type;


    Client(TYPE type, String name, int start, int end) {
        this.type = type;
        this.name = name;
        this.startingTime = start;
        this.endingTime = end;

    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", startInterval=" + startingTime +
                ", endInterval=" + endingTime +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return startingTime == client.startingTime && endingTime == client.endingTime && Objects.equals(name, client.name) && type == client.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startingTime, endingTime, type);
    }

    public String getName() {
        return name;
    }

    public int getStartInterval() {
        return startingTime;
    }

    public int getEndInterval() {
        return endingTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartInterval(int startInterval) {
        this.startingTime = startInterval;
    }

    public void setEndInterval(int endInterval) {
        this.endingTime = endInterval;
    }
}
