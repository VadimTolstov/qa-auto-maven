package ru.tolstov.clean.code.hw2.creational.builder.task2;

public class Personage {
    private final int health;
    private final int damage;
    private final int armor;
    private final int magic;

    private Personage(PersonageBuilder builder) {
        this.health = builder.health;
        this.damage = builder.damage;
        this.armor = builder.armor;
        this.magic = builder.magic;
    }

    @Override
    public String toString() {
        return "Personage{" +
                "health=" + health +
                ", damage=" + damage +
                ", armor=" + armor +
                ", magic=" + magic +
                '}';
    }

    static class PersonageBuilder {
        private int health;
        private int damage;
        private int armor;
        private int magic;

        public PersonageBuilder setHealth(int health) {
            this.health = health;
            return this;
        }

        public PersonageBuilder setDamage(int damage) {
            this.damage = damage;
            return this;
        }

        public PersonageBuilder setArmor(int armor) {
            this.armor = armor;
            return this;
        }

        public PersonageBuilder setMagic(int magic) {
            this.magic = magic;
            return this;
        }

        public Personage build() {
            return new Personage(this);
        }
    }
}
