package empleados.Presentacion;

import java.awt.Frame;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import actividades.Presentacion.SingletonControllerActividad;
import contabilidad.Presentacion.SingletonControllerContabilidad;
import empleados.Negocio.EmpleadoObserver;
import empleados.Negocio.SingletonServiAppEmpleado;
import empleados.Negocio.TEmpleado;
import empleados.Negocio.TEmpleadoLimpieza;
import gestoria.Presentacion.SingletonControllerGestoria;
import gestoria.Presentacion.VistaRegistrarEmpleado;
import launcher.Factory;
import sanidad.Presentacion.SingletonControllerSanidad;

public class ControllerEmpleado {

	public void registraFactoria(Factory<Object> factoriaTransferObjects) {
		SingletonServiAppEmpleado.getInstance().registraFactoria(factoriaTransferObjects);
	}
	
	public List<TEmpleado> getListaEmpleados() {
		return SingletonServiAppEmpleado.getInstance().getListaEmpleados();
	}
	
	public void registraUsuario(String text) {
		SingletonServiAppEmpleado.getInstance().registraUsuario(text);
		SingletonControllerSanidad.getInstance().registraUsuario(text);
		
	}
	public String getNombreUsuario() {
		return SingletonServiAppEmpleado.getInstance().getNombreUsuario();
	}

	
	public void empleado() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaEmpleado();
			}
		});
	}
	
	public void iniciarSesion() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaInicioSesionEmpleado();
			}
		});
	}
	
	public void menuEmpleado() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaMenuEmpleado();
			}
		});
	}
	
	public void resgistrar(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaRegistrarEmpleado(frame);
			}
		});
	}
	
	public boolean existeEmpleado(String usuario, String password) {
		return SingletonServiAppEmpleado.getInstance().existeEmpleado(usuario, password);
	}
	
	public void crearEmpleado(JFrame frame, String usuario, String contrasena, String nombre, String puesto) {
		boolean exito;
		exito = SingletonServiAppEmpleado.getInstance().anadirEmpleado(usuario, contrasena, nombre, puesto);
		if (exito) {
			frame.setVisible(false);
			SingletonControllerGestoria.getInstance().menuGestor();
		}
	}

	
	
	public void actividades(JFrame frame) {
		SingletonControllerActividad.getInstance().mostrarActividadGestor(frame);
	}
	
	public void gestoria(JFrame frame) {
		SingletonControllerGestoria.getInstance().menuGestor();
	}

	public void contabilidad(JFrame frame) {
		SingletonControllerContabilidad.getInstance().menuContabilidad(frame);
	}
	
	public void sanidad(JFrame frame) {
		SingletonControllerSanidad.getInstance().menuSanidad(frame);
		
	}
	public void comedor(JFrame frame) {
		SingletonControllerMenu.getInstance().mostrarMenu(frame);
	}
	
	public void modificarEmpleadoLimpieza(String empleado, String codigo) {
		SingletonServiAppEmpleado.getInstance().modificarEmpleadoLimpieza(empleado, codigo);
	}
	
	public void modificarEmpleadoMantenimiento(String empleado, String codigo) {
		SingletonServiAppEmpleado.getInstance().modificarEmpleadoMantenimiento(empleado, codigo);
	}
	
	public void modificarMedico(String empleado, String codigo) {
		SingletonServiAppEmpleado.getInstance().modificarMedico(empleado, codigo);
	}
	
	public void addObserver(EmpleadoObserver vista) {
		SingletonServiAppEmpleado.getInstance().addObserver(vista);
	}

	

	

	

	

	


	
}
