
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
		
		//Start the program with an introduction
		System.out.println("--- Welcome to the Quarterly Report ---\n");
		startProgram(electricalSales, kitchenSales);
		//qSales(electricalSales, "Electrical");
		//newTargets(electricalSales, "Electrical");
		//qTax(electricalSales, "Electrical");
		
	}
	
	private static void startProgram(double[] electricalSales, double[] kitchenSales) {
		Scanner keyboard = new Scanner(System.in);
		boolean exit = false;
		
			System.out.println("Please select an option:");
			System.out.println("1. Enter Sales Data");
			System.out.println("2. Run a Report:");
			System.out.println("3. Exit:");
			
			int choice = keyboard.nextInt();
			
			switch (choice) {
			case 1:
				getDepartment(electricalSales, kitchenSales);
				break;
			case 2:
				//reports go here
				break;
			default:
				System.out.println("Invalid choice. Please choose an option from the list");
			
		}
		
	}
	//ADD a new method. What do you want to do? 'Enter Sales?' OR 'Run a Report?'
	
	//defining a method to find the department so we can enter data
	private static void getDepartment(double[] electricalSales, double[] kitchenSales) {
		Scanner keyboard = new Scanner(System.in);
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
		keyboard.close();
	}
		
	private static void enterSales(Scanner keyboard, double[] salesData, String department) {
		System.out.println("---" + department +" department---");
		
		for (int month = 0; month < months; month++) {
			System.out.print("Enter sales for month " +(month+1)+":" );
			salesData[month] = keyboard.nextDouble();
		}

		}
	//This might be redundant
	private static void displaySales(String department, double[] salesData) {
		System.out.println("---" + department + " Sales---");
		for (int month = 0; month < months; month++) {
			System.out.println("Sales for month " +(month+1)+": " +salesData[month]);
		}
	}
	
	private static void qSales(double[] salesData, String Department) {
		double quarterlySales;
		int quarter = 0;
		for (int month = 0; month < months; month +=3) {
			quarterlySales = salesData[month] + salesData[month +1] + salesData[month+2];
			System.out.println("Sales for Q"+(quarter+=1)+ ": " +quarterlySales);
		}
		
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


		
