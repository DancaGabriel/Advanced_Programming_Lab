package org.example;

abstract public class Person {

    private int age;
    private String name;
    private String destination;


    public void setName(String name_2){
        this.name = name_2;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
