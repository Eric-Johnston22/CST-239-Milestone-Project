package app;

/**
 * Implements a Health product with a heal field, extends SalableProduct
 * @author Eric Johnston
 * @version 0.1
 */
public class Health extends SalableProduct implements Comparable<Health>
{
	// Amount this object can heal
	private int heal;
	
	public int getHeal() {
		return heal;
	}
	public void setHeal(int heal) {
		this.heal = heal;
	}
	
	/**
	 * Default constructor, needed for jackson
	 */
	public Health()
	{
		super();
		heal = 0;
	}
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
