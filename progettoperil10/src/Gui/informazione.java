package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;

public class informazione extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			informazione dialog = new informazione();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public informazione() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		JTextPane txtpnProgettoPerIl = new JTextPane();
		txtpnProgettoPerIl.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpnProgettoPerIl.setEditable(false);
		txtpnProgettoPerIl.setText("Progetto per il 10 maggio\r\nAndrea Spina 2021\r\nSalva password");
		txtpnProgettoPerIl.setBounds(10, 10, 416, 243);
		getContentPane().add(txtpnProgettoPerIl);
	}
}
