package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * Implements AdminService as a server
 * @author Eric Johnston
 * @version 1.0
 */
public class AdminService
{
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;

	FileService fileService = new FileService();

	/**
	 * Starts server
	 * 
	 * @param port
	 * @throws IOException
	 */
	public void start(int port) throws IOException
	{
		System.out.println("Waiting for a client connection...");
		serverSocket = new ServerSocket(port);
		
		// Keep server open to receive new commands
		while (true)
		{
			clientSocket = serverSocket.accept();

			SalableProduct[] products = new SalableProduct[3];
			products[0] = new Armor("Manaweave Robe", "A glimmering robe of fine cloth.", 8, 1, 1);
			products[1] = new Armor("Thorium Armor", "Nearly impenetrable plate armor of dwarven make.", 28, 1, 10);
			products[2] = new Weapon("Sturdy Recurve Bow", "A sturdy bow fashioned from yew.", 10, 2, 12);

			System.out.println("Recieved a client connection on port " + clientSocket.getLocalPort() + "\n");
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			String inputLine = in.readLine();

			// If inputLine is U, update inventory.
			if (inputLine.equals("U"))
			{
				System.out.println("Got a message to update inventory with new products\n");
				out.println("Successfully updated inventory with new products");
				for (int i = 0; i <= 2; i++)
				{
					fileService.saveToFile("products.json", products[i], true);
				}
			}
			//If inputLine is R, 
			if (inputLine.equals("R"))
			{
				System.out.println("Got a message to return inventory in JSON format\n");

				//List to hold JSON objects
				ArrayList<SalableProduct> SalableProducts = new ArrayList<SalableProduct>();
				SalableProducts = fileService.readFromFile("products.json");
				String s = "";
				for (SalableProduct product : SalableProducts)
				{
					s = "name: " + product.getName() + " description: " + product.getDescription()
							+ " price: " + product.getPrice() + " quantity: " + product.getQuantity();
				}
				out.println(s);
			}
		}
	}

	/**
	 * Closes I/O and client and server socket
	 * 
	 * @throws IOException
	 */
	public void cleanup() throws IOException
	{
		in.close();
		out.close();
		clientSocket.close();
		serverSocket.close();
	}

	public static void main(String[] args) throws IOException
	{
		AdminService server = new AdminService();
		server.start(6666);
		server.cleanup();
	}
}
