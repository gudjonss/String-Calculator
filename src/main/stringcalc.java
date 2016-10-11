import java.util.Arrays;
import java.io.*;


class StringCalculator {

    public int Add(String numbers){
	// Split string on commas to separate the input numbers.
	String[] values = numbers.split(",");

	// If the input is empty, we return 0 immediatly.
	if (numbers.isEmpty()){
	    return 0;
	}

	// todo: implement calculations 
	return 500;
    }








    public static void main(String [] args) throws IOException {
	// Variable that stores the result of adding.
	int result = 0;
	
	// Read from StdIn
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	String s = "";
	String myString = "";
	while ((s = in.readLine()) != null && s.length() != 0)
	    myString = myString + s;
	

	// Create a stringcalculator object and call our Add method.
	StringCalculator stringcalculator = new StringCalculator();
	result = stringcalculator.Add(myString);
	// Print the result
	System.out.println(result);
    }
}
