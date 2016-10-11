package is.ru.stringcalculator;
import java.util.Arrays;


public class Calculator {

	public static int add(String text){
		
		int result = 0;
		String[] values = text.split(",");

		if (text.isEmpty()){
			return result;
		}

		for(int i = 0; i < values.length; i++){
			result = result + Integer.parseInt(values[i]);
		}

		return result;
	}
}