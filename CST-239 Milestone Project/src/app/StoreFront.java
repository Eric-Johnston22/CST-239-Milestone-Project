package app;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Implements store front that allows for the purchase of products
 * @author Eric Johnston
 * @version 1.0
 */
public class StoreFront 
{
	
	// Scanner for user input
	static Scanner input = new Scanner(System.in);

	// Create InventoryManager object
	static InventoryManager inventoryManager = new InventoryManager();
	
	// Create ShoppingCart object
	static ShoppingCart shoppingCart = new ShoppingCart();
	

	/**
	 * The main menu of the program
	 */
	public static void mainMenu() 
	{
		System.out.println("Greetings adventurer! Welcome to Lionheart Armory! \nHow can I be of service?" + 
						   "\n1. View Products \n2. Shopping Cart \n3. Update inventory \n0. Exit");
		
		
		// Hold user input
		byte userChoice = input.nextByte();

		// Check for user input
		if (userChoice == 1) 
		{
			showProducts();
		}
		if (userChoice == 2)
		{
			viewCart();
		}
		if (userChoice == 3)
		{
			inventoryManager.createInventoryList();
			mainMenu();
		}
		if (userChoice == 0)
		{
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
		
		for (SalableProduct i : inventoryManager.inventoryList)
		{
			inventoryManager.checkStock(i);
		}
		
		System.out.println("\n9. Return to menu");
		System.out.println("0. Exit");
		
		productSelection();
	}

	/**
	 * Allows user to select a product to view more details and purchase
	 */
	public static void productSelection()
	{
		System.out.println("11. Sort by name ascending.\n12. Sort by name descending\n13. "
				+ "Sort by price ascending\n14. Sort by price descending.\n");
		Scanner newInput = new Scanner(System.in);
		byte userChoice = input.nextByte();
		
		// User selects one of the products and program displays product details
		switch(userChoice)
		{
			case 1:
			{
				// Display product details
				 inventoryManager.inventoryList.get(0).productDetails();
				 
				 System.out.println("Add to cart? (y/n)");
				 char purchase = newInput.nextLine().charAt(0);
				 
				 if(purchase == 'y')
				 {  
					 shoppingCart.addProduct(inventoryManager.inventoryList.get(0));
					 
					 // Update new quantity
					 inventoryManager.deductQuanitity(inventoryManager.inventoryList.get(0));
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
				 inventoryManager.inventoryList.get(1).productDetails();
				 
				 System.out.println("Add to cart? (y/n)");
				 char purchase = newInput.nextLine().charAt(0);
				 
				 if(purchase == 'y')
				 { 
					 shoppingCart.addProduct(inventoryManager.inventoryList.get(1));
					 
					 // Update new quantity
					 inventoryManager.deductQuanitity(inventoryManager.inventoryList.get(1));
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
				inventoryManager.inventoryList.get(2).productDetails();
				 
				 System.out.println("Add to cart? (y/n)");
				 char purchase = newInput.nextLine().charAt(0);
				 
				 if(purchase == 'y')
				 { 
					 shoppingCart.addProduct(inventoryManager.inventoryList.get(2));
					 
					 // Update new quantity
					 inventoryManager.deductQuanitity(inventoryManager.inventoryList.get(2));
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
				inventoryManager.inventoryList.get(3).productDetails();
				 
				 System.out.println("Add to cart? (y/n)");
				 char purchase = newInput.nextLine().charAt(0);
				 
				 if(purchase == 'y')
				 { 
					 shoppingCart.addProduct(inventoryManager.inventoryList.get(3));
					 
					 // Update new quantity
					 inventoryManager.deductQuanitity(inventoryManager.inventoryList.get(3));
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
				inventoryManager.inventoryList.get(4).productDetails();
				 
				 System.out.println("Add to cart? (y/n)");
				 char purchase = newInput.nextLine().charAt(0);
				 
				 if(purchase == 'y')
				 { 
					 shoppingCart.addProduct(inventoryManager.inventoryList.get(4));
					 
					 // Update new quantity
					 inventoryManager.deductQuanitity(inventoryManager.inventoryList.get(4));
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
				// Display product details
				inventoryManager.inventoryList.get(5).productDetails();
				 
				 System.out.println("Add to cart? (y/n)");
				 char purchase = newInput.nextLine().charAt(0);
				 
				 if(purchase == 'y')
				 { 
					 shoppingCart.addProduct(inventoryManager.inventoryList.get(5));
					 
					 // Update new quantity
					 inventoryManager.deductQuanitity(inventoryManager.inventoryList.get(5));
					 showProducts();
				 }
				 // If no, show products
				 if(purchase == 'n')
				 {
					 showProducts();
				 }
				 break;
			}
			
			case 7:
			{
				// Display product details
				inventoryManager.inventoryList.get(6).productDetails();
				 
				 System.out.println("Add to cart? (y/n)");
				 char purchase = newInput.nextLine().charAt(0);
				 
				 if(purchase == 'y')
				 { 
					 shoppingCart.addProduct(inventoryManager.inventoryList.get(6));
					 
					 // Update new quantity
					 inventoryManager.deductQuanitity(inventoryManager.inventoryList.get(6));
					 showProducts();
				 }
				 // If no, show products
				 if(purchase == 'n')
				 {
					 showProducts();
				 }
				 break;
			}
			
			case 8:
			{
				// Display product details
				inventoryManager.inventoryList.get(7).productDetails();
				 
				 System.out.println("Add to cart? (y/n)");
				 char purchase = newInput.nextLine().charAt(0);
				 
				 if(purchase == 'y')
				 { 
					 shoppingCart.addProduct(inventoryManager.inventoryList.get(7));
					 
					 // Update new quantity
					 inventoryManager.deductQuanitity(inventoryManager.inventoryList.get(7));
					 showProducts();
				 }
				 // If no, show products
				 if(purchase == 'n')
				 {
					 showProducts();
				 }
				 break;
			}
			
			case 9:
			{
				mainMenu();
				break;
			}
			
			case 0:
			{
				System.exit(0);
				break;
			}
			
			case 11:
			{
				inventoryManager.nameSortAscending();
				showProducts();
				break;
			}
			
			case 12:
			{
				inventoryManager.nameSortDescending();
				showProducts();
				break;
			}
			
			case 13:
			{
				inventoryManager.priceSortAscending();
				showProducts();
				break;
			}
			case 14:
			{
				inventoryManager.priceSortDescending();
				showProducts();
				break;
			}
		}
		newInput.close();
	}

	public static void viewCart()
	{
		System.out.println("Your shopping cart: \n");
		shoppingCart.checkCart(shoppingCart.cartList);
		System.out.println("\n1. Edit your cart \n2. Checkout \n3. Main menu");
		
		//Scanner newInput = new Scanner(System.in);
		byte userChoice = input.nextByte();
		
		if (userChoice == 1)
		{
			editCart(shoppingCart.cartList);
		}
		if (userChoice == 2)
		{
			checkout();
		}
		if (userChoice == 3)
		{
			mainMenu();
		}
	}
	
	/**
	 * Allow user to edit cart
	 * @param list
	 */
	public static void editCart(ArrayList<SalableProduct> list)
	{
		System.out.println("Select a product to edit or press 9 to clear cart");
		
		for (int i = 0; i < list.size(); i ++)
		{
			System.out.println((i + 1) + ". " + list.get(i).getName());
		}
		
		byte userChoice = input.nextByte();
		Scanner newInput = new Scanner(System.in);
		
	
		// Take user choice to decide to remove item or not
		switch(userChoice)
		{
			case 1:
			{
				System.out.println("Remove from cart? (y/n)");
				char edit = newInput.nextLine().charAt(0);
					
				if(edit == 'y')
				{
					shoppingCart.cartList.remove(0);
					inventoryManager.addQuanitity(inventoryManager.inventoryList.get(0));
				}
				if(edit == 'n')
				{
					viewCart();
				}
				
				 break;
			}
			
			case 2:
			{
				System.out.println("Remove from cart? (y/n)");
				char edit = newInput.nextLine().charAt(0);
					
				if(edit == 'y')
				{
					shoppingCart.cartList.remove(1);
					inventoryManager.addQuanitity(inventoryManager.inventoryList.get(1));
				}
				if(edit == 'n')
				{
					viewCart();
				}
				
				 break;
			}
			
			case 3:
			{
				System.out.println("Remove from cart? (y/n)");
				char edit = newInput.nextLine().charAt(0);
					
				if(edit == 'y')
				{
					shoppingCart.cartList.remove(2);
					inventoryManager.addQuanitity(inventoryManager.inventoryList.get(2));
				}
				if(edit == 'n')
				{
					viewCart();
				}
				
				 break;
			}
			
			case 4:
			{
				System.out.println("Remove from cart? (y/n)");
				char edit = newInput.nextLine().charAt(0);
					
				if(edit == 'y')
				{
					shoppingCart.cartList.remove(3);
					inventoryManager.addQuanitity(inventoryManager.inventoryList.get(3));
				}
				if(edit == 'n')
				{
					viewCart();
				}
				
				 break;
			}
			
			case 5:
			{
				System.out.println("Remove from cart? (y/n)");
				char edit = newInput.nextLine().charAt(0);
					
				if(edit == 'y')
				{
					shoppingCart.cartList.remove(4);
					inventoryManager.addQuanitity(inventoryManager.inventoryList.get(4));
				}
				if(edit == 'n')
				{
					viewCart();
				}
				
				 break;
			}
			
			case 6:
			{
				System.out.println("Remove from cart? (y/n)");
				char edit = newInput.nextLine().charAt(0);
					
				if(edit == 'y')
				{
					shoppingCart.cartList.remove(5);
					inventoryManager.addQuanitity(inventoryManager.inventoryList.get(5));
				}
				if(edit == 'n')
				{
					viewCart();
				}
				
				 break;
			}
			
			case 7:
			{
				System.out.println("Remove from cart? (y/n)");
				char edit = newInput.nextLine().charAt(0);
					
				if(edit == 'y')
				{
					shoppingCart.cartList.remove(6);
					inventoryManager.addQuanitity(inventoryManager.inventoryList.get(6));
				}
				if(edit == 'n')
				{
					viewCart();
				}
				
				 break;
			}
			
			case 8:
			{
				System.out.println("Remove from cart? (y/n)");
				char edit = newInput.nextLine().charAt(0);
					
				if(edit == 'y')
				{
					shoppingCart.cartList.remove(7);
					inventoryManager.addQuanitity(inventoryManager.inventoryList.get(7));
				}
				if(edit == 'n')
				{
					viewCart();
				}
				
				 break;
			}
			
			case 9:
			{
				shoppingCart.cartList.clear();
				mainMenu();
			}
			System.out.println("\n6. Clear cart");
		}
		
		viewCart();
		newInput.close();
	}
	
	/**
	 * Display thank you for checking out
	 * @param list
	 */
	public static void checkout()
	{
		System.out.println("Thank you for your business!");
		
		mainMenu();
	}
	
	public static void main(String[] args) 
	{
		inventoryManager.createInventoryList();
		//Collections.sort(inventoryManager.inventoryList, Collections.reverseOrder());
		// TODO Input validation
		mainMenu();
	}

}
