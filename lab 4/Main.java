package org.example;

import java.util.Random;
import com.github.javafaker.Faker;
import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;



public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Faker faker = new Faker();
        List<String> destinations = new ArrayList<>();

        var drivers = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Driver(20 + i) )
                .toArray(Driver[]::new);

        var passagers = IntStream.rangeClosed(0,4)
                .mapToObj(i -> new Passager(25 + i))
                .toArray(Passager[]::new);

        List<Driver> listOfDrivers = new ArrayList<>();
        List<Passager> listOfPassagers = new ArrayList<>();

        listOfPassagers.addAll(Arrays.asList(passagers));
        listOfDrivers.addAll(Arrays.asList(drivers));

        int min = 0;
        int max = 4; //  max + 1 destinatii

        for(int i=0;i<max + 1;i++){
            destinations.add(faker.address().cityName()); // generam destinatiile
        }

        for(Driver sofer : listOfDrivers){
            sofer.setName(faker.name().fullName());
            int randomNumber = random.nextInt(max - min + 1) + min;
            sofer.setDestination(destinations.get(randomNumber));

        }
        for(Passager pasager : listOfPassagers){
            pasager.setName(faker.name().fullName());
            int randomNumber = random.nextInt(max - min + 1) + min;
            pasager.setDestination(destinations.get(randomNumber));

        }
        //Collections.shuffle(destinations);
        destinations.add(0,faker.address().cityName()); // Adaugam de unde destinatia de plecare

        System.out.println(destinations);


        Problem problem = new Problem(false);
        int i=0;

        while(problem.isOver() == false) {
            for (Driver sofer : listOfDrivers) {
                if(destinations.get(i).equals(sofer.getDestination())) {
                    sofer.setArrived(true);
                    System.out.println("Soferul " + sofer.getName() + " cu destinatia "
                            + sofer.getDestination() + "a ajuns la " + destinations.get(i));
                }
                if(sofer.isArrived() == false) {
                    if (sofer.isFree()) {
                        for (Passager pasager : listOfPassagers) {
                            if(destinations.get(i).equals(pasager.getDestination()) && !pasager.isArrived()){
                                pasager.setArrived(true);
                                System.out.println("Pasagerul " + pasager.getName() + " cu destinatia "
                                + pasager.getDestination() + "a ajuns la " + destinations.get(i));
                            }
                            else if (pasager.isFree() && (destinations.indexOf(sofer.getDestination()) >=
                                    destinations.indexOf(pasager.getDestination()))) {
                                sofer.setFree(false);
                                pasager.setFree(false);
                                System.out.println("Soferul " + sofer.getName() + " care merge pana la " +
                                  sofer.getDestination()   + " o duce pe " + pasager.getName()
                                + "pana la " + pasager.getDestination());
                            }
                        }
                    }
                }

            }
            i++;
            if(i == destinations.size()){
                problem.setOk(true);
            }
        }


    }
}