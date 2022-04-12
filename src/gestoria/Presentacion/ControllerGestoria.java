package gestoria.Presentacion;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import empleados.Negocio.TEmpleadoLimpieza;
import empleados.Presentacion.SingletonControllerEmpleado;
import gestoria.Negocio.LimpiezaObserver;
import gestoria.Negocio.SingletonServiAppGestoria;
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

	

	public void addObserver(LimpiezaObserver vista) {
		SingletonServiAppGestoria.getInstance().addObserver(vista);
	}

}
