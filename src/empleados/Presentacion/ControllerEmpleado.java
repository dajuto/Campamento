package empleados.Presentacion;

import java.awt.Frame;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import empleados.Negocio.EmpleadoObserver;
import empleados.Negocio.SingletonServiAppEmpleado;
import empleados.Negocio.TEmpleadoLimpieza;
import launcher.Factory;

public class ControllerEmpleado {

	public void registraFactoria(Factory<Object> factoriaTransferObjects) {
		SingletonServiAppEmpleado.getInstance().registraFactoria(factoriaTransferObjects);
	}

	public void menuEmpleado(JFrame f) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaMenuEmpleado(f);
			}
		});
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
