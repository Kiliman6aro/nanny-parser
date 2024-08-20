package ua.pp.hophey.utils;

import static org.junit.jupiter.api.Assertions.*;
class PhoneNumberCountryFormatTest {

    private String expectedUkrainePhoneNumber = "+380999461546";
    @org.junit.jupiter.api.Test
    void toUkraineStartFromUkraineFormat() {
        String phoneNumber = "+380999461546";
        String ukrainePhoneNumber = PhoneNumberCountryFormat.toUkraine(phoneNumber);
        assertEquals(expectedUkrainePhoneNumber, ukrainePhoneNumber);
    }

    @org.junit.jupiter.api.Test
    void toUkraineStartFromZero() {
        String phoneNumber = "0999461546";
        String ukrainePhoneNumber = PhoneNumberCountryFormat.toUkraine(phoneNumber);
        assertEquals(expectedUkrainePhoneNumber, ukrainePhoneNumber);
    }

    @org.junit.jupiter.api.Test
    void toUkraineStartFromEightZero(){
        String phoneNumber = "80999461546";
        String ukrainePhoneNumber = PhoneNumberCountryFormat.toUkraine(phoneNumber);
        assertEquals(expectedUkrainePhoneNumber, ukrainePhoneNumber);
    }

    @org.junit.jupiter.api.Test
    void toUkraineStartFromPlusEightZero(){
        String phoneNumber = "+80999461546";
        String ukrainePhoneNumber = PhoneNumberCountryFormat.toUkraine(phoneNumber);
        assertEquals(expectedUkrainePhoneNumber, ukrainePhoneNumber);
    }

    @org.junit.jupiter.api.Test
    void toUkraineStartFromPlusZero(){
        String phoneNumber = "+0999461546";
        String ukrainePhoneNumber = PhoneNumberCountryFormat.toUkraine(phoneNumber);
        assertEquals(expectedUkrainePhoneNumber, ukrainePhoneNumber);
    }
}