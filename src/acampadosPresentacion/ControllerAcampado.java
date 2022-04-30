package acampadosPresentacion;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import acampados.Negocio.SingletonServiAppAcampado;
import acampados.Negocio.TAcampado;
import actividades.Presentacion.SingletonControllerActividad;
import contabilidad.Presentacion.SingletonControllerContabilidad;
import contabilidad.Presentacion.VistaIngresosContabilidad;
import empleados.Negocio.SingletonServiAppEmpleado;
import empleados.Negocio.TEmpleado;
import empleados.Presentacion.SingletonControllerEmpleado;
import empleados.Presentacion.VistaMenuEmpleado;
import gestoria.Presentacion.SingletonControllerGestoria;
import launcher.Factory;
import sanidad.Presentacion.SingletonControllerSanidad;
import comedor.Presentacion.SingletonControllerMenu;

public class ControllerAcampado {
	
	public void registraFactoria(Factory<Object> factoriaTransferObjects) {
		SingletonServiAppAcampado.getInstance().registrarFactoria(factoriaTransferObjects);
	}

	public List<TAcampado> getListaAcampados() {
		return SingletonServiAppAcampado.getInstance().getListaAcampados();
	}
	
	public void registraUsuario(String text) {
		SingletonServiAppAcampado.getInstance().registraUsuario(text);
		
	}
	
	public String getAcampado() {
		String nombreUsuarioGestor = SingletonServiAppAcampado.getInstance().getNombreUsuario();
		return nombreUsuarioGestor;

	}
	
	
	public void acampado() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaAcampado();
			}
		});
	}
	
	public void iniciarSesion() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaInicioSesionAcampado();
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
				new VistaMenuAcampado(f);
			}
		});
	}

	public void crearAcampado(String usuario, String contrasena, String nombre, String apellidos, String dni, String email, String edad, String telefono, String salud, JFrame frame) {
		boolean exito, exitito;
		exitito = SingletonControllerEmpleado.getInstance().comprobarUsuario(usuario, nombre);
		exito = SingletonServiAppAcampado.getInstance().anadirAcampado(usuario, contrasena, nombre, apellidos, dni, email, edad, telefono, salud, frame);
		if (exito) {
			frame.setVisible(false);
			SingletonControllerAcampado.getInstance().menuAcampado(frame);
		}
	}

	public void gestoria(JFrame frame) {
		SingletonControllerGestoria.getInstance().menuAcampadoGestoria();
	}
	
	public void contabilidad(JFrame frame) {
		SingletonControllerContabilidad.getInstance().estadoCuentasAcampado(frame);
	}
	
	public void actividades(JFrame frame) {
		SingletonControllerActividad.getInstance().mostrarListaActividadesAcampado(frame);
	}
	
	public void comedor(JFrame frame) {
		SingletonControllerMenu.getInstance().mostrarMenuAcampado(frame);
	}
	
	public void SanidadCita(JFrame frame) {
		SingletonControllerSanidad.getInstance().pedirCita(frame);
	}

	public void modificarAcampado(String nombreUsuario, String nombre, String apellidos, String edad,
			String dni, String email, String telefono,String usuario) {
		SingletonServiAppAcampado.getInstance().modificarAcampado(nombreUsuario, nombre, apellidos, edad, dni, email, telefono,usuario);
		
	}

	public void cambiarContrasena(String contrasena) {
		SingletonServiAppAcampado.getInstance().cambiarContrasena(contrasena);
	}
	
	public void cambiarIsPagado(boolean pagado) {
		SingletonServiAppAcampado.getInstance().cambiarIsPagado(pagado);
	}

	public boolean comprobarUsuario(String usuario, String nombre) {
		return SingletonServiAppAcampado.getInstance().comprobarUsuario(usuario, nombre);
	}

	
	
	
	
}
