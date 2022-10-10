package app;

import java.util.Comparator;

/**
 * Implements a Health product with a heal field, extends SalableProduct
 * @author Eric Johnston
 * @version 0.1
 */
public class Health extends SalableProduct implements Comparable<SalableProduct>
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
	public int compareTo(SalableProduct o)
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
	public static Comparator<SalableProduct> productNameComparator = new Comparator<SalableProduct>()
	{

		@Override
		public int compare(SalableProduct o1, SalableProduct o2)
		{
			String pName1 = o1.getName();
			String pName2 = o2.getName();
			
			return pName1.compareTo(pName2);
		}
		
	};
}
