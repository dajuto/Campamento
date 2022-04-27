package actividades.Presentacion;

import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import actividades.Negocio.ActividadObserver;
import actividades.Negocio.SingletonServiAppActividad;
import launcher.Factory;

public class ControllerActividad {

	public void registraUsuario(String text, char[] password) {
		SingletonServiAppActividad.getInstance().registraUsuario(text, password);
	}
	
	
	
	public void registraFactoria(Factory<Object> objetosFactory) {
		SingletonServiAppActividad.getInstance().registrarFactoria(objetosFactory);
	}

	public void mostrarActividadGestor(JFrame frame) {
		//String nombreUsuario = SingletonServiAppActividad.getInstance().getNombreUsuario();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaActividadGestor(frame);
			}
		});
	}

	public void mostrarListaActividadesGestor(JFrame frame) {
		//SingletonServiAppActividad.getInstance().updateActividad();
		String nombreUsuario = SingletonServiAppActividad.getInstance().getNombreUsuario();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaListaActividadesGestor(frame);
			}
		});
	}
	
	public void mostrarAnadirActividadGestor(JFrame frame) {
		//String nombreUsuario = SingletonServiAppActividad.getInstance().getNombreUsuario();
		//List<TActividad> l = SingletonServiAppActividad.getInstance().getListaActividades();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaAnadirActividadGestor(frame);
			}
		});
	}

	public void mostrarEliminarActividadGestor(JFrame frame) {
		//String nombreUsuario = SingletonServiAppActividad.getInstance().getNombreUsuario();
		//List<TActividad> l = SingletonServiAppActividad.getInstance().getListaActividades();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaEliminarActividadGestor(frame);
			}
		});
	}


	public void anadirActividad(JFrame ventanaListaActividad, String id, String nombre, String instalacion, String monitor) {
		boolean isNumericId =  id.matches("[+-]?\\d*(\\.\\d+)?");
		boolean isNumericNombre =  nombre.matches("[+-]?\\d*(\\.\\d+)?");
		boolean isNumericInstalacion =  instalacion.matches("[+-]?\\d*(\\.\\d+)?");
		boolean isNumericMonitor = instalacion.matches("[+-]?\\d*(\\.\\d+)?");
		if(isNumericId && !isNumericNombre && !isNumericInstalacion && !isNumericMonitor) {
			int idActividad = Integer.parseInt(id);
			boolean exito = SingletonServiAppActividad.getInstance().anadirActividad(idActividad, nombre, instalacion, monitor);
			if(!exito) {
				JOptionPane.showMessageDialog(ventanaListaActividad, "Ya existe una actividad con el mismo codigo", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(ventanaListaActividad, "Los datos introducidos en el formulario no son validos", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}


	public void eliminarActividad(Frame ventanaListaActividad, int codigoActividad) {
		boolean exito = SingletonServiAppActividad.getInstance().eliminarActividad(ventanaListaActividad, codigoActividad);
		if(!exito) {
			JOptionPane.showMessageDialog(ventanaListaActividad, "La actividad no ha podido ser borrada", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void addObserver(ActividadObserver vista) {
		SingletonServiAppActividad.getInstance().addObserver(vista);
	}

	
	
}
