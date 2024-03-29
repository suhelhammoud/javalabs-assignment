package s0823635;
import java.io.*;
import java.net.*;
import java.io.File;
import javax.swing.filechooser.*;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JToggleButton;
import javax.swing.JOptionPane;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import javax.swing.JRadioButton;



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
public class Client extends JFrame {


	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JButton jButton_ChooseFile = null;

	private JTextField jTextField_File = null;

	private JTextField jTextField_PacketSize = null;

	private JLabel jLabel = null;

	private JTextField jTextField_ServerIP = null;

	private JLabel jLabel1 = null;

	private JTextField jTextField_Port = null;

	private JLabel jLabel2 = null;

	private JLabel jLabel_StartTime = null;

	private JLabel jLabel_EndTime = null;

	private JLabel jLabel_TransferTime = null;

	private JLabel jLabel_Speed = null;

	private JLabel jLabel_SetStartTime = null;

	private JLabel jLabel_SetEndTime = null;

	private JLabel jLabel_SetTransferTime = null;

	private JLabel jLabel_SetSpeed = null;

	private JButton jButton_TransferFile = null;

	private JTextArea jTextArea_DispayArea = null;
	String sentenceFromServer;


	private JRadioButton Socket_TCP = null;

	private JLabel jLabel3 = null;

	private JRadioButton Socket_UDP = null;

	private JLabel jLabel4 = null;

	private JRadioButton RMI = null;

	private JLabel jLabel5 = null;

	private JLabel jLabel6 = null;

	private JLabel jLabel7 = null;

	private JLabel jLabel8 = null;

	/**
	 * This is the default constructor
	 */
	public Client() {
		super();
		initialize();
	}
	int port;
	String portStr;
	String packetSizeStr;
	String serverName;

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(1072, 849);
		this.setContentPane(getJContentPane());
		this.setTitle("Client");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel8 = new JLabel();
			jLabel8.setBounds(new java.awt.Rectangle(341,16,180,26));
			jLabel8.setText("TIME");
			jLabel7 = new JLabel();
			jLabel7.setBounds(new java.awt.Rectangle(702,10,156,25));
			jLabel7.setText("SERVER IP/PORT");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new java.awt.Rectangle(38,14,104,24));
			jLabel6.setText("METHODS:");
			jLabel5 = new JLabel();
			jLabel5.setBounds(new java.awt.Rectangle(48,103,135,14));
			jLabel5.setText("RMI ( Registry 14445 )");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new java.awt.Rectangle(47,79,123,15));
			jLabel4.setText("Socket UDP");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new java.awt.Rectangle(47,53,120,15));
			jLabel3.setText("Socket TCP");
			jLabel_SetSpeed = new JLabel();
			jLabel_SetSpeed.setBounds(new java.awt.Rectangle(407,172,203,20));
			jLabel_SetSpeed.setText("");
			jLabel_SetTransferTime = new JLabel();
			jLabel_SetTransferTime.setBounds(new java.awt.Rectangle(403,134,204,21));
			jLabel_SetTransferTime.setText("");
			jLabel_SetEndTime = new JLabel();
			jLabel_SetEndTime.setBounds(new java.awt.Rectangle(400,99,201,20));
			jLabel_SetEndTime.setText("");
			jLabel_SetStartTime = new JLabel();
			jLabel_SetStartTime.setBounds(new java.awt.Rectangle(401,64,199,21));
			jLabel_SetStartTime.setText("");
			jLabel_Speed = new JLabel();
			jLabel_Speed.setBounds(new java.awt.Rectangle(296,169,82,21));
			jLabel_Speed.setText("Speed");
			jLabel_TransferTime = new JLabel();
			jLabel_TransferTime.setBounds(new java.awt.Rectangle(293,129,94,23));
			jLabel_TransferTime.setText("Transfer Time");
			jLabel_EndTime = new JLabel();
			jLabel_EndTime.setBounds(new java.awt.Rectangle(299,93,76,23));
			jLabel_EndTime.setText("End Time");
			jLabel_StartTime = new JLabel();
			jLabel_StartTime.setBounds(new java.awt.Rectangle(300,57,80,27));
			jLabel_StartTime.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jLabel_StartTime.setText("Start Time");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new java.awt.Rectangle(679,103,90,26));
			jLabel2.setText("Port");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new java.awt.Rectangle(681,56,79,32));
			jLabel1.setText("Server IP");
			jLabel = new JLabel();
			jLabel.setBounds(new java.awt.Rectangle(7,208,106,33));
			jLabel.setText("UDP Packet Size");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJButton_ChooseFile(), null);
			jContentPane.add(getJTextField_File(), null);
			jContentPane.add(getJTextField_PacketSize(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJTextField_ServerIP(), null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(getJTextField_Port(), null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel_StartTime, null);
			jContentPane.add(jLabel_EndTime, null);
			jContentPane.add(jLabel_TransferTime, null);
			jContentPane.add(jLabel_Speed, null);
			jContentPane.add(jLabel_SetStartTime, null);
			jContentPane.add(jLabel_SetEndTime, null);
			jContentPane.add(jLabel_SetTransferTime, null);
			jContentPane.add(jLabel_SetSpeed, null);
			jContentPane.add(getJButton_TransferFile(), null);
			jContentPane.add(getJTextArea_DispayArea(), null);
			jContentPane.add(getSocket_TCP(), null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(getSocket_UDP(), null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(getRMI(), null);
			jContentPane.add(jLabel5, null);
			jContentPane.add(jLabel6, null);
			jContentPane.add(jLabel7, null);
			jContentPane.add(jLabel8, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButton_ChooseFile	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_ChooseFile() {
		if (jButton_ChooseFile == null) {
			jButton_ChooseFile = new JButton();
			jButton_ChooseFile.setBounds(new java.awt.Rectangle(41,129,136,34));
			jButton_ChooseFile.setText("Choose a File");
			jButton_ChooseFile.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					JFileChooser chooser = new JFileChooser();
					int returnVal = chooser.showOpenDialog(jButton_ChooseFile);
					if(returnVal == JFileChooser.APPROVE_OPTION){
						jTextField_File.setText(chooser.getSelectedFile().getAbsolutePath());
					}

				}
			});
		}
		return jButton_ChooseFile;
	}

	/**
	 * This method initializes jTextField_File	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_File() {
		if (jTextField_File == null) {
			jTextField_File = new JTextField();
			jTextField_File.setBounds(new java.awt.Rectangle(43,170,139,30));

		}
		return jTextField_File;
	}

	/**
	 * This method initializes jTextField_PacketSize	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_PacketSize() {
		if (jTextField_PacketSize == null) {
			jTextField_PacketSize = new JTextField();
			jTextField_PacketSize.setBounds(new java.awt.Rectangle(125,212,78,32));
			jTextField_PacketSize.setToolTipText("Set UDP packet size");
		}
		return jTextField_PacketSize;
	}

	/**
	 * This method initializes jTextField_ServerIP	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_ServerIP() {
		if (jTextField_ServerIP == null) {
			jTextField_ServerIP = new JTextField();
			jTextField_ServerIP.setBounds(new java.awt.Rectangle(772,61,198,30));
		}
		return jTextField_ServerIP;
	}

	/**
	 * This method initializes jTextField_Port	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_Port() {
		if (jTextField_Port == null) {
			jTextField_Port = new JTextField();
			jTextField_Port.setBounds(new java.awt.Rectangle(801,103,98,28));
		}
		return jTextField_Port;
	}

	/**
	 * This method initializes jButton_TransferFile	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_TransferFile() {
		if (jButton_TransferFile == null) {
			jButton_TransferFile = new JButton();
			jButton_TransferFile.setBounds(new java.awt.Rectangle(704,148,168,51));
			jButton_TransferFile.setText("Transfer File");
			jButton_TransferFile.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					try                    
					{

						long StartTime;
						long EndTime;
						long TransferTime;
						StartTime = System.currentTimeMillis();    // get the current time 

						String filename = jTextField_File.getText();                                    // get filename from textfield
						jTextArea_DispayArea.append(" Read File: " + filename);                        // display file's name
						jTextArea_DispayArea.append("\nStarting transfer in:" + StartTime +"\n" );       // display starting time
						jTextArea_DispayArea.append("\nstarting UDP transfer..." +"\n");
						serverName = jTextField_ServerIP.getText();                                 // get server address from server ip text box
						packetSizeStr = jTextField_PacketSize.getText();                           // get packet size from packet size text box
						int packetSize = Integer.valueOf(packetSizeStr).intValue();
						jTextArea_DispayArea.append("UDP socket connected");
						jTextArea_DispayArea.append("\n sending packet size to server: " + packetSize + "\n");
						portStr = jTextField_Port.getText();                                     // get port number from port text box
						int port = Integer.valueOf(portStr).intValue();
						byte[] sendData = new byte[packetSize];                                 // get size of packet
						DatagramSocket clientSocket = new DatagramSocket();
						File file = new File(filename);                                           // choose the file for transfer
						FileInputStream inFile = new FileInputStream(file);
						inFile.read(sendData);
						DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,InetAddress.getByName(serverName),port);
						jTextArea_DispayArea.append("Sending file: " + filename);
						clientSocket.send(sendPacket);
						jTextArea_DispayArea.append("\n data sent to server" + "\n");
						EndTime = System.currentTimeMillis();
						TransferTime = EndTime - StartTime;
						String start = String.valueOf(StartTime);
						String end = String.valueOf(EndTime);
						String transfer = String.valueOf(TransferTime);
						double speed;
						String speedstr;
						double speedsize = file.length();                // get the file's length in bytes

						speed = (speedsize*8)/(1024*(TransferTime/1000));
						jLabel_SetStartTime.setText(start);                             // show start time
						jLabel_SetEndTime.setText(end);                               // show end time
						jLabel_SetTransferTime.setText(transfer);                       // show transfer time
						speedstr = Double.toString(speed);
						jLabel_SetSpeed.setText(speedstr + "Kb/s");                    // shows transfer speed

						byte[] receiveData = new byte[1024];                           // receive datagram
						DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
						clientSocket.receive(receivePacket);
						String sentenceFromServer = new String(receivePacket.getData());
						jTextArea_DispayArea.append("\n " + sentenceFromServer + "\n");    // print response from server




						clientSocket.close();
					}
					catch (IOException ioException)
					{
						ioException.printStackTrace();
					}
				}









			});	

		}		 

		return jButton_TransferFile;
	}


	/**
	 * This method initializes jTextArea_DispayArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea_DispayArea() {
		if (jTextArea_DispayArea == null) {
			jTextArea_DispayArea = new JTextArea();
			jTextArea_DispayArea.setBounds(new java.awt.Rectangle(15,253,773,546));
		}
		return jTextArea_DispayArea;
	}

	/**
	 * This method initializes Socket_TCP	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getSocket_TCP() {
		if (Socket_TCP == null) {
			Socket_TCP = new JRadioButton();
			Socket_TCP.setBounds(new java.awt.Rectangle(9,51,20,15));
		}
		return Socket_TCP;
	}

	/**
	 * This method initializes Socket_UDP	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getSocket_UDP() {
		if (Socket_UDP == null) {
			Socket_UDP = new JRadioButton();
			Socket_UDP.setBounds(new java.awt.Rectangle(10,78,20,11));
		}
		return Socket_UDP;
	}

	/**
	 * This method initializes RMI	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRMI() {
		if (RMI == null) {
			RMI = new JRadioButton();
			RMI.setBounds(new java.awt.Rectangle(12,103,19,12));
		}
		return RMI;
	}

	public static void main(String[] args)                             // main method

	{
		new Client().setVisible(true);
	}
}  //  @jve:decl-index=0:visual-constraint="29,-15"

