package eDiscovery.dataGenerator;

import com.github.javafaker.Faker;

public class DataGeneratorCommon {
    public static Faker faker = new Faker();

    public static String getRandomName(){
        return getRandomName(30);
    }

    public static String getRandomName(int length){
        return faker.regexify("[a-zA-Z]{" + length + "}");
    }
}
