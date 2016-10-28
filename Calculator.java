public class Calculator {
	private int result;
	
	/**
	* Прибавляет к результату значения входящих аргументов
	* @args Входящие аргументы
	*/
	public void add(int...args) {
		for (Integer arg:args) {
			this.result+=arg;
		}
	}
	
	/**
	* Вычитает из результата значения входящих аргументов
	* @args Входящие аргументы
	*/
	public void sub(int...args) {
		for (Integer arg:args) {
			this.result-=arg;
		}
	}
	
	/**
	* Возвращает значение результата
	*/
	public int getResult() {
		return this.result;
	}
	
	/**
	* Обнуляет значение результата
	*/
	public void resetResult() {
		 this.result=0;
	}
}