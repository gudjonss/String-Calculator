package is.ru.stringcalculator;
import java.util.Arrays;


public class Calculator {
	// Our main class method
	public static int add(String text){
		// Our return variable
		int result = 0;

		// Replace all newline characters with commas, then split the string on commas.
		String[] values = text.replaceAll("\n", ",").split(",");

		// If the string is empty we immediatly return 0.
		if (text.isEmpty()){
			return result;
		}
		try{
			checkNegatives(values);	
		}catch(IllegalArgumentException e){
			e.getMessage();
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

	private static void checkNegatives (String[] vals) throws IllegalArgumentException{
		String[] negatives;
		String errorString = "";
		for (int i = 0; i < vals.length; i++){
			if(Integer.parseInt(vals[i]) < 0){
				errorString = errorString + vals[i] + ",";
			}
		}
		System.out.println(errorString);
		throw new IllegalArgumentException("Negatives not allowed");
	}
}