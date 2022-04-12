package empleados.Presentacion;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Font;

public class VistaMenuEmpleado extends JFrame{
	
	public VistaMenuEmpleado() {
		setTitle("Menu del empleado");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,300);
		
		JButton boton_actividades = new JButton("Actividades");
		boton_actividades.setFont(new Font("Tahoma", Font.PLAIN, 18));
		boton_actividades.setBounds(49, 33, 140, 36);
		getContentPane().add(boton_actividades);
		
		JButton boton_Sanidad = new JButton("Sanidad");
		boton_Sanidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		boton_Sanidad.setBounds(49, 111, 140, 36);
		getContentPane().add(boton_Sanidad);
		
		JButton boton_contabilidad = new JButton("Contabilidad");
		boton_contabilidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		boton_contabilidad.setBounds(283, 111, 140, 36);
		getContentPane().add(boton_contabilidad);
		
		JButton boton_Comedor = new JButton("Comedor");
		boton_Comedor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		boton_Comedor.setBounds(283, 33, 140, 36);
		getContentPane().add(boton_Comedor);
		
		JButton boton_Gestoria = new JButton("Gestoria");
		boton_Gestoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerEmpleado.getInstance().gestoria(getFrame());
			}
		});
		boton_Gestoria.setFont(new Font("Tahoma", Font.PLAIN, 18));
		boton_Gestoria.setBounds(165, 176, 140, 36);
		getContentPane().add(boton_Gestoria);
		setVisible(true);
	}
	
	private JFrame getFrame() {
		return this;
	}
}
