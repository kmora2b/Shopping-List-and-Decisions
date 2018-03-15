import java.util.*;

public class lab9 {
	
	public static void main (String args []) {
		
		Scanner scnr = new Scanner(System.in);
		double UB = 0;
		//double userBudget = 0;
		String yN = "";
		String error = "ERROR: Please input yes or no.";
		
		while (initialBudget(UB) == 0) 
			initialBudget(UB);
		
		//System.out.println(initialBudget(UB)); ECHO PRINT

		yN = menuChoice();
		
		Questions (yN);
		
	}
	
	public static double initialBudget (double userBudget) {
		int i;
		Scanner scnr = new Scanner(System.in);
		String sUserBudget = "";
		
		System.out.println("What is your Initial budget?");
		sUserBudget = scnr.next();
		
		for (i = 0; i < sUserBudget.length(); i++) {
			boolean numTrue = Character.isDigit(sUserBudget.charAt(i));
			
			if (numTrue == false) {
				System.out.println("Invalid input. Please enter a valid number.");
				return userBudget = 0;
			}
			
		}
		return userBudget = Double.valueOf(sUserBudget);
	}
	
	public static String menuChoice () {
		Scanner scnr = new Scanner(System.in);
		int count = 0;
		int promptUser;
		String yesNo = "";
		String sPromptUser = "";
		
		double a = 0;
		double itemPrice = 0;
		double TE = totalExpense(itemPrice);
		double B = balance(initialBudget(a), TE);
		
		do {
		System.out.println("Please pick a menu choice below:"
		+ "\n 1. Check if you should buy something"
		+ "\n 2. Exit");
		
		sPromptUser = scnr.next();
		//promptUser = Integer.valueOf(sPromptUser);
	
		switch(sPromptUser) {
			case "1": 
				System.out.println("\nWhat is the price of the item?");
				itemPrice = scnr.nextDouble();
				//System.out.println(totalExpense(itemPrice)); ECHO PRINT
				
				System.out.println("\nCan you comfortably afford it?");
				yesNo = scnr.next();
				return yesNo;
			
			//FIXME
			case "2":
				System.out.println("Your total expense amount is: " + TE); //followed by the sum of the items purchased. 
				System.out.println("Your remaining balance is: " + B); //followed by the difference between the budget and the expenses. 
				break;
			
				
			default:
				System.out.println("\nIncorrect choice. Please input 1 or 2.");
				count++;
				
				if (count == 3) { 
					System.out.println("The program has ended due to 3 wrong inputs.");
					break;
				}
				
			}
		}
		
		while ( (!sPromptUser.equals("1")) && (!sPromptUser.equals("2")) && (count < 3) );
	
		return yesNo;
		
	}
	
	public static double totalExpense(double itemPrice) {
		//String sItemPrice = String.valueOf(itemPrice);
		double priceSum = 0;
		priceSum += itemPrice;
		return priceSum;

	}
	
	public static double balance(double budget, double expense) {
		
		double remainBal = budget - expense;
		return remainBal;
		
	}
	
	public static void Questions (String yesNo) {
		Scanner scnr = new Scanner(System.in);
		int choice;
		String tell = "";
		String invalid = "invalid";
		
		String q1 = "Do you have an immediate use for it?";
		String q2 = "Can you borrow it from a friend?";
		String q3 = "Do you have cash to buy it instead of using a credit card?";
		String q4 = "Can you put it on layaway?";
		String q5 = "Do you own something that serves the same purpose?";
		String q6 = "Could your money be better spent on meeting a need?";
		String q7 = "Have you looked for sales, coupons, or generic versions?";
		String q8 = "After all this, do you still want to buy it?";
		String q9 = "You don't truly need this item.";
		
		String error = "ERROR: Please input yes or no.";
		
		do {
		switch(yesNo.toLowerCase()) {
			
			case "yes":
				System.out.println(q1);
				yesNo = scnr.next();
				
				tell = yesNo.equalsIgnoreCase("yes")? q3: 
				(yesNo.equalsIgnoreCase("no")? q9 + "\nDON'T BUY IT": error);
				if (tell.equals(q3)) {
					System.out.println(q3);
					yesNo = scnr.next();
				}
				
				tell = yesNo.equalsIgnoreCase("yes")? q5: 
				(yesNo.equalsIgnoreCase("no")? q2: error);
				if (tell.equals(q5)) {
					System.out.println(q5);
					yesNo = scnr.next();
					tell = yesNo.equalsIgnoreCase("yes")? q9 + "\nDON'T BUY IT": 
					(yesNo.equalsIgnoreCase("no")? q6: error);
				}
				
				else if (tell.equals(q2)) {
					System.out.println(q2);
					yesNo = scnr.next();
					tell = yesNo.equalsIgnoreCase("yes")? "\nASK TO BORROW IT": 
					(yesNo.equalsIgnoreCase("no")? q4: error);
				}
				
				
				
				if (tell.equals(q6)) {
					System.out.println(q6);
					yesNo = scnr.next();
					tell = yesNo.equalsIgnoreCase("yes")? "\nGO HOME AND SAVE UP": 
					(yesNo.equalsIgnoreCase("no")? q7: error);
								
						if (tell.equals(q7)) {
							System.out.println(q7);
							yesNo = scnr.next();
							tell = yesNo.equalsIgnoreCase("yes")? q8: 
							(yesNo.equalsIgnoreCase("no")? "\nCOMPARISON SHOP BEFORE BUYING": error);
						}
				}
				
				else if (tell.equals(q4)) {
							System.out.println(q4);
							yesNo = scnr.next();
							tell = yesNo.equalsIgnoreCase("yes")? "\nPUT IT ON LAYAWAY": 
							(yesNo.equalsIgnoreCase("no")? "\nGO HOME AND SAVE UP": error);
				}
				
				
				
				if (tell.equals(q8)) {
					System.out.println(q8);
					yesNo = scnr.next();
					tell = yesNo.equalsIgnoreCase("yes")? "\nBUY IT ALREADY": 
					(yesNo.equalsIgnoreCase("no")? "\nDON'T BUY IT": error);
				}
				
				System.out.println(tell);
				break;
			
			case "no":
				System.out.println(q1);
				yesNo = scnr.next();
				break;
				
				//return yesNo;
				
			default:
				//return invalid;
				System.out.println(error);
				tell = error;
				break;
		}
		}
		while ( (yesNo.equals("yes")) && (yesNo.equals("no")) );
		//return tell;
		
		//String a = yesNo.equalsIgnoreCase("yes")? "Do you have an immediate use four it?": "Can you borrow it from a friend?";
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}