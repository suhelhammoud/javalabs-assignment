/**
 * 
 */
package myPackage;

import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;

/**
 * @author dc08skp
 *
 */
public class EquationSolverGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel lblA = null;

	private JLabel lblB = null;

	private JLabel lblC = null;

	private JLabel lblRoot1 = null;

	private JLabel lblRoot2 = null;

	private JTextField txtA = null;

	private JButton btnCalculate = null;

	private JTextField txtC = null;

	private JTextField lblResult1 = null;

	private JTextField lblResult2 = null;

	private JTextField txtB = null;

	/**
	 * @throws HeadlessException
	 */
	public EquationSolverGUI() throws HeadlessException {
		// TODO Auto-generated constructor stub
		super();
		initialize();
	}

	/**
	 * @param gc
	 */
	public EquationSolverGUI(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * @param title
	 * @throws HeadlessException
	 */
	public EquationSolverGUI(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * @param title
	 * @param gc
	 */
	public EquationSolverGUI(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * This method initializes txtA	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtA() {
		if (txtA == null) {
			txtA = new JTextField();
			txtA.setBounds(new Rectangle(232, 1, 157, 20));
			txtA.setText("1");
		}
		return txtA;
	}

	/**
	 * This method initializes btnCalculate	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnCalculate() {
		if (btnCalculate == null) {
			btnCalculate = new JButton();
			btnCalculate.setBounds(new Rectangle(22, 243, 328, 32));
			btnCalculate.setText("Calculate");
			btnCalculate.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					calcutlateRoots();
				}
			});
		}
		return btnCalculate;
	}

	/**
	 * This method initializes txtC	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtC() {
		if (txtC == null) {
			txtC = new JTextField();
			txtC.setBounds(new Rectangle(232, 98, 157, 20));
			txtC.setText("-9");
		}
		return txtC;
	}

	/**
	 * This method initializes lblResult1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getLblResult1() {
		if (lblResult1 == null) {
			lblResult1 = new JTextField();
			lblResult1.setBounds(new Rectangle(232, 146, 157, 20));
		}
		return lblResult1;
	}

	/**
	 * This method initializes lblResult2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getLblResult2() {
		if (lblResult2 == null) {
			lblResult2 = new JTextField();
			lblResult2.setBounds(new Rectangle(232, 198, 157, 20));
		}
		return lblResult2;
	}

	/**
	 * This method initializes txtB	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtB() {
		if (txtB == null) {
			txtB = new JTextField();
			txtB.setBounds(new Rectangle(232, 53, 157, 20));
			txtB.setText("2");
		}
		return txtB;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				EquationSolverGUI thisClass = new EquationSolverGUI();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(409, 322);
		this.setContentPane(getJContentPane());
		this.setName("fram0");
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lblRoot2 = new JLabel();
			lblRoot2.setBounds(new Rectangle(13, 199, 38, 16));
			lblRoot2.setText("Root2");
			lblRoot1 = new JLabel();
			lblRoot1.setBounds(new Rectangle(13, 150, 38, 16));
			lblRoot1.setText("Root1");
			lblC = new JLabel();
			lblC.setBounds(new Rectangle(13, 101, 38, 16));
			lblC.setText("C");
			lblB = new JLabel();
			lblB.setBounds(new Rectangle(13, 52, 38, 16));
			lblB.setText("B");
			lblA = new JLabel();
			lblA.setBounds(new Rectangle(13, 3, 38, 16));
			lblA.setText("A");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(lblA, null);
			jContentPane.add(lblB, null);
			jContentPane.add(lblC, null);
			jContentPane.add(lblRoot1, null);
			jContentPane.add(lblRoot2, null);
			jContentPane.add(getTxtA(), null);
			jContentPane.add(getBtnCalculate(), null);
			jContentPane.add(getTxtC(), null);
			jContentPane.add(getLblResult1(), null);
			jContentPane.add(getLblResult2(), null);
			jContentPane.add(getTxtB(), null);
		}
		return jContentPane;
	}

  //  @jve:decl-index=0:visual-constraint="170,-23"

void calcutlateRoots(){
	double a,b,c;
	double d;

	
	a=Double.valueOf(txtA.getText());
	b=Double.valueOf(txtB.getText());
	c=Double.valueOf(txtC.getText());

	if (a==0){
		lblResult2 .setText(" a=0, this is not quardatric equation");
		lblResult1.setText(""+(-c/b));
		
		return ;
	}

	d= b*b-4*a*c;
	if (d < 0){
		lblResult2.setText("d= "+ d+", No real roots");
		return ;
	}else{
		double root1=(-b+Math.sqrt(d))/(2*a);
		double root2=(-b-Math.sqrt(d))/(2*a);
		lblResult2.setText(""+ root1);
		lblResult1.setText(""+ root2);
	}
}
}
