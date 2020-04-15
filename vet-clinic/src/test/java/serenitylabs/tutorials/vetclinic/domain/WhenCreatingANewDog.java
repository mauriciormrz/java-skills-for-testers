package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;


public class WhenCreatingANewDog {

    @Test
    public void it_should_have_a_name() throws Exception {

        LocalDate birthday = LocalDate.now();

        Dog fido = Dog.called("Fido")
                .ofBreed("Poodle")
                .bornOn(birthday);

        Assert.assertEquals("Fido", fido.getName());
        Assert.assertEquals("Poodle", fido.getBreed());
        Assert.assertEquals(birthday, fido.getDateOfBirthday());
    }

    @Test
    public void it_should_have_an_optional_favourite_food() throws Exception {

        LocalDate birthday = LocalDate.now();

        Dog fido = new Dog("Fido","Poodle",birthday, "pizza");

        Assert.assertEquals("pizza", fido.getFavouriteFood());

    }

}
