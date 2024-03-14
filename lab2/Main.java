package lab2;
// @Dancă Gabriel E2

import java.time.LocalTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client();
        client1.setName("Popescu");
        client1.setMinTime(LocalTime.of(8, 0));
        client1.setMaxTime(LocalTime.of(12, 30));

        Client client2 = new Client("Basescu");
        //System.out.println(client2);

        Client client3 = new Client("Iohanis", LocalTime.NOON, LocalTime.MIDNIGHT, ClientType.PREMIUM);
        //System.out.println(client3);

        Client client4 = new Client("Ciuca");
        Client client5 = new Client("Ciolacu");

        //Vehicle vehicle1 = new Vehicle("Dacia");

        Vehicle[] vehicles = new Vehicle[2];
        vehicles[0] = new Drone();
        vehicles[1] = new Truck();
        vehicles[0].setName("Drone");
        vehicles[1].setName("Truck");

        Depot depot1 = new Depot("Iasi");
        Depot depot2 = new Depot("Bucuresti");

        depot1.setVehicles(vehicles[0]);
        depot2.setVehicles(vehicles[1]);

        System.out.println(depot1);
        System.out.println(depot2);

        Problem problem = new Problem();
        problem.addDepot(depot1);
        problem.addDepot(depot2);
        problem.addClient(client1);
        problem.addClient(client2);
        problem.addClient(client3);
        problem.addClient(client4);
        problem.addClient(client5);
        System.out.println(problem);

        ArrayList<Vehicle> problemVehicles = problem.getVehicles();
        ArrayList<Client> clients = problem.getClients();
        int index = 0;
        for (Vehicle i : problemVehicles) {
            Tour tour = new Tour(i);
            int seats = 4;
            while (seats != 0 && index < clients.size()) {
                tour.addClient(clients.get(index));
                index += 1;
                seats -= 1;
            }
            System.out.println(tour);
        }

    }
}