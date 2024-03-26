package org.example;

public class Passager extends  Person{
    private String name;
    private String destination;

    private boolean isFree;
    private boolean arrived;

    public boolean isArrived() {
        return arrived;
    }

    public void setArrived(boolean arrived) {
        this.arrived = arrived;
    }



    private int age;

    public String getName() {
        return name;
    }

    Passager(int age_2){
        this.age = age_2;
        isFree = true;
        arrived = false;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}
