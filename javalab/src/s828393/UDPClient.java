// File UDPClient.java
package s828393;

//import
import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.Date;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;

import javax.swing.JTextArea;

public class UDPClient{ 

	public DatagramSocket clientSocket;
	protected Thread sendThread, recThread; 
	protected UDPUtil utilf;
	int currTimeout = 0, recIndex = 0;
	private int socket_timeout_value=5000;
	
	protected String inputHashData[][];
	protected String receivedHashData[][];
	protected int hashDataSize=0;
	
	protected String fileName;
	protected int fileSize=0;
	protected InetAddress serverHostName;
	protected int serverPort;
	protected int sendDataPacketSize;
	protected boolean flagSenddataFinished = false; 

	private double totalTime=0;
	private double speed;
	private String startTime;
	private String endTime;
	private JTextArea textarea;

	public String getTotalTime() { return String.valueOf(totalTime); }
	public String getSpeed() { return String.valueOf(speed); }
	public String getStartTime() { return startTime; }
	public String getEndTime() { return endTime; }
	
	// client socket send function 
	public DatagramSocket sendFile(String fileName, String serverAddress, int port, int packetSize, JTextArea jtx)
	throws Exception{
		if(jtx!=null){
			textarea = jtx;
		}
		this.fileName = fileName;
		this.serverHostName = InetAddress.getByName(serverAddress);
		this.serverPort = port;
		this.sendDataPacketSize = packetSize;
		utilf = new UDPUtil();
		
		clientSocket = new DatagramSocket();
		clientSocket.setSoTimeout(socket_timeout_value);
		{
			
			new sendData();
			sendThread.join();

			new receiveData();
			clientSocket.close();
		}	
		
		generateStatistics();
		
		return clientSocket;
	}

	public void setTimeout(int sTimeout)
	{
		socket_timeout_value = sTimeout;
	}
	
	private class sendData implements Runnable{
	
		public sendData() {
			try{
				sendThread = new Thread(this);
				sendThread.start();
			}catch(Exception e){}
		}
	
		public void run()
		{
			try {
				Thread.sleep(1);
				int numRead=0, i=0;
				FileInputStream inFile = new FileInputStream(fileName);
				byte[] sendData = new byte[sendDataPacketSize];
				fileSize =  inFile.available();
				
				hashDataSize =  (fileSize/sendDataPacketSize)+1;
				inputHashData = new String[2][hashDataSize];  

				if(textarea!=null){
					textarea.append("Client sending data\n");
				}
		
				while((numRead = inFile.read(sendData)) !=-1 ){
					inputHashData[0][i] = utilf.genMD5String(new String(sendData));
					inputHashData[1][i] = String.valueOf(System.currentTimeMillis());	
				
					//System.out.println("Client: sending data"+serverHostName+" port: "+serverPort);

					DatagramPacket sendPacket = new DatagramPacket (sendData, numRead, serverHostName, serverPort);
					if(textarea!=null){
						textarea.append("Sending packet:"+i+"\n");
					}

					clientSocket.send(sendPacket);
					//System.out.println("i:"+i);
					i++;
				}
				inFile.close();
				flagSenddataFinished = true;
			}catch(Exception e) {
				System.out.println("Exception : "+e);
			}
		}
	}
	
	private class receiveData {
		
		public receiveData() {
			try {
				recIndex = 0;
				byte[] receiveData = new byte[100];
				receivedHashData = new String[2][hashDataSize];

				if(textarea!=null){
					textarea.append("Client receiving data");
				}
				
				while(recIndex < hashDataSize){
					try{
						DatagramPacket receivePacket = new DatagramPacket (receiveData, receiveData.length);
						if(textarea!=null){
							textarea.append("Received packet:"+recIndex+"\n");
						}
						clientSocket.receive(receivePacket);
	
						//System.out.println("Client: receiving data \nindex"+recIndex);
						
						String sentence = new String(receivePacket.getData());
						//System.out.println(" "+sentence.substring(0, receivePacket.getLength()));
						
						int pos = sentence.indexOf("@#@");
						receivedHashData[0][recIndex] = sentence.substring(0, pos);
						receivedHashData[1][recIndex] = sentence.substring(pos+3 , receivePacket.getLength());
						recIndex++;
					}catch (InterruptedIOException iioe)
					{
						System.out.println ("Timeout occurred - killing connection");
						clientSocket.close();
					}
				}	
				
			}catch(Exception e) {}
		}
	}
	
	public void generateStatistics() throws Exception
	{
		int numpacketReceived = 0;
		//DateFormat dfm = new SimpleDateFormat("HH:mm:ss");
		
		if(textarea!=null){
			textarea.append("\nWait calaculating statistics");
		}

		for(int i=0; i<recIndex; i++){
			if(Arrays.binarySearch(this.inputHashData[0], this.receivedHashData[0][i])>0){
				if(textarea!=null){
					textarea.append(".");
				}
				numpacketReceived++;
				totalTime += Long.parseLong(receivedHashData[1][i]) - Long.parseLong(inputHashData[1][i]);
			}
		}

		speed = ((fileSize * 1000) / totalTime);
		
		Date start = new Date(Long.parseLong(inputHashData[1][0]));
		//System.out.println(""+start.getHours()+":"+start.getMinutes()+":"+start.getSeconds());
		startTime = "";
		startTime += start.getHours();
		startTime += ":";
		startTime += start.getMinutes();
		startTime += ":";
		startTime += start.getSeconds();
		

		Date end = new Date(Long.parseLong(receivedHashData[1][recIndex-1]));
		endTime = "";
		endTime += end.getHours();
		endTime += ":";
		endTime += end.getMinutes();
		endTime += ":";
		endTime += end.getSeconds();
		
		//endTime = dfm.parse((new Date(Long.parseLong(receivedHashData[1][recIndex])).toString())).toString();
		
		//System.out.println("recIndex:"+recIndex+"speed : "+speed+" startTime: "+startTime+"endTime: "+endTime);
	}
	
	
	// main for testing class	
	public static void main(String[] args)throws Exception {
		new UDPClient().sendFile("Assets/test", "localhost", 7777, 1024, null);
	} 

}


