package s824699;
import java.io.*;
import java.net.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
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
import java.sql.Time;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;


import javax.swing.JFileChooser;
import javax.swing.plaf.FileChooserUI;

import java.lang.IllegalArgumentException;



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
public class Client extends javax.swing.JFrame {
	private JMenuBar jMenuBar1;
	private JTextField txtip;
	private JTextField txtpsize;
	private JTextArea txt;
	private JScrollPane scrl;
	private JTextField txtport;
	private JLabel lbport;
	private JPanel jPanel3;
	private JLabel lbsip;
	private JButton btnchfile;
	private JLabel lbsd;
	private JLabel lbtrf;
	private JLabel lbend;
	private JButton btnTrasnsfer;
	private JLabel lbstr;
	private JPanel jPanel2;
	private JLabel lbspeed;
	private JLabel lbtrftime;
	private JLabel lbetime;
	private JLabel lbstrtime;
	private JLabel lbPsize;
	private JPanel jPanel1;
	private JTextField clientText;
	private JMenu jMenu1;

	String filename;
	//File file=null;
	
	String fn=" ";
	long filelength;
	String len=" ";
	String  filepath=" ";
	//String  tfx=" ";
	
	
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Client inst = new Client();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Client() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Client");
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(29, 23, 271, 183);
				jPanel1.setBorder(BorderFactory.createTitledBorder("Choose a File"));
				{
					clientText = new JTextField();
					jPanel1.add(clientText);
					clientText.setBounds(351, 93, 185, 33);
					clientText.setPreferredSize(new java.awt.Dimension(197, 33));
				}
				{
					btnchfile = new JButton();
					jPanel1.add(btnchfile);
					btnchfile.setText("Choose a File");
					btnchfile.setPreferredSize(new java.awt.Dimension(186, 33));
					btnchfile.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out.println("btnChfile.actionPerformed, event="+evt);
							JFileChooser chooser=new JFileChooser();
							chooser.showOpenDialog(null);
							filename=chooser.getSelectedFile().getAbsolutePath();
							fn=chooser.getSelectedFile().getName();
							//tfx=chooser.getSelectedFile().getPath();
							clientText.setText(fn);
							filelength=chooser.getSelectedFile().length();
							txt.append("choose file: "+ filename + "\n" + "filelength=" + filelength + " Bytes" + "\n");
							//TODO add some code to make sure that filename is set by the chooser
							System.out.println(filename);
						}
					});
				}
				{
					lbPsize = new JLabel();
					jPanel1.add(lbPsize);
					lbPsize.setText("UDP Packet Size");
					lbPsize.setPreferredSize(new java.awt.Dimension(123, 28));
				}
				{
					txtpsize = new JTextField();
					jPanel1.add(txtpsize);
					txtpsize.setPreferredSize(new java.awt.Dimension(80, 22));
					txtpsize.setText("128");
				}
			}
			{
				jPanel2 = new JPanel();
				getContentPane().add(jPanel2);
				jPanel2.setBounds(328, 22, 302, 184);
				jPanel2.setBorder(BorderFactory.createTitledBorder("Time"));
				{
					lbstrtime = new JLabel();
					jPanel2.add(lbstrtime);
					lbstrtime.setText("Star Time:");
					lbstrtime.setBounds(494, 243, 81, 24);
					lbstrtime.setPreferredSize(new java.awt.Dimension(85, 22));
				}
				{
					lbstr = new JLabel();
					jPanel2.add(lbstr);
					lbstr.setPreferredSize(new java.awt.Dimension(175, 23));
					lbstr.setText("0");
				}
				{
					lbetime = new JLabel();
					jPanel2.add(lbetime);
					lbetime.setText("End Time:");
					lbetime.setBounds(380, 183, 73, 28);
					lbetime.setPreferredSize(new java.awt.Dimension(84, 28));
				}
				{
					lbend = new JLabel();
					jPanel2.add(lbend);
					lbend.setPreferredSize(new java.awt.Dimension(174, 23));
				}
				{
					lbtrftime = new JLabel();
					jPanel2.add(lbtrftime);
					lbtrftime.setText("Transfer Time");
					lbtrftime.setBounds(392, 151, 73, 16);
					lbtrftime.setPreferredSize(new java.awt.Dimension(88, 24));
				}
				{
					lbtrf = new JLabel();
					jPanel2.add(lbtrf);
					lbtrf.setPreferredSize(new java.awt.Dimension(173, 23));
				}
				{
					lbspeed = new JLabel();
					jPanel2.add(lbspeed);
					lbspeed.setText("Speed");
					lbspeed.setBounds(397, 240, 32, 16);
					lbspeed.setPreferredSize(new java.awt.Dimension(86, 16));
				}
				{
					lbsd = new JLabel();
					jPanel2.add(lbsd);
					lbsd.setPreferredSize(new java.awt.Dimension(171, 20));
				}
			}
			{
				btnTrasnsfer = new JButton();
				getContentPane().add(btnTrasnsfer);
				btnTrasnsfer.setText("Start Transfer");
				btnTrasnsfer.setBounds(183, 303, 240, 35);
				btnTrasnsfer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnTrasnsferActionPerformed(evt);
							
					}
				});
			}
			{
				jPanel3 = new JPanel();
				getContentPane().add(jPanel3);
				jPanel3.setBounds(41, 225, 549, 70);
				jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Server IP/Port", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION));
				{
					lbsip = new JLabel();
					jPanel3.add(lbsip);
					lbsip.setText("Server IP");
					lbsip.setBounds(36, 257, 93, 21);
					lbsip.setPreferredSize(new java.awt.Dimension(79, 23));
				}
				{
					txtip = new JTextField();
					jPanel3.add(getTxtip());
					txtip.setText("127.0.0.1");
					txtip.setPreferredSize(new java.awt.Dimension(117, 23));
				}
				{
					lbport = new JLabel();
					jPanel3.add(lbport);
					lbport.setText("Port");
					lbport.setPreferredSize(new java.awt.Dimension(52, 16));
				}
				{
					txtport = new JTextField();
					jPanel3.add(txtport);
					txtport.setPreferredSize(new java.awt.Dimension(76, 22));
					txtport.setText("9876");
				}
			}
			{
				scrl = new JScrollPane();
				getContentPane().add(scrl);
				scrl.setBounds(24, 354, 600, 183);
				{
					txt = new JTextArea();
					scrl.setViewportView(txt);
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
			this.setSize(668, 646);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public JTextField getTxtip() {
		return txtip;
	}
	
	/*private void btnchfileActionPerformed(ActionEvent evt) 
	{		
			//choosefile();		
	}*/
	/*void choosefile() throws Exception
	{	
		
	
	}*/
	
	private void btnTrasnsferActionPerformed(ActionEvent evt) 
	{
		//UDPClient client=new UDPClient();
		try
		{
			int porty=9876;
			int packetx=Integer.parseInt(txtpsize.getText());
			String ipadd=txtip.getText();
			//FileInputStream fin= new FileInputStream(filename);
		///client.sendFile(fin,ipadd,porty,packetx);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TODO add code to check filename, port , ....  before calling client.send
		
		
		
		Date startTime=new Date();
		int sth=startTime.getHours();
		int stm=startTime.getMinutes();
		int sts=startTime.getSeconds();
		
		 
		lbstr.setText("" +sth+":" + stm+":" +sts+"." + startTime.getTime());
		txt.append("\nstart transfering file "+fn);
		try {
			FileInputStream fin= new FileInputStream(filename);
			int lnfin=fin.read();
			System.out.println(lnfin);
			
			UDPClient client=new UDPClient();
			
			client.sendFile(fin, txtip.getText(),Integer.parseInt( txtport.getText()),Integer.parseInt( txtpsize.getText()));
			} catch (Exception e) {
			e.printStackTrace();
		}
		Date stopTime= new Date();
		txt.append("\nfinished ");
		int stph=stopTime.getHours();
		int stpm=stopTime.getMinutes();
		int stps=stopTime.getSeconds();
		
		lbend.setText("" +stph+":" + stpm+":" +stps +"." + stopTime.getTime() );
		long transferTime=stopTime.getTime()-startTime.getTime();
		double trftime=(double) transferTime/1000;
		lbtrf.setText(""+trftime +" seconds");
		
		//long fileLength=new File(fn).length();
		//int fl=(int)fileLength;
		//txt.append(Integer.toString(fl));
		double speed=(double) filelength/(double)trftime;
		double sspeed=speed/1024;
		lbsd.setText(""+ sspeed+ "KByte/sec");
		
	}

}
