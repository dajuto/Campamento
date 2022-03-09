package paquete;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class IniciarSesion extends JFrame {

	private JPanel contentPane;
	private JTextField dni_usuario;
	private JPasswordField contraseña_usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IniciarSesion frame = new IniciarSesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IniciarSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnA = new JButton("Login");
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dni_usu = dni_usuario.getText();
				String cont_usu = contraseña_usuario.getText();
				if (dni_usu.length() == 9) {
					if (dni_usu.matches("[0-9]{7,8}[A-Za-z]")){
						if (cont_usu.length() >= 8) {
							acceso ac = new acceso();
							ac.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "La contraseña debe de tener 8 caracteres", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Formato de Dni invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Formato de Dni invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnA.setBounds(288, 155, 97, 25);
		contentPane.add(btnA);
		
		JLabel lblDni = new JLabel("Dni:");
		lblDni.setBounds(12, 108, 56, 16);
		contentPane.add(lblDni);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(12, 134, 71, 16);
		contentPane.add(lblContrasea);
		
		JLabel lblNewLabel = new JLabel("Iniciar Sesion");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(103, 13, 210, 53);
		contentPane.add(lblNewLabel);
		
		dni_usuario = new JTextField();
		dni_usuario.setBounds(48, 105, 116, 22);
		contentPane.add(dni_usuario);
		dni_usuario.setColumns(10);
		
		contraseña_usuario = new JPasswordField();
		contraseña_usuario.setBounds(93, 131, 97, 22);
		contentPane.add(contraseña_usuario);
	}
}
