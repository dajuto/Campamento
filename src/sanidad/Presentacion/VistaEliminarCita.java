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
import gestoria.Negocio.TMantenimiento;
import gestoria.Presentacion.SingletonControllerGestoria;
import sanidad.Negocio.SanidadObserver;
import sanidad.Negocio.SingletonServiAppSanidad;
import sanidad.Negocio.TCita;
import sanidad.Negocio.TReceta;

public class VistaEliminarCita extends JFrame implements SanidadObserver{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame atras;
	private String nombreUsuario;
	private JComboBox<Integer> codCita;
	List<TCita> listCitas;
	
	

	public VistaEliminarCita(JFrame frame) {
		setTitle("Menu Eliminar Cita");
		this.atras=frame;
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(551,275);
		
		JLabel lblNewLabel = new JLabel("Eliminar Cita Medico: " + nombreUsuario);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 261, 20);
		getContentPane().add(lblNewLabel);
		
		codCita = new JComboBox<Integer>();
		codCita.setBounds(330, 54, 184, 26);
		for(TCita te: SingletonServiAppSanidad.getInstance().getListaCitas()) {
			codCita.addItem(te.getCodigo());
		}
		getContentPane().add(codCita);
		
		JLabel lblMedico = new JLabel("Codigo de la Cita que desea eliminar: ");
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
				for (TCita l: listCitas) {
					if (l.getCodigo()==((int)codCita.getSelectedItem())) {
						SingletonControllerSanidad.getInstance().modificarMedico(l.getNombremedico(), codCita.getSelectedItem().toString());
					}
				}
				SingletonControllerSanidad.getInstance().eliminarCita(atras, ((int)codCita.getSelectedItem()));
			}
		});
		boton_Aceptar.setBounds(27, 163, 150, 25);
		getContentPane().add(boton_Aceptar);
		
		setVisible(true);
	}


	
	private void update(List<TCita> lista,  String nombreUsuario) {
		this.listCitas = lista;
		//this.listaAcampados=listaAcampados;
		this.nombreUsuario = nombreUsuario;
	}



	@Override
	public void onRegister(List<TReceta> listaRecetas, List<TCita> listaCitas, List<TMedico> listaMedicos,
			String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(listaCitas, nombreUsuario);
	}



	@Override
	public void onEliminar(List<TReceta> listaRecetas, List<TCita> listaCitas, List<TMedico> listaMedicos,
			String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(listaCitas, nombreUsuario);
	}



	@Override
	public void onConsultar(List<TReceta> listaRecetas, List<TCita> listaCitas, List<TMedico> listaMedicos,
			String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(listaCitas, nombreUsuario);
	}



	@Override
	public void onCrear(List<TReceta> listaRecetas, List<TCita> listaCitas, List<TMedico> listaMedicos,
			String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(listaCitas, nombreUsuario);
	}

}