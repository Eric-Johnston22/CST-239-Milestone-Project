package test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import app.Armor;
import app.FileService;
import app.Health;
import app.InventoryManager;
import app.SalableProduct;
import app.Weapon;

/**
 * Test Weapon class
 * @author Eric Johnston
 * @version 1.0
 */
public class WeaponTest
{
	private ArrayList<SalableProduct> salableProducts = new ArrayList<SalableProduct>();
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	
	Weapon sword = new Weapon("Short Sword", "A simple sword. It doesn't look very sharp...", 3, 2, 2);
	Weapon axe = new Weapon("Axe of Storms", "A one handed axe, marked with runes. It hums with magic.", 50, 1, 12);
	Weapon bow = new Weapon("Sturdy Recurve Bow", "A sturdy bow fashioned from yew.", 10, 2, 12);
	Armor shield = new Armor("Wooden Buckler", "A flimsy wooden shield.", 2, 1, 5);
	Armor chainMail = new Armor("Elven chain Mail", "A well made coat of chain mail.", 22, 3, 7);
	Armor plate = new Armor("Thorium Armor", "Nearly impenetrable plate armor of dwarven make.", 28, 1, 10);
	Armor robe = new Armor("Manaweave Robe", "A glimmering robe of fine cloth.", 8, 1, 1);
	Health minorPotion = new Health("Minor Healing Potion", "A healing draught with a bitter taste.", 1, 20, 2);

	@Before
	public void init()
	{	
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Test
	public void productDetailsTest()
	{
		salableProducts.add(sword);
		salableProducts.get(0).productDetails();
		
		Assert.assertEquals("Name: Short Sword\nDescription: A simple sword. It doesn't look very sharp..."
				+ "\nPrice: 3 gold pieces\nQty: 2\nDamage: 2", outputStreamCaptor.toString().trim());
	}
	
	@Test
	public void nameAscendingTest()
	{
		FileService fileService = new FileService();
		InventoryManager inventoryManager = new InventoryManager();
		inventoryManager.inventoryList = fileService.readFromFile("products.json");
		inventoryManager.nameSortAscending();
		
		salableProducts.add(axe);
		salableProducts.add(chainMail);
		salableProducts.add(robe);
		salableProducts.add(minorPotion);
		salableProducts.add(sword);
		salableProducts.add(bow);
		salableProducts.add(plate);
		salableProducts.add(shield);
		
		
		for(int i = 0; i < 8; i++)
		{
			Assert.assertEquals(salableProducts.get(i).getName(), inventoryManager.inventoryList.get(i).getName());
		}
	}
	
	@Test
	public void nameDescendingTest()
	{
		FileService fileService = new FileService();
		InventoryManager inventoryManager = new InventoryManager();
		inventoryManager.inventoryList = fileService.readFromFile("products.json");
		inventoryManager.nameSortDescending();
		
		// Add products to list in reverse alphabetical order
		
		salableProducts.add(shield);
		salableProducts.add(plate);
		salableProducts.add(bow);
		salableProducts.add(sword);
		salableProducts.add(minorPotion);
		salableProducts.add(robe);
		salableProducts.add(chainMail);
		salableProducts.add(axe);
	
		for(int i = 0; i < 8; i++)
		{
			Assert.assertEquals(salableProducts.get(i).getName(),inventoryManager.inventoryList.get(i).getName());
		}
	}
	
	@Test
	public void priceAscendingTest()
	{
		FileService fileService = new FileService();
		InventoryManager inventoryManager = new InventoryManager();
		inventoryManager.inventoryList = fileService.readFromFile("products.json");
		inventoryManager.priceSortAscending();
		
		salableProducts.add(minorPotion);
		salableProducts.add(shield);
		salableProducts.add(sword);
		salableProducts.add(robe);
		salableProducts.add(bow);
		salableProducts.add(chainMail);
		salableProducts.add(plate);
		salableProducts.add(axe);
		
		for(int i = 0; i < 8; i++)
		{
			Assert.assertEquals(salableProducts.get(i).getPrice(),inventoryManager.inventoryList.get(i).getPrice());
		}
		
	}
	
	@Test
	public void priceDescendingTest()
	{
		FileService fileService = new FileService();
		InventoryManager inventoryManager = new InventoryManager();
		inventoryManager.inventoryList = fileService.readFromFile("products.json");
		inventoryManager.priceSortDescending();
		
		salableProducts.add(axe);
		salableProducts.add(plate);
		salableProducts.add(chainMail);
		salableProducts.add(bow);
		salableProducts.add(robe);
		salableProducts.add(sword);
		salableProducts.add(shield);
		salableProducts.add(minorPotion);
		
		for(int i = 0; i < 8; i++)
		{
			Assert.assertEquals(salableProducts.get(i).getPrice(),inventoryManager.inventoryList.get(i).getPrice());
		}
	}
	
	@Test
	public void setDamageTest() throws NoSuchFieldException, IllegalAccessException
	{
		Weapon wpn = new Weapon();
		wpn.setDamage(3);
		
		Field field = wpn.getClass().getDeclaredField("damage");
		field.setAccessible(true);
		Assert.assertEquals("Fields didn't match", 3, field.get(wpn));
	}
	
	@Test
	public void getDamageTest() throws NoSuchFieldException, IllegalAccessException
	{
		Weapon wpn = new Weapon();
		Field field = wpn.getClass().getDeclaredField("damage");
		field.setAccessible(true);
		field.set(wpn, 3);
		
		int result = wpn.getDamage();
		
		Assert.assertEquals("Field wasn't retrieved properly", 3, result);;
	}
	
	@After
	public void reset() 
	{
		salableProducts.clear();
	    System.setOut(standardOut);
	}

}
