package app;

/**
 * Implements an Armor product with an armorClass, extends SalableProduct
 * @author Eric Johnston
 * @version 0.1
 */
public class Armor extends SalableProduct
{
	private int armorClass;
	
	/**
	 * Class constructor
	 * @param name string
	 * @param description string 
	 * @param price int 
	 * @param quantity int
	 * @param armorClass int
	 */
	public Armor(String name, String description, int price, int quantity, int armorClass)
	{
		super(name, description, price, quantity);
		this.armorClass = armorClass;
	}
	
	/**
	 * 
	 */
	public void productDetails()
	{
		System.out.println("Name: " + getName() +"\nDescription: " + getDescription()
		+ "\nPrice: " + getPrice() + " gold pieces" + "\nQty: " + getQuantity()
		+ "\nArmor class: " + armorClass);
	}
}
