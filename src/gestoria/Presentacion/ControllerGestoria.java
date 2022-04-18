package gestoria.Presentacion;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import empleados.Negocio.TEmpleado;
import empleados.Negocio.TEmpleadoLimpieza;
import empleados.Presentacion.SingletonControllerEmpleado;
import gestoria.Negocio.GestoriaObserver;
import gestoria.Negocio.SingletonServiAppGestoria;
import gestoria.Negocio.TInstalacion;
import gestoria.Negocio.TLimpieza;
import launcher.Factory;

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

	public void menuInstalacionesGestor(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaMenuInstalacionesGestor(frame);
			}
		});
	}
	
	public void menuMantenimientoGestor(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaMenuMantenimientoGestor(frame);
			}
		});
	}
	
	public void mostrarLimpieza(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaVerLimpiezaGestor(frame);
			}
		});
	}
	
	public void mostrarInstalacion(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaVerInstalacionGestor(frame);
			}
		});
	}
	
	public void mostrarModificarLimpieza(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaModificarLimpiezaGestor(frame);
			}
		});
	}
	
	public void mostrarModificarInstalacion(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaModificarInstalacionGestor(frame);
			}
		});
	}
	
	public void mostrarEliminarLimpieza(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaEliminarLimpiezaGestor(frame);
			}
		});
	}
	
	public void mostrarEliminarInstalacion(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaEliminarInstalacionGestor(frame);
			}
		});
	}
	
	public void mostrarCrearLimpieza(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaCrearLimpiezaGestor(frame);
			}
		});
	}
	
	public void mostrarCrearInstalacion(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaCrearInstalacionGestor(frame);
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
	
	public void añadirInstalacion(String codigo, String nombre, String superficie, String precio, boolean actividades,
			JFrame frame) {
		boolean existe = SingletonServiAppGestoria.getInstance().añadirInstalacion(codigo, nombre, superficie, precio, actividades, frame);
		if (existe) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					frame.setVisible(false);
					new VistaMenuInstalacionesGestor(frame);
				}
			});
		}
		else {
			JOptionPane.showMessageDialog(frame, "Codigo no disponible", "Error", JOptionPane.ERROR_MESSAGE);	
		}
	}
	
	public void crearEmpleado(JFrame frame) {
		SingletonControllerEmpleado.getInstance().resgistrar(frame);
	}
	

	public void eliminarLimpieza(JFrame frame, String codigo) {
		SingletonServiAppGestoria.getInstance().eliminarLimpieza(frame, codigo);
	}
	
	public void eliminarInstalacion(JFrame frame, String codigo) {
		SingletonServiAppGestoria.getInstance().eliminarInstalacion(frame, codigo);
	}
	
	public void modificarLimpieza(String codigo, String lugar, String fecha, String hora, String empleado, JFrame frame) {
		SingletonServiAppGestoria.getInstance().modificarLimpieza(codigo, lugar, fecha, hora, empleado);
		frame.setVisible(false);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaMenuLimpiezaGestor(frame);
			}
		});
	}
	
	public void modificarInstalacion(String codigo, String nombre, String superficie, String precio, boolean pagado,
			boolean actividades, JFrame frame) {
		SingletonServiAppGestoria.getInstance().modificarInstalacion(codigo, nombre, superficie, precio, pagado, actividades);
		frame.setVisible(false);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaMenuInstalacionesGestor(frame);
			}
		});
	}
	
	public List<TLimpieza> getListaLimpieza() {
		List<TLimpieza> listaLimpieza = SingletonServiAppGestoria.getInstance().getListaLimpieza();
		return listaLimpieza;
	}
	
	public List<TInstalacion> getListainstalaciones() {
		List<TInstalacion> listaInstalaciones = SingletonServiAppGestoria.getInstance().getListaInstalaciones();
		return listaInstalaciones;
	}
	
	public void addObserver(GestoriaObserver vista) {
		SingletonServiAppGestoria.getInstance().addObserver(vista);
	}

	public List<TEmpleado> getListaEmpleados() {
		return SingletonControllerEmpleado.getInstance().getListaEmpleados();
	}

	

	

	

	

	

	

	

	

	

	

	



}
