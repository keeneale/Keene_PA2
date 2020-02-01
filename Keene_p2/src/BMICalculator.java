import java.util.Scanner;

public class BMICalculator {
	private double userHeight;
	private double userWeight;
	private double userBmi;
	private int userUnitType;
	private String userBmiCategory;
	
	Scanner input = new Scanner(System.in);
	
	// Calls functions to receive which units to measure and users's weight/height
	public void readUserData() 
	{
		int type = readUnitType();
		readMeasurementData(type);
	}
	
	// Prints menu to select unit type and receives input from user
	private int readUnitType() 
	{
		int userSelection = 0;
		
		do {
			System.out.println("Select an option for measurement type");
			System.out.println("1 - Metric (Meters/Kilograms)");
			System.out.println("2 - Imperial (Inches/Pounds)");

			Scanner input = new Scanner(System.in);
			userSelection = input.nextInt();
		} while (userSelection < 1 || userSelection > 2);
		
		if (userSelection == 1)
		{
			return 1;
		}
		// userSelection == 2
		else
		{
			return 2;
		}
	}
	
	// Calls either readMetricData or readImperialData, depending on the unit type
	private void readMeasurementData(int unitType)
	{
		// Metric Selection
		if (unitType == 1) 
		{
			userUnitType = unitType;
			readMetricData();
		}
		// Imperial Selection
		else if (unitType == 2)
		{
			userUnitType = unitType;
			readImperialData();
		}
	}

	// Prompts user to enter height/weight (Metric) and receives data
	private void readMetricData()
	{
		System.out.println("Please enter your height in meters:");
	    double height = input.nextDouble();
	    if (height < 0)
	    	System.exit(0);
	    setHeight(height);
	    
	    System.out.println("Please enter your weight in kilograms:");
	    double weight = input.nextDouble();
	    if (weight < 0)
	    	System.exit(0);
	    setWeight(weight);
	}
	
	// Prompts user to enter height/weight (Imperial) and receives data
	private void readImperialData()
	{
		System.out.println("Please enter your height in inches:");
	    double height = input.nextDouble();
	    if (height < 0)
	    	System.exit(0);
	    setHeight(height);
	    
	    System.out.println("Please enter your weight in pounds:");
	    double weight = input.nextDouble();
	    if (weight < 0)
	    	System.exit(0);
	    setWeight(weight);
	}
	
	// Performs BMI calculation in either Metric or Imperial and calls BMI Category
	public void calculateBmi()
	{
		double height = getHeight();
		double weight = getWeight();

		// Metric BMI calculation
		if (userUnitType == 1)
		{
			userBmi = (1.0 * weight) / (height * height);
		}
		// Imperial BMI calculation
		else if (userUnitType == 2)
		{
			userBmi = (1.0 * 703 * weight) / (height * height);
		}
		userBmiCategory = calculateBmiCategory();
	}
	
	// Uses calculated BMI to determine what category user falls in
	private String calculateBmiCategory()
	{
		if (userBmi < 18.5)
		{
			// Underweight = <18.5
			userBmiCategory = "Underweight";
		}
		else if (userBmi < 24.9)
		{
			// Normal Weight = 18.5 - 24.9
			userBmiCategory = "Normal Weight";
		}
		else if (userBmi < 29.9)
		{
			// Overweight = 25 - 29.9
			userBmiCategory = "Overweight";
		}
		else
		{
			// Obese = >30
			userBmiCategory = "Obese";
		}
		return userBmiCategory;
	}
	
	// Prints user's BMI and category to the screen along with NHLBI Category chart
	public void displayBmi()
	{
		System.out.printf("%nYour BMI is %.1f which is classified as %s%n%n", getBmi(),getBmiCategory());
		System.out.println("National Heart Lung and Blood Institute BMI Categories:");
		System.out.println("Underweight = < 18.5");
		System.out.println("Normal weight = 18.5 - 24.9");
		System.out.println("Overweight = 25 - 29.9");
		System.out.println("Obese = 30 or greater");
	}
	
	// Returns user's weight
	public double getWeight()
	{
		return userWeight;
	}
	
	// Sets user's weight to instance variable
	private void setWeight(double weight)
	{
		userWeight = weight;
	}
	
	// Return's user's height
	public double getHeight()
	{
		return userHeight;
	}
	
	// Set's user's height to instance variable
	private void setHeight(double height)
	{
		userHeight = height;
	}
	
	// Return's user's BMI
	public double getBmi()
	{
		return userBmi;
	}
	
	// Return's user's BMI Category
	public String getBmiCategory()
	{
		return userBmiCategory;
	}
}