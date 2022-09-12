import java.util.Scanner;

/**
 * Implement store front that allows for the purchase of products
 * @author Eric Johnston
 * @version 0.1
 */
public class StoreFront {
	
	// Scanner for user input
	static Scanner input = new Scanner(System.in);

	// Create 2 product objects
	static SalableProduct sword = new SalableProduct("Sword", "A simple sword, it doesn't look very sharp...", 3, 2);
	static SalableProduct shield = new SalableProduct("Shield", "A flimsy wooden shield.", 2, 1);

	/**
	 * The main menu of the program
	 */
	public static void menu() 
	{
		System.out.println("Greetings adventurer! How can I be of service?" + "\n1. View Products \n2. Checkout \n3. Cancel");
		
		// Hold user input
		byte userChoice = input.nextByte();

		// Check for user input
		if (userChoice == 1) 
		{
			showProducts();
		}
		if (userChoice == 2) 
		{
			// TODO checkout
		}
		if (userChoice == 3) {
			System.exit(0);
		}
	}

	/**
	 * Display products and allow user to purchase if desired
	 */
	public static void showProducts()
	{
		// Display product names, allow user to choose a product
		System.out.println("Feel free to browse!");
		System.out.println(sword.getName());
		System.out.println(shield.getName());
		
		Scanner newInput = new Scanner(System.in);
		
		byte userChoice = input.nextByte();
		
		// User selects one of the products and program displays product details
		 if(userChoice == 1) 
		 {
			 // Display product details
			 sword.productDetails(); 
			 System.out.println("Interested in buying? (y/n)");
			 char purchase = newInput.nextLine().charAt(0);
			 
			 // If yes, purchase product
			 if(purchase == 'y')
			 { 
				 System.out.println("I appreciate your business!");
				 
				 // Update new quantity
				 sword.setQuantity(sword.getQuantity() - 1);
				 System.out.println("New stock: " + sword.getQuantity());
			 }
			 // If no, exit
			 if(purchase == 'n')
			 {
				 System.exit(0);
			 }
				 
		 } 
		 if(userChoice == 2) 
		 {
			 shield.productDetails();
			 System.out.println("Interested in buying? (y/n)");
			 char purchase = newInput.nextLine().charAt(0);
			 
			 // If yes, purchase product
			 if(purchase == 'y')
			 { 
				 System.out.println("I appreciate your business!");
				 
				 // Update new quantity
				 shield.setQuantity(shield.getQuantity() - 1);
				 System.out.println("New stock: " + shield.getQuantity());
			 }
			 // If no, exit
			 if(purchase == 'n')
			 {
				 System.exit(0);
			 }
		 }
		 
		 if(userChoice == 3)
		 { 
			 System.exit(0); 
		 }
		 // Close input
		 newInput.close();
	}

	public static void main(String[] args) 
	{
		menu();
	}

}
