package app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Implement FileService that allows writing to and reading from json files
 * @author Eric Johnston
 * @version 0.8
 */
public class FileService 
{
	public FileService()
	{
		
	}
	
	/**
	 * Save object to a json file.
	 * @param filename String
	 * @param product SalableProduct type
	 * @param append Boolean
	 */
	public void saveToFile(String filename, SalableProduct product, boolean append)
	{
		PrintWriter pw;
		
		try
		{
			//Create a file File to write
			File file = new File(filename);
			FileWriter fw = new FileWriter(file, append);
			pw = new PrintWriter(fw);
			
			//Write Car is JSON
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(product);
			pw.println(json);
			
			pw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Read file and store contents in an ArrayList of type SalableProduct
	 * @param filename String
	 * @return ArrayList of type SalableProduct
	 */
	public ArrayList<SalableProduct> readFromFile(String filename)
	{
		ArrayList<SalableProduct> SalableProducts = new ArrayList<SalableProduct>();
		
		try
		{
			// Open the file File to read
			File file = new File(filename);
			Scanner s = new Scanner(file);
			
			while(s.hasNext())
			{
				String json = s.nextLine();
				ObjectMapper objectMapper = new ObjectMapper();
				SalableProduct product = objectMapper.readValue(json, SalableProduct.class);
				SalableProducts.add(product);
			}
			System.out.println("Creating objects from products.json");
			s.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return SalableProducts;
	}
}
