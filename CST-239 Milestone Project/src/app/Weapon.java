package app;

import java.util.Comparator;

/**
 * Implements a Weapon product with a damage field, extends SalableProduct
 * @author Eric Johnston
 * @version 1.0
 */
public class Weapon extends SalableProduct implements Comparable<SalableProduct>
{
	private int damage;
	
	/**
	 * Damage getter
	 * @return
	 */
	public int getDamage() 
	{
		return damage;
	}
	
	/**
	 * Damage setter
	 * @param damage
	 */
	public void setDamage(int damage) 
	{
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
	
	/**
	 * Sorts objects by name ascending
	 */
	public static Comparator<SalableProduct> productNameAscending = new Comparator<SalableProduct>()
	{
		@Override
		public int compare(SalableProduct o1, SalableProduct o2)
		{
			String pName1 = o1.getName();
			String pName2 = o2.getName();
			
			return pName1.compareTo(pName2);
		}
	};
	
	/**
	 * Sorts objects by price descending
	 */
	public static Comparator<SalableProduct> productPriceDescending = new Comparator<SalableProduct>()
	{
		@Override
		public int compare(SalableProduct o1, SalableProduct o2)
		{
			int pPrice1 = o1.getPrice();
			int pPrice2 = o2.getPrice();
			
			return pPrice2 - pPrice1;
		}
	};
	
	/**
	 * Sorts objects by price ascending
	 */
	public static Comparator<SalableProduct> productPriceAscending = new Comparator<SalableProduct>()
	{
		@Override
		public int compare(SalableProduct o1, SalableProduct o2)
		{
			int pPrice1 = o1.getPrice();
			int pPrice2 = o2.getPrice();
			
			return pPrice1 - pPrice2;
		}
	};
}
