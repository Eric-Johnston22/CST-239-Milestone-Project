package app;

/**
 * Implements a Health product with a heal field, extends SalableProduct
 * @author Eric Johnston
 * @version 0.1
 */
public class Health extends SalableProduct implements Comparable<Health>
{
	private int heal;
	
	/**
	 * Class constructor
	 * @param name string
	 * @param description string 
	 * @param price int 
	 * @param quantity int
	 * @param heal int
	 */
	public Health(String name, String description, int price, int quantity, int heal)
	{
		super(name, description, price, quantity);
		this.heal = heal;
	}

	/**
	 * 
	 */
	public void productDetails()
	{
		System.out.println("Name: " + getName() +"\nDescription: " + getDescription()
		+ "\nPrice: " + getPrice() + " gold pieces" + "\nQty: " + getQuantity()
		+ "\nHeal: " + heal);
	}

	@Override
	public int compareTo(Health o) {
		int value = this.getName().compareTo(o.getName());
		if(value == 0)
		{
			return this.getName().compareTo(o.getName());
		}
		else
		{
			return value;
		}
	}
}
