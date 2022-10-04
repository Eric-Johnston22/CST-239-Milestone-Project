package app;

/**
 * Implements a Weapon product with a damage field, extends SalableProduct
 * @author Eric Johnston
 * @version 0.1
 */
public class Weapon extends SalableProduct implements Comparable<Weapon>
{
	private int damage;
	
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	/**
	 * Default constructor, needed for jackson
	 */
	public Weapon()
	{
		super();
		damage = 0;
	}
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

	@Override
	public int compareTo(Weapon o) 
	{
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
