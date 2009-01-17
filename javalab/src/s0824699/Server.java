package s0824699;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.*;
import java.net.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.SwingUtilities;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;





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
public class Server extends javax.swing.JFrame {
	
	//private static final Socket DatagramSocket = null;
	private JMenuBar jMenuBar1;
	private JTextArea txtserver;
	private JPanel jPanel1;
	private JScrollPane scrl;
	private JTextField txtport;
	private JLabel lbport;
	private JTextField txtsktip;
	private JPanel jPanel2;
	private JLabel lbsktip;
	private JButton btnstoplistening;
	private JButton btnstlartlistening;
	private JMenu jMenu1;

	private DatagramSocket serverSocket;
    private BufferedReader input;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Server inst = new Server();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Server() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Server");
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(35, 29, 199, 112);
				jPanel1.setBorder(BorderFactory.createTitledBorder("Listening"));
				{
					btnstlartlistening = new JButton();
					jPanel1.add(btnstlartlistening);
					btnstlartlistening.setText("Start Listening");
					btnstlartlistening.setBounds(235, 94, 181, 22);
					btnstlartlistening.setPreferredSize(new java.awt.Dimension(148, 35));
					btnstlartlistening.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							btnstlartlisteningActionPerformed(evt);
							
						}
					});
				}
				{
					btnstoplistening = new JButton();
					jPanel1.add(btnstoplistening);
					btnstoplistening.setText("Stop Listening");
					btnstoplistening.setBounds(215, 258, 150, 30);
					btnstoplistening.setPreferredSize(new java.awt.Dimension(141, 31));
					btnstoplistening.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							btnstoplisteningMouseClicked(evt);
						}
					});
				}
			}
			{
				jPanel2 = new JPanel();
				getContentPane().add(jPanel2);
				jPanel2.setBounds(257, 36, 329, 71);
				jPanel2.setBorder(BorderFactory.createTitledBorder("Socket IP/Port"));
				{
					lbsktip = new JLabel();
					jPanel2.add(lbsktip);
					lbsktip.setText("Socket IP");
					lbsktip.setBounds(298, 95, 110, 24);
				}
				{
					txtsktip = new JTextField();
					jPanel2.add(txtsktip);
					txtsktip.setPreferredSize(new java.awt.Dimension(142, 22));
					txtsktip.setText("127.0.0.1");
				}
				{
					lbport = new JLabel();
					jPanel2.add(lbport);
					lbport.setText("Port");
					lbport.setPreferredSize(new java.awt.Dimension(38, 21));
				}
				{
					txtport = new JTextField();
					jPanel2.add(txtport);
					txtport.setPreferredSize(new java.awt.Dimension(53, 22));
					txtport.setText("9876");
				}
			}
			{
				scrl = new JScrollPane();
				getContentPane().add(scrl);
				scrl.setBounds(18, 155, 601, 172);
				{
					txtserver = new JTextArea();
					scrl.setViewportView(txtserver);
				}
			}
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu1 = new JMenu();
					jMenuBar1.add(jMenu1);
					jMenu1.setText("File");
				}
			}
			pack();
			this.setSize(659, 429);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
		
			
	
	private void closeConnection() {
	      try {
	    	 // serverSocket.close();
	    	  serverSocket.disconnect();
	    	  //btnstlartlistening.enable();
	         input.close();
	         System.exit( 0 );
	      }
	      catch (IOException e) {
	         txtserver.append("\n" + e);
	         System.exit( 0 ) ;
	      }
	   }
	
	private void btnstoplisteningMouseClicked(MouseEvent evt) 
	{
		closeConnection();
	}
	
	private void btnstlartlisteningActionPerformed(ActionEvent evt) {
				
		
		txtserver.setText("Starting UDP Server..." + "\nStarting UDP listen..." + 
				"\nWaiting for packetsize...") ;	
		
		UDPServer server =new UDPServer();
		
		
			try {
				
							
			server.run(9876,1024);
			
			
			
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
