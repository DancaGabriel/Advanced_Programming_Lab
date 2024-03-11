package lab2;
// @Dancă Gabriel E2


public class Main {
    public static void main(String[] args) {

        Client c1 = new Client(Client.TYPE.REGULAR,"Bogdan",12,8);
        Client c2 = new Client(Client.TYPE.PREMIUM,"Valeria",9,12);

        Depot depot1 = new Depot(1,"Copou");
        Depot depot2 = new Depot(2,"Centru");

        Truck v1 = new Truck(80,"T1");
        Drone v2 = new Drone(15,"D1");

        Problem problem = new Problem();

        problem.addClients(c1);
        problem.addClients(c2);

        problem.addDepots(depot1);
        problem.addDepots(depot2);

        problem.addVehicleToDepot(v1,depot1);
        problem.addVehicleToDepot(v2,depot2);

        //problem.getVehicles();






    }
}