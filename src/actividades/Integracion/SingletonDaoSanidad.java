package actividades.Integracion;

import java.io.IOException;

import subsistemaActividad.capaIntegracion.DaoActividad;

public class SingletonDaoSanidad {

	
	private static DaoSanidad INSTANCE = null;

    // Private constructor suppresses 
    private SingletonDaoSanidad(){}

    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple 
    private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            try {
				INSTANCE = new DaoSanidad();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("El archivo no se ha encontrado");
			}
        }
    }

    public static DaoSanidad getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    //El método "clone" es sobreescrito por el siguiente que arroja una excepción:
    @Override
    public Object clone() throws CloneNotSupportedException {
        	throw new CloneNotSupportedException(); 
    }
}
