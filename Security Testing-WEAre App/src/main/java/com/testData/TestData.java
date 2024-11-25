package com.testData;


import java.util.Arrays;
import java.util.List;

public class TestData {

    private static String registeredName;

    private static final List<String> commonPasswords = Arrays.asList(
            "12345678", "password", "123456789", "12345", "1234567", "qwerty", "abc123", "monkey", "letmein", "VankoI"
    );
    private static final String validEmail = "xesse@abv.bg";
    private static final String validPassword = getRandomCommonPassword();
    private static final String confValidPassword = validPassword;


    public static String getValidEmail() {
        return validEmail;
    }

    public static String getValidPassword() {
        return validPassword;
    }

    public static String getConfValidPassword() {
        return confValidPassword;
    }




    public static String getRegisteredName() {
        if (registeredName == null) {
            registeredName = UniqueNameGenerator.getInstance().generateUniqueName();
        }
        return registeredName;
    }

    public static void setRegisteredName(String registeredName) {
        TestData.registeredName = registeredName;
    }



    public static String getRandomCommonPassword() {
        int randomIndex = (int) (Math.random() * commonPasswords.size());
        return commonPasswords.get(randomIndex);
    }
}