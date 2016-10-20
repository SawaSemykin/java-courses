import java.util.Scanner;

public class InteractRunner {
	
	private int theFirstOperand;
	private int theSecondOperand;
	private String operator;
	private String isReset;
	private Scanner userInput;
	private Calculator calculator;
	
	public InteractRunner() {
		userInput=new Scanner(System.in);
		calculator=new Calculator();
		isReset="yes";
	}
	
	public static void main(String[] args) {
		InteractRunner runner=new InteractRunner();
		runner.go();
	}
	
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
	
	private void requestData() {
		if (!isReset.equals("yes")) {
			theFirstOperand=0;
		} else {
			System.out.println("Enter the first operand");
			theFirstOperand=Integer.valueOf(userInput.next());
		}
		System.out.println("Enter the second operand");
		theSecondOperand=Integer.valueOf(userInput.next());
		requestOperator();
	}
	
	private void requestOperator() {
		System.out.println("Choose operator: add/a; sub/s");
		this.operator=userInput.next();
	}
	
	private void calculate() {
		switch(operator.charAt(0)) {
			case 'a':
			calculator.add(this.theFirstOperand,this.theSecondOperand);
			break;
			
			case 's':
			calculator.sub(this.theFirstOperand,this.theSecondOperand);
			break;
		}
		System.out.println("Result is "+calculator.getResult());
	}
	
	private void requestResetResult() {
		System.out.println("Reset result? yes/no");
		isReset=userInput.next();
		if (isReset.equals("yes")) {
			calculator.resetResult();
		}
	}
	
	private String requestExitApp() {
		System.out.println("Exit? yes/no");
		String isExit=userInput.next();
		return isExit;
	}
}