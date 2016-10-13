public class Calculate {
	private int addition;
	private int subtraction;
	private int multiplication;
	private int division;
	private int modulo;
	public static void main(String[] args) {
		int x=Integer.parseInt(args[0]);
		int y=Integer.parseInt(args[1]);
		Calculate calculate=new Calculate();
		calculate.setAddition(x,y);
		calculate.setSubtraction(x,y);
		calculate.setMultiplication(x,y);
		calculate.setDivision(x,y);
		calculate.setModulo(x,y);
		System.out.println("addition result - "+calculate.getAddition());
		System.out.println("subtraction result - "+calculate.getSubtraction());
		System.out.println("multiplication result - "+calculate.getMultiplication());
		System.out.println("division result - "+calculate.getDivision());
		System.out.println("modulo result - "+calculate.getModulo());
	}
	
	public void setAddition(int x, int y) {
		addition=x+y;
	}
	
	public void setSubtraction(int x, int y) {
		subtraction=x-y;
	}
	
	public void setMultiplication(int x, int y) {
		multiplication=x*y;
	}
	
	public void setDivision(int x, int y) {
		division=x/y;
	}
	
	public void setModulo(int x, int y) {
		modulo=x%y;
	}
	
	public int getAddition() {
		return addition;
	}
	
	public int getSubtraction() {
		return subtraction;
	}
	
	public int getMultiplication() {
		return multiplication;
	}
	
	public int getDivision() {
		return division;
	}
	
	public int getModulo() {
		return modulo;
	}
	
}