package contabilidad.Presentacion;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import contabilidad.Negocio.SingletonServiAppContabilidad;
import empleados.Negocio.TEmpleado;
import empleados.Negocio.TEmpleadoLimpieza;
import empleados.Presentacion.SingletonControllerEmpleado;
import gestoria.Negocio.GestoriaObserver;
import gestoria.Negocio.SingletonServiAppGestoria;
import gestoria.Negocio.TInstalacion;
import gestoria.Negocio.TLimpieza;
import gestoria.Presentacion.VistaCrearLimpiezaGestor;
import launcher.Factory;

public class ControllerContabilidad {
	
	public void registraUsuario(String text, char[] password) {
		SingletonServiAppGestoria.getInstance().registraUsuario(text, password);
	}

	public void registraFactoria(Factory<Object> objetosFactory) {
		SingletonServiAppGestoria.getInstance().registrarFactoria(objetosFactory);
	}

	
	
	public void menuContabilidad(JFrame frame) {  //hecha
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaMenuContabilidad(frame);
			}
		});
	}

	public void menuGastos(JFrame frame) { //hecha
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaGastosContabilidad(frame);
			}
		});
	}

	public void menuIngresos(JFrame frame) { //hecha
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaIngresosContabilidad(frame);
			}
		});
	}

	
		public void mostrarGastos(JFrame frame) { //hecha
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					new VistaVerGastos(frame);
			    }
			});
		}
	
		public void mostrarIngresos(JFrame frame) { //hecha
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					new VistaVerIngresos(frame);
			    }
			});
		}
	
	public void mostrarCrearGasto(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaCrearGasto(frame);
			}
		});
	}
	
	public void mostrarCrearIngreso(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaCrearIngreso(frame);
			}
		});
	}

	
	 //ALVARO
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
	

	//ADRIANA
	public void añadirGasto(String cuenta, String concepto, String importe, String fecha, String empleado, JFrame frame) {
		boolean existe = SingletonServiAppContabilidad.getInstance().añadirGasto(cuenta, concepto, importe, fecha, empleado, frame);
		if (existe) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					frame.setVisible(false);
					new VistaGastosContabilidad(frame); 
				}
			});
		}
		else {
			JOptionPane.showMessageDialog(frame, "Codigo no disponible", "Error", JOptionPane.ERROR_MESSAGE);	
		}
	}
	
	public void añadirIngreso(String cuenta, String concepto, String importe, String fecha, String empleado, JFrame frame) {
		boolean existe = SingletonServiAppContabilidad.getInstance().añadirIngreso(cuenta, concepto, importe, fecha, empleado, frame);
		if (existe) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					frame.setVisible(false);
					new VistaIngresosContabilidad(frame);  
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
	
	public void mostrarModificarLimpieza(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaModificarLimpiezaGestor(frame);
			}
		});
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
	
	public void modificarEmpleadoLimpieza(String empleado, String codigo) {
		SingletonControllerEmpleado.getInstance().modificarEmpleadoLimpieza(empleado, codigo);
	}



	

}
