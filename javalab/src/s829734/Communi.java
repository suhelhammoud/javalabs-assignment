package s829734;
// EVALUATING UDP PERFORMANCE IN FILE TRANSFER
//JAVA CODE
//*********************************************
//LIBRARIES DECLARATION
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.SwingUtilities;
import javax.swing.plaf.FileChooserUI;


//USER INTERFACE CLASS
public class Communi extends javax.swing.JFrame {
	private JTabbedPane tp;
	private JTextField jTextField2;
	private JTextField jTextField1;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JRadioButton jRadioButton1;
	private JPanel jPanel4;
	private JButton jButton2;
	private JButton jButton1;
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
	private JLabel lblSpeed;
	private JLabel lblTTime;
	private JLabel lblStopTime;
	private JLabel lblStartTime;
	private JTextArea txtInfo;
	private JLabel lblPacketSize;
	private JButton btnChooseFile;
	private JRadioButton rb;
	private JPanel panelServer;
	String fileName;
{
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Communi inst = new Communi();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				inst.getContentPane().setLayout(null);
				inst.setSize(630,530);
			}
		});
	}

	public Communi() {
		super();
		initGUI();
		//USER INTERFACE MAIN PROGRAM
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setPreferredSize(new java.awt.Dimension(800, 550));
			getContentPane().setLayout(null);
			this.setTitle("IP/PORT");
			{
				tp = new JTabbedPane();
				getContentPane().add(tp);
				tp.setBounds(0, 11, 581, 414);
				{
					panelClient = new JPanel();
					tp.addTab("Client", null, panelClient, null);
					panelClient.setLayout(null);
					panelClient.setPreferredSize(new java.awt.Dimension(663, 392));
					panelClient.setFont(new java.awt.Font("Arial",3,11));
					{
						pnlMehtods = new JPanel();
						panelClient.add(pnlMehtods);
						pnlMehtods.setLayout(null);
						pnlMehtods.setBounds(22, 18, 166, 125);
						pnlMehtods.setBorder(BorderFactory.createEtchedBorder(new java.awt.Color(0,64,0), null));
						{
							rb = new JRadioButton();
							pnlMehtods.add(rb);
							rb.setText("Socket UDP");
							rb.setBounds(13, 27, 140, 75);
							rb.setFont(new java.awt.Font("Arial Black",0,12));
						}
					}
					{
						jPanel1 = new JPanel();
						panelClient.add(jPanel1);
						jPanel1.setBorder(BorderFactory.createEtchedBorder(new java.awt.Color(0,64,0), null));
						jPanel1.setLayout(null);
						jPanel1.setBounds(217, 11, 174, 154);
						{
							lblFileName = new JLabel();
							jPanel1.add(lblFileName);
							lblFileName.setText("File Name");
							lblFileName.setBounds(12, 32, 151, 18);
							lblFileName.setFont(new java.awt.Font("Arial Black",0,12));
						}
						{
							btnChooseFile = new JButton();
							jPanel1.add(btnChooseFile);
							btnChooseFile.setText("File");
							btnChooseFile.setBounds(22, 61, 111, 29);
							btnChooseFile.setFont(new java.awt.Font("Arial Black",0,12));
							btnChooseFile.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									System.out.println("btnChooseFile.actionPerformed, event="+evt);
									JFileChooser chooser=new JFileChooser("d://");
									chooser.showOpenDialog(null);
									fileName=chooser.getSelectedFile().getAbsolutePath();
									lblFileName.setText(fileName);
									txtInfo.append("choose file "+ fileName);
									System.out.println(fileName);
								}
							});
						}
						{
							lblPacketSize = new JLabel();
							jPanel1.add(lblPacketSize);
							lblPacketSize.setText("Packet Size");
							lblPacketSize.setBounds(16, 101, 86, 36);
							lblPacketSize.setFont(new java.awt.Font("Arial Black",0,12));
						}
						{
							txtPacketSize = new JTextField();
							jPanel1.add(txtPacketSize);
							txtPacketSize.setText("1024");
							txtPacketSize.setBounds(114, 95, 43, 32);
						}
					}
					{
						jPanel2 = new JPanel();
						panelClient.add(jPanel2);
						jPanel2.setBorder(BorderFactory.createEtchedBorder(new java.awt.Color(0,64,0), null));
						jPanel2.setLayout(null);
						jPanel2.setBounds(397, 18, 174, 250);
						jPanel2.setFont(new java.awt.Font("Arial Black",0,11));
						{
							lblStartTime = new JLabel();
							jPanel2.add(lblStartTime);
							lblStartTime.setText("Start Time");
							lblStartTime.setBounds(30, 26, 102, 17);
							lblStartTime.setFont(new java.awt.Font("Arial Black",0,11));
						}
						{
							lblStopTime = new JLabel();
							jPanel2.add(lblStopTime);
							lblStopTime.setText("Stop Time");
							lblStopTime.setBounds(30, 49, 102, 14);
							lblStopTime.setFont(new java.awt.Font("Arial Black",0,11));
						}
						{
							lblTTime = new JLabel();
							jPanel2.add(lblTTime);
							lblTTime.setText("Transfer Time");
							lblTTime.setBounds(30, 69, 102, 19);
							lblTTime.setFont(new java.awt.Font("Arial Black",0,11));
						}
						{
							lblSpeed = new JLabel();
							jPanel2.add(lblSpeed);
							lblSpeed.setText("Speed");
							lblSpeed.setBounds(24, 94, 120, 36);
							lblSpeed.setFont(new java.awt.Font("Arial Black",0,11));
						}
					}
					{
						jPanel3 = new JPanel();
						panelClient.add(jPanel3);
						jPanel3.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
						jPanel3.setLayout(null);
						jPanel3.setBounds(32, 177, 343, 74);
						jPanel3.setFont(new java.awt.Font("Arial Black",0,12));
						jPanel3.setName("Server IP/PORT\n");
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
							txtServerIP.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
						}
						{
							jLabel3 = new JLabel();
							jPanel3.add(jLabel3);
							jLabel3.setBounds(11, 22, 75, 28);
							jLabel3.setFont(new java.awt.Font("Arial Black",0,11));
						}
						{
							lblServerPort = new JLabel();
							jPanel3.add(lblServerPort);
							lblServerPort.setText("Port");
							lblServerPort.setBounds(182, 31, 45, 14);
							lblServerPort.setFont(new java.awt.Font("Arial Black",0,12));
						}
						{
							txtPort = new JTextField();
							jPanel3.add(txtPort);
							txtPort.setText("7777");
							txtPort.setBounds(237, 29, 79, 20);
							txtPort.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
						}
					}
					{
						btnStart = new JButton();
						panelClient.add(btnStart);
						btnStart.setText("Start Transfer");
						btnStart.setBounds(77, 257, 206, 23);
						btnStart.setFont(new java.awt.Font("Arial Black",0,12));
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
						scrl.setBorder(BorderFactory.createEtchedBorder(new java.awt.Color(0,64,0), null));
						{
							txtInfo = new JTextArea();
							scrl.setViewportView(getTxtInfo());
							txtInfo.setText("data");
							txtInfo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0,0,0)));
						}
					}
				}
				{
					panelServer = new JPanel();
					tp.addTab("Server", null, panelServer, null);
					panelServer.setLayout(null);
					panelServer.setFont(new java.awt.Font("Arial",1,11));
					{
						jButton1 = new JButton();
						panelServer.add(jButton1);
						jButton1.setText("Start Listening");
						jButton1.setBounds(152, 134, 257, 24);
						jButton1.setFont(new java.awt.Font("Arial Black",0,11));
					}
					{
						jButton2 = new JButton();
						panelServer.add(jButton2);
						jButton2.setText("Stop Listening");
						jButton2.setFont(new java.awt.Font("Arial Black",0,11));
						jButton2.setBounds(152, 201, 257, 24);
					}
					{
						jPanel4 = new JPanel();
						panelServer.add(getJPanel4());
						jPanel4.setBounds(13, 34, 164, 46);
						jPanel4.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
						{
							jRadioButton1 = new JRadioButton();
							jPanel4.add(jRadioButton1);
							jRadioButton1.setText("Socket UDP");
							jRadioButton1.setBounds(51, 88, 81, 23);
							jRadioButton1.setFont(new java.awt.Font("Arial Black",0,12));
						}
					}
					{
						jLabel1 = new JLabel();
						panelServer.add(jLabel1);
						jLabel1.setText("Socket IP:");
						jLabel1.setBounds(188, 34, 169, 45);
						jLabel1.setFont(new java.awt.Font("Arial Black",0,12));
					}
					{
						jLabel2 = new JLabel();
						panelServer.add(jLabel2);
						jLabel2.setText("Port:");
						jLabel2.setBounds(374, 48, 67, 17);
						jLabel2.setFont(new java.awt.Font("Arial Black",0,12));
					}
					{
						jTextField1 = new JTextField();
						panelServer.add(jTextField1);
						jTextField1.setBounds(260, 47, 101, 20);
					}
					{
						jTextField2 = new JTextField();
						panelServer.add(jTextField2);
						jTextField2.setBounds(413, 47, 101, 20);
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

		//TRANSFERING DATA
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
		//GET TRANSFER INFORMATION
		long fileLength=new File(fileName).length();
		double speed=1000*(double) fileLength/(double)transferTime;
		lblSpeed.setText(""+ speed);
		
	}
	
	public JPanel getJPanel4() {
		return jPanel4;
	}

}

