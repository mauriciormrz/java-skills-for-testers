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
                .ofColour("black")
                .withFavouriteFood("pizza")
                .bornOn(birthday);

        Assert.assertEquals("Fido", fido.getName());
        Assert.assertEquals("Poodle", fido.getBreed());
        Assert.assertEquals(birthday, fido.getDateOfBirthday());
        Assert.assertEquals("pizza", fido.getFavouriteFood());
        Assert.assertEquals("black", fido.getColour());
    }

}
