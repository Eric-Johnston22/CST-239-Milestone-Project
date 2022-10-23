package test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
 * Test InventoryManager class
 * @author Eric Johnston
 * @version
 */
public class InventoryManagerTest
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
	public void checkStockTest()
	{
		InventoryManager manager = new InventoryManager();
		FileService fileService = new FileService();
		manager.inventoryList = fileService.readFromFile("products.json");
		manager.checkStock(manager.inventoryList.get(1));

		Assert.assertEquals("Axe of Storms - Price: 50g", outputStreamCaptor.toString().trim());
		
	}

	@Test
	public void deductQuantityTest()
	{
		InventoryManager manager = new InventoryManager();
		
		// Set minor potion qty from 20 to 19
		manager.deductQuanitity(salableProducts.get(4));
		Assert.assertEquals(19, salableProducts.get(4).getQuantity());
	}

	@Test
	public void addQuantityTest()
	{
		InventoryManager manager = new InventoryManager();

		// Set minor potion qty from 20 to 21
		manager.addQuanitity(salableProducts.get(4));
		Assert.assertEquals(21, salableProducts.get(4).getQuantity());
	}

	@Test
	public void createInventoryListTest()
	{
		FileService fileService = new FileService();
		// Create a new list to hold products read from json
		ArrayList<SalableProduct> inventoryList = new ArrayList<SalableProduct>();
		inventoryList = fileService.readFromFile("products.json");

		// Loop through both lists and compare their properties.
		for (int i = 0; i < 8; i++)
		{
			Assert.assertEquals(salableProducts.get(i).getName(), inventoryList.get(i).getName());
			Assert.assertEquals(salableProducts.get(i).getDescription(), inventoryList.get(i).getDescription());
			Assert.assertEquals(salableProducts.get(i).getPrice(), inventoryList.get(i).getPrice());
			Assert.assertEquals(salableProducts.get(i).getQuantity(), inventoryList.get(i).getQuantity());
		}
	}

	@After
	public void tearDown()
	{
		System.setOut(standardOut);
	}

}
