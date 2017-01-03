package ru.parsentev.calculator;

import java.util.Scanner;

public class InteractRunner {

	/**
	 * Первый и второй операнды
	 */
	private double theFirstOperand;
	private double theSecondOperand;

	/**
	 * Оператор
	 */
	private String operator;

	/**
	 * Повторное использование результата
	 */
	private String doReset;

	/**
	 * Пользовательский ввод
	 */
	private Scanner userInput;

	/**
	 * Ссылка на объет Calculator
	 */
	private Calculator calculator;
	
	/** 
	* Конструктор
	*/
	public InteractRunner() {
		userInput = new Scanner(System.in);
		calculator = new Calculator();
		doReset = "yes";
	}
	
	/** 
	* Вызывает последавательность работы программы
	*/
	public static void main(String[] args) {
		InteractRunner runner = new InteractRunner();
		runner.go();
	}
	
	/** 
	* Последовательность работы программы
	*/
	public void go() {
		try {
			
			String isExit = "no";
			while (!isExit.equals("yes")) {
				requestData();
				calculate();
				requestResetResult();
				isExit = requestExitApp();
			}
		} finally {
			userInput.close();
		}
	}
	
	/** 
	* Выполняет запрос аргументов для вычисления и вызывает метод для запроса арифметической операции над аргументами
	*/
	private void requestData() {
		if (!this.doReset.equals("yes")) {
			this.theFirstOperand = 0;
		} else {
			System.out.println("Enter the first operand");
			this.theFirstOperand = Integer.valueOf(userInput.next());
		}
		System.out.println("Enter the second operand");
		this.theSecondOperand = Integer.valueOf(userInput.next());
		requestOperator();
	}
	
	/** 
	* Выполняет запрос арифметической операции, которую нужно выполнить над аргументами
	*/
	private void requestOperator() {
		do {
			System.out.println("Choose operator: addition/a; subtraction/s; multiplication/m; division/d");
			this.operator = userInput.next();
		} while (!validateOperator(this.operator));
	}
	
	/** 
	* Выполняет вычисления над полученными аргументами
	*/
	private void calculate() {
		switch(this.operator.charAt(0)) {
			case 'a':
			calculator.addition(this.theFirstOperand, this.theSecondOperand);
			break;
			
			case 's':
			calculator.subtraction(this.theFirstOperand, this.theSecondOperand);
			break;

			case 'm':
			calculator.multiplication(this.theFirstOperand, this.theSecondOperand);
			break;

			case 'd':
				try {
					calculator.division(this.theFirstOperand, this.theSecondOperand);
				} catch(ArithmeticException aE) {
					System.out.println("Divizion by zero. Result was reseted. Try again. \n");
					calculator.resetResult();
					go();
			}

			break;
		}
		System.out.println("Result is "+calculator.getResult());
	}
	
	/** 
	* Выполняет запрос об обнулении результата вычисления
	*/
	private void requestResetResult() {
		do {
			System.out.println("Do reset result? yes/no");
			this.doReset = userInput.next();
		} while(!validateYesNo(this.doReset));
		if (this.doReset.equals("yes")) {
			calculator.resetResult();
			calculator.setMemoryEmpty(true);
		} else {
			calculator.setMemoryEmpty(false);
		}
	}
	
	/** 
	* Выполняет запрос о выходе из программы
	* @return isExit Флаг выхода из программы
	*/
	private String requestExitApp() {
		String doExit;
		do {
			System.out.println("Do exit? yes/no");
			doExit = userInput.next();
		} while (!validateYesNo(doExit));
		return doExit;
	}

	/**
	 * Валидация ввода пользователем yes/no
	 * @param input ввод пользователя
	 * @return корректный ввод?
	 */
	private boolean validateYesNo(String input) {
		boolean isValid = false;
		String[] validInputs = {"yes", "no"};
		for (int i = 0; i < validInputs.length; i++) {
			if (input.equals(validInputs[i])) {
				isValid = true;
				break;
			}
		}
		if (!isValid) {
			System.out.println("Invalid input. Try again.");
		}
		return isValid;
	}

	/**
	 * Валидация ввода пользователем оператора
	 * @param input ввод пользователя
	 * @return корректный ввод?
	 */
	private boolean validateOperator (String input) {
		boolean isValid = false;
		String[] validInputs = {"a", "s", "m", "d"};
		for (int i = 0; i < validInputs.length; i++) {
			if (input.equals(validInputs[i])) {
				isValid = true;
				break;
			}
		}
		if (!isValid) {
			System.out.println("Invalid input. Try again");
		}
		return isValid;
	}
}