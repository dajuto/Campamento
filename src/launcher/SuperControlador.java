package launcher;

import java.awt.Frame;

import javax.swing.JFrame;

import acampadosPresentacion.SingletonControllerAcampado;
import actividades.Presentacion.SingletonControllerActividad;
import contabilidad.Presentacion.SingletonControllerContabilidad;
import empleados.Presentacion.SingletonControllerEmpleado;
import gestoria.Presentacion.SingletonControllerGestoria;
import sanidad.Presentacion.SingletonControllerSanidad;


public class SuperControlador{
	
	public void generalEmpleado() {
		SingletonControllerEmpleado.getInstance().empleado();
	}

	public void generalAcampado(JFrame f) {
		SingletonControllerAcampado.getInstance().acampado(f);
	}

	public void registraFactoria(Factory<Object> factoriaTransferObjects) {
		
		
		SingletonControllerEmpleado.getInstance().registraFactoria(factoriaTransferObjects);
		SingletonControllerAcampado.getInstance().registraFactoria(factoriaTransferObjects);

		SingletonControllerActividad.getInstance().registraFactoria(factoriaTransferObjects);
		SingletonControllerContabilidad.getInstance().registraFactoria(factoriaTransferObjects);
		SingletonControllerSanidad.getInstance().registraFactoria(factoriaTransferObjects);
		SingletonControllerGestoria.getInstance().registraFactoria(factoriaTransferObjects);
		//SingletonControllerComedor.getInstance().registraFactoria(factoriaTransferObjects);
		
		
	
	}

}
