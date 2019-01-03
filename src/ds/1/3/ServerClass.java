import java.net.*;
import java.io.*;

public class ServerClass
{
	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream in= null;
	private Socket socket2 = null;
	private ServerSocket server2 = null;
	private DataInputStream in2= null;
	private Socket socket3 = null;
	private ServerSocket server3 = null;
	private DataInputStream in3= null;
	private DataOutputStream out= null;
	private DataOutputStream out2= null;
	private DataOutputStream out3= null;
	public ServerClass(int port){
		try{
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
			in2 = new DataInputStream(
new BufferedInputStream(socket2.getInputStream()));
			System.out.println("Waiting for client 3...");
			socket3 = server.accept();
			System.out.println("Client 3 accepted");
			out3    = new DataOutputStream(socket3.getOutputStream());
			in3 = new DataInputStream(
new BufferedInputStream(socket3.getInputStream()));
			String line = "";
			String line2 = "";
			String line3 = "";
			try{
					line = in.readUTF();
					System.out.println(line);
					out2.writeUTF("Client 1 had sent \""+line+"\"");
				}catch(IOException i)
				{
					System.out.println(i);
				}
				try{
					line2 = in2.readUTF();
					System.out.println(line2);
					out3.writeUTF("Client 2 had sent \""+line2+"\"");							}
				catch(IOException i){
				System.out.println(i);
				}
				try{
				line3 = in3.readUTF();
				System.out.println(line3);
				out.writeUTF("Client 3 had sent \""+line3+"\"");					}
				catch(IOException i){
				System.out.println(i);
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
	public static void main(String args[]){
		ServerClass server = new ServerClass(15710);
	}
}