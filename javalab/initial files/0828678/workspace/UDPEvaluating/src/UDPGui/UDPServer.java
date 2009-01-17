// File UDPServer.java

package UDPGui;  

//import 
import java.net.*;
import javax.swing.JTextArea;

public class UDPServer implements Runnable{
	
	Thread thread; 
	int serverPort;
	int packetSize;
	DatagramSocket serverSocket;
	String outBuffer;
	Application app = new Application();
	JTextArea jtx  = app.getJTextArea1();
	
	// Constructor
	public void startServer( int cServerPort, int cPacketSize)throws Exception{
			outBuffer = new String();
			serverPort = cServerPort;
			packetSize = cPacketSize;
			thread = new Thread(this);
			thread.start();
			System.out.println("Server started");
    }

	// thread run for starting Server 
	public void run(){
		try{
			UDPUtil utilf = new UDPUtil();
			//String hashData = new String();
			
			byte[] receiveData = new byte[packetSize];
			serverSocket = new DatagramSocket(serverPort);
			try{
				while (true){
					DatagramPacket receivePacket = new DatagramPacket (receiveData, receiveData.length);
					jtx.append("Server localhost: Listenning on port "+serverPort+"\r\n");
					//System.out.println("Server "+IPAddress+": Listenning on port:"+port");
					serverSocket.receive(receivePacket);
					String sentence = new String(receivePacket.getData());
					System.out.println(" "+sentence.substring(0, receivePacket.getLength()));
					jtx.append("Packet received\r\n");
					
					String strHashData = new String(utilf.genMD5String(sentence.substring(0, receivePacket.getLength())));
					strHashData += "@#@";
					strHashData += String.valueOf(System.currentTimeMillis());

					byte[] hashData = strHashData.getBytes();
					InetAddress IPAddress = receivePacket.getAddress();
					int port = receivePacket.getPort();
					DatagramPacket sendPacket = new DatagramPacket (hashData , hashData.length, IPAddress, port);
					serverSocket.send(sendPacket);
					jtx.append("Acknowledgement sent\r\n");
				}
			}
			catch(java.net.BindException b){}
		}catch(Exception e){}
	}


	public void stopServer() {
        thread.interrupt();
        serverSocket.close();
		jtx.append("Server stopped\r\n");
    }
	
	
	// main for testing class 
	public static void main(String[] args) throws Exception{
		UDPServer server = new UDPServer();
		server.startServer(7777, 1024);
		//server.stopServer();
	}

}
