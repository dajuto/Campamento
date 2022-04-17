package acampadosPresentacion;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import acampados.Negocio.SingletonServiAppAcampado;
import empleados.Negocio.SingletonServiAppEmpleado;
import empleados.Presentacion.VistaMenuEmpleado;
import gestoria.Presentacion.SingletonControllerGestoria;
import launcher.Factory;

public class ControllerAcampado {
	
	public void registraFactoria(Factory<Object> factoriaTransferObjects) {
		SingletonServiAppAcampado.getInstance().registrarFactoria(factoriaTransferObjects);
	}

	public void acampado(JFrame f) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaAcampado(f);
			}
		});
	}
	
	public void iniciarSesion(JFrame f) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaInicioSesionAcampado(f);
			}
		});
	}
	
	public void resgistrar(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaRegistrarAcampado(frame);
			}
		});
	}

	public boolean existeAcampado(String usuario, String password) {
		return SingletonServiAppAcampado.getInstance().existeAcampado(usuario, password);
	}

	public void menuAcampado(JFrame f) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaMenuAcampado();
			}
		});
	}

	public void crearAcampado(JFrame frame) {
		//TODO HAcerlo
	}
	
}
