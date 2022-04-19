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

<<<<<<< HEAD
	public void crearAcampado(String usuario, String contrasena, String nombre, String apellidos, String text5, String text6,
			String text7, String text8, String salud, JFrame frame) {
	
=======
	public void crearAcampado(String usuario, String contrasena, String nombre, String apellidos, String dni, String email, String edad, String telefono, String salud, JFrame frame) {
		boolean exito;
		exito = SingletonServiAppAcampado.getInstance().anadirAcampado(usuario, contrasena, nombre, apellidos, dni, email, edad, telefono, salud, frame);
		if (exito) {
			frame.setVisible(false);
			SingletonControllerAcampado.getInstance().menuAcampado(frame);
		}
		
		else {
			JOptionPane.showMessageDialog(frame, "Usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);			
		}
>>>>>>> 00ebea6f17e95d2456711977cd701e3d6b425329
	}
	
	
}
