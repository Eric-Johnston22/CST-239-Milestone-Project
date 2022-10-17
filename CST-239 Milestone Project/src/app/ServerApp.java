package app;

/**
 * Implements serverapp
 * @author Eric Johnston
 * @version 1.0
 */
public class ServerApp
{

	public static void main(String[] args) throws InterruptedException
	{
		ServerThread serverThread = new ServerThread();
		
		serverThread.start();
		while(serverThread.isAlive())
		{
			System.out.println("\nServer running...\n");
			Thread.sleep(60000);
		}

	}

}
