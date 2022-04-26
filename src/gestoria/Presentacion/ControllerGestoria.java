package gestoria.Presentacion;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import acampados.Negocio.TAcampado;
import acampadosPresentacion.SingletonControllerAcampado;
import contabilidad.Presentacion.VistaCrearGasto;
import contabilidad.Presentacion.VistaCrearGasto;
import empleados.Negocio.TEmpleado;
import empleados.Negocio.TEmpleadoLimpieza;
import empleados.Presentacion.SingletonControllerEmpleado;
import gestoria.Negocio.GestoriaObserver;
import gestoria.Negocio.SingletonServiAppGestoria;
import gestoria.Negocio.TInstalacion;
import gestoria.Negocio.TLimpieza;
import gestoria.Negocio.TMantenimiento;
import launcher.Factory;

public class ControllerGestoria {
	
	public String getNombreAcampado() {
		return SingletonControllerAcampado.getInstance().getAcampado();
	}

	public void registraFactoria(Factory<Object> objetosFactory) {
		SingletonServiAppGestoria.getInstance().registrarFactoria(objetosFactory);
	}

	public void menuGestor() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaMenuGestor();
			}
		});
	}
	
	public void menuAcampadoGestoria() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaMenuAcampado();
			}
		});
	}
	
	public void menuAcampado(JFrame frame) {
		SingletonControllerAcampado.getInstance().menuAcampado(frame);
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
	
	public void mostrarMantenimiento(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaVerMantenimientoGestor(frame);
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
	
	public void mostrarModificarMantenimiento(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaModificarMantenimientoGestor(frame);
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
	
	public void mostrarEliminarMantenimiento(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaEliminarMantenimientoGestor(frame);
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
	
	public void mostrarCrearMantenimiento(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaCrearMantenimientoGestor(frame);
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
	
	public void añadirMantenimiento(String codigo, String descripcion, String lugar, String coste, String empleado,
			JFrame frame) {
		boolean existe = SingletonServiAppGestoria.getInstance().añadirMantenimiento(codigo, descripcion, lugar, coste, empleado);
		if (existe) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					frame.setVisible(false);
					new VistaMenuMantenimientoGestor(frame);
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
	
	public void eliminarMantenimiento(JFrame frame, String codigo) {
		SingletonServiAppGestoria.getInstance().eliminarMantenimiento(frame, codigo);
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
	
	public void modificarMantenimiento(String codigo, String descripcion, String lugar, String coste, String empleado,
			String estado, JFrame frame) {
		SingletonServiAppGestoria.getInstance().modificarMantenimiento(codigo, descripcion, lugar, coste, empleado, estado);
		frame.setVisible(false);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaMenuMantenimientoGestor(frame);
			}
		});
	}
	
	public List<TLimpieza> getListaLimpieza() {
		List<TLimpieza> listaLimpieza = SingletonServiAppGestoria.getInstance().getListaLimpieza();
		return listaLimpieza;
	}
	
	public List<TInstalacion> getListaInstalaciones() {
		List<TInstalacion> listaInstalaciones = SingletonServiAppGestoria.getInstance().getListaInstalaciones();
		return listaInstalaciones;
	}
	
	public List<TMantenimiento> getListaAverias() {
		List<TMantenimiento> listaAverias = SingletonServiAppGestoria.getInstance().getListaMantenimiento();
		return listaAverias;
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

	public void modificarEmpleadoMantenimiento(String empleado, String codigo) {
		SingletonControllerEmpleado.getInstance().modificarEmpleadoMantenimiento(empleado, codigo);		
	}

<<<<<<< HEAD
	public void perfilAcampado(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaPerfilAcampado(frame);
			}
		});
	}

	public void modificarAcampado(String nombreUsuario, String nombre, String apellidos, String edad,
			String dni, String email, String telefono, String usuario) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaMenuAcampado();
			}
		});
		SingletonControllerAcampado.getInstance().modificarAcampado(nombreUsuario, nombre, apellidos, edad, dni, email, telefono, usuario);
	}

	public List<TAcampado> getListaAcampados() {
		return SingletonControllerAcampado.getInstance().getListaAcampados();
	}
	
	public void modificarContrasena() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaContrasenaAcampado();
			}
		});
	}

	public void CambiarContrasena(String contrasena) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaMenuAcampado();
			}
		});
		SingletonControllerAcampado.getInstance().cambiarContrasena(contrasena);
	}

	

	
	

	

	

	

	

	
	

	

	



	

=======
>>>>>>> 09bef8d3818490b1c569cb718d4713c94f16971e
}
