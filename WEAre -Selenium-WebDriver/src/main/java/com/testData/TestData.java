package com.testData;

import lombok.Getter;
import lombok.Setter;

public class TestData {

    @Setter
    private static String registeredName;
    private static String secondRegisteredName;


    @Getter
    private static final String validEmail = "xesse@abv.bg";
    @Getter
    private static final String validPassword = "Vanko1212!";
    @Getter
    private static final String confValidPassword = "Vanko1212!";

//    @Getter
//    private static final String secondValidEmail = "vanko@abv.bg";
//    @Getter
//    private static final String secondPassword = "Vanko1212!";
//    @Getter
//    private static final String secondConfPassword = "Vanko1212!";



//    @Getter
//    private static final String thirdEmail = "vanko@abv.bg";
    @Getter
    private static final String shortPassword = "gibbons";
    @Getter
    private static final String shortConfPassword = "gibbons";

//    @Getter
//    private static final String longPassword = "gibbons";
//    @Getter
//    private static final String longConfPassword = "gibbons";




    public static String getRegisteredName() {
        if (registeredName == null) {
            registeredName = UniqueNameGenerator.getInstance().generateUniqueName();
        }
        return registeredName;
    }

    public static String getSecondRegisteredName() {
        if (secondRegisteredName == null) {
            secondRegisteredName = UniqueNameGenerator.getInstance().generateUniqueName();
        }
        return secondRegisteredName;
    }

}