package ru.lesson.lessons;

import java.util.Scanner;

public class ClinicRunner {
	
	/**
	 * Максимальное количество клиентов, обслуживаемых в клинике
	 */
	private final int MAX_CLINIC_SIZE = 10;

	private Clinic theClinic;
	private Scanner userInput;

	/**
	 * Конструктор
	 */
	private ClinicRunner() {
		this.generateClinic();
		this.userInput = new Scanner(System.in);
	}

	/**
	 * Создает клинику. Вносит в клинику 3-х посетителей
	 */
	private void generateClinic() {
		this.theClinic = new Clinic(MAX_CLINIC_SIZE);
		this.theClinic.addClient(0, new Client("Julia", new Cat("Barsik")));
		this.theClinic.addClient(1, new Client("Richard", new Cat("Felix")));
		this.theClinic.addClient(2, new Client("Hellen", new Dog("Sparky")));
	}

	/**
	* Запускает работу клиники
	*/
	private void run() {
		String doStopRunning = "no";
		while (doStopRunning.equals("no")) {
			showServices();
			requestService();
			doStopRunning = requestStopRunning();
		}

	}

	/**
	 * Отображает список сервисов
	 */
	private void showServices() {
		System.out.println("Which service would you like to get?");
		System.out.println("");
		System.out.println("Get registred to the clinic/ 1");
		System.out.println("Get out from the clinic/ 2");
		System.out.println("Find client by name/ 3");
		System.out.println("Edit client's name/ 4");
		System.out.println("Edit pet's name of client/ 5");
	}

	/**
	* Запрашивает у пользователя сервис, который необходимо выполнить и выполняет его
	*/
	private void requestService() {
		String selectedService;
		do {
			selectedService = this.userInput.next();
		} while(!validateRequestService(selectedService));
		if (selectedService.equals("1")) {
			addClientAction();
		} else if (selectedService.equals("2")) {
			removeClientAction();
		} else if (selectedService.equals("3")) {
			findByNameAction();
		} else if (selectedService.equals("4")) {
			editClientNameAction();
		} else if (selectedService.equals("5")) {
			editClientPetNameAction();
		}
	}

	/**
	 * Проверяет ввод пользователя на соответствие допостимым значениям для ввода при выборе сервиса
	 * @param service Ввод пользователя
	 * @return isValid булевое значение о принадлежности пользовательского ввода к допустимым значениям
	 */
	private boolean validateRequestService(String service) {
		boolean isValid = false;
			String[] services = {"1", "2", "3", "4", "5", "6"};
			for (int i = 0; i < services.length; i++) {
				if (service.equals(services[i])) {
					isValid = true;
					break;
				}
			}
			if (!isValid) {
				System.out.println("Wrong input. Try again.");
			}
		return isValid;
	}

	/**
	* Добавляет клиента в клинику по полученным от пользователя данным - имя пользователя, вид питомца, кличка питомца 
	*/
	private void addClientAction() {
		System.out.println("Enter client's name");
		String clientName = this.userInput.next();
		System.out.println("Enter client's kind of pet/ Cat or Dog");
		String kindOfPet = this.userInput.next();
		System.out.println("Enter pet's name of client");
		String petName = this.userInput.next();
		for (int i=0; i  < MAX_CLINIC_SIZE; i++) {
			if ((this.theClinic.getClients()[i] == null)) {
				this.theClinic.addClient(i, new Client(clientName, petRecognize(kindOfPet, petName)));
				break;
			} else if ((i + 1) == MAX_CLINIC_SIZE) {
				System.out.println("Clinic is full");
			}
		}
	}
	
	/**
	* Определяет вид питомца
	* @ kindOfPet вид питомца
	* @ petName кличка питомца
	* @return pet
	*/
	private Pet petRecognize(String kindOfPet, String petName) {
		Pet pet = null;
		if (kindOfPet.equals("cat")) {
			pet = new Cat(petName);
		} else if (kindOfPet.equals("Dog")) {
			pet = new Dog(petName);
		}
		return pet;
	}
	
	/**
	* Удаляет клиента из клиники по полученному от пользователя имени этого клиента
	*/
	private void removeClientAction() {
		System.out.println("");
		System.out.println("Enter client's name");
		String clientName = this.userInput.next();
		this.theClinic.removeClient(clientName);
	}

	/**
	 * Выполняет поиск клиента по имени, полученному от пользователя
	 * @return foundposition Позиция в массиве
	 */
	private int findByNameAction() {
		System.out.println("Enter client's name you want to find");
		String clientName = this.userInput.next();
		int foundPosition = this.theClinic.findByName(clientName);
		if (foundPosition == -1) {
			System.out.println("Client isn't found");
		} else {
			System.out.println("Client's found");
		}
		return foundPosition;
	}

	/**
	 * Запрашивает у пользователя старое имя клиента, новое имя и производит замену старого имени на новое
	 */
	private void editClientNameAction() {
		String oldName;
		do {
			System.out.println("Enter initial name of client");
			oldName = this.userInput.next();
			if (theClinic.findByName(oldName) == -1) {
				System.out.println("Client isn't found. Try again.");
			}
		} while (theClinic.findByName(oldName) == -1);
		System.out.println("Enter new name of client");
		String newName = this.userInput.next();
		this.theClinic.editClientName(oldName,newName);
		System.out.println("Editing succsessful");
	}

	/**
	 * Запрашивает у пользователя имя клиента и новую кличку питомца и заменяет старую кличку этого питомца на новую
	 */
	private void editClientPetNameAction() {
		String clientName;
		do {
			System.out.println("Enter name of client");
			clientName = this.userInput.next();
			if (theClinic.findByName(clientName) == -1) {
				System.out.println("Client isn't found. Try again.");
			}
		} while (theClinic.findByName(clientName) == -1);
		System.out.println("Enter new pet's name of client");
		String petName = this.userInput.next();
		theClinic.editClientPetName(clientName,petName);
	}

	/**
	 * Принимает пользовательский ввод о выходе из программы
	 */
	private String requestStopRunning() {
		String doStopRunning;
		System.out.println("");
		System.out.println("Was it the last request? yes/no");
		do {
			doStopRunning = this.userInput.next();
		} while(!validateStopRunning(doStopRunning));
		return doStopRunning;
	}

	/**
	 * Проверяет ввод пользователя на соответствие допустиму вводу при запросе о выходе из программы
	 * @param input Пользовательский ввод
	 * @return isValid булевое значение о принадлежности пользовательского ввода к допустимым значениям
	 */
	private boolean validateStopRunning(String input) {
		boolean isValid = false;
		String[] wrightInputs = {"yes", "no"};
		for (int i = 0; i < wrightInputs.length; i++) {
			if (input.equals(wrightInputs[i])) {
				isValid = true;
				break;
			}
		}
		if (!isValid) {
			System.out.println("Wrong input. Try again.");
		}
		return isValid;
	}


	public static void main(String[] args) {
		new ClinicRunner().run();
	}
}