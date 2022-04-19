package contabilidad.Integracion;

import java.io.IOException;

public class SingletonDaoContabilidad {
	
	private static DaoContabilidad INSTANCE = null;

    // Private constructor suppresses 
    private SingletonDaoContabilidad(){}

    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple 
    private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            try {
				INSTANCE = new DaoContabilidad();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("El archivo no se ha encontrado");
			}
        }
    }

    public static DaoContabilidad getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    //El método "clone" es sobreescrito por el siguiente que arroja una excepción:
    @Override
    public Object clone() throws CloneNotSupportedException {
        	throw new CloneNotSupportedException(); 
    }
}
