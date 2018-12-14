package ru.ott.autotest.model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ParametersList {
    public String getName() {
        List<String> list = Arrays.asList("Москва", "Italy", "Карелия", "Африка", "Сан-Фр", "Китай", "Radisson", "Домодедово", "SVO", "123");
        Random random = new Random();
        String foo = list.get(random.nextInt(list.size()));
        System.out.println(foo);
        return foo;
    }
}