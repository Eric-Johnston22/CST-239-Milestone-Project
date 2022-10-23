package app;

import java.util.Comparator;

/**
 * Implements an Armor product with an armorClass, extends SalableProduct
 * @author Eric Johnston
 * @version 1.0
 */
public class Armor extends SalableProduct implements Comparable<SalableProduct>
{
	private int armorClass;
	
	/**
	 * Default constructor, needed for jackson
	 */
	public Armor()
	{
		super();
		armorClass = 0;
	}
	
	public int getArmorClass() {
		return armorClass;
	}

	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}

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
