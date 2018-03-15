import java.util.*;

public class lab9 {
	
	public static void main (String args []) { 
		Scanner scnr = new Scanner(System.in);
		String error = "ERROR: Please input yes or no.";
		
		double userInitialBudget = 0;
		double priceSum = 0;
		double itemPrice = 0;
		
		int count = 0;
		String sPromptUser = "";
		String Msg = "";
		
		do {
		System.out.println("What is your Initial budget?");
		String sUserBudget = scnr.next();
		userInitialBudget = initialBudget (sUserBudget);
		}
		while (userInitialBudget == 0);

		do {
		System.out.println("Please pick a menu choice below:"
		+ "\n 1. Check if you should buy something"
		+ "\n 2. Exit");
		
		sPromptUser = scnr.next();
	
		switch(sPromptUser) {
			case "1": 
				do {
					System.out.println("\nWhat is the price of the item?");
					String sItemPrice = scnr.next();
					priceSum = totalExpense(sItemPrice);
				}	
				while (priceSum == 0);
				
				String yesNoPrice = canAfford(userInitialBudget, priceSum);
				sPromptUser = Questions(yesNoPrice);
				System.out.println(Msg);
				
			case "again":
			break;
			
			case "2":
				System.out.println("Your total expense amount is: " + priceSum); //followed by the sum of the items purchased. 
				System.out.println("Your remaining balance is: " + balance(userInitialBudget, priceSum)); //followed by the difference between the budget and the expenses. 
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
		
		while ( (!sPromptUser.equals("1")) && (!sPromptUser.equals("2")) && (count < 3) && (sPromptUser.equals("again")) );
	}
	
	public static double initialBudget (String sUserBudget) {
		int i;
		double userBudget = 0;

		for (i = 0; i < sUserBudget.length(); i++) {
			boolean numTrue = Character.isDigit(sUserBudget.charAt(i));
			
			if (numTrue == false) {
				System.out.println("Invalid input. Please enter a valid number.");
				return userBudget = 0;
			}
		}
		return userBudget = Double.valueOf(sUserBudget);
	}
	
	public static String canAfford (double budget, double itemPrice) {
		String yesNoPrice;
		
		if (budget > itemPrice)
			yesNoPrice = "yes";
		
		else if (budget < itemPrice)
			yesNoPrice = "no";
		
		else 
			yesNoPrice = "";
		System.out.println("Can you comfortably afford it?\n" + yesNoPrice);
		return yesNoPrice;
	}
	
	public static double totalExpense(String sItemPrice) {
		int i;
		double itemPrice = 0;
		double priceSum = 0;
		
		for (i = 0; i < sItemPrice.length(); i++) {
			boolean numTrue = Character.isDigit(sItemPrice.charAt(i));
			
			if (numTrue == false) {
				System.out.println("Invalid input. Please enter a valid number.");
				return itemPrice = 0;
			}
		}
		itemPrice = Double.valueOf(sItemPrice);
		return priceSum += itemPrice;
	
	}
	
	public static double balance(double budget, double expense) {
		double remainBal = budget - expense;
		return remainBal;
	}
	
	public static String Questions (String yesNo) { //FINISH NO BRANCH IN SWITCH + INPUT VALIDATION FOR ERROR
		Scanner scnr = new Scanner(System.in);
		int choice;
		String tell = "";
		
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
		String finMsg [] = {"\nDON'T BUY IT", "\nASK TO BORROW IT", "\nGO HOME AND SAVE UP", 
		"\nCOMPARISON SHOP BEFORE BUYING", "\nPUT IT ON LAYAWAY", "\nBUY IT ALREADY"};
		
		
		switch(yesNo.toLowerCase()) {
			
			case "yes":
				//"Do you have an immediate use for it?";
				//YES: "Do you have cash to buy it instead of using a credit card?"
					//YES: "Do you own something that serves the same purpose?"
						//YES: "You don't truly need this item." + "DONT BUY IT" 
							/*END*/
						//NO: "Could your money be better spent on meeting a need?"
							//YES: "GO HOME AND SAVE UP"
								/*END*/
							//NO: "Have you looked for sales, coupons, or generic versions?"
								//YES: "After all this, do you still want to buy it?" + "BUY IT ALREADY"
									/*END*/
								//NO: "COMPARISON SHOPPING"
									/*END*/
					//NO: ""Can you borrow it from a friend?"
				
				//NO: ""You don't truly need this item." + "DONT BUY IT" 
					/*END*/
				System.out.println(q1);
				yesNo = scnr.next();
				
				tell = yesNo.equalsIgnoreCase("yes")? q3: 
				(yesNo.equalsIgnoreCase("no")? q9 + finMsg[0]: error);
				if (tell.equals(q3)) {
					System.out.println(q3);
					yesNo = scnr.next();
					tell = yesNo.equalsIgnoreCase("yes")? q5: 
					(yesNo.equalsIgnoreCase("no")? q2: error);
				}
				
				if (tell.equals(q5)) {
					System.out.println(q5);
					yesNo = scnr.next();
					tell = yesNo.equalsIgnoreCase("yes")? q9 + finMsg[0]: 
					(yesNo.equalsIgnoreCase("no")? q6: error);
				}
				
				if (tell.equals(q2)) {
					System.out.println(q2);
					yesNo = scnr.next();
					tell = yesNo.equalsIgnoreCase("yes")? finMsg[1]: 
					(yesNo.equalsIgnoreCase("no")? q4: error);
				}
				
				if (tell.equals(q6)) {
					System.out.println(q6);
					yesNo = scnr.next();
					tell = yesNo.equalsIgnoreCase("yes")? finMsg[2]: 
					(yesNo.equalsIgnoreCase("no")? q7: error);
				}
				
				if (tell.equals(q7)) {
					System.out.println(q7);
					yesNo = scnr.next();
					tell = yesNo.equalsIgnoreCase("yes")? q8: 
					(yesNo.equalsIgnoreCase("no")? finMsg[3]: error);
				}
				
				if (tell.equals(q4)) {
					System.out.println(q4);
					yesNo = scnr.next();
					tell = yesNo.equalsIgnoreCase("yes")? finMsg[4]: 
					(yesNo.equalsIgnoreCase("no")? finMsg[2]: error);
				}
				
				if (tell.equals(q8)) {
					System.out.println(q8);
					yesNo = scnr.next();
					tell = yesNo.equalsIgnoreCase("yes")? finMsg[5]: 
					(yesNo.equalsIgnoreCase("no")? finMsg[0]: error);
				}
				
				System.out.println(tell);
				break;
			
			case "no":
				System.out.println(q1);
				yesNo = scnr.next();
				break;
				
			default:
				System.out.println(error);
				tell = error;
				break;
		}
		if (tell.equals(finMsg[5]))
			return "again";
		return tell;
	}
}