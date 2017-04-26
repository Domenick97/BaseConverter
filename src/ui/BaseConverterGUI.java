package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import converter.Converter;

/**
 * The GUI for the BinaryDecimalConverter
 * @author Domenick DiBiase
 *
 */
public class BaseConverterGUI extends JFrame implements ActionListener {
	/**Serial version ID Number*/
	private static final long serialVersionUID = 1L;
	/** Button to run the conversion*/
	JButton btnRun = new JButton("Convert");
	/** Text box for the number to be converted*/
	JTextField tbNumber = new JTextField();
	/** Text box for the base of the number being converted*/
	JTextField tbCBase = new JTextField();
	/** Text box for the base of the number being converted to*/
	JTextField tbIBase = new JTextField();
	/** Checkbox if the number being converted is not base 10*/
	JCheckBox cbBaseTen = new JCheckBox();
	/** Panel for the input fields*/
	JPanel pnlInput = new JPanel();
	/** Panel for the output*/
	JPanel pnlOutput = new JPanel();
	/** Label for the output*/
	JLabel lblOut = new JLabel("Out");
	
	public static void main(String[] args){
		new BaseConverterGUI();
	}

	public BaseConverterGUI(){
		Container cont = getContentPane();
		
		setTitle("Base Converter");
		setSize(800, 800);
		setLocation(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		JLabel lblNumber = new JLabel("Number to be converted");
		JLabel lblBaseTen = new JLabel("Number is not base 10");
		JLabel lblCBase = new JLabel("Base: ");
		tbNumber.setColumns(10);
		pnlInput.add(lblNumber);
		pnlInput.add(tbNumber);
		pnlInput.add(lblBaseTen);
		pnlInput.add(cbBaseTen);
		pnlInput.add(tbCBase);
		tbCBase.setVisible(false);
		pnlInput.add(lblCBase);
		lblCBase.setVisible(false);
		pnlInput.add(btnRun);
		
		
		pnlOutput.add(lblOut, BorderLayout.NORTH);
		
		cont.add(pnlInput, BorderLayout.NORTH);
		cont.add(pnlOutput);
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cbBaseTen){
			System.out.println("Checked");
		}
		if(e.getSource() == btnRun){
			lblOut.setText(Converter.getInstance().convert("2", 2, 2));
		}
		
	}
}
