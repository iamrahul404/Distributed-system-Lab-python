
import java.net.*;

import java.io.*;


public class Servers
{

	private Socket socket = null;

	private ServerSocket server = null;

	private DataInputStream in= null;

	private Socket socket2 = null;

	private ServerSocket server2 = null;

	private DataInputStream in2= null;


	
	private DataOutputStream out= null;
	private DataOutputStream out2= null;

	public Servers(int port)
	
	{
		try
		
		{

			server = new ServerSocket(port);

			System.out.println("Server started");

					
			System.out.println("Waiting for client 1...");

			
			socket = server.accept();
	
			System.out.println("Client accepted");


			in = new DataInputStream(
new BufferedInputStream(socket.getInputStream()));


			out    = new DataOutputStream(socket.getOutputStream());
			
			
			System.out.println("Waiting for client 2...");

			
			socket2 = server.accept();

			System.out.println("Client 2 accepted");


			out2    = new DataOutputStream(socket2.getOutputStream());
			String line = "";




			in2 = new DataInputStream(
new BufferedInputStream(socket2.getInputStream()));


			String line2 = "";



			boolean flag=false;			
			while(true)
			{
				try

				{

					line = in.readUTF();
												System.out.println("Client 1 sent - "+line);

		
					out2.writeUTF("\t\t"+line);
					if(line.equalsIgnoreCase("bye"))
					{
						flag=true;
						break;
					}
				}

				catch(IOException i)

				{

					System.out.println(i);

				}


				try

				{

					line2 = in2.readUTF();
												System.out.println("Client 2 sent - "+line2);

		
					out.writeUTF("\t\t"+line2);
					if(line2.equalsIgnoreCase("bye"))
					{
						flag=true;
						break;
					}			
				}

				catch(IOException i)

				{
															System.out.println(i);

				}


				if(flag)
				break;
			}			
			System.out.println("Closing connection");


			socket.close();

			in.close();

		}

		catch(IOException i)

		{

			System.out.println(i);

		}

	}


	public static void main(String args[])

	{

		Servers server = new Servers(15710);

	}

}