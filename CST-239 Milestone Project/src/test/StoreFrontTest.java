package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import app.Armor;
import app.FileService;
import app.Health;
import app.InventoryManager;
import app.SalableProduct;
import app.StoreFront;
import app.Weapon;

/**
 * Test StoreFront class
 * @author Eric Johnston
 * @version 1.0
 */
public class StoreFrontTest
{
	private ArrayList<SalableProduct> salableProducts = new ArrayList<SalableProduct>();
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	
	@Before
	public void init()
	{
		Weapon sword = new Weapon("Short Sword", "A simple sword. It doesn't look very sharp...", 3, 2, 2);
		Weapon axe = new Weapon("Axe of Storms", "A one handed axe, marked with runes. It hums with magic.", 50, 1, 12);
		Weapon bow = new Weapon("Sturdy Recurve Bow", "A sturdy bow fashioned from yew.", 10, 2, 12);
		Armor shield = new Armor("Wooden Buckler", "A flimsy wooden shield.", 2, 1, 5);
		Armor chainMail = new Armor("Elven chain Mail", "Delicately crafted from mithril links.", 22, 1, 7);
		Armor plate = new Armor("Thorium Armor", "Nearly impenetrable plate armor of dwarven make.", 28, 1, 10);
		Armor robe = new Armor("Manaweave Robe", "A glimmering robe of fine cloth.", 8, 1, 1);
		Health minorPotion = new Health("Minor Healing Potion", "A healing draught with a bitter taste.", 1, 20, 2);

		salableProducts.add(sword);
		salableProducts.add(axe);
		salableProducts.add(shield);
		salableProducts.add(chainMail);
		salableProducts.add(minorPotion);
		salableProducts.add(robe);
		salableProducts.add(plate);
		salableProducts.add(bow);

		System.setOut(new PrintStream(outputStreamCaptor));
	}
	
	@Test
	public void showProductsTest()
	{
		InventoryManager inventoryManager = new InventoryManager();
		FileService fileService = new FileService();
		// Create a new list to hold products read from json
		ArrayList<SalableProduct> inventoryList = new ArrayList<SalableProduct>();
		inventoryList = fileService.readFromFile("products.json");
		
		//String inputData = "0";
		//System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		
		//StoreFront.showProducts();
		
		//Assert.assertEquals("Axe of Storms - Price: 50g", outputStreamCaptor.toString().trim());
	}
	
	@Test
	public void productSelectionTest()
	{
		//StoreFront.productSelection();
		//String inputData = "1";
		//System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		
		//Assert.assertEquals("Add to cart? (y/n)", outputStreamCaptor.toString().trim());
	}
	@After
	public void tearDown()
	{
		System.setOut(standardOut);
	}
}
