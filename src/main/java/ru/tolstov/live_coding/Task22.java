package ru.tolstov.live_coding;

public class Task22 {
    static class Person {
        private  int age;

        public Person(int age) {
            this.age = age;
        }

        public boolean isAdult() {
            return this.age >= 18;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Person(18).isAdult());
        System.out.println(new Person(19).isAdult());
        System.out.println(new Person(17).isAdult());
    }
}
