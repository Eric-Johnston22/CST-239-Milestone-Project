package app;
import java.util.Scanner;

/**
 * Implements store front that allows for the purchase of products
 * @author Eric Johnston
 * @version 0.2
 */
public class StoreFront {
	
	// Scanner for user input
	static Scanner input = new Scanner(System.in);

	// Create InventoryManager object
	static InventoryManager inventoryManager = new InventoryManager();

	/**
	 * The main menu of the program
	 */
	public static void mainMenu() 
	{
		System.out.println("Greetings adventurer! Welcome to Lionheart Armory! \nHow can I be of service?" + "\n1. View Products \n2. Exit");
		
		
		// Hold user input
		byte userChoice = input.nextByte();

		// Check for user input
		if (userChoice == 1) 
		{
			showProducts();
		}
		if (userChoice == 2) {
			System.exit(0);
		}
	}

	/**
	 * Displays products and allow user to select one
	 */
	public static void showProducts()
	{
		// Display product names, allow user to choose a product
		System.out.println("Feel free to browse!\n");
		inventoryManager.checkStock(inventoryManager.sword1);
		inventoryManager.checkStock(inventoryManager.axe1);
		inventoryManager.checkStock(inventoryManager.shield);
		inventoryManager.checkStock(inventoryManager.chainMail);
		inventoryManager.checkStock(inventoryManager.minorPotion);
		
		System.out.println("\n6. Return to menu");
		System.out.println("7. Exit");
		
		productSelection();
	}

	/**
	 * Allows user to select a product to view more details and purchase
	 */
	public static void productSelection()
	{
		Scanner newInput = new Scanner(System.in);
		byte userChoice = input.nextByte();
		
		// User selects one of the products and program displays product details
		switch(userChoice)
		{
			case 1:
			{
				// Display product details
				 inventoryManager.sword1.productDetails();
				 
				 System.out.println("Interested in buying? (y/n)");
				 char purchase = newInput.nextLine().charAt(0);
				 
				 if(purchase == 'y')
				 { 
					 System.out.println("I appreciate your business!");
					 
					 // Update new quantity
					 inventoryManager.deductQuanitity(inventoryManager.sword1);
					 showProducts();
				 }
				 // If no, show products
				 if(purchase == 'n')
				 {
					 showProducts();
				 }
				 break;
			}
			
			case 2:
			{
				// Display product details
				 inventoryManager.axe1.productDetails();
				 
				 System.out.println("Interested in buying? (y/n)");
				 char purchase = newInput.nextLine().charAt(0);
				 
				 if(purchase == 'y')
				 { 
					 System.out.println("I appreciate your business!");
					 
					 // Update new quantity
					 inventoryManager.deductQuanitity(inventoryManager.axe1);
					 showProducts();
				 }
				 // If no, show products
				 if(purchase == 'n')
				 {
					 showProducts();
				 }
				 break;
			}
			
			case 3:
			{
				// Display product details
				 inventoryManager.shield.productDetails();
				 
				 System.out.println("Interested in buying? (y/n)");
				 char purchase = newInput.nextLine().charAt(0);
				 
				 if(purchase == 'y')
				 { 
					 System.out.println("I appreciate your business!");
					 
					 // Update new quantity
					 inventoryManager.deductQuanitity(inventoryManager.shield);
					 showProducts();
				 }
				 // If no, show products
				 if(purchase == 'n')
				 {
					 showProducts();
				 }
				 break;
			}
			
			case 4:
			{
				// Display product details
				 inventoryManager.chainMail.productDetails();
				 
				 System.out.println("Interested in buying? (y/n)");
				 char purchase = newInput.nextLine().charAt(0);
				 
				 if(purchase == 'y')
				 { 
					 System.out.println("I appreciate your business!");
					 
					 // Update new quantity
					 inventoryManager.deductQuanitity(inventoryManager.chainMail);
					 showProducts();
				 }
				 // If no, show products
				 if(purchase == 'n')
				 {
					 showProducts();
				 }
				 break;
			}
			
			case 5:
			{
				// Display product details
				 inventoryManager.minorPotion.productDetails();
				 
				 System.out.println("Interested in buying? (y/n)");
				 char purchase = newInput.nextLine().charAt(0);
				 
				 if(purchase == 'y')
				 { 
					 System.out.println("I appreciate your business!");
					 
					 // Update new quantity
					 inventoryManager.deductQuanitity(inventoryManager.minorPotion);
					 showProducts();
				 }
				 // If no, show products
				 if(purchase == 'n')
				 {
					 showProducts();
				 }
				 break;
			}
			
			case 6:
			{
				mainMenu();
			}
			
			case 7:
			{
				System.exit(0);
			}
			
		}
		newInput.close();
	}
	
	public static void main(String[] args) 
	{
		mainMenu();
	}

}
