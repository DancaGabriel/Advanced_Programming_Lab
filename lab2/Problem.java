package lab2;

import java.util.ArrayList;
import java.util.List;

public class Problem {
    private List<Depot> depots;
    private List<Client> clients;



    Problem(){
        clients = new ArrayList<>();
        depots = new ArrayList<>();
    }

    public void addClients(Client client)
    {
        if(clients.contains(client)){
            System.out.println("Clientul a fost deja adaugat!");
        } else clients.add(client);
    }

    public void addDepots(Depot depot){
        if(depots.contains(depot)){
            System.out.println("Depozitul a fost deja adaugat!");
        }
        else depots.add(depot);
    }

    public void addVehicleToDepot(Vehicle vehicul,Depot depot){
        System.out.println(vehicul);
        System.out.println(depot);
        if(depots.contains(depot)){
            depot.addVehicle(vehicul);
            System.out.println("112" + depot.getVehicleList());
        }
        else System.out.println("Depozitul nu exista");
    }

    public void getVehicles(){
        for(Depot i : depots){
            System.out.println("Depozitul " + i.getDepotName() + " contine urmatoarele vehicule: " + i.getVehicleList());
        }
    }
}
