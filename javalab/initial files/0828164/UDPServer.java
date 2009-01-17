package com.usma.udp;

//UDP Server
//Usage: java UDPServer [server port]
import java.net.*;

public class UDPServer {
	
	public void run( int serverPort, int packetSize)throws Exception{
		
		DatagramSocket serverSocket = new DatagramSocket (serverPort);
		byte[] receiveData = new byte[packetSize];
		
		while (true) {
			DatagramPacket receivePacket = new DatagramPacket (receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			int recievedPacketSize = receivePacket.getLength();
			System.out.println("size of packet"+receivePacket.getLength());
			//process data
			String sentence = new String(receivePacket.getData());
			
			System.out.println(sentence);
			System.out.println("size of file"+recievedPacketSize);

			InetAddress IPAddress = receivePacket.getAddress();
			System.out.println("IP ADd"+IPAddress.getHostAddress());
			int port = receivePacket.getPort();
			// construct datagram
			byte[] sendData = new byte[recievedPacketSize];
			sendData=sentence.getBytes();
			DatagramPacket sendPacket = new DatagramPacket (sendData, sendData.length, IPAddress, port);
			// send
			serverSocket.send(sendPacket);
			
		}
	}
	public static void main(String[] args) throws Exception{
	 new UDPServer().run(1540,2048);
		 // end of while
	} // end of main
} // end of UDPServer
