package s820045;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
public class NewJFrame extends javax.swing.JFrame {
	private JLabel label_file;
	private JLabel label_size;
	private JLabel label_bytes;
	private JLabel label_server;
	private JLabel label_transferTime;
	private JLabel label_endTime;
	private JLabel label_startTime;
	private JLabel jLabel1;
	private JScrollPane logScrollPane;
	private JTextArea area;
	private JLabel label_speed_result;
	private JLabel label_speed;
	private JLabel label_transfer;
	private JLabel label_end;
	private JButton btnStartTransfer;
	private JButton btnChooseFile;
	private JTextArea txt_port;
	private JTextArea txt_serverIp;
	private JTextArea txt_size;
	private JLabel label_start;
	private JLabel label_time;
	private JLabel jLabel2;
	private JLabel label_port;
	private JLabel label_serverIp;
	long startTime;
	long endTime;
	long transferTime;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NewJFrame inst = new NewJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public NewJFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Client Side");
			{
				label_file = new JLabel();
				getContentPane().add(label_file);
				label_file.setText("The file that will be transfer :");
				label_file.setBounds(17, 40, 187, 18);
			}
			{
				label_size = new JLabel();
				getContentPane().add(label_size);
				label_size.setText("UDP Packet size :");
				label_size.setBounds(17, 92, 101, 18);
			}
			{
				label_bytes = new JLabel();
				getContentPane().add(label_bytes);
				label_bytes.setText("bytes");
				label_bytes.setBounds(187, 89, 34, 18);
			}
			{
				label_server = new JLabel();
				getContentPane().add(label_server);
				label_server.setText("Server IP/Port");
				label_server.setBounds(17, 129, 93, 17);
				label_server.setFont(new java.awt.Font("Tahoma",1,12));
			}
			{
				label_serverIp = new JLabel();
				getContentPane().add(label_serverIp);
				label_serverIp.setText("Server IP               :");
				label_serverIp.setBounds(17, 152, 101, 20);
			}
			{
				label_port = new JLabel();
				getContentPane().add(label_port);
				label_port.setText("Port no.                 :");
				label_port.setBounds(17, 178, 109, 19);
			}
			{
				label_time = new JLabel();
				getContentPane().add(label_time);
				label_time.setText("Time ");
				label_time.setBounds(242, 12, 62, 14);
				label_time.setFont(new java.awt.Font("Tahoma",1,12));
			}
			{
				label_start = new JLabel();
				getContentPane().add(label_start);
				label_start.setText("Start time         :");
				label_start.setBounds(242, 32, 96, 20);
			}
			
			{
				label_end = new JLabel();
				getContentPane().add(label_end);
				label_end.setText("End time            :");
				label_end.setBounds(242, 58, 103, 22);
			}
			{
				label_transfer = new JLabel();
				getContentPane().add(label_transfer);
				label_transfer.setText("Transfer time  :");
				label_transfer.setBounds(242, 88, 91, 21);
			}
			{
				label_speed = new JLabel();
				getContentPane().add(label_speed);
				label_speed.setText("0");
				label_speed.setBounds(338, 115, 91, 14);
			}
			{
				label_speed_result = new JLabel();
				getContentPane().add(label_speed_result);
				label_speed_result.setText("kBps");
				label_speed_result.setBounds(435, 112, 37, 20);
			}
			{
				txt_size = new JTextArea();
				getContentPane().add(txt_size);
				txt_size.setBounds(129, 92, 46, 18);
			}
			{
				txt_serverIp = new JTextArea();
				getContentPane().add(txt_serverIp);
				txt_serverIp.setBounds(130, 152, 91, 20);
			}
			{
				txt_port = new JTextArea();
				getContentPane().add(txt_port);
				txt_port.setBounds(130, 178, 91, 18);
			}
			{
				btnChooseFile = new JButton();
				getContentPane().add(btnChooseFile);
				btnChooseFile.setText("Please choose a file");
				btnChooseFile.setBounds(17, 13, 187, 21);
				btnChooseFile.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						chooseFile ();
						System.out.println("btnChooseFile.actionPerformed, event="+evt);
						//TODO add your code for btnChooseFile.actionPerformed
					}
				});
			}
			{
				btnStartTransfer = new JButton();
				getContentPane().add(btnStartTransfer);
				btnStartTransfer.setText("Start Transfer !!");
				btnStartTransfer.setBounds(126, 219, 213, 21);
				btnStartTransfer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						SendRequest();
						System.out.println("btnStartTransfer.actionPerformed, event="+evt);
						//TODO add your code for btnStartTransfer.actionPerformed
					}
				});
			}
			{
				area = new JTextArea();
				getContentPane().add(area);
				area.setBounds(17, 246, 450, 126);
				area.setEditable(false);
			}
			{
				logScrollPane = new JScrollPane(area);
				getContentPane().add(logScrollPane);
				logScrollPane.setBounds(23, 259, 449, 111);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setBounds(17, 62, 187, 18);
			}
			{
				label_startTime = new JLabel();
				getContentPane().add(label_startTime);
				label_startTime.setBounds(338, 34, 118, 17);
			}
			{
				label_endTime = new JLabel();
				getContentPane().add(label_endTime);
				label_endTime.setBounds(339, 60, 123, 18);
			}
			{
				label_transferTime = new JLabel();
				getContentPane().add(label_transferTime);
				label_transferTime.setBounds(339, 89, 123, 17);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setBounds(242, 114, 90, 16);
				jLabel2.setText("Speed                :");
			}
			pack();
			this.setSize(507, 425);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	String file = null;
	
	void chooseFile ()
	{
		{
			JFileChooser chooser=new JFileChooser("c://");
			chooser.showOpenDialog(null);
			file=chooser.getSelectedFile().getAbsolutePath();
			label_file.setText(file);
			area.append("File to transfer: "+ file);
			//TODO add some code to make sure that filename is set by the chooser		
	}
	
	}
	
	public void SendRequest()
	{		

			
			
			
			area.append("\nStart transferring file "+ file + "........");
			try{
				
				// Start time here !!
				startTime = System.currentTimeMillis();
				label_startTime.setText("" + startTime);
				
				// Get server address
				String serverName = txt_serverIp.getText();
				InetAddress serverIPaddress = InetAddress.getByName(serverName);
				
				// Get server port
				String port_input = txt_port.getText();
				int port = Integer.parseInt(port_input);
				
				//Get packet size
				String size = txt_size.getText();
				int packetSize = Integer.parseInt(size);
				
				// Create socket
				DatagramSocket clientSocket = new DatagramSocket ();
				
				// Open file
				byte [] sendData = new byte [packetSize];
				File fileName = new File (file);
				FileInputStream inFile = new FileInputStream (fileName);
				inFile.read (sendData);
				
		
				// Construct and send datagram
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIPaddress, port); 
				clientSocket.send(sendPacket);
				
				// Receive datagram
				byte [] receiveData = new byte [packetSize];
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				clientSocket.receive(receivePacket);
				
				//Print output 
				String sentenceFromServer = new String(receivePacket.getData());
				area.append("\nReceived from server: " + sentenceFromServer + "\n"); 
				
				// End time here !!
				endTime = System.currentTimeMillis();
				label_endTime.setText("" + endTime);
				transferTime= endTime - startTime;
				label_transferTime.setText(""+transferTime);
				
				long fileLength=new File(file).length();
				double speed=((double) fileLength/1000)/((double)transferTime/1000);
				label_speed.setText(""+ speed);
				
				// Close client socket
				clientSocket.close();
				
				
			}
			catch(IOException io){}
			area.append("File transfer finished ");

		


	}	
}
