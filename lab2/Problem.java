package lab2;
// Danca Gabriel 2E2
import java.util.ArrayList;

public class Problem {
    private ArrayList<Depot> depots = new ArrayList<Depot>();
    private ArrayList<Client> clients = new ArrayList<Client>();

    public void addDepot(Depot depot) {
        if (this.depots.size() == 0) {
            depots.add(depot);
            return;
        }
        for (Depot i : depots) {
            if (i.equals(depot)) {
                System.out.println("The depot " + depot.getName() + " already exists!");
                return;
            }
            Vehicle[] firstVehicles = i.getVehicles();
            Vehicle[] secondVehicles = depot.getVehicles();
            for (Vehicle j : firstVehicles) {
                for (Vehicle k : secondVehicles) {
                    if(j.equals(k)) {
                        System.out.println("The vehicle " + k.getName() + " from the depot " + depot.getName() + " already exists!");
                        return;
                    }
                }
            }
        }
        depots.add(depot);
    }

    public void addClient(Client client) {
        if (this.clients.size() == 0) {
            clients.add(client);
            return;
        }
        for (Client i : clients) {
            if(i.equals(client)) {
                System.out.println("The client " + client.getName()+ " already exists!");
                return;
            }
        }
        clients.add(client);
    }

    public ArrayList<Vehicle> getVehicles() {
        ArrayList<Vehicle> returnVehicles = new ArrayList<Vehicle>();
        for (Depot i : depots) {
            for (Vehicle j : i.getVehicles()) {
                returnVehicles.add(j);
            }
        }
        return returnVehicles;
    }

    public ArrayList<Client> getClients() {
        return this.clients;
    }

    @Override
    public String toString() {
        return "Problem: we have " + this.getVehicles().size() + " vehicles and " + this.clients.size() + " clients. " +
                '\n' + "Assign each vehicle max 4 clients";
    }
}