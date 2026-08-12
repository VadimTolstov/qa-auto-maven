package ru.tolstov.oop.zd3;

import java.util.List;

public class PetCareService {
    public void eatAll(List<Pet> list) {
        list.forEach(Pet::eat);
    }

    public void sleepAll(List<Pet> list) {
        list.forEach(Pet::sleep);
    }
}
