package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDateTime;

public class Dog {

    private final String name;
    private final String breed;
    private final LocalDateTime dateOfBirthday;

    private final String favouriteFood;

    public Dog(String name, String breed, LocalDateTime dateOfBirthday) {

        this(name,breed,dateOfBirthday,null);
    }

    public Dog(String name, String breed, LocalDateTime dateOfBirthday,String favouriteFood) {

        this.name = name;
        this.breed = breed;
        this.dateOfBirthday = dateOfBirthday;
        this.favouriteFood = favouriteFood;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public LocalDateTime getDateOfBirthday() {
        return dateOfBirthday;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }
}
