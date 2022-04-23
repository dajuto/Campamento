package actividades.Presentacion;

import java.awt.Frame;

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

	public void mostrarActividadGestor(Frame frame) {
		String nombreUsuario = SingletonServiAppActividad.getInstance().getNombreUsuario();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaActividadGestor(frame, nombreUsuario);
			}
		});
	}

	public void mostrarListaActividadesGestor(Frame frame) {
		//SingletonServiAppActividad.getInstance().updateActividad();
		String nombreUsuario = SingletonServiAppActividad.getInstance().getNombreUsuario();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaListaActividadesGestor(frame);
			}
		});
	}
	
	public void mostrarAnadirActividadGestor(Frame frame) {
		//String nombreUsuario = SingletonServiAppActividad.getInstance().getNombreUsuario();
		//List<TActividad> l = SingletonServiAppActividad.getInstance().getListaActividades();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaAnadirActividadGestor(frame);
			}
		});
	}

	public void mostrarEliminarActividadGestor(Frame frame) {
		//String nombreUsuario = SingletonServiAppActividad.getInstance().getNombreUsuario();
		//List<TActividad> l = SingletonServiAppActividad.getInstance().getListaActividades();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaEliminarActividadGestor(frame);
			}
		});
	}


	public void anadirActividad(Frame ventanaListaActividad, String cod, String lugar, String desc, String Fecha) {
		boolean isNumericCodigo =  cod.matches("[+-]?\\d*(\\.\\d+)?");
		boolean isNumericLugar =  lugar.matches("[+-]?\\d*(\\.\\d+)?");
		boolean isNumericDesc =  desc.matches("[+-]?\\d*(\\.\\d+)?");
		if(isNumericCodigo && !isNumericLugar && !isNumericDesc) {
			int codigoActividad = Integer.parseInt(cod);
			boolean exito = SingletonServiAppActividad.getInstance().anadirActividad(codigoActividad, lugar, desc, Fecha);
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
