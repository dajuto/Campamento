package sanidad.Presentacion;

import java.awt.Frame;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import launcher.Factory;
import sanidad.Negocio.SanidadObserver;
import sanidad.Negocio.SingletonServiAppSanidad;

public class ControllerSanidad {

	
	public void registraUsuario(String text, char[] password) {
		SingletonServiAppSanidad.getInstance().registraUsuario(text, password);
	}
	
	
	public void registraFactoria(Factory<Object> objetosFactory) {
		SingletonServiAppSanidad.getInstance().registraFactoria(objetosFactory);
	}

	public void mostrarMenuMedico(Frame frame) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaMenuMedico(frame);
			}
		});
	}

	public void mostrarListaCitas(Frame frame) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaVerListaCitas(frame);
			}
		});
	}
	
	public void mostrarEliminarCita(Frame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaEliminarCita(frame);
			}
		});
	}
	public void mostrarConsultarCitas(Frame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaConsultarListaCitas(frame);
			}
		});
	}
	
	public void mostrarCrearReceta(Frame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaCrearReceta(frame);
			}
		});
	}

	public void mostrarEliminarReceta(Frame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaEliminarReceta(frame);
			}
		});
	}
	public void mostrarListaRecetas(Frame frame) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaVerListaRecetas(frame);
			}
		});
	}
	public void mostrarConsultarRecetas(Frame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaConsultarListaRecetas(frame);
			}
		});
	}

/*public void anadirActividad(Frame ventanaListaActividad, String cod, String lugar, String desc, String Fecha) {
		boolean isNumericCodigo =  cod.matches("[+-]?\\d*(\\.\\d+)?");
		boolean isNumericLugar =  lugar.matches("[+-]?\\d*(\\.\\d+)?");
		boolean isNumericDesc =  desc.matches("[+-]?\\d*(\\.\\d+)?");
		if(isNumericCodigo && !isNumericLugar && !isNumericDesc) {
			int codigoActividad = Integer.parseInt(cod);
			boolean exito = SingletonServiAppSanidad.getInstance().anadirActividad(codigoActividad, lugar, desc, Fecha);
			if(!exito) {
				JOptionPane.showMessageDialog(ventanaListaActividad, "Ya existe una actividad con el mismo codigo", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(ventanaListaActividad, "Los datos introducidos en el formulario no son validos", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}*/
	

	public void addObserver(SanidadObserver vista) {
		SingletonServiAppSanidad.getInstance().addObserver(vista);
	}

	
}
