package com.iljasstan;

import com.github.javafaker.Faker;

public class TestData {
    private static final Faker faker = new Faker();
    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            dayofBirth = "07",
            monthofBirth = "October",
            subject1 = "Biology",
            subject2 = "Maths",
            currentAddress = faker.address().streetAddress(),
            state = "Rajasthan",
            city = "Jaipur",
            resultTableTitle = "Thanks for submitting the form",
            resultGender = "Female";
    public static int yearofBirth = faker.number().numberBetween(1900, 2015);
}
