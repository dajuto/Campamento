package gestoria.Presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaMenuLimpiezaGestor extends JFrame{
	private JFrame atras;
	public VistaMenuLimpiezaGestor(JFrame frame) {
		setTitle("Menu de Limpieza");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		
		this.atras = frame;
		
		JButton boton_Atras = new JButton("Atras");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(323, 215, 97, 25);
		getContentPane().add(boton_Atras);
		
		JButton boton_Mostrar = new JButton("Mostrar Horarios");
		boton_Mostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		boton_Mostrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		boton_Mostrar.setBounds(51, 53, 145, 38);
		getContentPane().add(boton_Mostrar);
		
		JButton boton_Modificar = new JButton("Modificar Horarios");
		boton_Modificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		boton_Modificar.setBounds(232, 53, 145, 38);
		getContentPane().add(boton_Modificar);
		
		JButton boton_Eliminar = new JButton("Eliminar Horarios");
		boton_Eliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		boton_Eliminar.setBounds(232, 119, 145, 38);
		getContentPane().add(boton_Eliminar);
		
		JButton boton_Anadir = new JButton("A\u00F1adir Horarios");
		boton_Anadir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		boton_Anadir.setBounds(51, 119, 145, 38);
		getContentPane().add(boton_Anadir);
		
	}

}
