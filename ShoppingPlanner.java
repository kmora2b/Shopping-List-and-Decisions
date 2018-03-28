import java.util.*;

/* CS1101 – Intro to Computer Science Lab
Instructor: Dr. Ceberio
Comprehensive Lab 1
Modified and submitted by: KIMBERLY MORALES
*/

public class ShoppingPlanner {
	
	public static void main (String args []) { 
		Scanner scnr = new Scanner(System.in);
		
		//Declare 3 double varialbes: userBudget, priceSum, itemPrice; and intialize each one 0
		double userBudget = 0;
		double itemSum = 0;
		double itemPrice = 0;
		
		//Declare an integer called count and initialize to 0
		//Declare a string called sPromptUser and initialize to 0
		int count = 0;
		String sPromptUser = "";
		
		//At least once, display a question that asks the user their initial budget
		//Take the users budget input (userBudget) and check if it is a valid input in the method checkNum
		do {
		System.out.println("What is your Initial budget?");
		userBudget = checkNum();
		}
		while (userBudget == 0); //If userBudget is 0 then repeat
		
		/*At least once, display a menu with two choices.
		  1. Check if you should buy something
		  2. Exit                                         */
		do {
		System.out.println("Please pick a menu choice below:"
		+ "\n 1. Check if you should buy something"
		+ "\n 2. Exit");
		
		//Take the users input to choose from the menu and assign it to the string sPromptUser
		sPromptUser = scnr.next();
		
		/*Create a switch statement that takes the two menu options: 1 and 2.
		  Input sPromptUser into the switch statement and depending on the userInput, follow the case.*/
		switch(sPromptUser) {
			case "1":	
				//If user inputs 1 then do the following:
				/*At least once, display a question to the user asking for the price of the item they want to buy.
				Scan in the itemPrice from the user and assign it to the method checkNum() to see if it is valid. */
				do {
					System.out.println("\nWhat is the price of the item?");
					itemPrice = checkNum();
					itemSum = totalExpense(itemPrice, itemSum);
				}	
				while (itemSum == 0); //If priceSum is equal to 0 then repeat 
				
				//Take the string, yesNoPrice, and assign it to the canAfford method with two double parameters: userBudget and priceSum
				String yesNo = canAfford(userBudget, itemSum);
				sPromptUser = Questions(yesNo);	//Assign sPromptUser to the questions method that takes in the string parameter: yesNoPrice
				break; //End the switch statement
			
			case "2":	
				//If user inputs 2 then do the following
				/*Display the total expense amount that is taken from the varialbe priceSum then
				  Display the remaining balance that is taken from the balance method with two parameters: userBudget and priceSum 
				*/
				System.out.printf("\nYour total expense amount is: %.2f", itemSum); //followed by the sum of the items purchased. 
				System.out.printf("\nYour remaining balance is: %.2f", balance(userBudget, itemSum)); //followed by the difference between the budget and the expenses. 
				break; //End the switch statement
			
			default:	
			//Anything other than 1 0r 2 then do the following
				//Display an error message and tell the user to input 1 or 2 and try again
				System.out.println("\nIncorrect choice. Please input 1 or 2."); 
				count++;	//Add one to the count variable
				
				if (count == 3) {	//If count is equal to 3 then end the program
					System.out.println("The program has ended due to 3 wrong inputs.");
					break; //End the switch statement
				}
				continue; //Continue onto next iteration
			}
		}
		//As long as sPromptUser is NOT equal to 1 or 2 and count is less than 3 then repeat
		while ((!sPromptUser.equals("1")) && (!sPromptUser.equals("2")) && (count < 3));
	}
	
	public static String canAfford (double userBudget, double itemSum) {
		//Declare string called yesNoPrice
		String yesNo;
		
		//If the budget is greater than or equal to itemPrice then yesNoPrice is assigned the string "yes"
		if (userBudget >= itemSum)
			yesNo = "yes";
		
		//Otherwise, yesNoPrice is assigned to the string "no"
		else 
			yesNo = "no";
		
		System.out.println("Can you comfortably afford it?\n" + yesNo); //Display if the user can comfortably afford the item and show yesNoPrice
		return yesNo;	//Return yesNoPrice
	}
	
	public static double totalExpense(double itemPrice, double itemSum) {
		return itemSum += itemPrice; //ItemSumn is assigned to the sum of itemSum and itemPrice then return
	}
	
	public static double checkNum () {
		//Take in the string sUserInput and assign it to the user's input
		Scanner scnr = new Scanner(System.in);
		String sUserInput = scnr.next();
		
		//Declare integer i and initialize to 0 
		//For as long as i is less the length of sUserInput then do the following:
		/*Declare boolean numTrue and assign to true if the sUserInput at each chafracter is a digit.
		  If numTrue is false then print an error messagee and return 0
		*/
		for (int i = 0; i < sUserInput.length(); i++) {
			boolean numTrue = Character.isDigit(sUserInput.charAt(i));
			
			if (numTrue == false) {
				System.out.println("Invalid input. Please enter a valid number.");
				return 0;
			}
		}
		//Declare double variable called userInput and assign to the conversion of sUserInput to a double value
		double userInput = Double.valueOf(sUserInput);
	
		return userInput; //Return userInput
	}
	
	public static double balance(double userBudget, double itemSum) {
		double remainBal = 0; //Declare double variable called remainBal and intialize to 0
		
		//Assign remainBal to remainBal plus the difference of expense from budget then return 
		return remainBal = (remainBal) + (userBudget - itemSum); 
	}
	
	public static String Questions (String yesNo) { 
		Scanner scnr = new Scanner(System.in);	//Create a new scanner
		String tell = "";	//Declare a string called tell and intialize to ""
		int count = 0;		//Declare a integer called count and initialize to 0
		
		//Create strings for each yellow prompt box
		String q1 = "Do you have an immediate use for it?";
		String q2 = "Can you borrow it from a friend?";
		String q3 = "Do you have cash to buy it instead of using a credit card?";
		String q4 = "Can you put it on layaway?";
		String q5 = "Do you own something that serves the same purpose?";
		String q6 = "Could your money be better spent on meeting a need?";
		String q7 = "Have you looked for sales, coupons, or generic versions?";
		String q8 = "After all this, do you still want to buy it?";
		String q9 = "You don't truly need this item.";
		
		String error = "ERROR: Please input yes or no.";	//Declare a string called arror that contains error message
		String errorMsg = error;	//Declare a string called errorMsg and 
		String endMsg = "The program has ended due to 3 wrong inputs.";
		String finMsg [] = {"\nDON'T BUY IT", "\nASK TO BORROW IT", "\nGO HOME AND SAVE UP", 
		"\nCOMPARISON SHOP BEFORE BUYING", "\nPUT IT ON LAYAWAY", "\nBUY IT ALREADY"};
		
		switch(yesNo.toLowerCase()) {
		// Do while loops are used to loop statements at least once and then tests condition with while loop 
		
		/* Ternay operators: (Condition)? Do this: Else, then this [MY VERISON]----> IF? DO THIS (:)	ELSE IF? DO THIS: ELSE DO THIS 
		
		This program uses one if to get question and then ternary is used for simple yes or no to lead to another if question branch.
		Consider it like if statements as big branches and ternary operators as the smaller branches that will lead to a recommendation*/
			case "yes":
				do {
					System.out.println(q1);
					yesNo = scnr.next();
					
					tell = yesNo.equalsIgnoreCase("yes")? q3: // If Yes then tell assigned to q3
					(yesNo.equalsIgnoreCase("no")? q9 + finMsg[0]: errorMsg);	//If no then tell assigned to q9 //Else, errorMsg
					
					if (tell == errorMsg) {
						System.out.println(errorMsg);//Print error Message and add one to count
						count++;
						if (count == 3) {// If count equal to 3 then end program
							tell = endMsg;
							break;
						}
						tell = error;
					}
				}
				while ((tell == error) && (count < 3)); 
				
				if (tell.equals(q3)) {
					do {
					System.out.println(q3);
					yesNo = scnr.next();
					
					tell = yesNo.equalsIgnoreCase("yes")? q5: 
					(yesNo.equalsIgnoreCase("no")? q2: errorMsg);
					
					if (tell == errorMsg) {
						System.out.println(errorMsg);
						count++;
						if (count == 3) {
							tell = endMsg;
							break;
						}
						tell = error;
					}
					}
					while ((tell == error) && (count < 3));
				}
				
				if (tell.equals(q5)) {
					do {
					System.out.println(q5);
					yesNo = scnr.next();
					
					tell = yesNo.equalsIgnoreCase("yes")? q9 + finMsg[0]: 
					(yesNo.equalsIgnoreCase("no")? q6: errorMsg);
					
					if (tell == errorMsg) {
						System.out.println(errorMsg);
						count++;
						if (count == 3) {
							tell = endMsg;
							break;
						}
						tell = error;
					}
					}
					while ((tell == error) && (count < 3));
				}
				
				if (tell.equals(q2)) {
					do {
					System.out.println(q2);
					yesNo = scnr.next();
					
					tell = yesNo.equalsIgnoreCase("yes")? finMsg[1]: 
					(yesNo.equalsIgnoreCase("no")? q4: errorMsg);
					
					if (tell == errorMsg) {
						System.out.println(errorMsg);
						count++;
						if (count == 3) {
							tell = endMsg;
							break;
						}
						tell = error;
					}
					}
					while ((tell == error) && (count < 3));
				}
				
				if (tell.equals(q4)) {
					do {
					System.out.println(q4);
					yesNo = scnr.next();
					
					tell = yesNo.equalsIgnoreCase("yes")? finMsg[4]: 
					(yesNo.equalsIgnoreCase("no")? finMsg[2]: errorMsg);
					
					if (tell == errorMsg) {
						System.out.println(errorMsg);
						count++;
						if (count == 3) {
							tell = endMsg;
							break;
						}
						tell = error;
					}
					}
					while ((tell == error) && (count < 3));
				}
				
				if (tell.equals(q6)) {
					do {
					System.out.println(q6);
					yesNo = scnr.next();
					
					tell = yesNo.equalsIgnoreCase("yes")? finMsg[2]: 
					(yesNo.equalsIgnoreCase("no")? q7: errorMsg);
					
					if (tell == errorMsg) {
						System.out.println(errorMsg);
						count++;
						if (count == 3) {
							tell = endMsg;
							break;
						}
						tell = error;
					}
					}
					while ((tell == error) && (count < 3));
				}
				
				if (tell.equals(q7)) {
					do {
					System.out.println(q7);
					yesNo = scnr.next();
					
					tell = yesNo.equalsIgnoreCase("yes")? q8: 
					(yesNo.equalsIgnoreCase("no")? finMsg[3]: errorMsg);
					
					if (tell == errorMsg) {
						System.out.println(errorMsg);
						count++;
						if (count == 3) {
							tell = endMsg;
							break;
						}
						tell = error;
					}
					}
					while ((tell == error) && (count < 3));
				}
				
				if (tell.equals(q8)) {
					do {
					System.out.println(q8);
					yesNo = scnr.next();
					
					tell = yesNo.equalsIgnoreCase("yes")? finMsg[5]: 
					(yesNo.equalsIgnoreCase("no")? finMsg[0]: errorMsg);
					
					if (tell == errorMsg) {
						System.out.println(errorMsg);
						count++;
						if (count == 3) {
							tell = endMsg;
							break;
						}
						tell = error;
					}
					}
					while ((tell == error) && (count < 3));
				}
				System.out.println(tell);
				break;
			
			case "no":
				do {
					System.out.println(q2);
					yesNo = scnr.next();
					
					tell = yesNo.equalsIgnoreCase("yes")? finMsg[1]: 
					(yesNo.equalsIgnoreCase("no")? q4: errorMsg);
					
					if (tell == errorMsg) {
						System.out.println(errorMsg);
						count++;
						if (count == 3) {
							tell = endMsg;
							break;
						}
						tell = error;
					}
				}
				while ((tell == error) && (count < 3));
				
				if (tell.equals(q4)) {
					do {
					System.out.println(q4);
					yesNo = scnr.next();
					
					tell = yesNo.equalsIgnoreCase("yes")? finMsg[4]: 
					(yesNo.equalsIgnoreCase("no")? finMsg[2]: errorMsg);
					
					if (tell == errorMsg) {
						System.out.println(errorMsg);
						count++;
						if (count == 3) {
							tell = endMsg;
							break;
						}
						tell = error;
					}
					}
					while ((tell == error) && (count < 3));
				}
				System.out.println(tell);
				break;
		}
		
		//if tell is not equal to "buy it" then end program
		if (!tell.equals(finMsg[5]))
			System.exit(0);
		return tell;
	}
}