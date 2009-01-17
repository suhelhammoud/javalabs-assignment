package udpPackage;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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
import java.net.*;
import java.io.*;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class udpClient extends javax.swing.JFrame {
	private JPanel panelMethod;
	private JLabel labelPort;
	private JScrollPane txtAreaScroll;
	private JButton btnTransfer;
	private JTextField TxtTransferTime;
	private JLabel labelTransferTime;
	private JTextField TxtEndTime;
	private JLabel labelEndTime;
	private JTextField TxtStartTime;
	private JLabel labelTimeStart;
	private JPanel panelTime;
	private JTextArea TxtAreaDisplay;
	private JTextField txtSpeed;
	private JLabel labelSpeed;
	private JTextField TxtPort;
	private JTextField TxtIP;
	private JLabel labelIP;
	private JPanel panelServerProp;
	private JFileChooser fcFileChoose;
	private static JTextField TxtPacketSize;
	private JLabel labelPacketSize;
	private JButton BtnOpenFile;
	private JTextField TxtFileName;
	private JPanel panelFile;
	private JRadioButton RdBtnRMI;
	private JRadioButton RdBtnUDPSocket;
	private JRadioButton RdBtnTCPSocket;

	File file;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				udpClient inst = new udpClient();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public void chooseFile() {
		int retval = fcFileChoose.showOpenDialog(udpClient.this);

		if (retval == JFileChooser.APPROVE_OPTION) {
			File fn = fcFileChoose.getSelectedFile();
			file = fn;

			// update user interface
			String file_name = new String(fn.getName());
			TxtFileName.setText(file_name);
			TxtAreaDisplay.append("Opening: " + file_name + "\n");
		}
	}

	
	public void udpTransfer() {

		long startTime;
		long endTime;
		double time;

		try {
			// start time
			startTime = System.currentTimeMillis();
			String start = Long.toString(startTime);
			TxtStartTime.setText(start);
			
			// get packet size
			String size = TxtPacketSize.getText();
			int packetSize = Integer.parseInt(size);
			
			//TODO get file size
			long fileLength = file.length();
			// only for MB file size
			TxtAreaDisplay.append("File size is : " + fileLength + "bytes\n");
			
			// get IP address
			String IPAddress = TxtIP.getText();
			InetAddress serverAddress = InetAddress.getByName(IPAddress);

			// get port number
			String serverPort = TxtPort.getText();
			int port = Integer.parseInt(serverPort);

			TxtAreaDisplay.append("Sending file to server with IP Address "
					+ IPAddress + " and port " + serverPort + "\n");

			// create socket
			DatagramSocket clientSocket = new DatagramSocket();

			// get input for transfer
			byte[] sendData = new byte[packetSize];

			// byte[] sendData = new byte[packetSize];

			FileInputStream fin = new FileInputStream(file);

			char[] arrChar = new char[packetSize];
			while (fin.read(sendData) > 0) {

				//System.out.println(new String(sendData));

				DatagramPacket sendPacket = new DatagramPacket(sendData,
						sendData.length, serverAddress, port);
				clientSocket.send(sendPacket);
			}

			// sendData = message.getBytes();
			// construct and send datagram
			// DatagramPacket sendPacket = new DatagramPacket(sendData,
			// sendData.length, serverAddress, port);
			// clientSocket.send(sendPacket);
			//			
			 //receive datagram
			 byte[] receiveData = new byte[packetSize];
			 DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
			 clientSocket.receive(receivePacket);
						
			 //print output
			 String sentenceFromServer = new String(receivePacket.getData());
			 TxtAreaDisplay.append("From server: " + sentenceFromServer);
						
			// close client socket
			clientSocket.close();

			// get end time
			endTime = System.currentTimeMillis();
			String end = Long.toString(endTime);
			TxtEndTime.setText(end);

			// calculate total time
			time = endTime - startTime;
			String timetaken = Double.toString(time);
			TxtTransferTime.setText(timetaken);
			
			//TODO get speed
			double speed = ((double) fileLength / 1000) /((double) time / 1000);
			txtSpeed.setText("" + speed);

		} catch (IOException io) {
			io.printStackTrace();
			TxtAreaDisplay.append("Server cannot be identified\n");
		}

	}

	public udpClient() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("UDP File Transfer - Client");
			{
				panelMethod = new JPanel();
				getContentPane().add(panelMethod);
				panelMethod.setBorder(BorderFactory.createTitledBorder(
						BorderFactory.createBevelBorder(BevelBorder.LOWERED),
						"Methods:", TitledBorder.LEADING, TitledBorder.TOP));
				panelMethod.setLayout(null);
				panelMethod.setBounds(0, 5, 310, 83);
				{
					RdBtnTCPSocket = new JRadioButton();
					panelMethod.add(RdBtnTCPSocket);
					RdBtnTCPSocket.setText("TCP Socket");
					RdBtnTCPSocket.setFont(new java.awt.Font("Verdana", 0, 9));
					RdBtnTCPSocket.setBounds(11, 20, 136, 19);
				}
				{
					RdBtnUDPSocket = new JRadioButton();
					panelMethod.add(RdBtnUDPSocket);
					RdBtnUDPSocket.setText("UDP Socket");
					RdBtnUDPSocket.setFont(new java.awt.Font("Verdana", 0, 9));
					RdBtnUDPSocket.setBounds(158, 20, 101, 17);
				}
				{
					RdBtnRMI = new JRadioButton();
					panelMethod.add(RdBtnRMI);
					RdBtnRMI.setText("RMI (registry 14445)");
					RdBtnRMI.setFont(new java.awt.Font("Verdana", 0, 9));
					RdBtnRMI.setBounds(75, 50, 184, 22);
				}
			}
			{
				panelFile = new JPanel();
				getContentPane().add(panelFile);
				panelFile.setBorder(BorderFactory.createTitledBorder(
						BorderFactory.createBevelBorder(BevelBorder.LOWERED),
						"File", TitledBorder.LEADING, TitledBorder.TOP));
				panelFile.setLayout(null);
				panelFile.setBounds(0, 88, 310, 133);
				{
					TxtFileName = new JTextField();
					panelFile.add(TxtFileName);
					TxtFileName.setFont(new java.awt.Font("Verdana", 0, 9));
					TxtFileName.setEditable(false);
					TxtFileName.setBounds(11, 21, 284, 25);
				}
				{
					BtnOpenFile = new JButton();
					panelFile.add(BtnOpenFile);
					BtnOpenFile.setText("Open a File");
					BtnOpenFile.setFont(new java.awt.Font("Verdana", 0, 9));
					BtnOpenFile.setBounds(160, 52, 136, 26);
					BtnOpenFile.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							chooseFile();
							// System.out.println("BtnOpenFile.actionPerformed, event="+evt);
							// TODO add your code for
							// BtnOpenFile.actionPerformed
						}
					});
				}
				{
					labelPacketSize = new JLabel();
					panelFile.add(labelPacketSize);
					labelPacketSize.setText("UDP Packet Size (bytes):");
					labelPacketSize.setFont(new java.awt.Font("Verdana", 0, 9));
					labelPacketSize.setBounds(11, 87, 137, 26);
				}
				{
					TxtPacketSize = new JTextField();
					panelFile.add(TxtPacketSize);
					TxtPacketSize.setFont(new java.awt.Font("Verdana", 0, 9));
					TxtPacketSize.setBounds(160, 92, 97, 18);
				}
				{
					fcFileChoose = new JFileChooser();
					panelFile.add(fcFileChoose);
					fcFileChoose.setBounds(-5, 306, 502, 326);
				}
			}
			{
				panelServerProp = new JPanel();
				getContentPane().add(panelServerProp);
				panelServerProp.setBorder(BorderFactory.createTitledBorder(
						BorderFactory.createBevelBorder(BevelBorder.LOWERED),
						"Server IP and Port", TitledBorder.LEADING,
						TitledBorder.TOP));
				panelServerProp.setLayout(null);
				panelServerProp.setBounds(0, 221, 310, 102);
				{
					labelIP = new JLabel();
					panelServerProp.add(labelIP);
					labelIP.setText("Server IP:");
					labelIP.setFont(new java.awt.Font("Verdana", 0, 9));
					labelIP.setBounds(18, 29, 58, 8);
				}
				{
					TxtIP = new JTextField();
					panelServerProp.add(TxtIP);
					TxtIP.setFont(new java.awt.Font("Verdana", 0, 9));
					TxtIP.setBounds(100, 24, 158, 19);
				}
				{
					labelPort = new JLabel();
					panelServerProp.add(labelPort);
					labelPort.setText("Server Port:");
					labelPort.setFont(new java.awt.Font("Verdana", 0, 9));
					labelPort.setBounds(18, 52, 61, 11);
				}
				{
					TxtPort = new JTextField();
					panelServerProp.add(TxtPort);
					TxtPort.setFont(new java.awt.Font("Verdana", 0, 9));
					TxtPort.setBounds(100, 49, 157, 20);
				}
			}
			{
				txtAreaScroll = new JScrollPane();
				getContentPane().add(txtAreaScroll);
				txtAreaScroll.setBounds(316, 12, 340, 210);
				{
					TxtAreaDisplay = new JTextArea();
					txtAreaScroll.setViewportView(TxtAreaDisplay);
					TxtAreaDisplay.setBounds(316, 12, 340, 209);
					TxtAreaDisplay.setEditable(false);
					TxtAreaDisplay.setFont(new java.awt.Font("Verdana", 0, 9));
					TxtAreaDisplay.setPreferredSize(new java.awt.Dimension(336,
							209));
				}
			}
			{
				panelTime = new JPanel();
				getContentPane().add(panelTime);
				panelTime.setBorder(BorderFactory.createTitledBorder(
						BorderFactory.createBevelBorder(BevelBorder.LOWERED),
						"Time", TitledBorder.LEADING, TitledBorder.TOP));
				panelTime.setLayout(null);
				panelTime.setBounds(314, 227, 347, 142);
				{
					labelTimeStart = new JLabel();
					panelTime.add(labelTimeStart);
					labelTimeStart.setText("Start");
					labelTimeStart.setFont(new java.awt.Font("Verdana", 0, 9));
					labelTimeStart.setBounds(12, 20, 37, 18);
				}
				{
					TxtStartTime = new JTextField();
					panelTime.add(TxtStartTime);
					TxtStartTime.setFont(new java.awt.Font("Verdana", 0, 9));
					TxtStartTime.setEditable(false);
					TxtStartTime.setBounds(12, 44, 85, 22);
				}
				{
					labelEndTime = new JLabel();
					panelTime.add(labelEndTime);
					labelEndTime.setText("End");
					labelEndTime.setFont(new java.awt.Font("Verdana", 0, 9));
					labelEndTime.setBounds(109, 21, 29, 15);
				}
				{
					TxtEndTime = new JTextField();
					panelTime.add(TxtEndTime);
					TxtEndTime.setFont(new java.awt.Font("Verdana", 0, 9));
					TxtEndTime.setEditable(false);
					TxtEndTime.setBounds(109, 43, 79, 22);
				}
				{
					labelTransferTime = new JLabel();
					panelTime.add(labelTransferTime);
					labelTransferTime.setText("Transfer Time (milisec)");
					labelTransferTime
							.setFont(new java.awt.Font("Verdana", 0, 9));
					labelTransferTime.setBounds(201, 20, 133, 15);
				}
				{
					TxtTransferTime = new JTextField();
					panelTime.add(TxtTransferTime);
					TxtTransferTime.setFont(new java.awt.Font("Verdana", 0, 9));
					TxtTransferTime.setEditable(false);
					TxtTransferTime.setBounds(207, 42, 95, 22);
				}
				{
					labelSpeed = new JLabel();
					panelTime.add(labelSpeed);
					labelSpeed.setText("Speed (KBps)");
					labelSpeed.setBounds(60, 89, 87, 15);
					labelSpeed.setFont(new java.awt.Font("Verdana",0,9));
				}
				{
					txtSpeed = new JTextField();
					panelTime.add(txtSpeed);
					txtSpeed.setBounds(147, 86, 117, 21);
					txtSpeed.setFont(new java.awt.Font("Verdana",0,9));
					txtSpeed.setEditable(false);
				}
			}
			{
				btnTransfer = new JButton();
				getContentPane().add(btnTransfer);
				btnTransfer.setText("Start Transfer");
				btnTransfer.setBounds(62, 335, 188, 42);
				btnTransfer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out
								.println("btnTransfer.actionPerformed, event="
										+ evt);
						udpTransfer();
						
					}
				});
			}
			pack();
			this.setSize(675, 429);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
