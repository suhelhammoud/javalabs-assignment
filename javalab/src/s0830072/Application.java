package s0830072;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
public class Application extends javax.swing.JFrame {
	private JTabbedPane tp;
	private JTextField lblSpeed;
	private JLabel jLabel7;
	private JTextField lblTTime;
	private JLabel jLabel6;
	private JTextField lblStopTime;
	private JLabel jLabel5;
	private JTextField lblStartTime;
	private JTextField jTextField3;
	private JScrollPane jScrollPane1;
	private JButton jButton2;
	private JButton jButton1;
	private JTextField jTextField2;
	private JLabel jLabel2;
	private JPanel jPanel5;
	private JTextField txtPort;
	private JButton btnStart;
	private JScrollPane scrl;
	private JLabel lblServerPort;
	private JTextField txtServerIP;
	private JLabel lblServerIP;
	private JPanel jPanel3;
	private JPanel panelClient;
	private JPanel jPanel1;
	private JLabel lblFileName;
	private JPanel jPanel2;
	private JTextField txtPacketSize;
	public JTextArea jTextArea1;
	private JLabel jLabel8;
	private JTextArea txtInfo;
	private JLabel lblPacketSize;
	private JButton btnChooseFile;
	private JPanel panelServer;

	static final long serialVersionUID = 1L;
	
	String fileName;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
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
				inst.setSize(600, 480);
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
						jPanel1 = new JPanel();
						panelClient.add(jPanel1);
						jPanel1.setBorder(BorderFactory.createTitledBorder("Select File"));
						jPanel1.setLayout(null);
						jPanel1.setBounds(22, 15, 267, 113);
						{
							lblFileName = new JLabel();
							jPanel1.add(lblFileName);
							lblFileName.setText("File Name");
							lblFileName.setBounds(5, 31, 63, 16);
						}
						{
							btnChooseFile = new JButton();
							jPanel1.add(btnChooseFile);
							btnChooseFile.setText("Browse");
							btnChooseFile.setBounds(166, 31, 89, 20);
							btnChooseFile.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									JFileChooser file = new JFileChooser("c://");
									file.showOpenDialog(null);
									fileName = file.getSelectedFile().getAbsolutePath();
									jTextField3.setText(fileName);
								}
							});
						}
						{
							lblPacketSize = new JLabel();
							jPanel1.add(lblPacketSize);
							lblPacketSize.setText("Packet Size");
							lblPacketSize.setBounds(6, 67, 72, 21);
						}
						{
							txtPacketSize = new JTextField();
							jPanel1.add(txtPacketSize);
							jPanel1.add(getJTextField3());
							txtPacketSize.setText("1024");
							txtPacketSize.setBounds(90, 67, 40, 19);
						}
					}
					{
						jPanel2 = new JPanel();
						panelClient.add(jPanel2);
						jPanel2.setBorder(BorderFactory.createTitledBorder("Time"));
						jPanel2.setLayout(null);
						jPanel2.setBounds(384, 158, 181, 151);
						jPanel2.add(getLblStartTime());
						jPanel2.add(getJLabel5());
						jPanel2.add(getLblStopTime());
						jPanel2.add(getJLabel6());
						jPanel2.add(getLblTTime());
						jPanel2.add(getJLabel7());
						jPanel2.add(getLblSpeed());
						jPanel2.add(getJLabel8());
					}
					{
						jPanel3 = new JPanel();
						panelClient.add(jPanel3);
						jPanel3.setBorder(BorderFactory.createTitledBorder("Server IP/Port"));
						jPanel3.setLayout(null);
						jPanel3.setBounds(295, 19, 135, 109);
						{
							lblServerIP = new JLabel();
							jPanel3.add(lblServerIP);
							lblServerIP.setText("Server IP");
							lblServerIP.setBounds(6, 31, 63, 14);
						}
						{
							txtServerIP = new JTextField();
							jPanel3.add(txtServerIP);
							txtServerIP.setText("127.0.0.1");
							txtServerIP.setBounds(61, 28, 54, 20);
						}
						{
							lblServerPort = new JLabel();
							jPanel3.add(lblServerPort);
							lblServerPort.setText("Port");
							lblServerPort.setBounds(6, 61, 44, 16);
						}
						{
							txtPort = new JTextField();
							jPanel3.add(txtPort);
							txtPort.setText("9998");
							txtPort.setBounds(61, 60, 37, 17);
						}
					}
					{
						btnStart = new JButton();
						panelClient.add(btnStart);
						btnStart.setText("Start Transfer");
						btnStart.setBounds(448, 67, 117, 23);
						btnStart.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								btnStartActionPerformed(evt);
							}
						});
					}
					{
						scrl = new JScrollPane();
						panelClient.add(scrl);
						scrl.setBounds(22, 158, 352, 221);
						{
							txtInfo = new JTextArea();
							scrl.setViewportView(txtInfo);
							txtInfo.setBounds(22, 249, 350, 213);
						}
					}
				}
				{
					panelServer = new JPanel();
					tp.addTab("Server", null, panelServer, null);
					panelServer.setLayout(null);
					panelServer.setBorder(BorderFactory.createTitledBorder(""));
					panelServer.add(getJPanel5());
					panelServer.add(getJButton1());
					panelServer.add(getJButton2());
					panelServer.add(getJScrollPane1());
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
		Date startTime=new Date();
		lblStartTime.setText(""+startTime.getTime());
		txtInfo.append("\nstart transfering file "+fileName);
		try {
			client.sendFile(fileName, txtServerIP.getText(),Integer.parseInt( txtPort.getText()),Integer.parseInt( txtPacketSize.getText()));
			lblStartTime.setText(client.getStartTime());
			lblStopTime.setText(client.getEndTime());
			lblTTime.setText(client.getTotalTime());
			lblSpeed.setText(client.getSpeed());


		} catch (Exception e) {
			e.printStackTrace();
		}
		Date stopTime= new Date();
		txtInfo.append("\nfinished ");
		lblStopTime.setText(""+stopTime.getTime());
		long transferTime=stopTime.getTime()-startTime.getTime();

		long fileLength=new File(fileName).length();

	}

	private JPanel getJPanel5() {
		if(jPanel5 == null) {
			jPanel5 = new JPanel();
			jPanel5.setLayout(null);
			jPanel5.setBounds(13, 17, 197, 111);
			jPanel5.setBorder(BorderFactory.createTitledBorder("Server IP/PORT"));
			jPanel5.setLayout(null);
			jPanel5.add(getJLabel2());
			jPanel5.add(getJTextField2());
		}
		return jPanel5;
	}

	private JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("PORT:");
			jLabel2.setBounds(16, 38, 50, 14);
		}
		return jLabel2;
	}
	
	private JTextField getJTextField2() {
		if(jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setBounds(57, 38, 69, 19);
			jTextField2.setText("9998");
		}
		return jTextField2;
	}
	
	private JButton getJButton1() {
		if(jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Start Server");
			jButton1.setBounds(321, 25, 105, 34);
			jButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton1ActionPerformed(evt);
				}
			});
		}
		return jButton1;
	}
	
	private JButton getJButton2() {
		if(jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("Stop Server");
			jButton2.setBounds(321, 86, 105, 33);
			jButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton2ActionPerformed(evt);
				}
			});
		}
		return jButton2;
	}
	
	private JScrollPane getJScrollPane1() {
		if(jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBounds(16, 164, 544, 187);
			jScrollPane1.setViewportView(getJTextArea1());
		}
		return jScrollPane1;
	}

	private JTextField getJTextField3() {
		if(jTextField3 == null) {
			jTextField3 = new JTextField();
			jTextField3.setBounds(62, 31, 101, 20);
		}
		return jTextField3;
	}
	
	/*private JLabel getJLabel4() {
		if(jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("Start Time");
			jLabel4.setBounds(16, 29, 68, 14);
		}
		return jLabel4;
	}*/
	
	private JTextField getLblStartTime() {
		if(lblStartTime == null) {
			lblStartTime = new JTextField();
			lblStartTime.setBounds(89, 26, 77, 20);
		}
		return lblStartTime;
	}
	
	private JLabel getJLabel5() {
		if(jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("End Time:");
			jLabel5.setBounds(5, 59, 59, 14);
		}
		return jLabel5;
	}
	
	private JTextField getLblStopTime() {
		if(lblStopTime == null) {
			lblStopTime = new JTextField();
			lblStopTime.setBounds(89, 56, 75, 20);
		}
		return lblStopTime;
	}
	
	private JLabel getJLabel6() {
		if(jLabel6 == null) {
			jLabel6 = new JLabel();
			jLabel6.setText("Transfer Time:");
			jLabel6.setBounds(5, 90, 91, 14);
		}
		return jLabel6;
	}
	
	private JTextField getLblTTime() {
		if(lblTTime == null) {
			lblTTime = new JTextField();
			lblTTime.setBounds(89, 87, 74, 20);
		}
		return lblTTime;
	}
	
	private JLabel getJLabel7() {
		if(jLabel7 == null) {
			jLabel7 = new JLabel();
			jLabel7.setText("Speed:");
			jLabel7.setBounds(5, 122, 61, 14);
		}
		return jLabel7;
	}
	
	private JTextField getLblSpeed() {
		if(lblSpeed == null) {
			lblSpeed = new JTextField();
			lblSpeed.setBounds(89, 119, 75, 20);
		}
		return lblSpeed;
	}
	
	private JLabel getJLabel8() {
		if(jLabel8 == null) {
			jLabel8 = new JLabel();
			jLabel8.setText("Start Time:");
			jLabel8.setBounds(5, 29, 58, 14);
		}
		return jLabel8;
	}
	
	private void jButton1ActionPerformed(ActionEvent evt) {
		UDPServer server = new UDPServer();
		try {
			server.startServer(Integer.parseInt(jTextField2.getText().toString()), 1024);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public JTextArea getJTextArea1() {
		if(jTextArea1 == null) {
			jTextArea1 = new JTextArea();
		}
		return jTextArea1;
	}
	
	private void jButton2ActionPerformed(ActionEvent evt) {
		UDPServer server = new UDPServer();
		try {
			server.stopServer();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
