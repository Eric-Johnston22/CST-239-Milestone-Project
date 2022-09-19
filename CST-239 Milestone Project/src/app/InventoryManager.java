package app;

/**
 * Implements inventory manager
 * @author Eric Johnston
 * @version 0.1
 */
public class InventoryManager
{
		// Create 2 weapon objects
		public Weapon sword1 = new Weapon("Short Sword", "A simple sword. It doesn't look very sharp...", 3, 2, 2);
		public Weapon axe1 = new Weapon("Axe of Storms", "A one handed axe, marked with runes. It hums with magic.", 50, 1, 12);
		
		// Create 2 armor objects
		public Armor shield = new Armor("Wooden Buckler", "A flimsy wooden shield.", 2, 1, 5);
		public Armor chainMail = new Armor("Chain Mail", "A well made coat of chain mail.", 8, 3, 7);
		
		// Create health object
		public Health minorPotion = new Health("Minor Healing Potion", "A healing draught with a bitter taste.", 2, 20, 2);
		
		/**
		 * Checks if product quanity is at 0, if not then print to console
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
}
