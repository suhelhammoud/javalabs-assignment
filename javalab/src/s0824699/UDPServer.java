package s0824699;

//UDP Server
//Usage: java UDPServer [server port]
import java.net.*;

public class UDPServer
	{
	private int serverport = 9876;
	 public void run( int serverPort, int packetSize)throws Exception{
		
		DatagramSocket serverSocket = new DatagramSocket (serverport);
		byte[] receiveData = new byte[1024];
		//byte[] sendData = new byte[1024];
		while (true) {
			DatagramPacket receivePacket = new DatagramPacket (receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			//process data
			String sentence = new String(receivePacket.getData());
			
			System.out.println(sentence);
			/* InetAddress IPAddress = receivePacket.getAddress(); 
			 int port = receivePacket.getPort(); 
			 DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,port); 
			 serverSocket.send(sendPacket); */
					}
	 }
	//public static void main(String[] args) throws Exception{
		//  run (9876,1024);

	//}
public void run(DatagramSocket serverSocket) {
		// TODO Auto-generated method stub
	
	}
	 
		 // end of while
	//} // end of main
} // end of UDPServer

