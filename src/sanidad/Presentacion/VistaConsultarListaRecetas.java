package sanidad.Presentacion;

import java.awt.Color;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import empleados.Negocio.TMedico;
import sanidad.Negocio.SanidadObserver;
import sanidad.Negocio.TReceta;

public class VistaConsultarListaRecetas extends JFrame implements SanidadObserver{
	
	private static final long serialVersionUID = 1L;
	private JFrame atras;
	private String nombreUsuario;
	private JComboBox<TReceta> codReceta;
	List<TReceta> listaRecetas;

	public VistaConsultarListaRecetas(JFrame frame) {
		setTitle("Menu Consultar Receta");
		this.atras=frame;
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(551,275);
		
		JLabel lblNewLabel = new JLabel("Consultar Receta Medico: " + nombreUsuario);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 261, 20);
		getContentPane().add(lblNewLabel);
		
		
		for(TReceta te: this.listaRecetas) {
			codReceta.addItem(te);
		}
		
		
		codReceta = new JComboBox<TReceta>();
		codReceta.setBounds(353, 70, 138, 26);
		getContentPane().add(codReceta);
		
		JLabel lblMedico = new JLabel("Codigo de la Receta que desea poner como Adquirida: ");
		lblMedico.setBounds(36, 73, 314, 20);
		getContentPane().add(lblMedico);
		
		JButton boton_Atras = new JButton("Atras");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				//atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(353, 162, 138, 25);
		getContentPane().add(boton_Atras);
		
		JButton boton_Aceptar = new JButton("Aceptar");
		boton_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerSanidad.getInstance().consultarCompraReceta(atras, ((TReceta)codReceta.getSelectedItem()).getCodigo());
			}
		});
		boton_Aceptar.setBounds(36, 162, 244, 25);
		getContentPane().add(boton_Aceptar);
		
	}

	private void update(List<TReceta> listarecetas,  String nombreUsuario) {
		this.listaRecetas = listarecetas;
		//this.listaAcampados=listaAcampados;
		this.nombreUsuario = nombreUsuario;
	}
	@Override
	public void onRegister(List<TReceta> listaRecetas, List<TMedico> listaMedicos, String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(listaRecetas, nombreUsuario);
	}



	@Override
	public void onCrearReceta(List<TReceta> listaRecetas, List<TMedico> listaMedicos, String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(listaRecetas, nombreUsuario);
	}



	@Override
	public void onEliminarReceta(List<TReceta> listaRecetas, List<TMedico> listaMedicos, String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(listaRecetas, nombreUsuario);
	}



	@Override
	public void onConsultarReceta(List<TReceta> listaRecetas, List<TMedico> listaMedicos, String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(listaRecetas, nombreUsuario);
	}



	@Override
	public void onEliminarCita(List<TReceta> listaCitas, List<TMedico> listaMedicos, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onConsultarCita(List<TReceta> listaCitas, List<TMedico> listaMedicos, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}

}
