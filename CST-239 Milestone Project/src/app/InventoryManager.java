package app;

import java.util.ArrayList;


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
			System.out.println(product.getName());
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
		 inventoryList = fileService.readFromFile("products.json");
	}
}
