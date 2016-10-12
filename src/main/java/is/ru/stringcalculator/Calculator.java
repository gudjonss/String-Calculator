package is.ru.stringcalculator;
import java.util.Arrays;


public class Calculator {
	// Our main class method
	public static int add(String text){
		// Our return variable
		int result = 0;		
		// Create an array with our numbers, commas and newlines removed.
		String[] values = text.replaceAll("\n", ",").split(",");
		if(text.contains("-"))
			throw new IllegalArgumentException(createMessage(values));
		// If the string is empty we immediatly return 0.
		if (text.isEmpty()){
			return result;
		}

		result = sum(values);		
		return result;
	}



	// Helper method for summing up our array
	private static int sum(String[] vals){
		int result = 0;
		// Loop over the array and add the numbers stored there.
		for(int i = 0; i < vals.length; i++){
			result = result + Integer.parseInt(vals[i]);
		}

		return result;
	}

	private static String createMessage(String[] vals){
		String errorString = "Negatives not allowed: ";
		for (int i = 0; i < vals.length; i++){
			if(Integer.parseInt(vals[i]) < 0){
				errorString = errorString + vals[i] + ",";
			}
		}
		errorString = errorString.replaceAll(", $", "");
		return errorString;
	}
}

