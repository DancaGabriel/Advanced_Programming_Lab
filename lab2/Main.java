package lab2;
// @Dancă Gabriel E2


public class Main {
    public static void main(String[] args) {
        Client client1 = new Client(Client.TYPE.REGULAR,"Bogdan",12,20);
        Client client2 = new Client(Client.TYPE.PREMIUM,"Vlad",12,20);

        Depot depouCentru = new Depot(1,"Depou centru");
        Vehicle vehicul1 = new Vehicle("General Motors",1,10,depouCentru);
        Vehicle vehicul2 = new Vehicle("BMW",2,9,depouCentru);


        Depot depouCopou = new Depot(2,"Depou Copou");
        depouCopou.addVehicle(vehicul1);
        depouCopou.addVehicle(vehicul2);
        System.out.println("Lista cu masini din depouCopou este: " +  depouCopou.getVehicleListList());


        System.out.println(client1);
        System.out.println(depouCentru);
        System.out.println(vehicul1);

    }
}