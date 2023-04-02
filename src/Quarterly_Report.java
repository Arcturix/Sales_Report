
import java.util.*;
public class Quarterly_Report {
	
	// Create a constant for the months in a year
	static int months = 6;
	
	// line of code needed in all Java programs 
	public static void main(String[] args) {
		
		//This is a 1D array to store the info for each department
		double[] electricalSales = new double[months];
		double[] kitchenSales = new double[months];
		double[] bathroomSales = new double[months];
		double[] softFurnishingSales = new double[months];
		double[] accessoriesSales = new double[months];
		
		Scanner keyboard = new Scanner(System.in);
				
		System.out.println("--- Welcome to the Quarterly Report ---\n");

		startProgram(electricalSales, kitchenSales, keyboard);
				
	}
	
	private static void startProgram(double[] electricalSales, double[] kitchenSales, Scanner keyboard) {
		boolean exit = false;
		int choice;
		
		do {
			System.out.println("Please select an option:");
			System.out.println("1. Enter Sales Data");
			System.out.println("2. Run a Report");
			System.out.println("3. Exit");
			
			choice = keyboard.nextInt();
			
			switch (choice) {
			case 1:
				getDepartment(electricalSales, kitchenSales, keyboard);
				break;
			case 2:
				qSales(electricalSales, "Electrical");
				qSales(kitchenSales, "Kitchen");
				break;
			case 3:
				exit = true;
				break;
			default:
				System.out.println("Invalid choice. Please choose an option from the list");
			
		}
		
	} while (!exit);
		
	}
	//ADD a new method. What do you want to do? 'Enter Sales?' OR 'Run a Report?'
	
	//defining a method to find the department so we can enter data
	private static void getDepartment(double[] electricalSales, double[] kitchenSales, Scanner keyboard) {
		
	//If possible, loop this with do - while department is between 1-3
		System.out.println("Select your department from the list:");
		System.out.println("1. Electrical");
		System.out.println("2. Kitchen");
		
		int department = keyboard.nextInt();
		
		switch(department) {
		case 1:
			enterSales(keyboard, electricalSales, "Electrical");
			break;
		case 2:
			enterSales(keyboard, kitchenSales, "Kitchen");
			break;
		default:
			System.out.println("Please choose an option from the list");
				
		}
		
		//call the display sales here or in the switch?
	}
		
	private static void enterSales(Scanner keyboard, double[] salesData, String department) {
		System.out.println("---" + department +" department---");
		
		for (int month = 0; month < months; month++) {
			System.out.print("Enter sales for month " +(month+1)+":" );
			salesData[month] = keyboard.nextDouble();
			
		}
		System.out.println("\nThank you for submitting your data.\n");

		}
	
	private static void qSales(double[] salesData, String Department) {
		double quarterlySales;
		int quarter = 0;
		for (int month = 0; month < months; month +=3) {
			quarterlySales = salesData[month] + salesData[month +1] + salesData[month+2];
			System.out.println(Department + "Sales for Q"+(quarter+=1)+ ": " +quarterlySales);
		}
		
		System.out.println("---END OF REPORT---\n");
		
	}
	
	private static void newTargets(double[] salesData, String Department) {
		double lastQSales = salesData[months - 3] + salesData[months -2] + salesData[months -1];
		double lastQAverage = lastQSales /3;
		
		double newerTargets = lastQAverage * 1.12;
		System.out.println("New Targets for " +Department +": " + newerTargets);
		
	}
	private static void qTax(double[] salesData, String Department) {
		double quarterlyTax;
		int quarter = 0;
		for (int month = 0; month < months; month +=3) {
			quarterlyTax = (salesData[month] + salesData[month +1] + salesData[month+2])/100 * 17;
			System.out.println("Tax for Q"+(quarter+=1)+ ": " +quarterlyTax);
		}
	}
	
	
}


		
