package org.example;

public class Driver extends Person{
    private String name;
    private String destination;

    private Passager pasager;

    boolean isFree;

    public boolean isArrived() {
        return arrived;
    }

    public void setArrived(boolean arrived) {
        this.arrived = arrived;
    }

    private boolean arrived;

    private int age;

    Driver(int age_2){
        this.age = age_2;
        isFree = true;
        arrived = false;
    }

    public String getName() {
        return name;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public Passager getPasager() {
        return pasager;
    }

    public void setPasager(Passager pasager) {
        this.pasager = pasager;
    }
}
