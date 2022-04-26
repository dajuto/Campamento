package launcher;

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

public class SuperVista extends JFrame{
	
	public SuperVista() {
		setTitle("HappyCamp");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,300);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(132, 13, 209, 53);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblHappyCamp = new JLabel("HAPPY CAMP");
		lblHappyCamp.setBounds(48, 13, 116, 25);
		panel.add(lblHappyCamp);
		lblHappyCamp.setHorizontalAlignment(SwingConstants.CENTER);
		lblHappyCamp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton boton_Empleados = new JButton("Empleados");
		boton_Empleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SingletonSuperControlador.getInstance().generalEmpleado();
				setVisible(false);
			}
		});
		boton_Empleados.setFont(new Font("Tahoma", Font.PLAIN, 16));
		boton_Empleados.setBounds(58, 128, 138, 29);
		getContentPane().add(boton_Empleados);
		
		JButton boton_Acampados = new JButton("Acampados");
		boton_Acampados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonSuperControlador.getInstance().generalAcampado(getFrame());
			}
		});
		boton_Acampados.setFont(new Font("Tahoma", Font.PLAIN, 16));
		boton_Acampados.setBounds(279, 128, 138, 29);
		getContentPane().add(boton_Acampados);
		setVisible(true);
	}
	
	private JFrame getFrame() {
		return this;
	}
}
