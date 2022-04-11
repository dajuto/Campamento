package launcher;

import java.awt.Frame;

import javax.swing.JFrame;

import empleados.Presentacion.SingletonControllerEmpleado;
import gestoria.Presentacion.SingletonControllerGestoria;
import sanidad.Presentacion.SingletonControllerSanidad;


public class SuperControlador{
	
	public void mostrarGeneralEmpleado(Frame f) {
		SingletonControllerEmpleado.getInstance().mostrarGeneralEmpleado(f);
	}

	public void mostrarGeneralAcampado(JFrame f) {
		SingletonControllerAcampado.getInstance().mostrarGeneralAcampado(f);
	}

	public void registraFactoria(Factory<Object> factoriaTransferObjects) {
		
		SingletonControllerActividades.getInstance().registraFactoria(factoriaTransferObjects);
		SingletonControllerContabilidad.getInstance().registraFactoria(factoriaTransferObjects);
		SingletonControllerSanidad.getInstance().registraFactoria(factoriaTransferObjects);
		SingletonControllerGestoria.getInstance().registraFactoria(factoriaTransferObjects);
		SingletonControllerComedor.getInstance().registraFactoria(factoriaTransferObjects);
		
		SingletonControllerEmpleado.getInstance().registraFactoria(factoriaTransferObjects);
		SingletonControllerAcampado.getInstance().registraFactoria(factoriaTransferObjects);

	
	}
}
