package wearetests.unums;

import com.testData.UniqueNameGenerator;

public enum WEAreTestData {


    name ((UniqueNameGenerator.getInstance().generateUniqueName())),
    email ("xesse@abv.bg"),
    password ("Vanko1212"),
    confPassword ("Vanko1212");

    //public static String registeredName;


    private  String value;


    WEAreTestData(String probName) {
        this.value = probName;
    }

    public String getValue() {
        return value;
    }



}
