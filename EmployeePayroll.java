//CS 1233 - Computer Programming 2
//Class 4-301 TTh 7:40A - 10:10A
//Machine Problem 1 - Employee Payroll
//Sarah Haw & Arabella Grace Mejorada 
   
import java.io.File; // input and output operations
import java.io.FileWriter; //write characters to a file
import java.io.IOException; // a checked exception that indicates an error occurred during input/output operations
import java.util.ArrayList; //provides a resizable array implementation of the list
import java.util.Scanner; // read input from the user or a file

public class EmployeePayroll {

	private static int numEmployee = 10; // number of employees
	private static double philHealthPercent = 0.02; 
	private static double pagIbig = 50.0;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// input for Employee Names
		ArrayList<String> employees = inputEmployee(scanner);
		
		// Creates file
		File file = new File("PayrollLog.txt");
		FileWriter writer;
		try {    
			writer = new FileWriter(file, true); // append mode
		} catch (IOException e) {
			System.out.println("ERROR" + e.getMessage());
			return;
		}

		// calculates and print the payroll for the given employee.
		employees.stream().forEach(employee -> {
			solution(employee, scanner, writer);
			
			});
				try {
					writer.close();
				}
				catch (IOException e) {
					System.out.println("ERROR" + e.getMessage());
				}

	}

	// input for name
	private static ArrayList<String> inputEmployee(Scanner scanner) {
		ArrayList<String> employees = new ArrayList<String>();
		for (int i = 1; i <= numEmployee; i++) {
			System.out.println();
			System.out.print("Employee " + i + ": ");
			String name = scanner.nextLine();
			employees.add(name);

			System.out.println(name + "'s Payroll: ");
			System.out.print("Enter gross pay: ");
			double grossPay = scanner.nextDouble();
			scanner.nextLine();

			employees.add(name + "," + grossPay);
		}
		return employees;
	}


	private static void solution(String employee, Scanner scanner, FileWriter writer) {

		// splits the user input to name and gross pay
		String[] empInfo = employee.split(",");
		if (empInfo.length < 2) {
			System.out.println(employee);
			return;
		}
		String name = empInfo[0];
		double grossPay = Double.parseDouble(empInfo[1]);

		// calculate deductions
		double withTax    = calculateWithTax(grossPay);
		double sssValue   = calculateSssValue(grossPay);
		double philHealth = calculatephilHealth(grossPay);
		double deductions = withTax + sssValue + philHealth + pagIbig;
		double netPay     = grossPay - deductions;

		//-------------------------------------------------------------------------
 
		// output payroll details
		System.out.println("Net Pay:         " + (netPay));
		System.out.println("Withholding tax: " + (withTax));
		System.out.println("PhilHealth:      " + (philHealth));
		System.out.println("Pag-ibig:        " + (pagIbig));
		System.out.println("SSS:             " + (sssValue));

		//file writer
		try {
			writer.write("\n" + name + "\n" + grossPay + "\n");
			writer.write("--------------------------------------------------\n");
			writer.write("Gross basic pay: " + (grossPay)  + "\n");
			writer.write("Net Pay:         " + (netPay)         + "\n");
			writer.write("Withholding tax: " + (withTax) + "\n");
			writer.write("PhilHealth:      " + (philHealth)     + "\n");
			writer.write("Pag-ibig:        " + (pagIbig)        + "\n");
			writer.write("SSS:             " + (sssValue)            + "\n");
			writer.write("--------------------------------------------------\n");
		}
		catch (IOException e) {
			System.out.println("ERROR" + e.getMessage());
		}
	}


	//Calculate SSS Contribution
	public static double calculateSssValue(double grossPay) {

		double sssValue = 0.0;;
   
			for (int i = 1; i <= numEmployee; i++){
	 
				if      (grossPay >= 0.00     && grossPay <= 4249.99)  {sssValue  = 90.00;}
				else if (grossPay >= 4250.00  && grossPay  <= 4749.99) {sssValue  = 101.25;}
				else if (grossPay >= 4850.00  && grossPay <= 5249.99)  {sssValue  = 112.50;}
				else if (grossPay >= 5250.00  && grossPay <= 5749.99)  {sssValue  = 123.75;}
				else if (grossPay >= 5750.00  && grossPay <= 6249.99)  {sssValue  = 135.00;}
				else if (grossPay >= 6250.00  && grossPay <= 6749.99)  {sssValue  = 146.25;}
				else if (grossPay >= 6750.00  && grossPay <= 7249.99)  {sssValue  = 157.50;}
				else if (grossPay >= 7250.00  && grossPay <= 7749.99)  {sssValue  = 168.75;}
				else if (grossPay >= 7750.00  && grossPay <= 8249.99)  {sssValue  = 180.00;}
				else if (grossPay >= 8250.00  && grossPay <= 8749.99)  {sssValue  = 191.25;}
				else if (grossPay >= 8750.00  && grossPay <= 9249.99)  {sssValue  = 202.50;}
				else if (grossPay >= 9250.00  && grossPay <= 9749.99)  {sssValue  = 213.75;}
				else if (grossPay >= 9750.00  && grossPay <= 10249.99) {sssValue  = 225.00;}
				else if (grossPay >= 10250.00 && grossPay <= 10749.99) {sssValue  = 236.25;}
				else if (grossPay >= 10750.00 && grossPay <= 11249.99) {sssValue  = 247.50;}
				else if (grossPay >= 11250.00 && grossPay <= 11749.99) {sssValue  = 258.75;}
				else if (grossPay >= 11750.00 && grossPay <= 12249.99) {sssValue  = 270.00;}
				else if (grossPay >= 12250.00 && grossPay <= 12749.99) {sssValue  = 281.25;}
				else if (grossPay >= 12750.00 && grossPay <= 13249.99) {sssValue  = 292.50;}
				else if (grossPay >= 13250.00 && grossPay <= 13749.99) {sssValue  = 303.75;}
				else if (grossPay >= 13750.00 && grossPay <= 14249.99) {sssValue  = 315.00;}
				else if (grossPay >= 14250.00 && grossPay <= 14749.99) {sssValue  = 326.25;}
				else if (grossPay >= 14750.00 && grossPay <= 15249.99) {sssValue  = 337.50;}
				else if (grossPay >= 15250.00 && grossPay <= 15749.99) {sssValue  = 348.75;}
				else if (grossPay >= 15750.00 && grossPay <= 16249.99) {sssValue  = 360.00;}
				else if (grossPay >= 16250.00 && grossPay <= 16749.99) {sssValue  = 371.25;}
				else if (grossPay >= 16750.00 && grossPay <= 17249.99) {sssValue  = 382.50;}
				else if (grossPay >= 17250.00 && grossPay <= 17749.99) {sssValue  = 393.75;}
				else if (grossPay >= 17750.00 && grossPay <= 18249.99) {sssValue  = 405.00;}
				else if (grossPay >= 18250.00 && grossPay <= 18749.99) {sssValue  = 438.75;}
				else if (grossPay >= 18750.00 && grossPay <= 19249.99) {sssValue  = 438.75;}
				else if (grossPay >= 19250.00 && grossPay <= 19749.99) {sssValue  = 438.75;}
				else                                                   {sssValue  = 450.00;}
	
			}
			return sssValue;

		}

	//Calculate Withholding Tax
	private static double calculateWithTax(double grossPay) {
		double withTax = 0.0;
	
		if      (grossPay >= 0     && grossPay <= 10417)  {withTax =(0.0);}
		else if (grossPay >= 10418 && grossPay <= 16666)  {withTax = ((grossPay-10417)*0.15); }
		else if (grossPay >= 16667 && grossPay <= 33332)  {withTax = (937+((grossPay-16667)*0.2)); }
		else if (grossPay >= 33333 && grossPay <= 83332)  {withTax = (4270.70+((grossPay-33333)*0.25)); }
		else if (grossPay >= 83333 && grossPay <= 333332) {withTax = (16770.70+((grossPay-83333)*0.3)); }
		else                                              {withTax = (91770.70+((grossPay-333333)*0.35)); }
	 

	    return withTax;
	}
  
	// calculate phil health contribution
	private static double calculatephilHealth(double grossPay) {
		return grossPay * philHealthPercent;
	}
}

