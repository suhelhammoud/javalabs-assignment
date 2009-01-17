package UDPGui;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.plaf.FileChooserUI;


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
public class Application extends javax.swing.JFrame {
	private JTabbedPane tp;
	private JPanel jPanel6;
	private JTextField jTextField2;
	private JLabel jLabel4;
	private JLabel jLabel2;
	private JTextField jTextField1;
	private JLabel jLabel1;
	private JPanel jPanel5;
	private JRadioButton jRadioButton5;
	private JRadioButton jRadioButton4;
	private JRadioButton jRadioButton3;
	private JPanel jPanel4;
	private JLabel jLabel3;
	private JTextField txtPort;
	private JButton btnStart;
	private JScrollPane scrl;
	private JLabel lblServerPort;
	private JTextField txtServerIP;
	private JLabel lblServerIP;
	private JPanel jPanel3;
	private JPanel panelClient;
	private JPanel pnlMehtods;
	private JPanel jPanel1;
	private JLabel lblFileName;
	private JPanel jPanel2;
	private JTextField txtPacketSize;
	private JLabel jLabel9;
	private JLabel jLabel8;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JLabel jLabel5;
	private JButton jButton2;
	private JTextPane data;
	private JButton jButton1;
	private JLabel lblSpeed;
	private JLabel lblTTime;
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

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
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
				Application inst = new Application();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				inst.getContentPane().setLayout(null);
				inst.setSize(455, 354);
			}
		});
	}

	public Application() {
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
					{
						pnlMehtods = new JPanel();
						panelClient.add(pnlMehtods);
						pnlMehtods.setLayout(null);
						pnlMehtods.setBounds(22, 18, 144, 154);
						pnlMehtods.setBorder(BorderFactory.createTitledBorder("Methods"));
						{
							rb = new JRadioButton();
							pnlMehtods.add(rb);
							rb.setText("Socket UDP");
							rb.setBounds(24, 36, 81, 23);
						}
						{
							jRadioButton1 = new JRadioButton();
							pnlMehtods.add(jRadioButton1);
							jRadioButton1.setText("Socket TCP");
							jRadioButton1.setBounds(24, 67, 81, 23);
						}
						{
							jRadioButton2 = new JRadioButton();
							pnlMehtods.add(jRadioButton2);
							jRadioButton2.setText("RMI");
							jRadioButton2.setBounds(24, 101, 81, 23);
						}
					}
					{
						jPanel1 = new JPanel();
						panelClient.add(jPanel1);
						jPanel1.setBorder(BorderFactory.createTitledBorder("File"));
						jPanel1.setLayout(null);
						jPanel1.setBounds(217, 11, 174, 154);
						{
							lblFileName = new JLabel();
							jPanel1.add(lblFileName);
							lblFileName.setText("File Name");
							lblFileName.setBounds(22, 31, 151, 18);
						}
						{
							btnChooseFile = new JButton();
							jPanel1.add(btnChooseFile);
							btnChooseFile.setText("File");
							btnChooseFile.setBounds(22, 67, 49, 23);
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
							lblPacketSize.setText("Packet Size");
							lblPacketSize.setBounds(16, 101, 55, 21);
						}
						{
							txtPacketSize = new JTextField();
							jPanel1.add(txtPacketSize);
							txtPacketSize.setText("1024");
							txtPacketSize.setBounds(108, 101, 43, 20);
						}
					}
					{
						jPanel2 = new JPanel();
						panelClient.add(jPanel2);
						jPanel2.setBorder(BorderFactory.createTitledBorder("Time"));
						jPanel2.setLayout(null);
						jPanel2.setBounds(401, 22, 189, 169);
						{
							lblStartTime = new JLabel();
							jPanel2.add(lblStartTime);
							lblStartTime.setText("Start Time");
							lblStartTime.setBounds(64, 26, 102, 17);
						}
						{
							lblStopTime = new JLabel();
							jPanel2.add(lblStopTime);
							lblStopTime.setText("Stop Time");
							lblStopTime.setBounds(64, 49, 102, 14);
						}
						{
							lblTTime = new JLabel();
							jPanel2.add(lblTTime);
							lblTTime.setText("Transfer Time");
							lblTTime.setBounds(64, 74, 102, 14);
						}
						{
							lblSpeed = new JLabel();
							jPanel2.add(lblSpeed);
							lblSpeed.setText("Speed");
							lblSpeed.setBounds(57, 99, 114, 14);
						}
						{
							jLabel5 = new JLabel();
							jPanel2.add(jLabel5);
							jLabel5.setText("Start Time");
							jLabel5.setBounds(5, 23, 49, 14);
						}
						{
							jLabel6 = new JLabel();
							jPanel2.add(jLabel6);
							jLabel6.setText("Start Time");
							jLabel6.setBounds(5, 23, 49, 14);
						}
						{
							jLabel7 = new JLabel();
							jPanel2.add(jLabel7);
							jLabel7.setText("End Time");
							jLabel7.setBounds(8, 45, 43, 14);
						}
						{
							jLabel8 = new JLabel();
							jPanel2.add(jLabel8);
							jLabel8.setText("Delay");
							jLabel8.setBounds(8, 74, 27, 14);
						}
						{
							jLabel9 = new JLabel();
							jPanel2.add(jLabel9);
							jLabel9.setText("Speed");
							jLabel9.setBounds(8, 99, 30, 14);
						}
					}
					{
						jPanel3 = new JPanel();
						panelClient.add(jPanel3);
						jPanel3.setBorder(BorderFactory.createTitledBorder("Server IP/Port"));
						jPanel3.setLayout(null);
						jPanel3.setBounds(22, 176, 333, 58);
						{
							lblServerIP = new JLabel();
							jPanel3.add(lblServerIP);
							lblServerIP.setText("Server IP");
							lblServerIP.setBounds(24, 31, 63, 14);
						}
						{
							txtServerIP = new JTextField();
							jPanel3.add(txtServerIP);
							txtServerIP.setText("127.0.0.1");
							txtServerIP.setBounds(107, 28, 54, 20);
						}
						{
							jLabel3 = new JLabel();
							jPanel3.add(jLabel3);
							jLabel3.setText("Server IP");
							jLabel3.setBounds(24, 31, 63, 14);
						}
						{
							lblServerPort = new JLabel();
							jPanel3.add(lblServerPort);
							lblServerPort.setText("Port");
							lblServerPort.setBounds(182, 31, 45, 14);
						}
						{
							txtPort = new JTextField();
							jPanel3.add(txtPort);
							txtPort.setText("7777");
							txtPort.setBounds(237, 28, 30, 20);
						}
					}
					{
						btnStart = new JButton();
						panelClient.add(btnStart);
						btnStart.setText("Start Transfer");
						btnStart.setBounds(22, 245, 101, 23);
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
							txtInfo.setText("data");
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
						jPanel4.setBorder(BorderFactory.createTitledBorder("Methods"));
						LayoutManager jPanel4Layout = null;
						jPanel4.setLayout(jPanel4Layout);
						jPanel4.setBounds(8, 8, 139, 147);
						{
							jRadioButton3 = new JRadioButton();
							jPanel4.add(jRadioButton3);
							jRadioButton3.setText("Socket UDP");
							jRadioButton3.setBounds(24, 36, 81, 23);
						}
						{
							jRadioButton4 = new JRadioButton();
							jPanel4.add(jRadioButton4);
							jRadioButton4.setText("Socket TCP");
							jRadioButton4.setBounds(24, 67, 81, 23);
						}
						{
							jRadioButton5 = new JRadioButton();
							jPanel4.add(jRadioButton5);
							jRadioButton5.setText("RMI");
							jRadioButton5.setBounds(24, 101, 81, 23);
						}
					}
					{
						jPanel5 = new JPanel();
						panelServer.add(jPanel5);
						jPanel5.setBorder(BorderFactory.createTitledBorder("Server IP/Port"));
						LayoutManager jPanel5Layout = null;
						jPanel5.setLayout(jPanel5Layout);
						jPanel5.setBounds(157, 20, 337, 58);
						{
							jLabel1 = new JLabel();
							jPanel5.add(jLabel1);
							jLabel1.setText("Server IP");
							jLabel1.setBounds(24, 31, 63, 14);
						}
						{
							jTextField1 = new JTextField();
							jPanel5.add(jTextField1);
							jTextField1.setText("127.0.0.1");
							jTextField1.setBounds(107, 28, 54, 20);
						}
						{
							jLabel2 = new JLabel();
							jPanel5.add(jLabel2);
							jLabel2.setText("Server IP");
							jLabel2.setBounds(24, 31, 63, 14);
						}
						{
							jLabel4 = new JLabel();
							jPanel5.add(jLabel4);
							jLabel4.setText("Port");
							jLabel4.setBounds(182, 31, 45, 14);
						}
						{
							jTextField2 = new JTextField();
							jPanel5.add(jTextField2);
							jTextField2.setText("7777");
							jTextField2.setBounds(237, 28, 30, 20);
						}
					}
					{
						jPanel6 = new JPanel();
						panelServer.add(jPanel6);
						jPanel6.setBorder(BorderFactory.createTitledBorder("Listening"));
						jPanel6.setBounds(157, 114, 337, 58);
						{
							jButton1 = new JButton();
							jPanel6.add(jButton1);
							jButton1.setText("Start Listening");
						}
						{
							jButton2 = new JButton();
							jPanel6.add(jButton2);
							jButton2.setText("STOP");
						}
					}
					{
						data = new JTextPane();
						panelServer.add(data);
						data.setText("DATA");
						data.setBounds(27, 217, 360, 147);
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
		long transferTime=stopTime.getTime()-startTime.getTime();
		
		lblTTime.setText(""+transferTime);
		
		long fileLength=new File(fileName).length();
		double speed=1000*(double) fileLength/(double)transferTime;
		lblSpeed.setText(""+ speed);
		
	}

}

