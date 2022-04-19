package acampadosPresentacion;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VistaAcampado extends JFrame{
	private JFrame atras;
	
	public VistaAcampado(JFrame frame) {
		setTitle("Empleado");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,300);
		
		this.atras = frame;
		
		JButton boton_Atras = new JButton("Atras");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(373, 215, 97, 25);
		getContentPane().add(boton_Atras);
		
		JButton boton_IniciarSesion = new JButton("Iniciar Sesion");
		boton_IniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerAcampado.getInstance().iniciarSesion(getFrame());
			}
		});
		boton_IniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		boton_IniciarSesion.setBounds(58, 101, 138, 29);
		getContentPane().add(boton_IniciarSesion);
		
		JButton boton_Registrarse = new JButton("Registrarse");
		boton_Registrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerAcampado.getInstance().resgistrar(getFrame());
			}
		});
		boton_Registrarse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		boton_Registrarse.setBounds(279, 101, 138, 29);
		getContentPane().add(boton_Registrarse);
		setVisible(true);
	}
	
	private JFrame getFrame() {
		return this;
	}
}
