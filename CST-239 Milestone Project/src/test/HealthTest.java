package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Test;

import app.Health;
import app.Health;

/**
 * Test Health class
 * @author Eric Johnston
 * @version 1.0
 */
public class HealthTest
{

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@Test
	public void productDetailsTest()
	{
		Health minorPotion = new Health("Minor Healing Potion", "A healing draught with a bitter taste.", 1, 20, 2);
		System.setOut(new PrintStream(outputStreamCaptor));
		minorPotion.productDetails();
		
		Assert.assertEquals("Name: Minor Healing Potion\nDescription: A healing draught with a bitter taste."
				+ "\nPrice: 1 gold pieces\nQty: 20\nHeal: 2", outputStreamCaptor.toString().trim());
		
		System.setOut(standardOut);
	}
	
	@Test
	public void setHealTest() throws NoSuchFieldException, IllegalAccessException
	{
		Health health = new Health();
		health.setHeal(3);

		Field field = health.getClass().getDeclaredField("heal");
		field.setAccessible(true);
		Assert.assertEquals("Fields didn't match", 3, field.get(health));
	}

	@Test
	public void getHealTest() throws NoSuchFieldException, IllegalAccessException
	{
		Health health = new Health();
		Field field = health.getClass().getDeclaredField("heal");
		field.setAccessible(true);
		field.set(health, 3);

		int result = health.getHeal();

		Assert.assertEquals("Field wasn't retrieved properly", 3, result);
		;
	}

}
