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

import acampados.Negocio.TAcampado;
import empleados.Negocio.TMedico;
import sanidad.Negocio.SanidadObserver;
import sanidad.Negocio.SingletonServiAppSanidad;
import sanidad.Negocio.TReceta;

public class VistaEliminarReceta extends JFrame implements SanidadObserver{
	
	private JFrame atras;
	private String nombreUsuario;
	private JComboBox<Integer> codReceta;
	List<TReceta> listaRecetas;
	
	

	public VistaEliminarReceta(JFrame frame) {
		setTitle("Menu Añadir Receta");
		this.atras=frame;
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(551,275);
		
		JLabel lblNewLabel = new JLabel("Eliminar Receta Medico: " + nombreUsuario);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 261, 20);
		getContentPane().add(lblNewLabel);
		
		codReceta = new JComboBox<Integer>();
		codReceta.setBounds(330, 54, 184, 26);
		for(TReceta te: SingletonServiAppSanidad.getInstance().getListaRecetas()) {
			codReceta.addItem(te.getCodigo());
		}
		getContentPane().add(codReceta);
		
		JLabel lblMedico = new JLabel("Codigo de la Receta que desea eliminar: ");
		lblMedico.setBounds(27, 57, 314, 20);
		getContentPane().add(lblMedico);
		
		JButton boton_Atras = new JButton("Atras");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				//atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(364, 163, 150, 25);
		getContentPane().add(boton_Atras);
		
		JButton boton_Aceptar = new JButton("Aceptar");
		boton_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerSanidad.getInstance().eliminarReceta(atras, ((int)codReceta.getSelectedItem()));
			}
		});
		boton_Aceptar.setBounds(27, 163, 150, 25);
		getContentPane().add(boton_Aceptar);
		
		setVisible(true);
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
