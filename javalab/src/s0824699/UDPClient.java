package s0824699;

//Usage: java UDPClient [server addr] [server port]
import java.io.*;
import java.net.*;
public class UDPClient {

	public DatagramSocket sendFile(FileInputStream fin, String serverName, int serverPort, int packetSize)
	throws Exception{

		// create socket
		DatagramSocket clientSocket = new DatagramSocket ();
		// get server port
		InetAddress serverIPAddress = InetAddress.getByName(serverName);
				
		// get input from keyboard
		byte[] sendData = new byte[packetSize];
		//System.out.println(fileName);

		//FileInputStream fin= new FileInputStream(fileName);

		//char[] arrChar=new char[1024];
		while( fin.read(sendData) >0){
		
			System.out.println(new String(sendData));
			
			DatagramPacket sendPacket = new DatagramPacket (sendData, sendData.length, serverIPAddress, serverPort);
			clientSocket.send(sendPacket);
		}
		//close client socket
		clientSocket.close();
		return clientSocket;
	}

	//public static void main(String[] args)throws Exception {
	//	new UDPClient().sendFile("d://test.txt", "localhost", 1979, 1024);
	//} // end of main
} // end of UDPClient

