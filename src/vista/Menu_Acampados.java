package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Menu_Acampados extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Acampados frame = new Menu_Acampados();
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
	public Menu_Acampados() {
		setTitle("Acceso datos acampado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Boton_Lista_Actividades = new JButton("Actividades");
		Boton_Lista_Actividades.setBounds(59, 57, 97, 25);
		contentPane.add(Boton_Lista_Actividades);
		
		JButton Boton_Sanidad = new JButton("Sanidad");
		Boton_Sanidad.setBounds(59, 143, 97, 25);
		contentPane.add(Boton_Sanidad);
		
		JButton Boton_comida = new JButton("Men\u00FA");
		Boton_comida.setBounds(270, 57, 97, 25);
		contentPane.add(Boton_comida);
		
		JButton Boton_Servicios = new JButton("Servicios");
		Boton_Servicios.setBounds(270, 143, 97, 25);
		contentPane.add(Boton_Servicios);
	}
}
