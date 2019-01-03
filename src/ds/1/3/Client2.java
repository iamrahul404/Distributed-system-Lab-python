import java.net.*;
import java.io.*;
 
public class Client2
{
    // initialize socket and input output streams
    private Socket socket            = null;
    private DataInputStream  input   = null;
    private DataOutputStream out     = null;
    private DataInputStream in= null;


 
    // constructor to put ip address and port
    public Client2(String address, int port)
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
 
        try
		{
			line = in.readUTF();
									System.out.println(line);


		}
catch(IOException i)
            {
                System.out.println();
            }
            try
            {
                line = input.readLine();
                out.writeUTF(line);
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
		try
		{
			line = in.readUTF();
									System.out.println(line);


		}
catch(IOException i)
            {
                System.out.println();
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
        Client2 client = new Client2("127.0.0.1", 15710);
    }
}