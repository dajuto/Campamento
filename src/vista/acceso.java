package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import java.awt.SystemColor;

public class acceso extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public acceso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrSeHaIniciado = new JTextArea();
		txtrSeHaIniciado.setFont(new Font("Monospaced", Font.PLAIN, 24));
		txtrSeHaIniciado.setText("Se ha iniciado \r\ncorrectamente \r\nla sesion");
		txtrSeHaIniciado.setBounds(99, 39, 214, 152);
		contentPane.add(txtrSeHaIniciado);
	}
}
