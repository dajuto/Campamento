package acampadosPresentacion;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import acampados.Negocio.SingletonServiAppAcampado;
import empleados.Negocio.SingletonServiAppEmpleado;
import empleados.Presentacion.VistaMenuEmpleado;

public class ControllerAcampado {

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
	
}
