package s0825263;
import java.awt.Component;
import java.awt.Event;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.SwingUtilities;
import javax.swing.plaf.FileChooserUI;

import java.awt.BorderLayout;

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
@SuppressWarnings({ "serial", "unused" })
public class VasuCode extends javax.swing.JFrame {
	private JTabbedPane tp;
	private JPanel pnlserverport;
	private JTextField txtsocket;
	private JButton btndelay;
	private JTextField txtspeed;
	private JButton btnspeed;
	private JTextField txtdelay;
	private JButton btnstop;
	private JButton btnstart;
	private JTextField txtportnum;
	private JTextField txtport;
	private JTextField txtsocketip;
	private JPanel pnlserver;
	private JButton btnStoptime;
	private JButton btnStrarttime;
	private JPanel jPanel4;
	private JLabel jLabel3;
	private JTextField txtPort;
	private JButton btnStart;
	private JScrollPane scrl;
	private JLabel lblServerPort;
	private JTextField txtServerIP;
	private JPanel jPanel3;
	private JPanel panelClient;
	private JPanel pnlMehtods;
	private JPanel jPanel1;
	private JLabel lblFileName;
	private JPanel jPanel2;
	private JTextField txtPacketSize;
	private JLabel lblStopTime;
	private JLabel lblStartTime;
	private JTextArea txtInfo;
	private JLabel lblPacketSize;
	private JButton btnChooseFile;
	private JRadioButton jRadioButton2;
	private JRadioButton jRadioButton1;
	private JRadioButton rb;
	private JPanel panelServer;

	//added by me
	String fileName;
	private LayoutManager pnllisteningLayout;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VasuCode inst = new VasuCode();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				inst.getContentPane().setLayout(null);
				inst.setSize(455, 354);
			}
		});
	}

	public VasuCode() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setPreferredSize(new java.awt.Dimension(607, 461));
			getContentPane().setLayout(null);
			{
				tp = new JTabbedPane();
				getContentPane().add(tp);
				tp.setBounds(0, 11, 581, 414);
				{
					panelClient = new JPanel();
					tp.addTab("Client", null, panelClient, null);
					panelClient.setLayout(null);
					panelClient.setPreferredSize(new java.awt.Dimension(576, 407));
					{
						pnlMehtods = new JPanel();
						panelClient.add(pnlMehtods);
						pnlMehtods.setLayout(null);
						pnlMehtods.setBounds(22, 18, 149, 125);
						pnlMehtods.setBorder(BorderFactory.createTitledBorder("Methods"));
						{
							rb = new JRadioButton();
							pnlMehtods.add(rb);
							rb.setText("Socket UDP");
							rb.setBounds(24, 29, 107, 22);
						}
						{
							jRadioButton1 = new JRadioButton();
							pnlMehtods.add(jRadioButton1);
							jRadioButton1.setText("Socket TCP");
							jRadioButton1.setBounds(24, 60, 107, 23);
						}
						{
							jRadioButton2 = new JRadioButton();
							pnlMehtods.add(jRadioButton2);
							jRadioButton2.setText("RMI");
							jRadioButton2.setBounds(24, 90, 81, 22);
						}
					}
					{
						jPanel1 = new JPanel();
						panelClient.add(jPanel1);
						jPanel1.setBorder(BorderFactory.createTitledBorder("File"));
						jPanel1.setLayout(null);
						jPanel1.setBounds(183, 13, 187, 134);
						{
							lblFileName = new JLabel();
							jPanel1.add(lblFileName);
							lblFileName.setText("File Selected");
							lblFileName.setBounds(22, 31, 151, 18);
						}
						{
							btnChooseFile = new JButton();
							jPanel1.add(btnChooseFile);
							btnChooseFile.setText("Choose file...");
							btnChooseFile.setBounds(22, 67, 118, 23);
							btnChooseFile.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									System.out.println("btnChooseFile.actionPerformed, event="+evt);
									JFileChooser chooser=new JFileChooser("d://");
									chooser.showOpenDialog(null);
									fileName=chooser.getSelectedFile().getAbsolutePath();
									lblFileName.setText(fileName);
									txtInfo.append("choose file "+ fileName);
									//TODO add some code to make sure that filename is set by the chooser
									System.out.println(fileName);
								}
							});
						}
						{
							lblPacketSize = new JLabel();
							jPanel1.add(lblPacketSize);
							lblPacketSize.setText(" Size of Packet");
							lblPacketSize.setBounds(22, 101, 76, 21);
						}
						{
							txtPacketSize = new JTextField();
							jPanel1.add(txtPacketSize);
							txtPacketSize.setText("2048");
							txtPacketSize.setBounds(108, 101, 43, 20);
						}
					}
					{
						jPanel2 = new JPanel();
						panelClient.add(jPanel2);
						jPanel2.setBorder(BorderFactory.createTitledBorder("Time"));
						jPanel2.setLayout(null);
						jPanel2.setBounds(32, 149, 324, 125);
						{
							lblStartTime = new JLabel();
							jPanel2.add(lblStartTime);
							lblStartTime.setText("");
							lblStartTime.setBounds(132, 26, 102, 18);
						}
						{
							lblStopTime = new JLabel();
							jPanel2.add(lblStopTime);
							lblStopTime.setText("");
							lblStopTime.setBounds(131, 52, 100, 17);
						}
						{
							btnStrarttime = new JButton();
							jPanel2.add(btnStrarttime);
							btnStrarttime.setText("Start Time:");
							btnStrarttime.setBounds(16, 26, 98, 18);
						}
						{
							btnStoptime = new JButton();
							jPanel2.add(btnStoptime);
							btnStoptime.setText("Stop Time:");
							btnStoptime.setBounds(16, 54, 98, 17);
						}
						{
							btndelay = new JButton();
							jPanel2.add(btndelay);
							btndelay.setText("Transfer Time");
							btndelay.setBounds(17, 76, 97, 18);
						}
						{
							txtdelay = new JTextField();
							jPanel2.add(txtdelay);
							txtdelay.setText("");
							txtdelay.setBounds(125, 73, 109, 22);
						}
						{
							btnspeed = new JButton();
							jPanel2.add(btnspeed);
							btnspeed.setText("Speed");
							btnspeed.setBounds(17, 98, 97, 22);
						}
						{
							txtspeed = new JTextField();
							jPanel2.add(txtspeed);
							txtspeed.setBounds(125, 97, 109, 22);
						}
					}
					{
						jPanel3 = new JPanel();
						panelClient.add(jPanel3);
						jPanel3.setBorder(BorderFactory.createTitledBorder("Server IP/Port"));
						jPanel3.setLayout(null);
						jPanel3.setBounds(376, 18, 188, 122);
						{
							txtServerIP = new JTextField();
							jPanel3.add(txtServerIP);
							txtServerIP.setText("127.0.0.1");
							txtServerIP.setBounds(112, 47, 57, 19);
						}
						{
							jLabel3 = new JLabel();
							jPanel3.add(jLabel3);
							jLabel3.setText("Server IP Address");
							jLabel3.setBounds(13, 47, 100, 20);
						}
						{
							lblServerPort = new JLabel();
							jPanel3.add(lblServerPort);
							lblServerPort.setText("Port");
							lblServerPort.setBounds(16, 87, 55, 20);
						}
						{
							txtPort = new JTextField();
							jPanel3.add(txtPort);
							txtPort.setText("9999");
							txtPort.setBounds(104, 86, 40, 24);
						}
					}
					{
						btnStart = new JButton();
						panelClient.add(btnStart);
						btnStart.setText("Click To Transfer");
						btnStart.setBounds(400, 187, 165, 47);
						btnStart.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnStartActionPerformed(evt);
							}
						});
					}
					{
						scrl = new JScrollPane();
						panelClient.add(scrl);
						scrl.setBounds(22, 286, 544, 95);
						{
							txtInfo = new JTextArea();
							scrl.setViewportView(getTxtInfo());
							txtInfo.setText("\n");
							txtInfo.setPreferredSize(new java.awt.Dimension(526, 135));
						}
					}
				}
				{
					panelServer = new JPanel();
					tp.addTab("Server", null, panelServer, null);
					panelServer.setLayout(null);
					{
						jPanel4 = new JPanel();
						panelServer.add(jPanel4);
						jPanel4.setBounds(10, 11, 556, 364);
						jPanel4.setLayout((LayoutManager) jPanel4);
						jPanel4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
						{
							pnlserver = new JPanel();
							jPanel4.add(pnlserver);
							pnlserver.setPreferredSize(new java.awt.Dimension(410, 92));
							pnlserver.setLayout(null);
							pnlserver.setBorder(BorderFactory.createTitledBorder("Server IP/Port"));
							{
								txtsocketip = new JTextField();
								pnlserver.add(txtsocketip);
								txtsocketip.setText("127.0.0.1");
								txtsocketip.setBounds(155, 19, 119, 20);
							}
							{
								txtsocket = new JTextField();
								pnlserver.add(txtsocket);
								txtsocket.setText("Socket IP");
								txtsocket.setBounds(34, 19, 83, 20);
							}
							{
								txtport = new JTextField();
								pnlserver.add(txtport);
								txtport.setText("Port");
								txtport.setBounds(34, 51, 60, 20);
							}
							{
								txtportnum = new JTextField();
								pnlserver.add(getTxtportnum());
								txtportnum.setText("8888");
								txtportnum.setBounds(155, 51, 60, 20);
							}
						}
						{
							btnstop = new JButton();
							jPanel4.add(btnstop);
							btnstop.setText("START LISTENING");
							btnstop.setPreferredSize(new java.awt.Dimension(340, 26));
						}
						{
							btnstart = new JButton();
							jPanel4.add(btnstart);
							btnstart.setText("STOP LISTENING");
							btnstart.setPreferredSize(new java.awt.Dimension(331, 23));
						}
					}
				}
			}
			pack();
			this.setSize(607, 461);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JTextArea getTxtInfo() {
		return txtInfo;
	}

	private void btnStartActionPerformed(ActionEvent evt) {
		UDPClient client=new UDPClient();

		//TODO add code to check filename, port , ....  before calling client.send
		Date startTime=new Date();
		lblStartTime.setText(""+startTime.getTime());
		
		txtInfo.append("\nstart transfering file "+fileName);
		try {
			client.sendFile(fileName, txtServerIP.getText(),Integer.parseInt( txtPort.getText()),Integer.parseInt( txtPacketSize.getText()));


		} catch (Exception e) {
			e.printStackTrace();
		}
		Date stopTime= new Date();
		txtInfo.append("\nfinished ");
		lblStopTime.setText(""+stopTime.getTime());
		long transferTime=(stopTime.getTime()-startTime.getTime());
		txtdelay.setText(""+transferTime);
		long fileLength=new File(fileName).length();
		double speed=1000*(double) fileLength/(double)transferTime;
		txtspeed.setText(""+speed);
		
	}
	
	public JTextField getTxtportnum() {
		return txtportnum;
	}

}

