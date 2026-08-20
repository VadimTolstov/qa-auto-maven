package ru.tolstov.clean.code.hw2.creational.fabricmethod.task2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class WeaponFactoryRegistry {
    private static final Map<WeaponType, Supplier<WeaponFactory>> weaponHashMap = new HashMap<>();

    public static void registerWeaponFactory(WeaponType weaponType, Supplier<WeaponFactory> weapon) {
        weaponHashMap.put(weaponType, weapon);
    }

    public static WeaponFactory getWeaponFactory(WeaponType weaponType) {
        Supplier<WeaponFactory> weaponFactory = weaponHashMap.get(weaponType);
        if (weaponFactory == null) {
            throw new IllegalArgumentException("No such weapon type: " + weaponType);
        }
        return weaponFactory.get();
    }
}
