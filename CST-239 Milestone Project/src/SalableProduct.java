/**
 * Implement a SalableProduct that has a name, description, price, and quantity
 * @author Eric Johnston
 * @version 0.1
 */
public class SalableProduct
{
	private String name;
	private String description;
	private int price;
	private int quantity;
	
	/**
	 * Class constructor
	 * @param name
	 * @param description
	 * @param price
	 * @param quantity
	 */
	public SalableProduct(String name, String description, int price, int quantity)
	{
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	/**
	 * name getter
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * name setter
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * description getter
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * description setter
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * price getter
	 * @return
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * price setter
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * quantity getter
	 * @return
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 *  quantity setter
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Print products fields to console
	 */
	public void productDetails()
	{
		System.out.println("Name: " + getName() +"\nDescription: " + getDescription()
		+ "\nPrice: " + getPrice() + " gold pieces" + "\nQty: " + getQuantity());
	}
}
