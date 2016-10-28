import java.util.Scanner;

public class InteractRunner {
	
	private int theFirstOperand;
	private int theSecondOperand;
	private String operator;
	private String isReset;
	private Scanner userInput;
	private Calculator calculator;
	
	/** 
	* Конструктор
	*/
	public InteractRunner() {
		super();
		userInput=new Scanner(System.in);
		calculator=new Calculator();
		isReset="yes";
	}
	
	/** 
	* Вызывает последавательность работы программы
	*/
	public static void main(String[] args) {
		InteractRunner runner=new InteractRunner();
		runner.go();
	}
	
	/** 
	* Последовательность работы программы
	*/
	public void go() {
		try {
			
			String isExit="no";
			while (!isExit.equals("yes")) {
				requestData();
				calculate();
				requestResetResult();
				isExit=requestExitApp();
			}
		} finally {
			userInput.close();
		}
	}
	
	/** 
	* Выполняет запрос аргументов для вычисления и вызывает метод для запроса арифметической операции над аргументами
	*/
	private void requestData() {
		if (!this.isReset.equals("yes")) {
			this.theFirstOperand=0;
		} else {
			System.out.println("Enter the first operand");
			this.theFirstOperand=Integer.valueOf(userInput.next());
		}
		System.out.println("Enter the second operand");
		this.theSecondOperand=Integer.valueOf(userInput.next());
		requestOperator();
	}
	
	/** 
	* Выполняет запрос арифметической операции, которую нужно выполнить над аргументами
	*/
	private void requestOperator() {
		System.out.println("Choose operator: add/a; sub/s");
		this.operator=userInput.next();
	}
	
	/** 
	* Выполняет вычисления над полученными аргументами
	*/
	private void calculate() {
		switch(this.operator.charAt(0)) {
			case 'a':
			calculator.add(this.theFirstOperand,this.theSecondOperand);
			break;
			
			case 's':
			calculator.sub(this.theFirstOperand,this.theSecondOperand);
			break;
		}
		System.out.println("Result is "+calculator.getResult());
	}
	
	/** 
	* Выполняет запрос об обнулении результата вычисления
	*/
	private void requestResetResult() {
		System.out.println("Reset result? yes/no");
		this.isReset=userInput.next();
		if (this.isReset.equals("yes")) {
			calculator.resetResult();
		}
	}
	
	/** 
	* Выполняет запрос о выходе из программы
	* @return isExit Флаг выхода из программы
	*/
	private String requestExitApp() {
		System.out.println("Exit? yes/no");
		String isExit=userInput.next();
		return isExit;
	}
}