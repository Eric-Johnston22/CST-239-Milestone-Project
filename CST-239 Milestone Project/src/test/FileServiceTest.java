package test;

import org.junit.Assert;

import java.io.File;

import org.junit.Test;

import app.Armor;
import app.FileService;
import app.SalableProduct;
import app.Weapon;

/**
 * Test FileService class
 * @author Eric Johnston
 * @version
 */
public class FileServiceTest
{

	@Test
	public void saveToFileTest()
	{
		FileService fileService = new FileService();
		SalableProduct[] products = new SalableProduct[3];
		products[0] = new Armor("Manaweave Robe", "A glimmering robe of fine cloth.", 8, 1, 1);
		products[1] = new Armor("Thorium Armor", "Nearly impenetrable plate armor of dwarven make.", 28, 1, 10);
		products[2] = new Weapon("Sturdy Recurve Bow", "A sturdy bow fashioned from yew.", 10, 2, 12);
		
		for (int i = 0; i <= 2; i++)
		{
			fileService.saveToFile("test.json", products[i], true);
		}
		
		File f = new File("test.json");
		Assert.assertEquals(true, f.exists());
	}

}
