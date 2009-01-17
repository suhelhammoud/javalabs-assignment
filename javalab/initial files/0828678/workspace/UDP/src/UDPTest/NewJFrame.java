package UDPTest;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
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
	private JTabbedPane mytabbedpanel;
	private ButtonGroup methods;
	private JTextArea jTextArea7;
	private JTextArea jTextArea10;
	private JTextArea jTextArea9;
	private JLabel jLabel9;
	private JLabel jLabel8;
	private JTextArea jTextArea8;
	private JButton jButton4;
	private JButton jButton3;
	private JRadioButton jRadioButton5;
	private JRadioButton jRadioButton4;
	private JRadioButton jRadioButton2;
	private JPanel jPanel6;
	private JPanel jPanel5;
	private JPanel jPanel4;
	private JTextArea jTextArea6;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JLabel jLabel5;
	private JPanel jPanel3;
	private JLabel jLabel4;
	private JLabel jLabel3;
	private JTextArea jTextArea5;
	private JTextArea jTextArea4;
	private JTextArea jTextArea3;
	private JPanel jPanel2;
	private JTextArea jTextArea2;
	private JLabel jLabel2;
	private JButton jButton2;
	private JButton jButton1;
	private JLabel jLabel1;
	private JTextArea jTextArea1;
	private JPanel jPanel1;
	private JRadioButton jRadioButton3;
	private JTextArea txt;
	private JRadioButton we;
	private JRadioButton jRadioButton1;
	private JPanel methodpanel;
	private JPanel clientPanel;
	private JPanel serverPanel;
	private LayoutManager clientPanelLayout;
	private LayoutManager jPanel3Layout;
	private LayoutManager jPanel4Layout;
	private LayoutManager jPanel5Layout;
	private LayoutManager jPanel6Layout;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NewJFrame inst = new NewJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				inst.setSize(330, 406);
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
			{
				mytabbedpanel = new JTabbedPane();
				getContentPane().add(mytabbedpanel);
				mytabbedpanel.setBounds(12, 12, 684, 507);
				mytabbedpanel.setBorder(BorderFactory.createTitledBorder("File"));
				{
					serverPanel = new JPanel();
					mytabbedpanel.addTab("Client", null, getClientPanel(), null);
					mytabbedpanel.addTab("Server", null, serverPanel, null);
					serverPanel.setPreferredSize(new java.awt.Dimension(667, 481));
					serverPanel.setLayout(null);
					serverPanel.add(getJPanel4());
					serverPanel.add(getJPanel5());
					serverPanel.add(getJPanel6());
					serverPanel.add(getJTextArea8());
				}
			}
			pack();
			this.setSize(704, 571);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private ButtonGroup getMethods() {
		if(methods == null) {
			methods = new ButtonGroup();
		}
		return methods;
	}
	
	private JPanel getClientPanel() {
		if(clientPanel == null) {
			clientPanel = new JPanel();
			clientPanel.setLayout(null);
			clientPanel.setPreferredSize(new java.awt.Dimension(574, 387));
			clientPanel.add(getJPanel1());
			clientPanel.add(getMethodpanel());
			clientPanel.add(getTxt());
			clientPanel.add(getJButton1());
			clientPanel.add(getJPanel2());
			clientPanel.add(getJPanel3());
		}
		return clientPanel;
	}
	
	private JPanel getMethodpanel() {
		if(methodpanel == null) {
			methodpanel = new JPanel();
			methodpanel.setBounds(12, 7, 156, 119);
			methodpanel.setLayout(null);
			methodpanel.setBorder(BorderFactory.createTitledBorder("Methods:"));
			methodpanel.add(getJRadioButton1());
			methodpanel.add(getWe());
			methodpanel.add(getJRadioButton3());
		}
		return methodpanel;
	}
	
	private JRadioButton getJRadioButton1() {
		if(jRadioButton1 == null) {
			jRadioButton1 = new JRadioButton();
			jRadioButton1.setText("Socket TCP");
			jRadioButton1.setBounds(17, 21, 86, 18);
		}
		return jRadioButton1;
	}
	
	private JRadioButton getWe() {
		if(we == null) {
			we = new JRadioButton();
			we.setText("Socket UDP");
			we.setBounds(17, 52, 86, 18);
		}
		return we;
	}

	private JTextArea getTxt() {
		if(txt == null) {
			txt = new JTextArea();
			txt.setBounds(12, 229, 633, 216);
		}
		return txt;
	}
	
	private JRadioButton getJRadioButton3() {
		if(jRadioButton3 == null) {
			jRadioButton3 = new JRadioButton();
			jRadioButton3.setText("RMI (registry 14445)");
			jRadioButton3.setBounds(17, 81, 128, 18);
		}
		return jRadioButton3;
	}
	
	private JPanel getJPanel1() {
		if(jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setBounds(186, 7, 235, 118);
			jPanel1.setLayout(null);
			jPanel1.setBorder(BorderFactory.createTitledBorder(null, "choice a file:", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION));
			jPanel1.add(getJTextArea1());
			jPanel1.add(getJButton2());
			jPanel1.add(getJLabel2());
			jPanel1.add(getJTextArea2());
		}
		return jPanel1;
	}
	
	private JTextArea getJTextArea1() {
		if(jTextArea1 == null) {
			jTextArea1 = new JTextArea();
			jTextArea1.setBounds(17, 20, 198, 18);
			jTextArea1.setText("ScreenShot003.bmp");
		}
		return jTextArea1;
	}
	
	private JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Start Time:");
			jLabel1.setBounds(9, 12, 55, 20);
		}
		return jLabel1;
	}
	
	private JButton getJButton1() {
		if(jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Start Transfer");
			jButton1.setBounds(17, 196, 97, 21);
			jButton1.setBorder(BorderFactory.createCompoundBorder(
					null, 
					null));
			jButton1.setBackground(new java.awt.Color(128,255,255));
		}
		return jButton1;
	}
	
	private JButton getJButton2() {
		if(jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("choose ...");
			jButton2.setBounds(135, 56, 81, 21);
			jButton2.setBackground(new java.awt.Color(128,255,255));
		}
		return jButton2;
	}
	
	private JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("UDP Packet Size:");
			jLabel2.setBounds(17, 87, 81, 14);
		}
		return jLabel2;
	}
	
	private JTextArea getJTextArea2() {
		if(jTextArea2 == null) {
			jTextArea2 = new JTextArea();
			jTextArea2.setBounds(143, 88, 72, 18);
			jTextArea2.setText("512");
		}
		return jTextArea2;
	}
	
	private JPanel getJPanel2() {
		if(jPanel2 == null) {
			jPanel2 = new JPanel();
			LayoutManager jPanel2Layout = null;
			jPanel2.setLayout(jPanel2Layout);
			jPanel2.setBounds(441, 7, 204, 177);
			jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Time:", TitledBorder.LEADING, TitledBorder.TOP));
			jPanel2.add(getJLabel1());
			jPanel2.add(getJTextArea5());
			jPanel2.add(getJLabel3());
			jPanel2.add(getJTextArea4());
			jPanel2.add(getJLabel4());
			jPanel2.add(getJTextArea3());
			jPanel2.add(getJLabel5());
		}
		return jPanel2;
	}
	
	private JTextArea getJTextArea3() {
		if(jTextArea3 == null) {
			jTextArea3 = new JTextArea();
			jTextArea3.setBounds(5, 35, 125, 18);
			jTextArea3.setPreferredSize(new java.awt.Dimension(46, 18));
			jTextArea3.setText("1.572 s");
		}
		return jTextArea3;
	}
	
	private JTextArea getJTextArea4() {
		if(jTextArea4 == null) {
			jTextArea4 = new JTextArea();
			jTextArea4.setBounds(9, 90, 125, 18);
			jTextArea4.setPreferredSize(new java.awt.Dimension(81, 18));
			jTextArea4.setText("1:34:40.699");
		}
		return jTextArea4;
	}
	
	private JTextArea getJTextArea5() {
		if(jTextArea5 == null) {
			jTextArea5 = new JTextArea();
			jTextArea5.setBounds(9, 135, 125, 18);
			jTextArea5.setPreferredSize(new java.awt.Dimension(77, 18));
			jTextArea5.setText("1:34:39.127");
		}
		return jTextArea5;
	}
	
	private JLabel getJLabel3() {
		if(jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("End Time:");
			jLabel3.setBounds(9, 65, 47, 14);
		}
		return jLabel3;
	}
	
	private JLabel getJLabel4() {
		if(jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("Transfer Time:");
			jLabel4.setBounds(9, 116, 70, 14);
			jLabel4.setPreferredSize(new java.awt.Dimension(70, 13));
		}
		return jLabel4;
	}
	
	private JLabel getJLabel5() {
		if(jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("Speed:");
			jLabel5.setBounds(9, 158, 37, 14);
		}
		return jLabel5;
	}
	
	private JPanel getJPanel3() {
		if(jPanel3 == null) {
			jPanel3 = new JPanel();
			jPanel3.setLayout(jPanel3Layout);
			jPanel3.setBounds(12, 132, 409, 52);
			jPanel3.setBorder(BorderFactory.createTitledBorder("Server IP/PORT"));
			jPanel3.add(getJLabel6());
			jPanel3.add(getJTextArea6());
			jPanel3.add(getJLabel7());
			jPanel3.add(getJTextArea7());
		}
		return jPanel3;
	}
	
	private JLabel getJLabel6() {
		if(jLabel6 == null) {
			jLabel6 = new JLabel();
			jLabel6.setText("Sever IP:");
			jLabel6.setBounds(10, 22, 56, 14);
		}
		return jLabel6;
	}
	
	private JLabel getJLabel7() {
		if(jLabel7 == null) {
			jLabel7 = new JLabel();
			jLabel7.setText("Port:");
			jLabel7.setBounds(188, 22, 31, 14);
		}
		return jLabel7;
	}
	
	private JTextArea getJTextArea6() {
		if(jTextArea6 == null) {
			jTextArea6 = new JTextArea();
			jTextArea6.setBounds(71, 22, 87, 18);
			jTextArea6.setPreferredSize(new java.awt.Dimension(159, 18));
			jTextArea6.setText("127.0.0.1");
		}
		return jTextArea6;
	}
	
	private JTextArea getJTextArea7() {
		if(jTextArea7 == null) {
			jTextArea7 = new JTextArea();
			jTextArea7.setBounds(237, 20, 62, 18);
			jTextArea7.setPreferredSize(new java.awt.Dimension(92, 18));
			jTextArea7.setText("1444");
		}
		return jTextArea7;
	}
	
	private JPanel getJPanel4() {
		if(jPanel4 == null) {
			jPanel4 = new JPanel();
			jPanel4.setLayout(jPanel4Layout);
			jPanel4.setBounds(6, 4, 163, 109);
			jPanel4.setBorder(BorderFactory.createTitledBorder("Methods:"));
			jPanel4.add(getJRadioButton2());
			jPanel4.add(getJRadioButton4());
			jPanel4.add(getJRadioButton5());
		}
		return jPanel4;
	}
	
	private JPanel getJPanel5() {
		if(jPanel5 == null) {
			jPanel5 = new JPanel();
			jPanel5.setLayout(jPanel5Layout);
			jPanel5.setBounds(186, 12, 430, 48);
			jPanel5.setBorder(BorderFactory.createTitledBorder("Server IP/PORT"));
			jPanel5.add(getJLabel8());
			jPanel5.add(getJTextArea9());
			jPanel5.add(getJLabel9());
			jPanel5.add(getJTextArea10());
		}
		return jPanel5;
	}
	
	private JPanel getJPanel6() {
		if(jPanel6 == null) {
			jPanel6 = new JPanel();
			jPanel6.setLayout(jPanel6Layout);
			jPanel6.setBounds(186, 66, 323, 92);
			jPanel6.setBorder(BorderFactory.createTitledBorder(null, "Listening:", TitledBorder.LEADING, TitledBorder.TOP));
			jPanel6.add(getJButton3());
			jPanel6.add(getJButton4());
		}
		return jPanel6;
	}
	
	private JRadioButton getJRadioButton2() {
		if(jRadioButton2 == null) {
			jRadioButton2 = new JRadioButton();
			jRadioButton2.setText("Socket TCP");
			jRadioButton2.setBounds(12, 19, 86, 18);
			jRadioButton2.setPreferredSize(new java.awt.Dimension(96, 18));
		}
		return jRadioButton2;
	}
	
	private JRadioButton getJRadioButton4() {
		if(jRadioButton4 == null) {
			jRadioButton4 = new JRadioButton();
			jRadioButton4.setText("Socket UDP");
			jRadioButton4.setBounds(12, 48, 86, 18);
			jRadioButton4.setPreferredSize(new java.awt.Dimension(88, 18));
		}
		return jRadioButton4;
	}
	
	private JRadioButton getJRadioButton5() {
		if(jRadioButton5 == null) {
			jRadioButton5 = new JRadioButton();
			jRadioButton5.setText("RMI (registry 14445)");
			jRadioButton5.setBounds(12, 79, 135, 18);
		}
		return jRadioButton5;
	}
	
	private JButton getJButton3() {
		if(jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setText("Start Listening");
			jButton3.setBounds(17, 19, 192, 28);
			jButton3.setBackground(new java.awt.Color(128,255,255));
		}
		return jButton3;
	}
	
	private JButton getJButton4() {
		if(jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setText("Stop Listening");
			jButton4.setBounds(17, 58, 192, 24);
			jButton4.setBackground(new java.awt.Color(128,255,255));
		}
		return jButton4;
	}
	
	private JTextArea getJTextArea8() {
		if(jTextArea8 == null) {
			jTextArea8 = new JTextArea();
			jTextArea8.setBounds(6, 170, 651, 263);
		}
		return jTextArea8;
	}
	
	private JLabel getJLabel8() {
		if(jLabel8 == null) {
			jLabel8 = new JLabel();
			jLabel8.setText("Socket IP:");
			jLabel8.setBounds(23, 19, 49, 14);
		}
		return jLabel8;
	}
	
	private JLabel getJLabel9() {
		if(jLabel9 == null) {
			jLabel9 = new JLabel();
			jLabel9.setText("Port:");
			jLabel9.setBounds(255, 19, 42, 14);
		}
		return jLabel9;
	}
	
	private JTextArea getJTextArea9() {
		if(jTextArea9 == null) {
			jTextArea9 = new JTextArea();
			jTextArea9.setBounds(78, 19, 130, 18);
			jTextArea9.setBorder(BorderFactory.createTitledBorder(""));
			jTextArea9.setText("127.0.0.1");
		}
		return jTextArea9;
	}
	
	private JTextArea getJTextArea10() {
		if(jTextArea10 == null) {
			jTextArea10 = new JTextArea();
			jTextArea10.setBounds(286, 19, 90, 18);
			jTextArea10.setBorder(BorderFactory.createTitledBorder(""));
			jTextArea10.setText("1444");
		}
		return jTextArea10;
	}

}
