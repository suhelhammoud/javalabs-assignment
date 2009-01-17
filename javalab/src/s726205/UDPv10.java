package s726205;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.BorderFactory;
import java.text.*;

//import com.cloudgarden.layout.AnchorLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.DatagramSocket;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;



/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class UDPv10 extends javax.swing.JFrame implements Runnable{
	private JTabbedPane tab;
	private JPanel client;
	private JButton StopServer;
	private JButton pickFile;
	private JTextArea ServerDisplay;
	private JButton ServerListen;
	private JTextField serverPort;
	private JTextField ServerIp;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel12;
	private JLabel jLabel11;
	private JTextArea ClientArea;
	private JButton Transfer;
	private JTextField Speed;
	private JTextField TransferTime;
	private JTextField PortNumber;
	private JTextField ServerIpAddress;
	private JTextField EndTime;
	private JTextField StartTime;
	private JTextField PacketSize;
	private JLabel jLabel10;
	private JLabel jLabel9;
	private JLabel jLabel8;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JTextField chooseFile;
	private JLabel jLabel1;
	private JPanel server;
	private JFileChooser PickFile;
	File TransmitFile = null;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args)  {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				UDPv10 inst = new UDPv10();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public UDPv10() {
		super();
		initGUI();
	}
	
	
	public synchronized void run()
	{
		
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("UDP Performance Analysis");
			{
				tab = new JTabbedPane();
				getContentPane().add(tab);
				tab.setBounds(12, 12, 796, 626);
				{
					server = new JPanel();
					tab.addTab("Server", null, server, null);
					server.setLayout(null);
					server.setPreferredSize(new java.awt.Dimension(791, 598));
					{
						jLabel2 = new JLabel();
						server.add(jLabel2);
						jLabel2.setText("Socket User Datagram Protocol (UDP) Receiver of  file");
						jLabel2.setFont(new java.awt.Font("Arial",1,12));
						jLabel2.setBounds(18, 12, 381, 27);
						jLabel2.setOpaque(true);
					}
					{
						jLabel11 = new JLabel();
						server.add(jLabel11);
						jLabel11.setText("Server IP address:");
						jLabel11.setBounds(18, 57, 113, 23);
						jLabel11.setFont(new java.awt.Font("Arial",0,12));
					}
					{
						jLabel12 = new JLabel();
						server.add(jLabel12);
						jLabel12.setText("Port:");
						jLabel12.setFont(new java.awt.Font("Arial",0,12));
						jLabel12.setBounds(463, 57, 36, 23);
					}
					{
						ServerIp = new JTextField();
						server.add(ServerIp);
						//
						InetAddress ipv4add = InetAddress.getLocalHost();
						String ipDisplay=ipv4add.getHostAddress()+" ("+ipv4add.getHostName()+")";
						ServerIp.setText(ipDisplay);
						//
						ServerIp.setBounds(131, 57, 232, 22);
					}
					{
						serverPort = new JTextField();
						server.add(serverPort);
						serverPort.setBounds(499, 57, 193, 22);
					}
					{
						ServerListen = new JButton();
						server.add(ServerListen);
						ServerListen.setText("Server ON");
						ServerListen.setBounds(25, 122, 113, 33);
						ServerListen.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								ServerListenMouseClicked(evt);
							}
						});
					}
					{
						StopServer = new JButton();
						server.add(StopServer);
						StopServer.setText("Server OFF");
						StopServer.setBounds(215, 122, 107, 33);
						StopServer.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								StopServerMouseClicked(evt);
							}
						});
					}
					{
						ServerDisplay = new JTextArea();
						ServerDisplay.setText("Server is off!");
						server.add(ServerDisplay);
						ServerDisplay.setBounds(25, 176, 740, 393);
					}
				}
				{
					client = new JPanel();
					tab.addTab("Client", null, client, null);
					client.setLayout(null);
					client.setPreferredSize(new java.awt.Dimension(787, 345));
					{
						jLabel1 = new JLabel();
						client.add(jLabel1);
						jLabel1.setText("Socket User Datagram Protocol (UDP) - File sender");
						jLabel1.setBounds(17, 12, 553, 25);
						jLabel1.setFont(new java.awt.Font("Arial",1,12));
					}
					{
						jLabel3 = new JLabel();
						client.add(jLabel3);
						jLabel3.setText("File to transfer:");
						jLabel3.setBounds(12, 55, 96, 25);
						jLabel3.setFont(new java.awt.Font("Arial",0,12));
					}
					{
						chooseFile = new JTextField();
						client.add(chooseFile);
						chooseFile.setBounds(107, 56, 193, 22);
					}
					{
						jLabel4 = new JLabel();
						client.add(jLabel4);
						jLabel4.setText("Packet Size:");
						jLabel4.setFont(new java.awt.Font("Arial",0,12));
						jLabel4.setBounds(12, 132, 96, 25);
					}
					{
						jLabel5 = new JLabel();
						client.add(jLabel5);
						jLabel5.setText("Server IP address:");
						jLabel5.setBounds(370, 56, 111, 22);
						jLabel5.setFont(new java.awt.Font("Arial",0,12));
					}
					{
						jLabel6 = new JLabel();
						client.add(jLabel6);
						jLabel6.setText("Port number:");
						jLabel6.setBounds(371, 132, 111, 22);
						jLabel6.setFont(new java.awt.Font("Arial",0,12));
					}
					{
						jLabel7 = new JLabel();
						client.add(jLabel7);
						jLabel7.setText("Start Time:");
						jLabel7.setFont(new java.awt.Font("Arial",0,12));
						jLabel7.setBounds(12, 186, 96, 25);
					}
					{
						jLabel8 = new JLabel();
						client.add(jLabel8);
						jLabel8.setText("End Time:");
						jLabel8.setFont(new java.awt.Font("Arial",0,12));
						jLabel8.setBounds(12, 231, 96, 25);
					}
					{
						jLabel9 = new JLabel();
						client.add(jLabel9);
						jLabel9.setText("Transfer Time:");
						jLabel9.setFont(new java.awt.Font("Arial",0,12));
						jLabel9.setBounds(371, 186, 96, 25);
					}
					{
						jLabel10 = new JLabel();
						client.add(jLabel10);
						jLabel10.setText("Speed:");
						jLabel10.setFont(new java.awt.Font("Arial",0,12));
						jLabel10.setBounds(371, 231, 96, 25);
					}
					{
						PacketSize = new JTextField();
						client.add(PacketSize);
						PacketSize.setBounds(108, 133, 192, 22);
					}
					{
						StartTime = new JTextField();
						client.add(StartTime);
						StartTime.setBounds(107, 187, 190, 22);
					}
					{
						EndTime = new JTextField();
						client.add(EndTime);
						EndTime.setBounds(107, 232, 190, 22);
					}
					{
						ServerIpAddress = new JTextField();
						client.add(ServerIpAddress);
						ServerIpAddress.setBounds(487, 56, 204, 22);
					}
					{
						PortNumber = new JTextField();
						client.add(PortNumber);
						PortNumber.setBounds(487, 132, 204, 22);
					}
					{
						TransferTime = new JTextField();
						client.add(TransferTime);
						TransferTime.setBounds(485, 187, 206, 22);
					}
					{
						Speed = new JTextField();
						client.add(Speed);
						Speed.setBounds(485, 232, 206, 22);
					}
					{
						Transfer = new JButton();
						client.add(Transfer);
						Transfer.setText("Begin Transfer");
						Transfer.setBounds(12, 288, 204, 25);
						Transfer.setFont(new java.awt.Font("Arial",0,12));
						Transfer.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								TransferMouseClicked(evt);
							}
						});
					}
					{
						ClientArea = new JTextArea();
						client.add(ClientArea);
						ClientArea.setText("No file selected");
						ClientArea.setBounds(12, 332, 758, 254);
						ClientArea.setFont(new java.awt.Font("Arial",0,12));
					}
					{
						pickFile = new JButton();
						client.add(pickFile);
						pickFile.setText("Pick File");
						pickFile.setBounds(184, 90, 114, 22);
						pickFile.setFont(new java.awt.Font("Arial",1,12));
						pickFile.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent evt) {
								pickFileMouseClicked(evt);
							}
						});
					}
					//client.setLayout(clientLayout);
				}
			}
			pack();
			this.setSize(844, 686);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void TransferMouseClicked(MouseEvent evt) 
	{
		
		
		Runnable s = new Runnable()
		{
			public void run()
			{
		
		
		ServerDisplay.setText("Server is on!");
		try {
			
			BeginTransfer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			}
		}; // end r
		Thread q = new Thread(s);
		q.start();
		
		
		
	}
	
	private void ServerListenMouseClicked(MouseEvent evt) 
	{
		
		Runnable r = new Runnable()
		{
			public void run()
			{
		
		
		
		try {
			ServerDisplay.setText("Server is on!");
			 
			activateServer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Server started!");
		//TODO add your code for ServerListen.mouseClicked
			}
		}; // end r
		Thread t = new Thread(r);
		t.start();
		
	}
	
	private void StopServerMouseClicked(MouseEvent evt) 
	{
		// Stop Server
		ServerDisplay.append("koko");
		System.out.println("Server Stopped!");
		//TODO add your code for StopServer.mouseClicked
		
	}
	
	private void activateServer() throws Exception
	{
		ServerListen.setEnabled(false);
        // Start Server
		ServerDisplay.append("Server listening...");
		int ServerPortNumber;
		String ServerIpAddressS;
		
		byte[] receiveData = new byte[100];
		byte[] receiveTrueData = new byte[10];
		 byte[] receiveSizeData = new byte[100];
		
		ServerPortNumber=Integer.parseInt(serverPort.getText());
		//ServerPortNumber=9876;
		ServerIpAddressS=ServerIp.getText();
		
		
		
		
		DatagramSocket SocketServer = new DatagramSocket(ServerPortNumber);
		 
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
			System.out.println("buffer size send :"+SocketServer.getSendBufferSize());
			System.out.println("buffer size receive:"+SocketServer.getReceiveBufferSize());
		   
	
		  int i=0;
		  
		  //*****
		  DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		  DatagramPacket receivePacket_file = new DatagramPacket(receiveSizeData, receiveSizeData.length);
		  SocketServer.receive(receivePacket);
		  
		  SocketServer.receive(receivePacket_file);
		  String formatPacketSize = new String(receivePacket.getData());
		  int packetsizes = Integer.parseInt(formatPacketSize);
		  long LongPacketSizes = Long.parseLong(formatPacketSize); //freshly added
		  System.out.println("packet size:"+packetsizes);
		  ServerDisplay.append("\n Client Packet size Syncronised at "+packetsizes+"bytes");
		  byte[] receiveNewData = new byte[packetsizes];
		  
		  
		
		  
		  String formatPacketFileSize = new String(receivePacket_file.getData());
		  //int fileSize = Integer.parseInt(formatPacketFileSize);
		  long fileSize_long = Long.parseLong(formatPacketFileSize);
		  System.out.println("file size:"+fileSize_long);
		  ServerDisplay.append("\n Client sending file of size: "+fileSize_long+" bytes");
		  //*****
		  
		  
		  //**********************Replies Client back*****************************
		  byte[] Sync_data_ServerToClient = new byte[4];
		  String reply;
		  reply="ack0";
		  Sync_data_ServerToClient=reply.getBytes();
		  InetAddress ClientIPAddress =  receivePacket.getAddress();
		  int ClientPort = receivePacket.getPort();
		  DatagramPacket sendPacket = new DatagramPacket(Sync_data_ServerToClient,Sync_data_ServerToClient.length,ClientIPAddress,ClientPort);
		  SocketServer.send(sendPacket);
		  System.out.println("Replying ack 0....");
		  ServerDisplay.append("\n Ack 0 : Ready to receive file...");
		  
		  
		  //**********************End Reply***************************************
		  SocketServer.setReceiveBufferSize(150000);
		  long tempLong=fileSize_long;
		  System.out.println(tempLong);
		  System.out.println(LongPacketSizes);
		  int setFlowControl=1;
		  long serverPacketCount=0;
		  while(tempLong>0)
		  {
			
		  DatagramPacket receivePacket2 = new DatagramPacket(receiveNewData, receiveNewData.length);
		  
			SocketServer.receive(receivePacket2);
			String ReceiveData = new String(receivePacket2.getData());
			serverPacketCount=serverPacketCount+1;
			
		  tempLong=tempLong-LongPacketSizes;
		  System.out.println(tempLong);

			System.out.println("buffer size send :"+SocketServer.getSendBufferSize());
			System.out.println("buffer size receive:"+SocketServer.getReceiveBufferSize());
			
			setFlowControl=setFlowControl+1;
			if(setFlowControl>100)
			{
				reply="ack5";
				Sync_data_ServerToClient=reply.getBytes();
				DatagramPacket sendPacket4 = new DatagramPacket(Sync_data_ServerToClient,Sync_data_ServerToClient.length,ClientIPAddress,ClientPort);
				SocketServer.send(sendPacket4);
				System.out.println("Ack5 - Packet acknowledgment");
				ServerDisplay.append("\n Ack5 sent "+serverPacketCount+" packet received");
				setFlowControl=1;
			}
			
			
		  } //end while
		 ////////
		  reply="ack9";
		  Sync_data_ServerToClient=reply.getBytes();
		  //InetAddress ClientIPAddress =  receivePacket.getAddress();
		  //int ClientPort = receivePacket.getPort();
		  DatagramPacket sendPacket3 = new DatagramPacket(Sync_data_ServerToClient,Sync_data_ServerToClient.length,ClientIPAddress,ClientPort);
		  SocketServer.send(sendPacket3);
		  System.out.println("Replying ack 9....");
		 
		  ServerDisplay.append("\n Total number of packets received:"+serverPacketCount);
		  ServerDisplay.append("\n ack9  File received!");
		 ////////
		
		  ServerListen.setEnabled(true);
		  SocketServer.close();
	} //end method activate server
	
	private void BeginTransfer() throws Exception
	{
		
		// UDP client program
		StartTime.setText("");
		EndTime.setText("");
		TransferTime.setText("");
		Speed.setText("");
		String ServerName_client= ServerIpAddress.getText();
		//System.out.println(ServerIpAddress.getText());
		int ClientPort_server=Integer.parseInt(PortNumber.getText());
		//System.out.println(PortNumber.getText());
		String ClientPacketSizeString = PacketSize.getText();
		int ClientPacketSizeInteger = Integer.parseInt(ClientPacketSizeString);
		long ClientPacketSizeLong = Long.parseLong(ClientPacketSizeString);
		//String dataToSend = "0000000010";
		
		//add trail to size
		long size;
		long value;
		long currentSize;
		size=100; //range should be always 10
		value=ClientPacketSizeInteger; //packet size for future packets //previously 10
		String dataToSend;
		dataToSend=Long.toString(value);
		currentSize=dataToSend.length();
		while(currentSize != size)
		{
			dataToSend="0"+dataToSend;
			currentSize=dataToSend.length();
		}
		
		
		
		//***
		
		
		// new send length of file
		long SizeofTransmitFile = TransmitFile.length();
		long sendsize=SizeofTransmitFile;
		String sendsize2 = Long.toString(sendsize);
		long size2=100; //should always be 100
		long currentSize2 = sendsize2.length();
		while(currentSize2!=size2)
		{
			sendsize2="0"+sendsize2;
			currentSize2=sendsize2.length();
		}
		
		
		
		//end new send length of file
		
		
		
		
		//System.out.println(chooseFile.getText());
		byte[] ClientToSend = new byte[100];  //packet size for packet synchronisation
		byte[] ClientToSend1 = new byte[100]; //packet size for file size transfer
		
	    ClientToSend = dataToSend.getBytes();

	    ClientToSend1 = sendsize2.getBytes();
	 
        String temp = null;
        int packetSize;
        long LongpacketSize;
        int start=0;
        int end=0;
        String restHold;
        long counter=0;
        packetSize=ClientPacketSizeInteger;
        LongpacketSize=ClientPacketSizeLong;
        long hold=SizeofTransmitFile;
        String cohold;
        int cohold2;
		//end new code
        
		
			InetAddress serverIPAddress_real = InetAddress.getByName(ServerName_client);
			//***********************************
				
					DatagramSocket clientSockets = new DatagramSocket();
					clientSockets.setSendBufferSize(64000);
					//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
					System.out.println("buffer size send :"+clientSockets.getSendBufferSize());
					System.out.println("buffer size receive:"+clientSockets.getReceiveBufferSize());
					//ClientToSend.length
					
					byte[] ClientToSend2 = new byte[ClientPacketSizeInteger]; //packet size for file transfer
					
					DatagramPacket ClientSendPacket = new DatagramPacket(ClientToSend, ClientToSend.length, serverIPAddress_real,ClientPort_server);
					DatagramPacket ClientSendPacket1 = new DatagramPacket(ClientToSend1, ClientToSend1.length, serverIPAddress_real,ClientPort_server);
					DatagramPacket ClientSendPacket2 = new DatagramPacket(ClientToSend2, ClientToSend2.length, serverIPAddress_real,ClientPort_server);
					System.out.println("datagram set");
					//ClientSendPacket.
					
					
						//new code 3
						Date endT;
						Date beginT;
						String result;
						SimpleDateFormat formatter;
						formatter = new SimpleDateFormat("HH:mm:ss:SSS");
						beginT = new Date();
						long beginTx = System.currentTimeMillis();
						result = formatter.format(beginT);
						StartTime.setText(result);
						//end code 3
						
						
						//long xtime = System.currentTimeMillis();
						// Send packet size
						ClientArea.append("\n Sending Packet Size:"+ClientPacketSizeInteger+"bytes");
						ClientArea.append("\n Sending File Size:"+SizeofTransmitFile+"bytes");
						clientSockets.send(ClientSendPacket);
						ClientSendPacket.setData(ClientToSend1);
						clientSockets.send(ClientSendPacket);
						
						
					
						
				        // new receive response from server
						byte[] AckResponseFromServer = new byte[4];
						DatagramPacket receivePacket0 = new DatagramPacket(AckResponseFromServer, AckResponseFromServer.length);
						clientSockets.receive(receivePacket0);
						String displayFromServer = new String(receivePacket0.getData());
						ClientArea.append("\n "+displayFromServer);
						
						
						
						//*** latest ***//
						ClientArea.append("\n "+"Synchronized! Sending "+TransmitFile.getPath());
						long localfile=TransmitFile.length();
						System.out.println(" "+localfile);
						FileInputStream fin;
					    long TTx;
						long RRx;
						try{
							fin=new FileInputStream(TransmitFile);
							byte[] datax=new byte[packetSize];
							String str;
							int FlowControl=1;
							long clientNumberPacketsx=0;
							
							while (localfile >0)
							{
								fin.read(datax);
								//myarea.append(new String(data));
								localfile=localfile-LongpacketSize;
								System.out.println(localfile);
								ClientToSend2 = datax;
								ClientSendPacket2.setData(ClientToSend2);
								TTx = System.currentTimeMillis();
								clientSockets.send(ClientSendPacket2);
								RRx = System.currentTimeMillis();
								clientNumberPacketsx=clientNumberPacketsx+1;
								
								
								
								FlowControl=FlowControl+1;
								if(FlowControl>300)
								{
									DatagramPacket receivePacket4 = new DatagramPacket(AckResponseFromServer, AckResponseFromServer.length);
									clientSockets.receive(receivePacket4);
									displayFromServer = new String(receivePacket4.getData());
									ClientArea.append("\n"+displayFromServer+"Data Acknowledge from server");
									FlowControl=1;
								}
								
								//System.out.println(new String(datax));
								//txt.append(new String(data));
							}
							ClientArea.append("\n "+"Total packets sent:"+clientNumberPacketsx);
							fin.close();
						}catch (IOException ioe){
							ioe.printStackTrace();
						}
						//***        ***//
						
						
						
					   //new code 4
						
					    endT = new Date();
					    long endTx = System.currentTimeMillis();
						result = formatter.format(endT);
						EndTime.setText(result);
						beginTx=endTx-beginTx;
						TransferTime.setText(" "+beginTx+"ms");
						
						
						
						float alfa=Float.parseFloat(Long.toString(beginTx));
						float beta=Float.parseFloat(Long.toString(SizeofTransmitFile));
					    float speed = beta /(alfa/1000);
						System.out.println(speed);
						System.out.println(alfa);
						System.out.println(beta);
						Speed.setText(speed+" bytes/s");
					    //end code 4
						
						
						//wait for final reply
						// new receive response from server
						
						//DatagramPacket receivePacket3 = new DatagramPacket(AckResponseFromServer, AckResponseFromServer.length);
						//clientSockets.receive(receivePacket3);
						//displayFromServer = new String(receivePacket3.getData());
						//ClientArea.append("\n"+displayFromServer+"Tranmission Terminated!");
						
						
						// end receive response from server
						//end wait
						
						clientSockets.close();
					
		
		
	} //End begin Transfer
	
	private void pickFileMouseClicked(MouseEvent evt) 
	{
		//Choose a file to transfer
		JFileChooser PickFile = new JFileChooser();
		int returnVal = PickFile.showOpenDialog(this);
		if(returnVal != JFileChooser.APPROVE_OPTION) return ;
		TransmitFile= PickFile.getSelectedFile();
		chooseFile.setText(PickFile.getSelectedFile().getPath());
	}

}



