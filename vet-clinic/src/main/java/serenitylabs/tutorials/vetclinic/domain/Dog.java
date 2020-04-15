package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;

public class Dog {

    private final String name;
    private final String breed;
    private final LocalDate dateOfBirthday;
    private final String favouriteFood;
    private final String colour;


    private Dog(String name, String breed, LocalDate dateOfBirthday, String favouriteFood, String colour) {

        this.name = name;
        this.breed = breed;
        this.dateOfBirthday = dateOfBirthday;
        this.favouriteFood = favouriteFood;
        this.colour = colour;
    }

    public static OfBreed called(String name) {
        return new DogBuilder(name);
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

    public String getColour() {
        return colour;
    }

    interface OfBreed {
        OfColour ofBreed(String breed);
    }

    interface OfColour {
        DogBuilder ofColour(String colour);
    }

    public static class DogBuilder implements OfBreed, OfColour {

        private String name;
        private String breed;
        private String favouriteFood;
        private String colour;

        public DogBuilder(String name) {
            this.name = name;
        }

        public DogBuilder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Dog bornOn(LocalDate birthday) {
            return new Dog(name, breed, birthday, favouriteFood, colour);
        }

        public DogBuilder withFavouriteFood(String favouriteFood) {
            this.favouriteFood = favouriteFood;
            return this;
        }

        public DogBuilder ofColour(String colour) {
            this.colour = colour;
            return this;
        }
    }
}
