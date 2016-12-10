package ru.lesson.lessons;

import java.util.*;

public class Clinic {
	
	/**
	* Клиенты клиники
	*/
	private final Client[] clients;

	/**
	 * Геттер поля clients
	 * @return
	 */
	public Client[] getClients() {
		return this.clients;
	}

	/**
	* Конструктор
	* @param size Количиство клиентов
	*/
	public Clinic(final int size) {
		this.clients = new Client[size];
	}
	
	/**
	* Добавляет клиента в массив по номеру позиции
	* @param position - номер позиции
	* @param client - клиент
	*/
	public void addClient(final int position,final Client client) {
		this.clients[position] = client;
	}




	/**
	* Удалаяет клиента
	* @param clientName Client's name
	*/
	public void removeClient(final String clientName) {
		String didRemove = "no";
		for (int i = 0; i < this.clients.length; i++) {
			if (!(this.clients[i] == null) && this.clients[i].getName().equals(clientName)) {
				this.clients[i] = null;
				didRemove = "yes";
			}
		}
		if (didRemove.equals("yes")) {
			System.out.println("Succsessful removing");
		} else {
			System.out.println("Unsuccsessful removing");
		}
	}

	
	/**
	* Gives a client's pet
	* @param theClientName Client's name
	* @return Client's pet
	*/
	public Pet getPetOfClient(String theClientName) {
		int count=0;
		for (int i=0; i<this.clients.length; i++){
			if (theClientName.equals(this.clients[i].getName())) {
				break;
			}
			count++;
		}
		return this.clients[count].getPet();
	}

	/**
	 * Выполняет поиск клиента по имени
	 * @param theClientName имя клиента
	 * @return
	 */
	public int findByName(String theClientName) {
		int position = -1;
			for (int i = 0; i < this.clients.length; i++) {
				if (!(this.clients[i] == null) && this.clients[i].getName().equals(theClientName)) {
					position = i;
					break;
				}
			}
		return position;

	}

	/**
	 * Выполняет поиск клиента по кличке питомца
	 * @param thePetName кличка питомца
	 * @return
	 */
	public int searchByPet(String thePetName) {
		return 0;
	}

	/**
	 * Редактирует имя клиента
	 * @param oldName Исходное имя клиента
	 * @param newName Отредактированное имя клиента
	 */
	public void editClientName(String oldName, String newName) {
		if (!(findByName(oldName) == -1)) {
			Client client = this.clients[findByName(oldName)];
			client.setClientName(newName);
		}
	}

	/**
	 * Редактирует кличку питомпа выбранного клиента
	 * @param clientName имя клиента
	 * @param newPetName новая кличка питомца питомца
	 */
	public void editClientPetName(String clientName, String newPetName) {
		if (!(findByName(clientName) == -1)) {
			Client client = this.clients[findByName(clientName)];
			client.getPet().setName(newPetName);
		}
	}
}