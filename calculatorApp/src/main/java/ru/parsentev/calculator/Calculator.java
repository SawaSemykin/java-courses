package ru.parsentev.calculator;

public class Calculator {
	/**
	 * память для запоминания результата вычисления
	 */
	private boolean memoryEmpty = true;
	/**
	 * результат вычисления
	 */
	private double result;
	
	/**
	* Операция сложения
	* @args Входящие аргументы
	*/
	public void addition(double...args) {
		for (Double arg: args) {
			this.result += arg;
		}
	}
	
	/**
	* Операция вычитания
	* @args Входящие аргументы
	*/
	public void subtraction(double...args) {
		if (isMemoryEmpty()) {
			this.result = args[0] - args[1];
		} else {
			for (Double arg: args) {
				this.result -= arg;
			}
		}
	}

	/**
	 * Операция умножения
	 * @param args входящие аргументы
	 */
	public void multiplication(double...args) {
		if (isMemoryEmpty()) {
			this.result = args[0] * args[1];
		} else {
			for (double arg: args) {
				this.result *= arg;
			}
		}
	}

	/**
	 * Операция деления
	 * @param args входящие аргументы
	 */
	public void division(double...args) throws ArithmeticException {
		if (isMemoryEmpty()) {
			if (args[1] == 0) {
				throw new ArithmeticException();
			} else {
				this.result = args[0] / args[1];
			}
		} else {
			for (double arg: args) {
				if (arg == 0){
					throw new ArithmeticException();
				} else {
					this.result /= arg;
				}
			}
		}
	}

	/**
	* Возвращает значение результата
	*/
	public double getResult() {
		return this.result;
	}
	
	/**
	* Обнуляет значение результата
	*/
	public void resetResult() {
		 this.result = 0;
	}

	/**
	 * сеттер для памяти результата вычисления
	 * @param memoryEmpty
	 */
	public void setMemoryEmpty(boolean memoryEmpty) {
		this.memoryEmpty = memoryEmpty;
	}

	/**
	 * геттер для памяти результата вычисления
	 * @return
	 */
	public boolean isMemoryEmpty() {
		return this.memoryEmpty;
	}
}