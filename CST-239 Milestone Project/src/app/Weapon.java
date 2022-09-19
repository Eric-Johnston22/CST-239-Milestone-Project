package app;

/**
 * Implements a Weapon product with a damage field, extends SalableProduct
 * @author Eric Johnston
 * @version 0.1
 */
public class Weapon extends SalableProduct
{
	private int damage;
	
	/**
	 * Class constructor
	 * @param name string
	 * @param description string
	 * @param price int
	 * @param quantity int
	 * @param damage int
	 */
	public Weapon(String name, String description, int price, int quantity, int damage)
	{
		super(name, description, price, quantity);
		this.damage = damage;
	}

	/**
	 * 
	 */
	public void productDetails()
	{
		System.out.println("Name: " + getName() +"\nDescription: " + getDescription()
		+ "\nPrice: " + getPrice() + " gold pieces" + "\nQty: " + getQuantity() +
		"\nDamage: " + damage);
	}
}
