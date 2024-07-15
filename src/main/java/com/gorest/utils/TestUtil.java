package com.gorest.utils;

import com.github.javafaker.Faker;

import java.util.Random;

public class TestUtil {

    public static String getRandomValue(){
        Random random = new Random();
        int randomInt = random.nextInt(100000);
        return Integer.toString(randomInt);
    }

    public static String getRandomName(){
        Faker faker = new Faker();
        return faker
                .name()
                .firstName();
    }

}
