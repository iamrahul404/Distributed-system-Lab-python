
import java.net.*;

import java.io.*;


public class Servers
{

	private Socket socket = null;

	private ServerSocket server = null;

	private DataInputStream in= null;
	private DataOutputStream out= null;
	private DataInputStream  input   = null;

	public Servers(int port)
	
	{
		try
		
		{

			server = new ServerSocket(port);

			System.out.println("Server started");

	
			System.out.println("Waiting for a client ...");

			
			socket = server.accept();
	
			System.out.println("Client accepted");


			input  = new DataInputStream(System.in);
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(
new BufferedInputStream(socket.getInputStream()));
		}

		catch(UnknownHostException u)
        	{
            		System.out.println(u);
        	}
        	catch(IOException i)
        	{
            	System.out.println(i);
        	}

		

		String inline = "",outline="";


		boolean flag=false;
		while(true)
		{
			try

			{
	
			inline = in.readUTF();
	
				System.out.println(inline);
				if(inline.equalsIgnoreCase("bye"))										{
					flag=true;
					outline="Goodbye";
					out.writeUTF(outline);
					break;
				}
				else
				outline="OK";
			}

			catch(IOException i)

			{

				System.out.println(i);
			}

			try
        	    	{
                		out.writeUTF(outline);
            		}
            		catch(IOException i)
            		{
                		System.out.println(i);
            		}
			if(flag)
			break;
		}
		
		try
		{	
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
