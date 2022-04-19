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
		
		JButton boton_Mostrar = new JButton("Mostrar Gastos");
		boton_Mostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				SingletonControllerContabilidad.getInstance().mostrarGastos(getFrame());

			}
		});
		boton_Mostrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		boton_Mostrar.setBounds(54, 110, 145, 38);
		getContentPane().add(boton_Mostrar);
		

		JButton boton_Añadir = new JButton("A\u00F1adir Gasto");
		boton_Añadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				SingletonControllerContabilidad.getInstance().mostrarCrearGasto(getFrame());
			}
		});
		boton_Añadir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		boton_Añadir.setBounds(284, 110, 145, 38);
		getContentPane().add(boton_Añadir);

		
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
	public void onActualizar(List<Gastos> listaLimpieza, List<TIngresos> listaIngresos, String nombreUsuario) {
		this.update(nombreUsuario);
		
	}
}
