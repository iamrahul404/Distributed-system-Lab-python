import java.net.*;
import java.io.*;
 
public class Clients
{
    // initialize socket and input output streams
    private Socket socket            = null;
    private DataInputStream  input   = null;
    private DataOutputStream out     = null;
    private DataInputStream in= null;

 
    // constructor to put ip address and port
    public Clients(String address, int port)
    {
        // establish a connection
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");
 
            // takes input from terminal
            input  = new DataInputStream(System.in);
		in = new DataInputStream(
new BufferedInputStream(socket.getInputStream()));


 
            // sends output to the socket
            out    = new DataOutputStream(socket.getOutputStream());
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
	boolean flag=false;
	while(true)
	{
		try
		{
			System.out.println("Enter message");
			line = input.readLine();
        	out.writeUTF(line);
		}
	
		catch(IOException e)
		{
			System.out.println(e);
		}
 
 	        try

		{

			line = in.readUTF();

			if(line.equals("Goodbye"))
			{
				flag=true;
				System.out.println("\t\tServer Sent\n\t\t"+line);
				break;
			}
					
			if(!(line.equals("OK")||line.equals("Goodbye")))
			{
				flag=true;
				System.out.println("Wrong message received");
				break;									
				}

			System.out.println("\t\tServer Sent\n\t\t"+line);
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
        Clients client = new Clients("127.0.0.1", 15710);
    }
}
