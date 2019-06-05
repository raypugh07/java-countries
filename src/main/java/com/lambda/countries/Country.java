package com.lambda.countries;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class Country {

    private static final AtomicLong counter=new AtomicLong();
    private long id;
    private String name;
    private double population;
    private double landMass;
    private int age;

    public Country(String name, double population, double landMass, int age) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.population = population;
        this.landMass = landMass;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public double getLandMass() {
        return landMass;
    }

    public void setLandMass(double landMass) {
        this.landMass = landMass;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", landMass=" + landMass +
                ", age=" + age +
                '}';
    }


}
