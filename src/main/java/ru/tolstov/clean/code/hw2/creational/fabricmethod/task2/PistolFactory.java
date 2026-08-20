package ru.tolstov.clean.code.hw2.creational.fabricmethod.task2;

public class PistolFactory implements WeaponFactory {
    @Override
    public Weapon createWeapon() {
        return new Pistol();
    }
}
