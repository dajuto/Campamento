package sanidad.Presentacion;

import java.awt.Frame;
import java.util.List;

import javax.swing.JFrame;

import empleados.Negocio.TMedico;
import sanidad.Negocio.SanidadObserver;
import sanidad.Negocio.TReceta;

public class VistaCrearReceta extends JFrame implements SanidadObserver{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VistaCrearReceta(JFrame frame) {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unused")
	private JFrame getFrame() {
		return this;
	}

	@Override
	public void onRegister(List<TReceta> listaRecetas, List<TMedico> listaMedicos, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCrearReceta(List<TReceta> listaRecetas, List<TMedico> listaMedicos, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEliminarReceta(List<TReceta> listaRecetas, List<TMedico> listaMedicos, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConsultarReceta(List<TReceta> listaRecetas, List<TMedico> listaMedicos, String nombreUsuario) {
		// TODO Auto-generated method stub
		
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
