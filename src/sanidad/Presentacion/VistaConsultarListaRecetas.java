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
import sanidad.Negocio.SingletonServiAppSanidad;
import sanidad.Negocio.TCita;
import sanidad.Negocio.TReceta;

public class VistaConsultarListaRecetas extends JFrame implements SanidadObserver{
	
	private static final long serialVersionUID = 1L;
	private JFrame atras;
	private String nombreUsuario=SingletonControllerSanidad.getInstance().getNombreUsuarioSanidad();
	private JComboBox<Integer> codReceta;
	List<TReceta> listaRecetas;

	public VistaConsultarListaRecetas(JFrame frame) {
		setTitle("Menu Consultar Receta");
		this.atras=frame;
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(551,275);
		this.setLocation(550,10);
		
		
		JLabel lblNewLabel = new JLabel("Consultar Receta Medico: " + nombreUsuario);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 261, 20);
		getContentPane().add(lblNewLabel);
		
		
		
		
		
		codReceta = new JComboBox<Integer>();
		codReceta.setBounds(65, 84, 184, 26);
		for(TReceta te: SingletonServiAppSanidad.getInstance().getListaRecetas()) {
			if(te.getNombremedico().equals(this.nombreUsuario)) {
				codReceta.addItem(te.getCodigo());
			}
		}
		getContentPane().add(codReceta);
		
		JLabel lblMedico = new JLabel("Codigo de la Receta que desea poner como Adquirida: ");
		lblMedico.setBounds(77, 48, 391, 20);
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
				SingletonControllerSanidad.getInstance().consultarCompraReceta(atras, (int) codReceta.getSelectedItem());
			}
		});
		boton_Aceptar.setBounds(297, 85, 194, 25);
		getContentPane().add(boton_Aceptar);
		
		setVisible(true);
	}

	private void update(List<TReceta> listarecetas,  String nombreUsuario) {
		this.listaRecetas = listarecetas;
		//this.listaAcampados=listaAcampados;
		this.nombreUsuario = nombreUsuario;
	}


	@Override
	public void onRegister(List<TReceta> listaRecetas, List<TCita> listaCitas, List<TMedico> listaMedicos,
			String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(listaRecetas, nombreUsuario);
	}

	@Override
	public void onEliminar(List<TReceta> listaRecetas, List<TCita> listaCitas, List<TMedico> listaMedicos,
			String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(listaRecetas, nombreUsuario);
	}

	@Override
	public void onConsultar(List<TReceta> listaRecetas, List<TCita> listaCitas, List<TMedico> listaMedicos,
			String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(listaRecetas, nombreUsuario);
	}

	@Override
	public void onCrear(List<TReceta> listaRecetas, List<TCita> listaCitas, List<TMedico> listaMedicos,
			String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(listaRecetas, nombreUsuario);
	}

}
