package app;

import java.util.ArrayList;

/**
 * Implements a shopping cart
 * @author Eric Johnston
 *
 */
public class ShoppingCart 
{
	public ArrayList<SalableProduct> cartList = new ArrayList<>();
	
	/**
	 * Add product to cart list
	 * @param object
	 */
	public void addProduct(SalableProduct object)
	{
		System.out.println("Adding " + object.getName() + " to cart");
		cartList.add(object);
	}
	
	/**
	 * Remove product from cart list
	 * @param object
	 */
	public void removeProduct(SalableProduct object)
	{
		System.out.println("Removing " + object.getName() + " from cart");
		cartList.remove(object);
	}
	
	/**
	 * Print cart item names and price, along with total cart price
	 * @param list
	 */
	public void checkCart(ArrayList<SalableProduct> list)
	{
		// Hold cart total checkout price
		int cartTotal = 0;
		
		if(list.size() == 0)
		{
			System.out.println("Your cart is empty.");
		}
		
		for (int i = 0; i < list.size(); i ++)
		{
			System.out.println(list.get(i).getName() + " - Price: " + list.get(i).getPrice() + " gold pieces");
			cartTotal += list.get(i).getPrice();
		}
		
		// Print cart total
		System.out.println("\r\nCart total: " + cartTotal + " gold pieces");
	}
	
}
