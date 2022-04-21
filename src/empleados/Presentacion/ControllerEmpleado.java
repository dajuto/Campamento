package empleados.Presentacion;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

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
	
	public void empleado(JFrame f) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaEmpleado(f);
			}
		});
	}
	
	public void iniciarSesion(JFrame f) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaInicioSesionEmpleado(f);
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
		
		else {
			JOptionPane.showMessageDialog(frame, "Usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);			
		}
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
	
	public void modificarEmpleadoLimpieza(String empleado, String codigo) {
		SingletonServiAppEmpleado.getInstance().modificarEmpleadoLimpieza(empleado, codigo);
	}
	
	public void modificarEmpleadoMantenimiento(String empleado, String codigo) {
		SingletonServiAppEmpleado.getInstance().modificarEmpleadoMantenimiento(empleado, codigo);
	}
	
	public void addObserver(EmpleadoObserver vista) {
		SingletonServiAppEmpleado.getInstance().addObserver(vista);
	}

	

	

	

	

	


	
}
