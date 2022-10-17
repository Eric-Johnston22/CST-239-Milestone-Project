package app;

import java.io.IOException;

/**
 * Creates a server thread
 * @author Eric Johnston
 * @version 1.0
 */
public class ServerThread extends Thread
{
	public void run()
	{
		AdminService server = new AdminService();
		try
		{
			server.start(6666);
			//server.cleanup();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
