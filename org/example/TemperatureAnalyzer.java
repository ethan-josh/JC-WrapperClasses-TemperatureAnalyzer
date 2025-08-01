package org.example; // Should be the first line

import java.util.Scanner; // importing Java Scanner

class TemperatureAnalyzer{ // This should be default modifier
	static public void main(String args []){ // This works!
		Scanner scanner = new Scanner(System.in); // Creating an instance of Scanner object called scanner

		String day1TempStr, day2TempStr, day3TempStr; // This compiles!
		System.out.print("Enter Day 1 High Temperature (E.g., 28.5): ");
		day1TempStr = scanner.nextLine(); // getting user input and storing it
		System.out.print("Enter Day 2 High Temperature (E.g., 28.5): ");
		day2TempStr = scanner.nextLine(); // getting user input and storing it
		System.out.print("Enter Day 3 High Temperature (E.g., 28.5): ");
		day3TempStr = scanner.nextLine(); // getting user input and storing it

		// Convert day1TempStr to day3TempStr into primitive double values. 
		// Store them in double variables (e.g., day1TempPrimitive, day2TempPrimitive)

		double day1TempPrimitive, day2TempPrimitive, day3TempPrimitive;

		try {
    		day1TempPrimitive = Double.parseDouble(day1TempStr);
	    	/*
			Creating a double primitive called day1TempPrimitive
			Giving it the primitive double value of the parsed String day1TempStr
			*/
			// System.out.println(day1TempWrapper); // debug
		} catch (NumberFormatException e) {
    		System.err.println("Error: Invalid input for Day 1 temperature. Default temperature will be used.");
    		// Setting a default value
    		day1TempPrimitive = 20.0;
		}

		try {
    		day2TempPrimitive = Double.parseDouble(day2TempStr);
		} catch (NumberFormatException e) {
    		System.err.println("Error: Invalid input for Day 2 temperature. Default temperature will be used.");
    		// Setting a default value
    		day2TempPrimitive = 20.0;
		}

		try {
    		day3TempPrimitive = Double.parseDouble(day3TempStr);
		} catch (NumberFormatException e) {
    		System.err.println("Error: Invalid input for Day 3 temperature. Default temperature will be used.");
    		// Setting a default value
    		day3TempPrimitive = 20.0;
		}

		// Wrapper Object creation
		Double day1TempWrapper, day2TempWrapper, day3TempWrapper;

		day1TempWrapper = Double.valueOf(day1TempPrimitive);
		day2TempWrapper = Double.valueOf(day2TempPrimitive);
		day3TempWrapper = Double.valueOf(day3TempPrimitive);







	} 

}


/*
Enter Day 1 High Temperature (e.g., 28.5): 25.7
Enter Day 2 High Temperature (e.g., 28.5): 28.0
Enter Day 3 High Temperature (e.g., 28.5): 25.7

--- Temperature Analysis ---

Parsed Day 1 Temp (primitive double): 25.7
Parsed Day 2 Temp (primitive double): 28.0

Day 1 (25.7°C) was cooler than Day 2 (28.0°C).

Extracted Day 1 Temp (primitive float from Double wrapper): 25.7
Extracted Day 2 Temp (primitive int from Double wrapper, truncated): 28

The highest temperature recorded was: 28.0°C
*/