package contabilidad.Presentacion;


import javax.swing.JButton;
import javax.swing.JFrame;

import contabilidad.Negocio.ContabilidadObserver;
import contabilidad.Negocio.Gastos;
import contabilidad.Negocio.TGastos;
import contabilidad.Negocio.TIngresos;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VistaGastosContabilidad extends JFrame implements ContabilidadObserver{
	private JFrame atras;
	private String nombreUsuario;
	public VistaGastosContabilidad(JFrame frame) {
		setTitle("Menú de Gastos");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,300);
		
		this.atras = frame;
		
		JButton boton_Atras = new JButton("Atrás");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(373, 215, 97, 25);
		getContentPane().add(boton_Atras);
		
		
		JButton boton_Añadir = new JButton("A\u00F1adir Gasto");
		boton_Añadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				SingletonControllerContabilidad.getInstance().mostrarCrearGasto(getFrame());
			}
		});
		boton_Añadir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		boton_Añadir.setBounds(287, 65, 145, 38);
		getContentPane().add(boton_Añadir);
		
		JButton boton_Eliminar = new JButton("Eliminar Gastos");
		boton_Eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				SingletonControllerContabilidad.getInstance().mostrarEliminarGastos(getFrame());

			}
		});
		boton_Eliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		boton_Eliminar.setBounds(53, 157, 145, 38);
		getContentPane().add(boton_Eliminar);
		
		JButton boton_Modificar = new JButton("Modificar Gastos");
		boton_Modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				SingletonControllerContabilidad.getInstance().mostrarModificarGastos(getFrame());

			}
		});
		boton_Modificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		boton_Modificar.setBounds(287, 157, 145, 38);
		getContentPane().add(boton_Modificar);

		
		JButton boton_Mostrar = new JButton("Mostrar Gastos");
		boton_Mostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				SingletonControllerContabilidad.getInstance().mostrarGastos(getFrame());

			}
		});
		boton_Mostrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		boton_Mostrar.setBounds(53, 65, 145, 38);
		getContentPane().add(boton_Mostrar);
		
		
		setVisible(true);
	}
	
	private JFrame getFrame() {
		return this;
	}
	
	private void update(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	

	@Override
	public void onRegister(List<TGastos> listaGastos, List<TIngresos> listaIngresos, String nombreUsuario) {
		
		this.update(nombreUsuario);
	}

	@Override
	public void onCreate(List<TGastos> listaLimpieza, List<TIngresos> listaIngresos, String nombreUsuario) {
		this.update(nombreUsuario);	
	}

	@Override
	public void onActualizar(List<TGastos> listaLimpieza, List<TIngresos> listaIngresos, String nombreUsuario) {
		this.update(nombreUsuario);
		
	}
}
