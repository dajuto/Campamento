package sanidad.Presentacion;

import java.awt.Font;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import empleados.Negocio.TMedico;
import sanidad.Negocio.SanidadObserver;
import sanidad.Negocio.TCita;
import sanidad.Negocio.TReceta;

public class VistaMenuMedico  extends JFrame implements SanidadObserver{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame atras;
	private String nombreUsuario;
	
	
	public VistaMenuMedico(JFrame frame) {
		setTitle("Menu de Sanidad");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,300);
		
		this.atras = frame;
		
		JButton boton_Atras = new JButton("Atras");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(373, 215, 97, 25);
		getContentPane().add(boton_Atras);
		
		JButton boton_Recetas = new JButton("Recetas");
		boton_Recetas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerSanidad.getInstance().menuRecetas(getFrame());
			}
		});
		boton_Recetas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		boton_Recetas.setBounds(282, 78, 181, 59);
		getContentPane().add(boton_Recetas);
		
		JButton boton_Citas = new JButton("Citas");
		boton_Citas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerSanidad.getInstance().menuCitas(getFrame());
			}
		});
		boton_Citas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		boton_Citas.setBounds(15, 78, 181, 59);
		getContentPane().add(boton_Citas);
		
		
		this.setVisible(true);
	}

	private JFrame getFrame() {
		return this;
	}
	
	private void update(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	


	@Override
	public void onRegister(List<TReceta> listaRecetas, List<TCita> listaCitas, List<TMedico> listaMedicos,
			String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
	}

	@Override
	public void onEliminar(List<TReceta> listaRecetas, List<TCita> listaCitas, List<TMedico> listaMedicos,
			String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
	}

	@Override
	public void onConsultar(List<TReceta> listaRecetas, List<TCita> listaCitas, List<TMedico> listaMedicos,
			String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
	}

	@Override
	public void onCrear(List<TReceta> listaRecetas, List<TCita> listaCitas, List<TMedico> listaMedicos,
			String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
	}

}
