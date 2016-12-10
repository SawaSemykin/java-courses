package ru.lesson.lessons;

public class Cat extends Pet {

    public Cat(String catName) {
        super(catName);
        cryingBehavior = new Meow();
    }
}