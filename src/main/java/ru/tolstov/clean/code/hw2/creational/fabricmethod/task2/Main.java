package ru.tolstov.clean.code.hw2.creational.fabricmethod.task2;

public class Main {
    public static void main(String[] args) {
        WeaponFactoryRegistry.registerWeaponFactory(WeaponType.SWORD, SwordFactory::new);
        WeaponFactoryRegistry.registerWeaponFactory(WeaponType.PISTOL, PistolFactory::new);
        //Добавим Singleton
        BowFactory bowFactorySingleton = new BowFactory();
        WeaponFactoryRegistry.registerWeaponFactory(WeaponType.BOW, () -> bowFactorySingleton);
        WeaponFactory weaponBowSingleton1 = WeaponFactoryRegistry.getWeaponFactory(WeaponType.BOW);
        WeaponFactory weaponBowSingleton2 = WeaponFactoryRegistry.getWeaponFactory(WeaponType.BOW);

        boolean isSingletonWeaponFactory = weaponBowSingleton1 == weaponBowSingleton2;
        System.out.println("WeaponFactory is Singleton ? " + isSingletonWeaponFactory);

        Weapon weaponBow1 = weaponBowSingleton1.createWeapon();
        Weapon weaponBow2 = weaponBowSingleton1.createWeapon();

        boolean isSingletonWeapon = weaponBow1 == weaponBow2;

        System.out.println("Weapon is Singleton ? " + isSingletonWeapon);

        weaponBow1.attack();
        weaponBow2.attack();

    }
}
