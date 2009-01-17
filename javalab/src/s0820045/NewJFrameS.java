package s0820045;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;

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
/**
 * @author Suhel
 *
 */
public class NewJFrameS extends javax.swing.JFrame {
	private JLabel label_server;
	private JButton btnStartListen;
	private JButton btnStopListen;
	private JLabel label_bytes;
	private JLabel label_size;
	private JTextField txtPacketSize;
	private JTextArea area;
	private JLabel label_socketIp;
	private JTextArea txt_port;
	private JTextArea txt_socketIp;
	private JLabel label_listen;
	private JLabel label_port;
	private JScrollPane logScrollPane;
	Thread thread;
	DatagramSocket serverSocket;

	

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NewJFrameS inst = new NewJFrameS();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public NewJFrameS() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Server Side");
			getContentPane().setLayout(null);
			{
				label_server = new JLabel();
				getContentPane().add(label_server);
				label_server.setText("Server IP/Port");
				label_server.setBounds(28, 21, 98, 14);
				label_server.setFont(new java.awt.Font("Tahoma",1,12));
			}
			{
				label_socketIp = new JLabel();
				getContentPane().add(label_socketIp);
				label_socketIp.setText("Socket IP   :");
				label_socketIp.setBounds(28, 59, 74, 14);
			}
			{
				label_port = new JLabel();
				getContentPane().add(label_port);
				label_port.setText("Port            :");
				label_port.setBounds(30, 85, 76, 14);
			}
			{
				label_listen = new JLabel();
				getContentPane().add(label_listen);
				label_listen.setText("Listening");
				label_listen.setBounds(30, 120, 98, 14);
				label_listen.setFont(new java.awt.Font("Tahoma",1,12));
			}
			{
				txt_socketIp = new JTextArea();
				getContentPane().add(txt_socketIp);
				txt_socketIp.setBounds(99, 55, 112, 18);
			}
			{
				txt_port = new JTextArea();
				getContentPane().add(txt_port);
				txt_port.setBounds(100, 85, 109, 18);
			}
			{
				btnStartListen = new JButton();
				getContentPane().add(btnStartListen);
				btnStartListen.setBounds(134, 146, 186, 21);
				btnStartListen.setText("Start Listening ..");
				btnStartListen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						new StartThread();
						System.out.println("btnStartListen.actionPerformed, event="+evt);
						//TODO add your code for btnStartListen.actionPerformed
					}
				});
			}
			{
				btnStopListen = new JButton();
				getContentPane().add(btnStopListen);
				btnStopListen.setText("Stop Listening ..");
				btnStopListen.setBounds(134, 173, 186, 21);
				btnStopListen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						thread.interrupted();
						serverSocket.close();
						area.append("Server is stopped\n");
						btnStartListen.setEnabled(true);
						btnStopListen.setEnabled(false);
						System.out.println("btnStopListen.actionPerformed, event="+evt);
						//TODO add your code for btnStopListen.actionPerformed
					}
				});
			}
			{
				area = new JTextArea();
				getContentPane().add(area);
				area.setBounds(20, 221, 400, 150);
				area.setEditable(false);
			}
			{
				logScrollPane = new JScrollPane(area);
				getContentPane().add(logScrollPane);
				logScrollPane.setBounds(20, 222, 400, 147);
			}
			{
				txtPacketSize = new JTextField();
				getContentPane().add(txtPacketSize);
				txtPacketSize.setBounds(337, 54, 47, 21);
				txtPacketSize.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						//TODO add your code for txtPacketSize.actionPerformed
					}
				});
			}
			{
				label_size = new JLabel();
				getContentPane().add(label_size);
				label_size.setText("UDP Packet size     :");
				label_size.setBounds(217, 55, 120, 18);
			}
			{
				label_bytes = new JLabel();
				getContentPane().add(label_bytes);
				label_bytes.setText("bytes");
				label_bytes.setBounds(391, 57, 34, 14);
			}
			pack();
			this.setSize(451, 429);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	public class StartThread implements Runnable{
		StartThread(){
			thread = new Thread(this);
			thread.start();
			btnStartListen.setEnabled(false);
			btnStopListen.setEnabled(true);
		}
	public void run(){
			try{
				area.append("Server is started and waiting for packet ... :)\n");
				
				// Get server port
				String port_input = txt_port.getText();
				int serverPort = Integer.parseInt(port_input);
				
				//Get packet size
				String size = txtPacketSize.getText();
				int packetSize = Integer.parseInt(size);
				
				
				// Create server datagram socket
				byte[] receiveData = new byte[packetSize];
				byte[] sendData = new byte[packetSize];
				
				String message;
				serverSocket = new DatagramSocket(serverPort);
				
				while(true){
				
					//Receive request from client 
					DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length );
					serverSocket.receive(receivePacket);
					
					String sentence = new String (receivePacket.getData());
					String capitalizedSentence = sentence.toUpperCase();
					sendData = capitalizedSentence.getBytes();
					
					// Determine client address and port
					InetAddress IPAddress = receivePacket.getAddress();
					int clientPort = receivePacket.getPort();
					//area.append (capitalizedSentence +"\n");
					area.append("Packet received from" + IPAddress + "\n" );
					
					//Construct datagram
					message = "The packet has been received by the server. Thank You!";
					sendData = message.getBytes();
					DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPAddress, clientPort);
					
					//Send
					serverSocket.send(sendPacket);
				
				}// end of while
				
			}
			catch (IOException e){
				System.err.println(e);
			}
		}// end of void run
	} // end of start thread
}// Jframe
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

