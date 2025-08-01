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
    		System.err.println("Error: Invalid input for Day 1 temperature. Default temperature will be used.\n");
    		// Setting a default value
    		day1TempPrimitive = 20.0;
		}

		try {
    		day2TempPrimitive = Double.parseDouble(day2TempStr);
		} catch (NumberFormatException e) {
    		System.err.println("Error: Invalid input for Day 2 temperature. Default temperature will be used.\n");
    		// Setting a default value
    		day2TempPrimitive = 20.0;
		}

		try {
    		day3TempPrimitive = Double.parseDouble(day3TempStr);
		} catch (NumberFormatException e) {
    		System.err.println("Error: Invalid input for Day 3 temperature. Default temperature will be used.\n");
    		// Setting a default value
    		day3TempPrimitive = 20.0;
		}

		// Wrapper Object creation
		Double day1TempWrapper, day2TempWrapper, day3TempWrapper;

		day1TempWrapper = Double.valueOf(day1TempPrimitive);
		day2TempWrapper = Double.valueOf(day2TempPrimitive);
		day3TempWrapper = Double.valueOf(day3TempPrimitive);


		System.out.println("--- Temperature Analysis ---\n");
		System.out.println("Parsed Day 1 Temp (primitive double): " + day1TempPrimitive);
		System.out.println("Parsed Day 2 Temp (primitive double): " + day2TempPrimitive+"\n");

		if (day1TempWrapper.compareTo(day2TempWrapper) == 0) // error if not enclosed in ()
		{
			System.out.println("Day 1 (" + day1TempPrimitive + "°C) was the same temperature as Day 2 (" + day2TempPrimitive + "°C).\n");
		} else if (day1TempWrapper.compareTo(day2TempWrapper) < 0){
			System.out.println("Day 1 (" + day1TempPrimitive + "°C) was cooler than Day 2 (" + day2TempPrimitive + "°C).\n");
		} else {
			System.out.println("Day 1 (" + day1TempPrimitive + "°C) was warmer than Day 2 (" + day2TempPrimitive + "°C).\n");
		}
		/*
		compareTo() returns a negative integer if the calling object (day1TempWrapper) is less than the argument (day2TempWrapper).
		compareTo() returns zero if the calling object is equal to the argument.
		compareTo() returns a positive integer if the calling object is greater than the argument.
		*/

		float day1Float = day1TempWrapper.floatValue();
		int day2Int = day2TempWrapper.intValue();

		System.out.println("Extracted Day 1 Temp (primitive float from Double wrapper): " + day1Float);
		System.out.println("Extracted Day 2 Temp (primitive int from Double wrapper, truncated): " + day2Int + "\n");

		double maxTemp = Double.max(Double.max(day1TempWrapper.doubleValue(), day2TempWrapper.doubleValue()), day3TempWrapper.doubleValue());
		/*
		After some research, it turns out the specialized static method .max can only take 2 parameters
		However, I can embed the output of a max method as a parameter into a max method
		min and max are static method so it returns a double value, not a static method or reference
		Since I am nesting method calls, the most inner nest gets evaluated first. Kind of how recurssion works
		*/
		System.out.println("The highest temperature recorded was: " + maxTemp + "°C");

	} 

}