
//import the java utilities library. *imports everything as I might need more than Scanner. 
import java.util.*;
public class Quarterly_Report {
	
	// Create a constant for the months in a year. I use this later in the program to iterate through and input data. 
	static int months = 12;
	
	// line of code needed in all Java programs 
	public static void main(String[] args) {
		
		//This is a 1D array to store the info for each department. I guess a 2D array would be better.
		double[] electricalSales = new double[months];
		double[] kitchenSales = new double[months];
		double[] bathroomSales = new double[months];
		double[] softFurnishingSales = new double[months];
		double[] accessoriesSales = new double[months];
		
		// Initialising a new object of the scanner class. I will use the keyboard object to accept keyboard input from the user. 
		Scanner keyboard = new Scanner(System.in);
		
		// Printing a line to the terminal to welcome users to the program.
		System.out.println("--- Welcome to the Quarterly Report ---\n");

		//Here I call the startProgram method along with 6 arguements; The departments and also the keyboard input. 
		startProgram(electricalSales, kitchenSales, bathroomSales, softFurnishingSales, accessoriesSales, keyboard);
				
	}
	
	//This method creates an 'interface' for the user to interact with. There are options to enter new sales data, view reports or exit the program. 
	private static void startProgram(double[] electricalSales, double[] kitchenSales, double[] bathroomSales, double[] softFurnishingSales, double[] accessoriesSales, Scanner keyboard) {
		boolean exit = false;
		int choice;
		
		// Here I added a do/while clause to repeat this interface until the user wants to exit the program. I had to include this so users could 'loop' through the system and input data for multiple departments. 
		do {
			System.out.println("Please select an option:");
			System.out.println("1. Enter Sales Data");
			System.out.println("2. REPORT: Total Sales");
			System.out.println("3. REPORT: New Sales Targets");
			System.out.println("4. REPORT: Calculate Tax");
			System.out.println("5. Exit");
			
			choice = keyboard.nextInt();
			
			// I chose to use a switch rather than if/else etc as I prefer the formatting and it's easier for me to understand. Here I setup the menu structure and call the relevant method.
			switch (choice) {
			case 1:
				getDepartment(electricalSales, kitchenSales, bathroomSales, softFurnishingSales, accessoriesSales, keyboard);
				break;
			case 2:
				// I added some basic text to signify the start and end of the report to make it clear to the user
				System.out.println("\n---SALES REPORT---\n");
				qSales(electricalSales, "Electrical");
				qSales(kitchenSales, "Kitchen");
				qSales(bathroomSales, "Bathroom");
				qSales(softFurnishingSales, "Soft Furnishing");
				qSales(accessoriesSales, "Accessories");
				System.out.println("\n---END OF REPORT---\n");
				break;
			case 3:
				System.out.println("\n---NEW SALES TARGETS---\n");
				newTargets(electricalSales, "Electrical");
				newTargets(kitchenSales, "Kitchen");
				newTargets(bathroomSales, "Bathroom");
				newTargets(softFurnishingSales, "Soft Furnishing");
				newTargets(accessoriesSales, "Accessories");
				System.out.println("\n---END OF REPORT---\n");
				break;
			case 4:
				System.out.println("\n---TAX REPORT---\n");
				qTax(electricalSales, "Electrical");
				qTax(kitchenSales, "Kitchen");
				qTax(bathroomSales, "Bathroom");
				qTax(softFurnishingSales, "Soft Furnishing");
				qTax(accessoriesSales, "Accessories");
				System.out.println("\n---END OF REPORT---\n");
				break;
			case 5:
				exit = true;
				break;
			default:
				// Here I added some validation if the user tries to input an invalid option
				System.out.println("Invalid choice. Please choose an option from the list");
			
		}
		
	} while (!exit);
		
	}
	
	//This method creates an interface for the user to select which department they want to enter sales data. 
	private static void getDepartment(double[] electricalSales, double[] kitchenSales, double[] bathroomSales, double[] softFurnishingSales, double[] accessoriesSales, Scanner keyboard) {
		
		System.out.println("Select your department from the list:");
		System.out.println("1. Electrical");
		System.out.println("2. Kitchen");
		System.out.println("3. Bathroom");
		System.out.println("4. Soft Furnishing");
		System.out.println("5. Accessories");
		
		int department = keyboard.nextInt();
		
		switch(department) {
		case 1:
			enterSales(keyboard, electricalSales, "Electrical");
			break;
		case 2:
			enterSales(keyboard, kitchenSales, "Kitchen");
			break;
		case 3:
			enterSales(keyboard, bathroomSales, "Bathroom");
			break;
		case 4:
			enterSales(keyboard, softFurnishingSales, "Soft Furnishing");
			break;
		case 5:
			enterSales(keyboard, accessoriesSales, "Accessories");
			break;
		default:
			System.out.println("Please choose an option from the list\n");
				
		}
		
	}
	
	// This method prompts the user to enter sales data for the referenced department. 
	private static void enterSales(Scanner keyboard, double[] salesData, String department) {
		System.out.println("---" + department +" department---");
		
		//Here I added a for loop to iterate over each month and prompt the user for input. In this case 'Sales for each month'.
		for (int month = 0; month < months; month++) {
			System.out.print("Enter sales for month " +(month+1)+":" );
			salesData[month] = keyboard.nextDouble();
			
		}
		// Added a small confirmation message to let them know the 'upload' was successful
		System.out.println("\nThank you for submitting your data.\n");

		}
	
	// This method takes two parameters and displays the sales data for the called department per quarter. 
	private static void qSales(double[] salesData, String Department) {
		double quarterlySales;
		int quarter = 0;
		
		// I had to iterate through each month and for every 3 sum the total. i think this could have been 'smoother', but I found a way that worked.
		for (int month = 0; month < months; month +=3) {
			quarterlySales = salesData[month] + salesData[month +1] + salesData[month+2];
			
			// I also added some string formatting here to cap the number with 2 decimal places.
			System.out.println(Department + " Sales for Q"+(quarter+=1)+ ": £" + String.format("%.2f", quarterlySales));
		}
		//I just added this for formatting
		System.out.println();		
	}
	
	// This method calculates new sales targets for each department based on the previous quarter sales. 
	private static void newTargets(double[] salesData, String Department) {
		
		//This takes the last 3 month sales and adds them together under a new variable lastQSales. Following this, I just find the average and multiply to give a new sales target of 12%
		double lastQSales = salesData[months - 3] + salesData[months -2] + salesData[months -1];
		double lastQAverage = lastQSales /3;
		double newerTargets = lastQAverage * 1.12;
		
		//Again, same formatting as previous methods for consistency
		System.out.println("New Targets for " +Department +": £" + String.format("%.2f", newerTargets));
		
	}
	
	// This method is similar to the prior. It pulls the sales data for each department and calulates the tax paid at 17%
	private static void qTax(double[] salesData, String Department) {
		double quarterlyTax;
		int quarter = 0;
		
		for (int month = 0; month < months; month +=3) {
			quarterlyTax = (salesData[month] + salesData[month +1] + salesData[month+2])/100 * 17;
			System.out.println(Department+ " Tax for Q"+(quarter+=1)+ ": £" +quarterlyTax);
		}
		
		System.out.println();		
	}
	
	
}


		
