package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import converter.Converter;

/**
 * The GUI for the BinaryDecimalConverter
 * 
 * @author Domenick DiBiase
 *
 */
public class BaseConverterGUI extends JFrame implements ActionListener {
	/** Serial version ID Number */
	private static final long serialVersionUID = 1L;
	/** Button to run the conversion */
	JButton btnRun = new JButton("Convert");
	/** Text box for the number to be converted */
	JTextField tbNumber = new JTextField();
	/** Text box for the base of the number being converted */
	JTextField tbCBase = new JTextField();
	/** Text box for the base of the number being converted to */
	JTextField tbIBase = new JTextField();
	/** Panel for the input fields */
	JPanel pnlInput = new JPanel();
	/** Panel for the input fields */
	JPanel pnlInput2 = new JPanel();
	/** Panel for the input fields */
	JPanel pnlInput3 = new JPanel();
	/** Panel for the output */
	JPanel pnlOutput = new JPanel();
	/** Label for the output */
	JLabel lblOut;
	/** Combo box for the different bases */
	@SuppressWarnings("rawtypes")
	JComboBox cboCurBase;

	public static void main(String[] args) {
		new BaseConverterGUI();
	}

	public BaseConverterGUI() {
		Container cont = getContentPane();

		setTitle("Base Converter");
		setSize(600, 300);
		setLocation(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//GridBag Layout setup
		cont.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		lblOut = new JLabel("Out");
		JLabel lblNumber = new JLabel("Number to be converted");
		JLabel lblBaseTen = new JLabel("Numbers Current Base: ");
		JLabel lblCBase = new JLabel("Base: ");
		String[] allBases = { "2 Binary", "3", "4", "5", "6", "7", "8", "9", "10 Decimal", "11", "12", "13", "14", "15",
				"16 HexaDecimal" };
		cboCurBase = new JComboBox<String>(allBases);
		cboCurBase.setSelectedIndex(8);
		tbNumber.setColumns(10);
		//TODO: GridBag Layout for the panel
//		c.fill = GridBagConstraints.BOTH;
//		c.weightx = .0;
//		c.gridx = 0;
//		c.gridy = 0;
//		//c.anchor = GridBagConstraints.CENTER;
//		pnlInput.add(lblNumber, c);
//		
//		c.fill = GridBagConstraints.HORIZONTAL;
//		c.weightx = .0;
//		c.weighty = .0;
//		
//		c.gridx = 1;
//		c.gridy = 0;
//		pnlInput.add(tbNumber, c);
//		
//		c.weightx = .25;
//		c.weighty = .25;
//		c.gridx = 0;
//		c.gridy = 1;
//		pnlInput.add(lblBaseTen, c);
		
		
		
		pnlInput.add(lblNumber);
		pnlInput.add(tbNumber);
		pnlInput2.add(lblBaseTen);
		pnlInput2.add(cboCurBase);
		pnlInput2.add(tbCBase);
		tbCBase.setVisible(false);
		pnlInput3.add(lblCBase);
		lblCBase.setVisible(false);
		pnlInput3.add(btnRun, BorderLayout.NORTH);
		btnRun.addActionListener(this);

		pnlOutput.add(lblOut, BorderLayout.NORTH);

		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .0;
		c.weighty = .0;
		
		c.gridx = 0;
		c.gridy = 0;
		cont.add(pnlInput, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .0;
		c.weighty = .0;
		
		c.gridx = 1;
		c.gridy = 0;
		cont.add(pnlInput2, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .0;
		c.weighty = .0;
		
		c.gridx = 0;
		c.gridy = 1;
		cont.add(pnlInput3, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = .0;
		c.weighty = .0;
		
		c.gridx = 0;
		c.gridy = 2;
		cont.add(pnlOutput, c);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Button clicked");

		if (e.getSource() == btnRun) {
			lblOut.setText(Converter.getInstance().convert(tbNumber.getText(), cboCurBase.getSelectedIndex() + 2, 10));
		}
	}
}
