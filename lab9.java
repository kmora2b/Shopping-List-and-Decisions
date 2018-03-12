import java.util.*;

public class lab9 {
	
	public static void main (String args []) {
		
		float UB = 0;
		
		initialBudget(UB);
		
		do {
		menuChoice();
		}
		
		while (false);
	}
	
	public static double initialBudget (double userBudget) {
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("What is your Initial budget?");
		userBudget = scnr.nextDouble();
		
		return userBudget;
		
	}
	
	public static boolean menuChoice () {
		
		Scanner scnr = new Scanner(System.in);
		int count = 0;
		int promptUser;
		
		boolean again = true;
		boolean end = false;
		
		do {
		System.out.println("Please pick a menu choice below:"
		+ "\n 1. Check if you should buy something"
		+ "\n 2. Exit");
		
		promptUser = scnr.nextInt();
		
	
		switch(promptUser) {
			case 1: 
				System.out.println("\nWhat is the price of the item?");
				double itemPrice = scnr.nextDouble();
				
				System.out.println("\nCan you comfortably afford it?");
				String yn = scnr.next();
				
				if (yn.equalsIgnoreCase("yes")) {
					System.out.println("Do you have an immediate use for it?");
					yn = scnr.next();
					
					if (yn.equalsIgnoreCase("yes")) {
						System.out.println("Do you have cash to buy it instead of using a credit card?");
					}
					
					if (yn.equalsIgnoreCase("no")) {
						System.out.println("You don't truly need this item");
						System.out.println("DON'T BUY IT\n");
						//return again;
					}
					
				}
				
				else if ( yn.equalsIgnoreCase("no") ) {
					System.out.println("Can you borrow it from a friend?");
				}
				break;
			
			//FIXME
			case 2:
				System.out.printf("\nYour total expense amount is: "); //followed by the sum of the items purchased. 
				System.out.printf("\nYour remaining balance is: "); //followed by the difference between the budget and the expenses. 
				return end;
			
				
			default:
				System.out.println("\nIncorrect choice. Please input 1 or 2.");
				count++;
				
				if (count == 3) { 
					System.out.println("The program has ended due to 3 wrong inputs.");
					return end;
				}
				
			}
		}
		
		
		while ( (promptUser != 1) && (promptUser != 2) && (count < 3) );
	
		return end;
		
	}
	
	public static double totalExpense(float itemPrice) {
		
		double priceSum = 0;
		priceSum += itemPrice;
		
		return priceSum;
	}
	
	public static double balance(double budget, double expense) {
		
		double remainBal = budget - expense;
		return remainBal;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}