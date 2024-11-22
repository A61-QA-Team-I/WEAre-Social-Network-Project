package com.testData;


public class TestData {

    private static String registeredName;
    private static String secondRegisteredName;


    private static final String validEmail = "xesse@abv.bg";
    private static final String validPassword = "Vanko1212!";
    private static final String confValidPassword = "Vanko1212!";





    private static final String shortPassword = "gibbons";
    private static final String shortConfPassword = "gibbons";

    public static String getValidEmail() {
        return validEmail;
    }

    public static String getValidPassword() {
        return validPassword;
    }

    public static String getConfValidPassword() {
        return confValidPassword;
    }

    public static String getShortPassword() {
        return shortPassword;
    }

    public static String getShortConfPassword() {
        return shortConfPassword;
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

    public static String getSecondRegisteredName() {
        if (secondRegisteredName == null) {
            secondRegisteredName = UniqueNameGenerator.getInstance().generateUniqueName();
        }
        return secondRegisteredName;
    }
    public static void setSecondRegisteredName(String secondRegisteredName) {
        TestData.secondRegisteredName = secondRegisteredName;
    }


}