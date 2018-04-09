package ui;

import converter.Converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The GUI for the BinaryDecimalConverter
 *
 * @author Domenick DiBiase
 */
public class BaseConverterGUI extends JFrame implements ActionListener {
    /**
     * Serial version ID Number
     */
    private static final long serialVersionUID = 1L;
    /**
     * Button to run the conversion
     */
    private JButton btnRun = new JButton("Convert");
    /**
     * Text box for the number to be converted
     */
    private JTextField tbNumber = new JTextField();
    /**
     * Label for the output
     */
    private JLabel lblOut;
    /**
     * Combo box for the different bases
     */
    @SuppressWarnings("rawtypes")
    private JComboBox cboCurBase;
    /**
     * Combo box for the different bases
     */
    @SuppressWarnings("rawtypes")
    private JComboBox cboIntBase;

    /**
     * Creates an instance of the base converter GUI
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        new BaseConverterGUI();
    }

    private BaseConverterGUI() {
        // Panel for the input fields
        JPanel pnlInput = new JPanel(new GridBagLayout());
        // Panel for the input fields
        JPanel pnlInput2 = new JPanel();
        // Panel for the input fields
        JPanel pnlInput3 = new JPanel();
        // Panel for the run button
        JPanel pnlRun = new JPanel();
        // Panel for the output
        JPanel pnlOutput = new JPanel();

        Container cont = getContentPane();

        setTitle("Base Converter");
        setSize(600, 300);
        setLocation(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //GridBag Layout setup
        cont.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        lblOut = new JLabel("");
        JLabel lblNumber = new JLabel("Number to be converted");
        JLabel lblCBase = new JLabel("Number's Current Base: ");
        JLabel lblIBase = new JLabel("Number's Intended Base: ");
        String[] allBases = {"2 Binary", "3", "4", "5", "6", "7", "8", "9", "10 Decimal", "11", "12", "13", "14", "15",
                "16 Hexadecimal"};
        cboCurBase = new JComboBox<>(allBases);
        cboIntBase = new JComboBox<>(allBases);
        cboCurBase.setSelectedIndex(8);
        cboIntBase.setSelectedIndex(8);
        tbNumber.setColumns(10);
        tbNumber.addActionListener(this);

        c.insets = new Insets(0, 10, 0, 2);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = .5;
        c.weighty = .5;
        c.gridheight = 1;
        c.gridx = 0;
        c.gridy = 0;
        pnlInput.add(lblNumber, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = .5;
        c.weighty = .5;
        c.gridheight = 1;
        c.gridx = 0;
        c.gridy = 1;
        pnlInput.add(tbNumber, c);
        pnlInput2.add(lblCBase);
        pnlInput2.add(cboCurBase);
        pnlInput3.add(lblIBase);
        pnlInput3.add(cboIntBase);
        pnlRun.add(btnRun, BorderLayout.NORTH);
        btnRun.addActionListener(this);
        pnlOutput.add(lblOut, BorderLayout.NORTH);


        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = .5;
        c.weighty = .5;
        c.gridheight = 2;
        c.gridx = 0;
        c.gridy = 0;
        cont.add(pnlInput, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = .5;
        c.weighty = .5;
        c.anchor = GridBagConstraints.LINE_END;
        c.gridheight = 1;
        c.gridx = 1;
        c.gridy = 0;
        cont.add(pnlInput2, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = .5;
        c.weighty = .5;
        c.gridheight = 1;
        c.gridx = 1;
        c.gridy = 1;
        cont.add(pnlInput3, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = .5;
        c.weighty = .5;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 2;
        cont.add(pnlRun, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = .5;
        c.weighty = .5;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 3;
        cont.add(pnlOutput, c);

        setVisible(true);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnRun || e.getSource() == tbNumber) {
            lblOut.setText(Converter.getInstance().convert(tbNumber.getText(), cboCurBase.getSelectedIndex() + 2, cboIntBase.getSelectedIndex() + 2));
        }

    }
}
