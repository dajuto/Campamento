package launcher;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import acampados.Negocio.AcampadoBuilder;
import contabilidad.Negocio.GastosBuilder;
import contabilidad.Negocio.IngresosBuilder;
import empleados.Negocio.EmpleadoLimpiezaBuilder;
import empleados.Negocio.EmpleadoMantenimientoBuilder;
import empleados.Negocio.GestorBuilder;
import empleados.Negocio.MedicoBuilder;
import gestoria.Negocio.Instalacion;
import gestoria.Negocio.InstalacionBuilder;
import gestoria.Negocio.LimpiezaBuilder;
import gestoria.Negocio.MantenimientoBuilder;
import sanidad.Negocio.RecetaBuilder;

public class Main {
	
	private static Factory<Object> initFactories() {
		List<Builder<Object>> constructores = new ArrayList<>();
		
		constructores.add(new RecetaBuilder());
		
		constructores.add(new EmpleadoLimpiezaBuilder());
		
		constructores.add(new EmpleadoMantenimientoBuilder());
		constructores.add(new GestorBuilder());
		constructores.add(new AcampadoBuilder());
		constructores.add(new LimpiezaBuilder());
		constructores.add(new InstalacionBuilder());
		constructores.add(new MantenimientoBuilder());
		constructores.add(new MedicoBuilder());
		constructores.add(new GastosBuilder());
		constructores.add(new IngresosBuilder());
	
		
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
