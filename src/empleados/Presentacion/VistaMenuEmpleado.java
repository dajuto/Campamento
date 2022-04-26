package empleados.Presentacion;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import empleados.Negocio.EmpleadoObserver;
import empleados.Negocio.TEmpleado;

import java.awt.Font;

public class VistaMenuEmpleado extends JFrame implements EmpleadoObserver{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombreUsuario=SingletonControllerEmpleado.getInstance().getNombreUsuario();
	
	public VistaMenuEmpleado() {
		setTitle("Menu del empleado: "+ nombreUsuario);
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,300);
		
		JButton boton_actividades = new JButton("Actividades");
		boton_actividades.setFont(new Font("Tahoma", Font.PLAIN, 18));
		boton_actividades.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerEmpleado.getInstance().actividades(getFrame());
			}
			
		});

		boton_actividades.setBounds(49, 33, 140, 36);
		getContentPane().add(boton_actividades);

		JButton boton_Sanidad = new JButton("Sanidad");
		boton_Sanidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		boton_Sanidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerEmpleado.getInstance().sanidad(getFrame());
			}
		});
		boton_Sanidad.setBounds(49, 111, 140, 36);
		getContentPane().add(boton_Sanidad);
		
		JButton boton_contabilidad = new JButton("Contabilidad");	
		boton_contabilidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerEmpleado.getInstance().contabilidad(getFrame());
			}
		});
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
		
		JButton btnCerrarSesin = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerEmpleado.getInstance().iniciarSesion();
			}
		});
		btnCerrarSesin.setBounds(349, 215, 121, 25);
		getContentPane().add(btnCerrarSesin);
		setVisible(true);
	}
	
	private JFrame getFrame() {
		return this;
	}
	
	private void update(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	@Override
	public void onRegister(List<TEmpleado> listaAcampados, String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
	}

	@Override
	public void onCreateEmpleado(List<TEmpleado> lista, String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
	}

	@Override
	public void onEliminarEmpleado(List<TEmpleado> lista, String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
	}

	@Override
	public void onModificarEmpleado(List<TEmpleado> listaEmpleados, String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
	}
}
