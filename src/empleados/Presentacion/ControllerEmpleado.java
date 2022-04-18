package empleados.Presentacion;

import java.awt.Frame;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import empleados.Negocio.EmpleadoObserver;
import empleados.Negocio.SingletonServiAppEmpleado;
import empleados.Negocio.TEmpleadoGestoria;
import gestoria.Presentacion.SingletonControllerGestoria;
import launcher.Factory;

public class ControllerEmpleado {

	public void registraFactoria(Factory<Object> factoriaTransferObjects) {
		SingletonServiAppEmpleado.getInstance().registraFactoria(factoriaTransferObjects);
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
			SingletonControllerGestoria.getInstance().menuGestor(frame);
		}
		
		else {
			JOptionPane.showMessageDialog(frame, "Usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);			
		}
	}

	
	
	public void gestoria(JFrame frame) {
		SingletonControllerGestoria.getInstance().menuGestor(frame);
	}

	
	
	
	
	
	
	
	public void addObserver(EmpleadoObserver vista) {
		SingletonServiAppEmpleado.getInstance().addObserver(vista);
	}


	
}
