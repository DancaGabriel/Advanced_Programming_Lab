package lab2;
// Danca Gabriel 2E2

import java.time.LocalTime;
import java.util.Objects;

enum ClientType {
    REGULAR,
    PREMIUM;
}

/**
 * The class Client defines a client
 */
public class Client {
    private String name;
    private LocalTime minTime;
    private LocalTime maxTime;
    private ClientType type;

    public Client() {}
    public Client(String name) {
        this(name, null, null, null);
    }

    public Client(String name, LocalTime minTime, LocalTime maxTime, ClientType type) {
        this.name = name;
        this.minTime = minTime;
        this.maxTime = maxTime;
        this.type = type;
    }

    public Client(String name, ClientType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMinTime(LocalTime minTime) {
        this.minTime = minTime;
    }
    public void setMaxTime(LocalTime maxTime) {
        this.maxTime = maxTime;
    }
    public void setType (ClientType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", minTime=" + minTime +
                ", maxTime=" + maxTime +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(minTime, client.minTime) && Objects.equals(maxTime, client.maxTime) && type == client.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, minTime, maxTime, type);
    }
}