package ru.lesson.lessons;

public class AnimalTest {
	public static void main(String[] args) {

		Pet cat = new Cat("Murzik");
		System.out.print(cat.getName()+" says - ");
		cat.cryingPerfom();

		Pet dog=new Dog("Sparky");
		System.out.print(dog.getName()+" says - ");
		dog.cryingPerfom();
	}
}