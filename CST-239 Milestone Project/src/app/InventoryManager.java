package app;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Implements inventory manager
 * @author Eric Johnston
 * @version 0.2
 */
public class InventoryManager
{
	FileService fileService = new FileService();
	
	// Create ArrayList to hold inventory items
	public ArrayList<SalableProduct> inventoryList = new ArrayList<SalableProduct>();
	
		
	/**
	* Checks if product quantity is at 0, if not then print to console
	* @param product object
	*/
	public void checkStock(SalableProduct product)
	{
		if(product.getQuantity() != 0)
		{
			System.out.println(product.getName() + " - Price: " + product.getPrice() + "g");
		}
	}
		
	/**
	* Subtract 1 from product quantity
	* @param product object
	*/
	public void deductQuanitity(SalableProduct product)
	{
		product.setQuantity(product.getQuantity() - 1);
	}
	
	public void addQuanitity(SalableProduct product)
	{
		product.setQuantity(product.getQuantity() + 1);
	}
	
	/**
	 * Create inventory ArrayList
	 */
	public void createInventoryList()
	{	
		//Clear list if already made
		inventoryList.clear();
		inventoryList = fileService.readFromFile("products.json");
	}
	
	/**
	 * Sort SalableProduct list by name ascending
	 */
	public void nameSortAscending()
	{
		System.out.println("Sorting products by name ascending...\n");
		Collections.sort(inventoryList, Weapon.productNameAscending);
	}
	
	/**
	 * Sort SalableProduct list by name descending
	 */
	public void nameSortDescending()
	{
		System.out.println("Sorting products by name descending...\n");
		Collections.sort(inventoryList, Collections.reverseOrder());
	}
	
	/**
	 * Sort SalableProduct list by price ascending
	 */
	public void priceSortAscending()
	{
		System.out.println("Sorting products by price ascending...\n");
		Collections.sort(inventoryList, Weapon.productPriceAscending);
	}
	
	/**
	 * Sort SalableProduct list by price descending
	 */
	public void priceSortDescending()
	{
		System.out.println("Sorting products by price descending...\n");
		Collections.sort(inventoryList, Weapon.productPriceDescending);
	}
	
}
