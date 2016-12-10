package ru.lesson.lessons;

public class Client {
	
	/**
	* Имя клиента
	*/
	private String clientName;
	
	/**
	* Питомец клиента
	*/
	private final Pet pet;
	
	/**
	* Конструктор
	* @param clientName  Имя клиента
	* @param pet Питомец клиента
	*/
	public Client(String clientName, Pet pet) {
		this.clientName = clientName;
		this.pet = pet;
	}

	/**
	 * Сеттер имени клиента
	 * @param clientName Имя клиента
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	* Gives a client's name
	* @return clientName
	*/
	public String getName() {
		return this.clientName;
	}
	
	/**
	* Gives a client's pet
	*/
	public Pet getPet() {
		return this.pet;
	}
}