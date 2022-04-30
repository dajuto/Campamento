package actividades.Presentacion;

import java.awt.Font;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import actividades.Negocio.ActividadObserver;
import actividades.Negocio.SingletonServiAppActividad;
import actividades.Negocio.TActividad;


public class VistaModificarActividadGestor extends JFrame implements ActividadObserver{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombreUsuario;
	private Frame ventanaAnterior;
	private JFrame atras;
	private JComboBox<Integer> id;
	private JComboBox<String> instalacion;
	List<TActividad> listaActividades;
	private JTextField nombre;
	private JTextField monitor;
	
	public VistaModificarActividadGestor(JFrame frame) {
		setTitle("Modificar actividad");
		this.ventanaAnterior = frame;
		
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(551,501);
		this.setLocation(550,10);
		
		this.listaActividades = SingletonServiAppActividad.getInstance().getListaActividades();
		
		JButton boton_Atras = new JButton("Atras");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(373, 265, 97, 25);
		getContentPane().add(boton_Atras);
		
		JLabel labmodificar = new JLabel("Modificar Actividad");
		labmodificar.setFont(new Font("Times New Roman", Font.BOLD, 24));
		labmodificar.setBounds(25, 14, 341, 36);
		getContentPane().add(labmodificar);
		
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodigo.setBounds(25, 63, 69, 25);
		getContentPane().add(lblCodigo);
		
		id = new JComboBox<Integer>();
		id.setBounds(121, 63, 116, 22);
		for(TActividad cod: this.listaActividades) {
			id.addItem(cod.getId());
		}
		getContentPane().add(id);
		
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(25, 101, 69, 25);
		getContentPane().add(lblNombre);
		
		nombre = new JTextField();
		nombre.setBounds(121, 103, 116, 22);
		nombre.setText(listaActividades.get(0).getNombre());
		getContentPane().add(nombre);
		
		
		JLabel lblInstalacion = new JLabel("Instalacion:");
		lblInstalacion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInstalacion.setBounds(25, 137, 84, 25);
		getContentPane().add(lblInstalacion);
		
		instalacion = new JComboBox<String>();
		instalacion.setBounds(121, 139, 116, 22);
		for(TActividad cod: this.listaActividades) {
			instalacion.addItem(cod.getInstalacion());
		}
		getContentPane().add(instalacion);
		
		
		JLabel lblMonitor = new JLabel("Monitor:");
		lblMonitor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMonitor.setBounds(25, 175, 69, 25);
		getContentPane().add(lblMonitor);
		
		monitor = new JTextField();
		monitor.setBounds(121, 177, 116, 22);
		monitor.setText(listaActividades.get(0).getMonitor());
		getContentPane().add(monitor);
		
		
		JButton boton_modificar = new JButton("Modificar");
		boton_modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SingletonControllerActividad.getInstance().anadirActividad(atras, id.getSelectedItem().toString(), nombre.getText(), instalacion.getSelectedItem().toString(), monitor.getText());
			}
		});
		boton_modificar.setBounds(269, 129, 97, 25);
		getContentPane().add(boton_modificar);
		
		
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
