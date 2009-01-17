package udpPackage;
import udpPackage.udpClient;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
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
public class udpServer extends javax.swing.JFrame {
	

	private JPanel panelSvrMethod;
	private JRadioButton rdBtnSvrTCPSocket;
	private JRadioButton rdBtnSvrRMI;
	private JPanel panelSvrServerProp;
	private JLabel labelSvrIP;
	private JPanel panelListen;
	private JTextField txtPacketSize;
	private JLabel labelPacketSize;
	private JScrollPane displayScroll;
	private JTextArea displayArea;
	private JButton btnStopListen;
	private JButton btnStartListen;
	private JTextField txtSvrPort;
	private JLabel labelSvrPort;
	private JTextField txtSvrIP;
	private JRadioButton rdBtnSvrUDPSocket;
	
	DatagramSocket serverSocket ;
	boolean exitLoop=false;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				udpServer inst = new udpServer();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public void listen(){
		
		displayArea.append("Server is started\n");
		displayArea.append("Server is listening\n");
		
		try{
			
		
		
		String serverPort = txtSvrPort.getText();
		int port = Integer.parseInt(serverPort);
		
		String size = txtPacketSize.getText();
		int packetSize = Integer.parseInt(size);
		
		 	
		//create server datagram socket
		
		serverSocket = new DatagramSocket(port);
				
		byte[] receiveData = new byte[packetSize];
		byte[] sendData = new byte[packetSize];
		
		
		while(! exitLoop){
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			
			//process data
			//String sentence = new String(receivePacket.getData());
			//String capitalizedSentence = sentence.toUpperCase();
			//sendData = capitalizedSentence.getBytes();
			
			
			//determine client address and port
			InetAddress clientIPAddress = receivePacket.getAddress();
			int clientPort = receivePacket.getPort();
			
			//construct datagram
			String message = "The server received the file";
			sendData = message.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIPAddress, clientPort);
			
			//send
			serverSocket.send(sendPacket);
			
		}
				
	}catch (IOException io){
		io.printStackTrace();
		displayArea.append("Server failed to listen");
	}
	}
	
	public udpServer() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("UDP File Transfer - Server");
			this.addComponentListener(new ComponentAdapter() {
				public void componentHidden(ComponentEvent evt) {
					
				}
			});
			{
				panelSvrMethod = new JPanel();
				getContentPane().add(panelSvrMethod);
				panelSvrMethod.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED), "Methods:", TitledBorder.LEADING, TitledBorder.TOP));
				panelSvrMethod.setLayout(null);
				panelSvrMethod.setBounds(0, 0, 316, 87);
				{
					rdBtnSvrTCPSocket = new JRadioButton();
					panelSvrMethod.add(rdBtnSvrTCPSocket);
					rdBtnSvrTCPSocket.setText("TCP Socket");
					rdBtnSvrTCPSocket.setFont(new java.awt.Font("Verdana",0,9));
					rdBtnSvrTCPSocket.setBounds(10, 25, 139, 17);
				}
				{
					rdBtnSvrUDPSocket = new JRadioButton();
					panelSvrMethod.add(rdBtnSvrUDPSocket);
					rdBtnSvrUDPSocket.setText("UDP Socket");
					rdBtnSvrUDPSocket.setFont(new java.awt.Font("Verdana",0,9));
					rdBtnSvrUDPSocket.setBounds(181, 25, 118, 17);
				}
				{
					rdBtnSvrRMI = new JRadioButton();
					panelSvrMethod.add(rdBtnSvrRMI);
					rdBtnSvrRMI.setText("RMI (registry 14445)");
					rdBtnSvrRMI.setFont(new java.awt.Font("Verdana",0,9));
					rdBtnSvrRMI.setBounds(83, 49, 178, 20);
				}
			}
			{
				panelSvrServerProp = new JPanel();
				getContentPane().add(panelSvrServerProp);
				panelSvrServerProp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),"Server IP and Port",TitledBorder.LEADING,TitledBorder.TOP));
				panelSvrServerProp.setLayout(null);
				panelSvrServerProp.setBounds(0, 87, 316, 116);
				{
					labelSvrIP = new JLabel();
					panelSvrServerProp.add(labelSvrIP);
					labelSvrIP.setText("Server IP:");
					labelSvrIP.setFont(new java.awt.Font("Verdana",0,9));
					labelSvrIP.setBounds(34, 29, 63, 14);
				}
				{
					txtSvrIP = new JTextField();
					panelSvrServerProp.add(txtSvrIP);
					txtSvrIP.setFont(new java.awt.Font("Verdana",0,9));
					txtSvrIP.setBounds(144, 28, 147, 20);
				}
				{
					labelSvrPort = new JLabel();
					panelSvrServerProp.add(labelSvrPort);
					labelSvrPort.setText("Server Port:");
					labelSvrPort.setFont(new java.awt.Font("Verdana",0,9));
					labelSvrPort.setBounds(28, 55, 77, 14);
				}
				{
					txtSvrPort = new JTextField();
					panelSvrServerProp.add(txtSvrPort);
					txtSvrPort.setFont(new java.awt.Font("Verdana",0,9));
					txtSvrPort.setBounds(144, 54, 74, 19);
				}
				{
					labelPacketSize = new JLabel();
					panelSvrServerProp.add(labelPacketSize);
					labelPacketSize.setText("Packet Size (byte)");
					labelPacketSize.setBounds(18, 81, 114, 16);
					labelPacketSize.setFont(new java.awt.Font("Verdana",0,9));
				}
				{
					txtPacketSize = new JTextField();
					panelSvrServerProp.add(txtPacketSize);
					txtPacketSize.setBounds(144, 79, 76, 19);
					txtPacketSize.setFont(new java.awt.Font("Verdana",0,9));
				}
			}
			{
				panelListen = new JPanel();
				getContentPane().add(panelListen);
				panelListen.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),"Listening",TitledBorder.LEADING,TitledBorder.TOP));
				panelListen.setLayout(null);
				panelListen.setBounds(0, 207, 316, 93);
				{
					btnStartListen = new JButton();
					panelListen.add(btnStartListen);
					btnStartListen.setText("Start Listening");
					btnStartListen.setFont(new java.awt.Font("Verdana",0,9));
					btnStartListen.setBounds(17, 27, 282, 22);
					btnStartListen.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out.println("btnStartListen.actionPerformed, event="+evt);
							//TODO add your code for btnStartListen.actionPerformed
							Thread myThread=new Thread(){
								@Override
								public void run() {
									listen();
								}
							};
							myThread.start();
						}
					});
				}
				{
					btnStopListen = new JButton();
					panelListen.add(btnStopListen);
					btnStopListen.setText("Stop Listening");
					btnStopListen.setFont(new java.awt.Font("Verdana",0,9));
					btnStopListen.setBounds(17, 60, 282, 22);
					btnStopListen.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out.println("btnStopListen.actionPerformed, event="+evt);
							//TODO add your code for btnStopListen.actionPerformed
							
							exitLoop = true;
							if(serverSocket != null ){
								if(! serverSocket.isClosed())
								try {
									serverSocket.close();
								} catch (Exception e) {
									// TODO: handle exception
								}
							}
							
						}
					});
				}
			}
			{
				displayScroll = new JScrollPane();
				getContentPane().add(displayScroll);
				displayScroll.setBounds(328, 11, 281, 289);
				{
					displayArea = new JTextArea();
					displayScroll.setViewportView(displayArea);
					displayArea.setBounds(328, 7, 281, 293);
					displayArea.setEditable(false);
					displayArea.setPreferredSize(new java.awt.Dimension(281, 287));
				}
			}
			pack();
			this.setSize(629, 339);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
