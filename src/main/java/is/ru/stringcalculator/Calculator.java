package is.ru.stringcalculator;
import java.util.Arrays;


public class Calculator {
	// Our main class method
	public static int add(String text){
		char delimiter = 'x';	
		String delim = "bla";
		// If the string starts with / we identify the new delimiter
		if(text.startsWith("/")){
			delimiter = findDelimiter(text);
			delim = Character.toString(delimiter);
			text = cleanText(text);
			text.replaceAll(delim, ",");
			System.out.println(delimiter);
			System.out.println(text);
		}

		// Our return variable
		int result = 0;		
		// Create an array with our numbers, commas and newlines removed.
		String[] values = text.replaceAll("\n", ",").replaceAll(delim, ",").split(",");
		// If the input string contains a negative number we throw an exception
		if(text.contains("-"))
			throw new IllegalArgumentException(createMessage(values));
		// If the string is empty we immediatly return 0.
		if (text.isEmpty()){
			return result;
		}



		result = sum(values);		
		return result;
	}

	private static String cleanText (String input){
		String[] result = input.split("\n", 2);

		return result[1];
	}

	private static char findDelimiter(String text){
		char delim = text.charAt(2);

		return delim;
	}


	// Helper method for summing up our array
	private static int sum(String[] vals){
		int result = 0;
		// Loop over the array and add the numbers stored there.
		for(int i = 0; i < vals.length; i++){
			if(Integer.parseInt(vals[i]) < 1000)
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
		// Return our errorstring, but trim the trailing comma from the string.
		return errorString.replaceAll(", $", "");
	}
}

