// File UDPServer.java

package s0828393;  

//import 
import java.net.*;
import javax.swing.JTextArea;

public class UDPServer implements Runnable{
	
	private Thread thread; 
	private int serverPort;
	private int packetSize;
	private DatagramSocket serverSocket;
	private JTextArea textarea;
	
	// Constructor
	public void startServer( int cServerPort, int cPacketSize, JTextArea jtx)throws Exception{
			serverPort = cServerPort;
			packetSize = cPacketSize;
			thread = new Thread(this);
			thread.start();
			//thread.join();
			if(jtx!=null){
				textarea = jtx;
				textarea.append("Server started ");
			}
			System.out.println("Server started\n");
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
					if(textarea!=null)
						textarea.append("Server localhost: Listenning on port "+serverPort+"\n");
					//System.out.println("Server "+IPAddress+": Listenning on port:"+port");
					serverSocket.receive(receivePacket);
					String sentence = new String(receivePacket.getData());
					//System.out.println(" "+sentence.substring(0, receivePacket.getLength()));

					if(textarea!=null)
						textarea.append("Packet received\n");
					
					String strHashData = new String(utilf.genMD5String(sentence.substring(0, receivePacket.getLength())));
					strHashData += "@#@";
					strHashData += String.valueOf(System.currentTimeMillis());

					byte[] hashData = strHashData.getBytes();
					InetAddress IPAddress = receivePacket.getAddress();
					int port = receivePacket.getPort();
					DatagramPacket sendPacket = new DatagramPacket (hashData , hashData.length, IPAddress, port);
					serverSocket.send(sendPacket);
					if(textarea!=null)
						textarea.append("Acknowledgement sent\n");
				}
			}
			catch(java.net.BindException b){}
		}catch(Exception e){}
	}


	public void stopServer() {
		try{
			//Thread.currentThread().interrupted();
			//thread.interrupted();
	        //thread.interrupt();
			if(textarea!=null){
				textarea.append(" "+this.serverSocket.isConnected()+"\n");
				//serverSocket.close();
				textarea.append("Server stopped\n");
			}
		}catch(Exception e){
			System.out.println("Exception :"+e);
		}
    }
	
	
	// main for testing class 
	public static void main(String[] args) throws Exception{
		UDPServer server = new UDPServer();
		server.startServer(7777, 1024, null);
		//server.stopServer();
	}

}
