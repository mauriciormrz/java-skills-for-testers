package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;

public class Dog {

    private final String name;
    private final String breed;
    private final LocalDate dateOfBirthday;

    private final String favouriteFood;


    public Dog(String name, String breed, LocalDate dateOfBirthday) {

        this(name,breed,dateOfBirthday,null);
    }

    public Dog(String name, String breed, LocalDate dateOfBirthday,String favouriteFood) {

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

    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public static DogBuilder called(String name) {
        return new DogBuilder(name);
    }

    public static class DogBuilder {

        private String name;
        private String breed;

        public DogBuilder(String name) {
            this.name = name;
        }

        public DogBuilder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Dog bornOn(LocalDate birthday) {
            return new Dog(name, breed, birthday);
        }

    }
}
