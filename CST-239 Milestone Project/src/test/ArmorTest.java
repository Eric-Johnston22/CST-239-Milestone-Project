package test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Test;

import app.Armor;

/**
 * Test Armor class
 * @author Eric Johnston
 * @version 1.0
 */
public class ArmorTest
{
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@Test
	public void productDetailsTest()
	{
		Armor chainMail = new Armor("Elven chain Mail", "Delicately crafted from mithril links.", 22, 1, 7);
		System.setOut(new PrintStream(outputStreamCaptor));
		chainMail.productDetails();
		
		Assert.assertEquals("Name: Elven chain Mail\nDescription: Delicately crafted from mithril links."
				+ "\nPrice: 22 gold pieces\nQty: 1\nArmor class: 7", outputStreamCaptor.toString().trim());
		
		System.setOut(standardOut);
	}
	
	@Test
	public void setArmorClassTest() throws NoSuchFieldException, IllegalAccessException
	{
		Armor armor = new Armor();
		armor.setArmorClass(3);
		
		Field field = armor.getClass().getDeclaredField("armorClass");
		field.setAccessible(true);
		Assert.assertEquals("Fields didn't match", 3, field.get(armor));
	}
	
	@Test
	public void getArmorClassTest() throws NoSuchFieldException, IllegalAccessException
	{
		Armor armor = new Armor();
		Field field = armor.getClass().getDeclaredField("armorClass");
		field.setAccessible(true);
		field.set(armor, 3);
		
		int result = armor.getArmorClass();
		
		Assert.assertEquals("Field wasn't retrieved properly", 3, result);;
	}
}
