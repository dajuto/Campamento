package empleados.Presentacion;

import java.awt.Frame;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import empleados.Negocio.EmpleadoObserver;
import empleados.Negocio.SingletonServiAppEmpleado;
import empleados.Negocio.TEmpleadoLimpieza;
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
	
	public boolean existeEmpleado(String usuario, String password) {
		return SingletonServiAppEmpleado.getInstance().existeEmpleado(usuario, password);
	}

	public void menuEmpleado(JFrame f) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaMenuEmpleado();
			}
		});
	}
	
	public void gestoria(JFrame frame) {
		SingletonControllerGestoria.getInstance().menuGestor(frame);
	}
	
	

//	public void registraUsuario(String text, char[] password) {
//		SingletonServiAppEmpleado.getInstance().registraUsuario(text, password);
//		SingletonControllerMantenimiento.getInstance().registraUsuario(text, password);
//		SingletonControllerAulas.getInstance().registraUsuario(text, password);
//		SingletonControllerLimpieza.getInstance().registraUsuario(text, password);
//	}

	
	public void addObserver(EmpleadoObserver vista) {
		SingletonServiAppEmpleado.getInstance().addObserver(vista);
	}

	


	

	
	

	
}
