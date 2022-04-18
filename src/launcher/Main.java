package launcher;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import acampados.Negocio.AcampadoBuilder;
import empleados.Negocio.EmpleadoGestorBuilder;
import gestoria.Negocio.Instalacion;
import gestoria.Negocio.InstalacionBuilder;
import gestoria.Negocio.LimpiezaBuilder;

public class Main {
	
	private static Factory<Object> initFactories() {
		List<Builder<Object>> constructores = new ArrayList<>();
		constructores.add(new EmpleadoGestorBuilder());
		constructores.add(new AcampadoBuilder());
		constructores.add(new LimpiezaBuilder());
		constructores.add(new InstalacionBuilder());
		Factory<Object> factoriaTransferObjects = new BuilderBasedFactory<>(constructores);
		return factoriaTransferObjects;
	}

	private static void startGUIMode() {		
		Factory<Object> factoriaTransferObjects = initFactories();
		SingletonSuperControlador.getInstance().registraFactoria(factoriaTransferObjects);
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SuperVista();
			}
		});
	}

	public static void main(String[] args) {
		startGUIMode();	
	}

}
