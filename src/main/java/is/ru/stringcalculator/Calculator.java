package is.ru.stringcalculator;
import java.util.Arrays;


public class Calculator {
	// Our main class method
	public static int add(String text){	
		int result = 0;		
		String delim = "";
		// If the string starts with / we identify the new delimiter and clean up the input 
		if(text.startsWith("/")){
			delim = findDelimiter(text);
			text = cleanText(text, delim);
		}
		if (text.isEmpty())
			return result;

		String[] values = text.replaceAll("\n", ",").split(",");

		if(text.contains("-"))
			throw new IllegalArgumentException(createMessage(values));
		
		result = sum(values);		
		return result;
	}

	private static String cleanText (String input, String delim){
		input = input.replaceAll(delim, ",");
		String[] result = input.split("\n", 2);

		return result[1];
	}

	private static String findDelimiter(String text){
		char delim = text.charAt(2);
		String delimeter = Character.toString(delim);

		return delimeter;
	}

	private static int sum(String[] vals){
		int result = 0;
		for(int i = 0; i < vals.length; i++){
			if(Integer.parseInt(vals[i]) < 1000)
				result = result + Integer.parseInt(vals[i]);
		}

		return result;
	}

	// This function creates the error message thrown when someone tries to add negatives.
	private static String createMessage(String[] vals){
		String errorString = "Negatives not allowed: ";
		for (int i = 0; i < vals.length; i++){
			if(Integer.parseInt(vals[i]) < 0){
				errorString = errorString + vals[i] + ",";
			}
		}
		// Return our errorstring, but trim the trailing comma from the string.
		return errorString.replaceAll(", $", "");
	}
}

