package app;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Implements inventory manager
 * @author Eric Johnston
 * @version 0.1
 */
public class InventoryManager
{
	// Create ArrayList to hold inventory items
	public ArrayList<SalableProduct> inventoryList = new ArrayList<>();
	
	
	
	// Create 2 weapon objects
	public Weapon sword1 = new Weapon("Short Sword", "A simple sword. It doesn't look very sharp...", 3, 2, 2);
	public Weapon axe1 = new Weapon("Axe of Storms", "A one handed axe, marked with runes. It hums with magic.", 50, 1, 12);
		
	// Create 2 armor objects
	public Armor shield = new Armor("Wooden Buckler", "A flimsy wooden shield.", 2, 1, 5);
	public Armor chainMail = new Armor("Chain Mail", "A well made coat of chain mail.", 8, 3, 7);
		
	// Create health object
	public Health minorPotion = new Health("Minor Healing Potion", "A healing draught with a bitter taste.", 2, 20, 2);
		
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
	
	public void createInventoryList()
	{
		inventoryList.add(sword1);
		inventoryList.add(axe1);
		inventoryList.add(shield);
		inventoryList.add(chainMail);
		inventoryList.add(minorPotion);
		
		//Collections.sort(inventoryList);
		
		Weapon[] weapons = new Weapon[2];
		weapons[0] = new Weapon("Short Sword", "A simple sword. It doesn't look very sharp...", 3, 2, 2);
		weapons[1] = new Weapon("Axe of Storms", "A one handed axe, marked with runes. It hums with magic.", 50, 1, 12);
		Armor[] armors = new Armor[2];
		armors[0] = new Armor("Wooden Buckler", "A flimsy wooden shield.", 2, 1, 5);
		armors[1] = new Armor("Chain Mail", "A well made coat of chain mail.", 8, 3, 7);
		Health[] healths = new Health[1];
		healths[0] = new Health("Minor Healing Potion", "A healing draught with a bitter taste.", 2, 20, 2);
		Arrays.sort(weapons);
		Arrays.sort(armors);
		Arrays.sort(healths);
	}
	
}
