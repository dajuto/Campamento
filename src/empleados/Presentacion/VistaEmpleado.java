package empleados.Presentacion;

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

public class VistaEmpleado extends JFrame{
	private JFrame atras;
	
	public VistaEmpleado(JFrame frame) {
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
				SingletonControllerEmpleado.getInstance().iniciarSesion(getFrame());
			}
		});
		boton_IniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 24));
		boton_IniciarSesion.setBounds(149, 87, 179, 54);
		getContentPane().add(boton_IniciarSesion);
		setVisible(true);
	}
	
	private JFrame getFrame() {
		return this;
	}
}
