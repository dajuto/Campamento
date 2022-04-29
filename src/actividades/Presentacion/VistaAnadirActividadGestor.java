package actividades.Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import acampados.Negocio.TAcampado;
import actividades.Negocio.ActividadObserver;
import actividades.Negocio.TActividad;
import empleados.Negocio.TEmpleado;
import gestoria.Negocio.TInstalacion;
import gestoria.Presentacion.SingletonControllerGestoria;
import sanidad.Presentacion.SingletonControllerSanidad;

public class VistaAnadirActividadGestor extends JFrame implements ActividadObserver{
	private String nombreUsuario;
	private JButton aceptar;
	private JFrame atras;
	private JLabel ingresaId;
	private JTextField id;
	private JLabel ingresaInstalacion;
	private JTextField instalacion;
	private JLabel ingresaNombre;
	private JTextField nombre;
	private JTextField monitor;
	private JLabel ingresaMonitor;
	JComboBox<String> comboBox;
	//List<TMonitor> listaMonitor; 
	
	private Frame ventanaAnterior;

	public VistaAnadirActividadGestor(JFrame f) {
		setTitle("Crear nueva actividad");
		this.ventanaAnterior = f;
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(551,501);
		this.setLocation(550,10);
		
		
		
		JButton boton_Atras = new JButton("Atras");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				//atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(376, 32, 138, 25);
		getContentPane().add(boton_Atras);
		

		JButton boton_Aceptar = new JButton("Aceptar");
		boton_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerActividad.getInstance().anadirActividad(atras, id.getText(), nombre.getText(), instalacion.getText(), comboBox.getSelectedItem().toString());
				
			}
		});
		boton_Aceptar.setBounds(15, 404, 499, 25);
		getContentPane().add(boton_Aceptar);
		
		JLabel lblNewLabel = new JLabel("Añadir Nueva actividad: " + nombreUsuario);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 261, 20);
		getContentPane().add(lblNewLabel);
		
		
		ingresaId = new JLabel("Id: ");
		ingresaId.setBounds(15, 93, 69, 20);
		getContentPane().add(ingresaId);
		
		id = new JTextField();
		id.setBounds(142, 90, 146, 26);
		getContentPane().add(id);
		id.setColumns(10);
		
		
		ingresaNombre = new JLabel("Nombre: ");
		ingresaNombre.setBounds(15, 129, 112, 20);
		getContentPane().add(ingresaNombre);
		

		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(142, 126, 146, 26);
		getContentPane().add(nombre);
		
		ingresaInstalacion = new JLabel("Instalacion: ");
		ingresaInstalacion.setBounds(15, 165, 69, 20);
		getContentPane().add(ingresaInstalacion);
		
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(142, 162, 146, 26);
		for(TInstalacion e: SingletonControllerGestoria.getInstance().getListaInstalaciones()) {
			if (e.isPuedeActividades()) {
				comboBox.addItem(e.getNombre());
			}
		}
		getContentPane().add(comboBox);
		/*instalacion = new JTextField();
		instalacion.setColumns(10);
		instalacion.setBounds(142, 162, 146, 26);
		getContentPane().add(instalacion);*/
		
		ingresaMonitor = new JLabel("Monitor: ");
		ingresaMonitor.setBounds(15, 201, 69, 20);
		getContentPane().add(ingresaMonitor);
		
		monitor = new JTextField();
		monitor.setColumns(10);
		monitor.setBounds(142, 200, 146, 22);
		getContentPane().add(monitor);
		
		
		
		
		
		
		this.setVisible(true);
	}
	
	
	private void update(String nombreUsuario) {
		this.nombreUsuario=nombreUsuario;
	}

	@Override
	public void onRegister(List<TActividad> lista) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
	}

	@Override
	public void onCreateActividad(List<TActividad> lista) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);

	}

	@Override
	public void onEliminarActividad(List<TActividad> lista) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);

	}
}

