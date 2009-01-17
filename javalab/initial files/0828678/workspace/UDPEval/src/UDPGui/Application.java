


	package UDPGui;
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

	import javax.swing.WindowConstants;
	import javax.swing.border.TitledBorder;
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
		private JPanel pnlMethods2;
		private JTextArea jTextArea1;
		private JButton btnStopLis;
		private JButton btnStartLis;
		private JPanel jPanel5;
		private JTextField txtPort;
		private JLabel jLabel2;
		private JTextField textServerIP1;
		private JLabel jLabel1;
		private JPanel jPanel4;
		private JRadioButton jRadioButton4;
		private JRadioButton jRadioButton3;
		private JRadioButton rb1;
		private JLabel jLabel3;
		private JTextField txtPort1;
		private JButton btnStart;
		private JScrollPane scrl;
		private JLabel lblServerPort;
		private JTextField txtServerIP;
		private JLabel lblServerIP;
		private JPanel jPanel3;
		private JPanel panelClient;
		private JPanel pnlMehtods1;
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
				this.setPreferredSize(new java.awt.Dimension(607, 456));
				getContentPane().setLayout(null);
				getContentPane().setBackground(new java.awt.Color(240,240,240));
				{
					tp = new JTabbedPane();
					getContentPane().add(tp);
					tp.setBounds(0, 11, 581, 414);
					tp.setBorder(BorderFactory.createTitledBorder("File"));
					{
						panelClient = new JPanel();
						tp.addTab("Client", null, panelClient, null);
						panelClient.setLayout(null);
						panelClient.setPreferredSize(new java.awt.Dimension(564, 381));
						{
							pnlMehtods1 = new JPanel();
							panelClient.add(pnlMehtods1);
							pnlMehtods1.setLayout(null);
							pnlMehtods1.setBounds(22, 18, 172, 154);
							pnlMehtods1.setBorder(BorderFactory.createTitledBorder(null, "Methods:", TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font("Tahoma",0,11), new java.awt.Color(0,128,0)));
							{
								rb = new JRadioButton();
								pnlMehtods1.add(rb);
								rb.setText("Socket UDP");
								rb.setBounds(24, 36, 81, 23);
							}
							{
								jRadioButton1 = new JRadioButton();
								pnlMehtods1.add(jRadioButton1);
								jRadioButton1.setText("Socket TCP");
								jRadioButton1.setBounds(24, 67, 81, 23);
							}
							{
								jRadioButton2 = new JRadioButton();
								pnlMehtods1.add(jRadioButton2);
								jRadioButton2.setText("RMI (registry 14445)");
								jRadioButton2.setBounds(24, 101, 136, 23);
							}
						}
						{
							jPanel1 = new JPanel();
							panelClient.add(jPanel1);
							jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Choice a file:", TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font("Tahoma",0,11), new java.awt.Color(0,128,0)));
							jPanel1.setLayout(null);
							jPanel1.setBounds(213, 16, 174, 154);
							{
								lblFileName = new JLabel();
								jPanel1.add(lblFileName);
								lblFileName.setText("File Name:");
								lblFileName.setBounds(22, 31, 151, 18);
							}
							{
								btnChooseFile = new JButton();
								jPanel1.add(btnChooseFile);
								btnChooseFile.setText("File");
								btnChooseFile.setBounds(22, 67, 49, 23);
								btnChooseFile.setBackground(new java.awt.Color(128,255,255));
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
								lblPacketSize.setText("Packet Size:");
								lblPacketSize.setBounds(16, 101, 63, 21);
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
							jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Time:", TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font("Tahoma",0,11), new java.awt.Color(0,128,0)));
							jPanel2.setLayout(null);
							jPanel2.setBounds(397, 18, 174, 154);
							{
								lblStartTime = new JLabel();
								jPanel2.add(lblStartTime);
								lblStartTime.setText("Start Time");
								lblStartTime.setBounds(30, 26, 102, 17);
							}
							{
								lblStopTime = new JLabel();
								jPanel2.add(lblStopTime);
								lblStopTime.setText("Stop Time");
								lblStopTime.setBounds(30, 49, 102, 14);
							}
							{
								lblTTime = new JLabel();
								jPanel2.add(lblTTime);
								lblTTime.setText("Transfer Time");
								lblTTime.setBounds(30, 74, 102, 14);
							}
							{
								lblSpeed = new JLabel();
								jPanel2.add(lblSpeed);
								lblSpeed.setText("Speed");
								lblSpeed.setBounds(30, 99, 114, 14);
							}
						}
						{
							jPanel3 = new JPanel();
							panelClient.add(jPanel3);
							jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Server IP/Port", TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font("Tahoma",0,11), new java.awt.Color(0,128,0)));
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
								jLabel3.setText("Server IP:");
								jLabel3.setBounds(24, 31, 63, 14);
							}
							{
								lblServerPort = new JLabel();
								jPanel3.add(lblServerPort);
								lblServerPort.setText("Port:");
								lblServerPort.setBounds(182, 31, 45, 14);
							}
							{
								txtPort1 = new JTextField();
								jPanel3.add(txtPort1);
								txtPort1.setText("7777");
								txtPort1.setBounds(237, 28, 30, 20);
							}
						}
						{
							btnStart = new JButton();
							panelClient.add(btnStart);
							btnStart.setText("Start Transfer");
							btnStart.setBounds(22, 252, 101, 23);
							btnStart.setBackground(new java.awt.Color(128,255,255));
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
								txtInfo.setPreferredSize(new java.awt.Dimension(529, 93));
							}
						}
					}
					{
						panelServer = new JPanel();
						tp.addTab("Server", null, panelServer, null);
						panelServer.setLayout(null);
						{
							pnlMethods2 = new JPanel();
							panelServer.add(pnlMethods2);
							
							pnlMethods2.setBounds(32, 27, 169, 129);
							pnlMethods2.setLayout(null);
							pnlMethods2.setBorder(BorderFactory.createTitledBorder(null, "Methods:", TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font("Tahoma",0,11), new java.awt.Color(0,128,0)));
							{
								rb1 = new JRadioButton();
								pnlMethods2.add(rb1);
								rb1.setText("Socket UDP");
								rb1.setBounds(12, 32, 81, 23);
							}
							{
								jRadioButton3 = new JRadioButton();
								pnlMethods2.add(jRadioButton3);
								jRadioButton3.setText("Socket TCP");
								jRadioButton3.setBounds(12, 66, 79, 23);
							}
							{
								jRadioButton4 = new JRadioButton();
								pnlMethods2.add(jRadioButton4);
								jRadioButton4.setText("RMI (registry 14445)");
								jRadioButton4.setBounds(12, 99, 125, 23);
							}
						}
						{
							jPanel4 = new JPanel();
							panelServer.add(jPanel4);
	
							jPanel4.setBounds(224, 34, 305, 67);
							jPanel4.setBorder(BorderFactory.createTitledBorder(null, "Server IP/PORT", TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font("Tahoma",0,11), new java.awt.Color(0,128,0)));
							jPanel4.setLayout(null);
							{
								jLabel1 = new JLabel();
								jPanel4.add(jLabel1);
								jLabel1.setText("Socket IP:");
								jLabel1.setBounds(11, 31, 57, 14);
							}
							{
								textServerIP1 = new JTextField();
								jPanel4.add(textServerIP1);
								textServerIP1.setText("127.0.0.1");
								textServerIP1.setBounds(72, 28, 60, 20);
							}
							{
								jLabel2 = new JLabel();
								jPanel4.add(jLabel2);
								jLabel2.setText("Port:");
								jLabel2.setBounds(148, 31, 24, 14);
							}
							{
								txtPort1 = new JTextField();
								jPanel4.add(txtPort1);
								txtPort1.setText("7777");
								txtPort1.setBounds(182, 28, 30, 20);
							}
						}
						{
							jPanel5 = new JPanel();
							panelServer.add(jPanel5);
							
							jPanel5.setBounds(224, 112, 245, 86);
							jPanel5.setBorder(BorderFactory.createTitledBorder(null, "Listening:", TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font("Tahoma",0,11), new java.awt.Color(0,128,0)));
							jPanel5.setLayout(null);
							{
								btnStartLis = new JButton();
								jPanel5.add(btnStartLis);
								btnStartLis.setText("Start Listening");
								btnStartLis.setBounds(51, 20, 138, 26);
								btnStartLis.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										UDPServer myserver = new UDPServer();
										try {
											myserver.run(9876, 512);
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										System.out.println("btnStartLis.actionPerformed, event="+evt);
										//TODO add your code for btnStartLis.actionPerformed
									}
								});
							}
							{
								btnStopLis = new JButton();
								jPanel5.add(btnStopLis);
								btnStopLis.setText("Stop Listening");
								btnStopLis.setBounds(51, 52, 138, 27);
							}
						}
						{
							jTextArea1 = new JTextArea();
							panelServer.add(jTextArea1);
							jTextArea1.setText("data");
							jTextArea1.setBounds(32, 214, 522, 134);
						}
					}
				}
				pack();
				this.setSize(607, 456);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public JTextArea getTxtInfo() {
			return txtInfo;
		}

		private void btnStartActionPerformed(ActionEvent evt) {
			udpclient client=new udpclient();

			//TODO add code to check filename, port , ....  before calling client.send
			Date startTime=new Date();
			lblStartTime.setText(""+startTime.getTime());
			
			txtInfo.append("\nstart transfering file "+fileName);
			try {
				client.sendFile(fileName, txtServerIP.getText(),Integer.parseInt( txtPort1.getText()),Integer.parseInt( txtPacketSize.getText()));


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



