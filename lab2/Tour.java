package lab2;
import java.util.ArrayList;

public class Tour {
    private Vehicle vehicle;
    private ArrayList<Client> clients = new ArrayList<Client>();

    public Tour (Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    @Override
    public String toString() {
        StringBuilder names = new StringBuilder();
        for (Client c : clients) {
            names.append(c.getName());
            names.append(", ");
        }
        //names.delete(names.length()-2, names.length());

        return "The vehicle " + this.vehicle.getName() +
                " drives the clients: " + names.toString();
    }
}