package acampadosPresentacion;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Font;

public class VistaMenuAcampado extends JFrame{
	
	public VistaMenuAcampado() {
		setTitle("Menu del acampado");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,300);
		
		JButton boton_actividades = new JButton("Mis Actividades");
		boton_actividades.setFont(new Font("Tahoma", Font.PLAIN, 18));
		boton_actividades.setBounds(49, 33, 153, 36);
		getContentPane().add(boton_actividades);
		
		JButton boton_Sanidad = new JButton("Sanidad");
		boton_Sanidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		boton_Sanidad.setBounds(49, 108, 153, 36);
		getContentPane().add(boton_Sanidad);
		
		JButton boton_contabilidad = new JButton("Contabilidad");
		boton_contabilidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		boton_contabilidad.setBounds(270, 108, 153, 36);
		getContentPane().add(boton_contabilidad);
		
		JButton boton_Comedor = new JButton("Menu Comedor");
		boton_Comedor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		boton_Comedor.setBounds(270, 33, 153, 36);
		getContentPane().add(boton_Comedor);
		
		JButton boton_Gestoria = new JButton("Gestoria");
		boton_Gestoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerAcampado.getInstance().gestoria(getFrame());
			}
		});
		boton_Gestoria.setFont(new Font("Tahoma", Font.PLAIN, 18));
		boton_Gestoria.setBounds(161, 179, 153, 36);
		getContentPane().add(boton_Gestoria);
		setVisible(true);
	}
	
	private JFrame getFrame() {
		return this;
	}
}
