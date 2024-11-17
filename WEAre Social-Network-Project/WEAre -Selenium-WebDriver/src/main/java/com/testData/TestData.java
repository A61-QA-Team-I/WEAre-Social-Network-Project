package com.testData;

import lombok.Getter;
import lombok.Setter;

public class TestData {

    @Setter
    private static String registeredName;
    private static String secondRegisteredName;

    @Getter
    private static final String email = "xesse@abv.bg";
    @Getter
    private static final String password = "Vanko1212";
    @Getter
    private static final String confPassword = "Vanko1212";

    @Getter
    private static final String secondEmail = "vanko@abv.bg";
    @Getter
    private static final String secondPassword = "Vanko123";
    @Getter
    private static final String secondConfPassword = "Vanko123";

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