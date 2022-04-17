package gestoria.Presentacion;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import empleados.Negocio.TEmpleadoGestoria;
import empleados.Presentacion.SingletonControllerEmpleado;
import gestoria.Negocio.LimpiezaObserver;
import gestoria.Negocio.SingletonServiAppGestoria;
import gestoria.Negocio.TLimpieza;
import launcher.Factory;
import launcher.Observable;

public class ControllerGestoria {
	
	public void registraUsuario(String text, char[] password) {
		SingletonServiAppGestoria.getInstance().registraUsuario(text, password);
	}

	public void registraFactoria(Factory<Object> objetosFactory) {
		SingletonServiAppGestoria.getInstance().registrarFactoria(objetosFactory);
	}

	public void menuGestor(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaMenuGestor(frame);
			}
		});
	}

	public void menuLimpiezaGestor(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaMenuLimpiezaGestor(frame);
			}
		});
	}

	public void crearLimpieza(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaCrearLimpiezaGestor(frame);
			}
		});
	}
	
	public void añadirLimpieza(String codigo, String lugar, String fecha, String hora, String empleado, JFrame frame) {
		boolean existe = SingletonServiAppGestoria.getInstance().añadirLimpieza(codigo, lugar, fecha, hora, empleado, frame);
		if (existe) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					frame.setVisible(false);
					new VistaMenuLimpiezaGestor(frame);
				}
			});
		}
		else {
			JOptionPane.showMessageDialog(frame, "Codigo no disponible", "Error", JOptionPane.ERROR_MESSAGE);	
		}
	}

	public void mostrarLimpieza(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaVerLimpiezaGestor(frame);
			}
		});
	}
	
	public void crearEmpleado(JFrame frame) {
		SingletonControllerEmpleado.getInstance().resgistrar(frame);
	}
	
	public void mostrarEliminarLimpieza(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaEliminarLimpiezaGestor(frame);
			}
		});
	}

	public void eliminarLimpieza(JFrame frame, String codigo) {
		SingletonServiAppGestoria.getInstance().eliminarLimpieza(frame, codigo);
	}
	
	public List<TLimpieza> getListaCodigosLimpieza() {
		List<TLimpieza> listaLimpieza = SingletonServiAppGestoria.getInstance().getListaLimpiezaGestor();
//		List<String> listaCodigos = null;
//		for (int i = 0; i < listaLimpieza.size(); i++) {
//			String hola = listaLimpieza.get(i).getCodigo();
//			listaCodigos.add(index, element);
//		}
		return listaLimpieza;
	}
	
	public void addObserver(LimpiezaObserver vista) {
		SingletonServiAppGestoria.getInstance().addObserver(vista);
	}

	

	

	
	

	

	


}
