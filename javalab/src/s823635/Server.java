package s823635;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.net.BindException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.SocketException;
import javax.swing.JRadioButton;
import java.net.*;import java.io.*;


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
public class Server extends JFrame {

	private static final long serialVersionUID = 1L;
	public DatagramSocket serverSocket;
	private DatagramSocket socket;
	
	private JTextField jTextField_SocketIP;
	private JLabel jLabel_Port;
	private JTextArea jTextArea;
	private JButton jButtonStopListening;
	private JButton jButton_StartListening;
	private JTextField jTextField_Port;
	private JLabel jLabel1;

	private JPanel jContentPane = null;
	private JRadioButton jRadioButton = null;
	private JRadioButton jRadioButton1 = null;
	private JRadioButton jRadioButton2 = null;
	private JLabel jLabel = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;

	/**
	 * This is the default constructor
	 */
	public Server() {
		super("Server");
		initialize();
		
		try
		{
			 socket = new DatagramSocket(1444);
		}
		catch(SocketException socketException)
		{
		socketException.printStackTrace();
		System.exit(1);
		}
		
		
		
		  
	}    // end server constructor

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(624, 468);
		this.setContentPane(getJContentPane());
		this.setTitle("Server");
		getContentPane().setLayout(null);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel3 = new JLabel();
			jLabel3.setBounds(new java.awt.Rectangle(43,84,128,20));
			jLabel3.setText("RMI(registry 14445)");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new java.awt.Rectangle(42,46,126,22));
			jLabel2.setText("Socket UDP");
			jLabel = new JLabel();
			jLabel.setBounds(new java.awt.Rectangle(45,16,121,20));
			jLabel.setText("Socket TCP");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBounds(0, 0, 616, 441);
			jContentPane.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);
			jContentPane.add(getJLabel1());
			jContentPane.add(getJTextField_SocketIP());
			jContentPane.add(getJLabel_Port());
			jContentPane.add(getJTextField_Port());
			jContentPane.add(getJButton_StartListening());
			jContentPane.add(getJButtonStopListening());
			jContentPane.add(getJTextArea());
			jContentPane.add(getJRadioButton(), null);
			jContentPane.add(getJRadioButton1(), null);
			jContentPane.add(getJRadioButton2(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
		}
		return jContentPane;
	}
	
	private JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Socket IP/TCP");
			jLabel1.setBounds(202, 40, 89, 14);
		}
		return jLabel1;
	}
	
	private JTextField getJTextField_SocketIP() {
		if(jTextField_SocketIP == null) {
			jTextField_SocketIP = new JTextField();
			jTextField_SocketIP.setBounds(304, 36, 130, 21);
		}
		return jTextField_SocketIP;
	}
	
	private JLabel getJLabel_Port() {
		if(jLabel_Port == null) {
			jLabel_Port = new JLabel();
			jLabel_Port.setText("Port");
			jLabel_Port.setBounds(452, 37, 56, 14);
		}
		return jLabel_Port;
	}
	
	private JTextField getJTextField_Port() {
		if(jTextField_Port == null) {
			jTextField_Port = new JTextField();
			jTextField_Port.setBounds(525, 33, 79, 21);
		}
		return jTextField_Port;
	}
	
	private JButton getJButton_StartListening() {
		if(jButton_StartListening == null) {
			jButton_StartListening = new JButton();
			jButton_StartListening.setText("Start Listening");
			jButton_StartListening.setBounds(337, 82, 83, 21);
			jButton_StartListening.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					System.out.println("jButton_StartListening.actionPerformed, event="+evt);
					//TODO add your code for jButton_StartListening.actionPerformed
					StartListening();                                                         // call the  StarListening method
					
					
				}
			});
		}
		return jButton_StartListening;
	}
	
	private JButton getJButtonStopListening() {
		if(jButtonStopListening == null) {
			jButtonStopListening = new JButton();
			jButtonStopListening.setText("Stop Listening");
			jButtonStopListening.setBounds(452, 82, 81, 21);
			jButtonStopListening.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					System.out.println("jButtonStopListening.actionPerformed, event="+evt);
					//TODO add your code for jButtonStopListening.actionPerformed
					socket.close();
				}
			});

		}
		return jButtonStopListening;
	}
	
	private JTextArea getJTextArea() {
		if(jTextArea == null) {
			jTextArea = new JTextArea();
			jTextArea.setBounds(47, 131, 496, 289);
		}
		return jTextArea;
	}
	
	public void StartListening()
	{
		jTextArea.append("UDP server is Starting...\n");
		jTextArea.append("UDP server starts listening...\n");
		jTextArea.append("Waiting for packet size packet...\n");
		
		try
		{
			int serverPort = 9876;                                       // use default server port
			serverSocket = new DatagramSocket(serverPort);                  // create new datagram socket
			String file = "storagefile";                             // create file for temporary storage of data
			File out = new File(file);
			out.createNewFile();
			FileOutputStream outFile = null;
			outFile = new FileOutputStream(out);
			byte[] receiveData = new byte[1024];
			byte[] sendData = new byte[1024];
			while(true)
			{
				DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
				serverSocket.receive(receivePacket);
				outFile.write(receiveData);                                                          // process data
				InetAddress clientIP = receivePacket.getAddress();                                        // get client's IP address
				String socketIP = clientIP.getHostAddress();
				jTextField_SocketIP.setText(socketIP);
				int port = receivePacket.getPort();                                                      //   get port
				String portStr = String.valueOf(port);
				jTextField_Port.setText(portStr);
				
				String feedback = "response fromserver: Data sent to server";                         // create message fro Client
				sendData = feedback.getBytes();
				
				DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,clientIP,port);              // construct datagram
				 serverSocket.send(sendPacket);                                                                   // send packet
			}                                                    // end while
			
		}                                                           // end try
		catch(IOException ioException)
		{
		ioException.printStackTrace();	
		}                                                           // end catch
	}                                                                  // end Start listening method

	/**
	 * This method initializes jRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton() {
		if (jRadioButton == null) {
			jRadioButton = new JRadioButton();
			jRadioButton.setBounds(new java.awt.Rectangle(11,15,21,21));
		}
		return jRadioButton;
	}

	/**
	 * This method initializes jRadioButton1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton1() {
		if (jRadioButton1 == null) {
			jRadioButton1 = new JRadioButton();
			jRadioButton1.setBounds(new java.awt.Rectangle(12,45,21,21));
		}
		return jRadioButton1;
	}

	/**
	 * This method initializes jRadioButton2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton2() {
		if (jRadioButton2 == null) {
			jRadioButton2 = new JRadioButton();
			jRadioButton2.setBounds(new java.awt.Rectangle(13,83,21,21));
		}
		return jRadioButton2;
	}

	public static void main(String[] args)               // main method 
	{
	
		new Server().setVisible(true);
		
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"

