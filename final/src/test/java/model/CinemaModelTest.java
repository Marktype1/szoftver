package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CinemaModelTest {

    @Test
    public void nrIsInt() {
        CinemaModel cinemaModel = new CinemaModel();
        assertEquals(true,cinemaModel.nrIsInt("+123"));
        assertEquals(false,cinemaModel.nrIsInt("132"));
        assertEquals(false, cinemaModel.nrIsInt("abcde"));

    }

    @Test
    public void isvalidMail() {
        CinemaModel cinemaModel = new CinemaModel();
        assertEquals(true,cinemaModel.isvalidMail("abc@y"));
        assertEquals(false,cinemaModel.isvalidMail("214123"));
        assertEquals(false,cinemaModel.isvalidMail("abcde"));
    }

    @Test
    public void isvalidFirstName() {
        CinemaModel cinemaModel = new CinemaModel();
        assertEquals(true,cinemaModel.isvalidFirstName("abcd"));
        assertEquals(false,cinemaModel.isvalidFirstName("1abcd"));
        assertEquals(false, cinemaModel.isvalidFirstName("abc+"));
    }

    @Test
    public void isvalidLastName() {
        CinemaModel cinemaModel = new CinemaModel();
        assertEquals(true,cinemaModel.isvalidLastName("abcd"));
        assertEquals(false,cinemaModel.isvalidLastName("1abcd"));
        assertEquals(false, cinemaModel.isvalidLastName("abc+"));
    }
}