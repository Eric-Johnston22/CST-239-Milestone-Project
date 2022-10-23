package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import app.SalableProduct;
import app.ShoppingCart;
import app.Weapon;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Assert;

public class ShoppingCartTest
{
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@Before
	public void init()
	{
		System.setOut(new PrintStream(outputStreamCaptor));
	}
	
	@Test
	public void addProductTest()
	{
		ShoppingCart cart = new ShoppingCart();
		Weapon sword = new Weapon("Short Sword", "A simple sword. It doesn't look very sharp...", 3, 2, 2);
		cart.addProduct(sword);
		
		Assert.assertEquals("Adding Short Sword to cart", outputStreamCaptor.toString().trim());
	}
	
	@Test
	public void removeProductTest()
	{
		ShoppingCart cart = new ShoppingCart();
		Weapon sword = new Weapon("Short Sword", "A simple sword. It doesn't look very sharp...", 3, 2, 2);
		cart.removeProduct(sword);
		
		Assert.assertEquals("Removing Short Sword from cart", outputStreamCaptor.toString().trim());
	}
	
	@Test
	public void checkCart()
	{
		ShoppingCart cart = new ShoppingCart();
		ArrayList<SalableProduct> salableProducts = new ArrayList<SalableProduct>();
		Weapon sword = new Weapon("Short Sword", "A simple sword. It doesn't look very sharp...", 3, 2, 2);
		salableProducts.add(sword);
		
		StringWriter expectedStringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(expectedStringWriter);
		String s = "Short Sword - Price: 3 gold pieces\r\n\r\nCart total: 3 gold pieces";
		cart.checkCart(salableProducts);
		
		//Assert.assertEquals(s, outputStreamCaptor.toString().trim().replace("\n", ""));
		TestCase.assertEquals(s, outputStreamCaptor.toString().trim());
	}
	@After
	public void tearDown()
	{
		System.setOut(standardOut);
	}

}
