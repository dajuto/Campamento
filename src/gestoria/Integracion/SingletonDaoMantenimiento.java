package gestoria.Integracion;

import java.io.IOException;

public class SingletonDaoMantenimiento {
    private static DaoMantenimiento INSTANCE = null;

    // Private constructor suppresses 
    private SingletonDaoMantenimiento(){}

    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple 
    private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            try {
				INSTANCE = new DaoMantenimiento();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("El archivo no se ha encontrado");
			}
        }
    }

    public static DaoMantenimiento getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    //El método "clone" es sobreescrito por el siguiente que arroja una excepción:
    @Override
    public Object clone() throws CloneNotSupportedException {
        	throw new CloneNotSupportedException(); 
    }
}