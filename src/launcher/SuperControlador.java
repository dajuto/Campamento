package launcher;

import java.awt.Frame;

import javax.swing.JFrame;

import sanidad.Presentacion.SingletonControllerSanidad;
import subsistemaActividad.capaPresentacion.SingletonControllerActividad;
import subsistemaAulas.capaPresentacion.SingletonControllerAulas;
import subsistemaComedor.capaPresentacion.SingletonControllerComedor;
import subsistemaCoordCovid.capaPresentacion.SingletonControllerCoordCovid;
import subsistemaEmpleado.capaPresentacion.SingletonControllerEmpleado;
import subsistemaEstudiante.capaPresentacion.SingletonControllerEstudiante;
import subsistemaLimpieza.capaPresentacion.SingletonControllerLimpieza;
import subsistemaMantenimiento.capaPresentacion.SingletonControllerMantenimiento;


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
