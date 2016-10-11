package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		
		int result = 0;

		if (text.isEmpty()){
			return result;
		}

		else{
			result = Integer.parseInt(text);
			return result;
		}
	}




}