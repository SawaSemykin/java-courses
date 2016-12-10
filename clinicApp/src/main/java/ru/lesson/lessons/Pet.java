package ru.lesson.lessons;

public abstract class Pet {
	
	/**
	* кличка питомца
	*/
	private String petName;
	
	/**
	* Переменная интерфейсного типа, описывающая набор криков, издаваемых разными питомцами. Это м.б. кошка, собака или любой другой питомец
	*/
	CryingBehavior cryingBehavior;
	
	/**
	* Конструктор
	* @param petName - Название животного
	*/
	public Pet(final String petName) {
		this.petName = petName;
	}
	
	/**
	* Метод делегирует крик конкретному питомцу, на которого ссылается переменная cryingBehavior. 
	*/
	public void cryingPerfom() {
		this.cryingBehavior.cry();
	}
	
	/**
	* Сеттер для клички питомца
	* @param petName Кличка питомца
	*/
	public void setName(String petName ) {
	    this.petName = petName;
    }
	
	/**
	* Геттер для клички питомца
	* @return 
	*/
	public String getName() {
		return this.petName;
	}
}