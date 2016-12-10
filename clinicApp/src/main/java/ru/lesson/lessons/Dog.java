package ru.lesson.lessons;

public class Dog extends Pet {
	
	public Dog(String dogName) {
		super(dogName);
		cryingBehavior = new Bark();
	}
}