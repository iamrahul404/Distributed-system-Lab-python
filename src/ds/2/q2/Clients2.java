import java.net.*;
import java.io.*;
 
public class Clients2
{
    // initialize socket and input output streams
    private Socket socket            = null;
    private DataInputStream  input   = null;
    private DataOutputStream out     = null;
    private DataInputStream in= null;


 
    // constructor to put ip address and port
    public Clients2(String address, int port)
    {
        // establish a connection
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");
 
            // takes input from terminal
            input  = new DataInputStream(System.in);
 
            // sends output to the socket
            out    = new DataOutputStream(socket.getOutputStream());
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
 
        // string to read message from input
        String line = "";
 
        // keep reading until "Over" is input
	boolean flag=false;
	while(true)
	{
		try
		{
			line = in.readUTF();
												System.out.println(line);


			if(line.trim().equalsIgnoreCase("bye"))
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
                	line = input.readLine();
                	out.writeUTF(line);
			if(line.trim().equalsIgnoreCase("bye"))
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
        // close the connection
        try
        {
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
 
    public static void main(String args[])
    {
        Clients2 client = new Clients2("127.0.0.1", 15710);
    }
}