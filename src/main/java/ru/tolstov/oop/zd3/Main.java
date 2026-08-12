package ru.tolstov.oop.zd3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pet> list = new ArrayList<>();
        list.add(new Cat("Кара"));
        list.add(new Dog("Балто"));
        list.add(new Dragon("Синий зуб"));

        PetCareService petCareService = new PetCareService();
        petCareService.eatAll(list);
        petCareService.sleepAll(list);
    }
}
