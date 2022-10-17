package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Implements an Administration console app that connects to server
 * @author Eric Johnston
 * @version 1.0
 */
public class AdminApp
{
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;

	/**
	 * Starts client connection
	 * 
	 * @param ip
	 * @param port
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public void start(String ip, int port) throws UnknownHostException, IOException
	{
		clientSocket = new Socket(ip, port);

		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	}

	/**
	 * Sends message as a string
	 * 
	 * @param msg
	 * @return string
	 * @throws IOException
	 */
	public String sendMessage(String msg) throws IOException
	{
		out.println(msg);

		return in.readLine();
	}

	/**
	 * Close I/O and socket
	 * 
	 * @throws IOException
	 */
	public void cleanup() throws IOException
	{
		in.close();
		out.close();
		clientSocket.close();
	}

	/**
	 * Allows user to send input to servers
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public static void userSelection() throws UnknownHostException, IOException
	{
		AdminApp client = new AdminApp();
		client.start("127.0.0.1", 6666);
		String response;

		System.out.println("ADMIN APPLICATION\nU. Update inventory\nR. Display inventory");
		Scanner newInput = new Scanner(System.in);
		String purchase = newInput.next();

		response = client.sendMessage(purchase);
		System.out.println("Server response:\n" + response);
		
		newInput.close();
		//client.cleanup();
	}

	public static void main(String[] args) throws IOException, InterruptedException
	{
		userSelection();
	}
}
