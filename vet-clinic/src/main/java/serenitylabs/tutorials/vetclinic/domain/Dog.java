package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDateTime;

public class Dog {

    private String name;
    private String breed;

    private LocalDateTime dateOfBirthday;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public LocalDateTime getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(LocalDateTime dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }
}
