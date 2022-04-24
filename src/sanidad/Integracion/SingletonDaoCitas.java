package sanidad.Integracion;

import java.io.IOException;



public class SingletonDaoCitas {

	
	private static DaoCitas INSTANCE = null;

    // Private constructor suppresses 
    private SingletonDaoCitas(){}

    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple 
    private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            try {
				INSTANCE = new DaoCitas();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("El archivo no se ha encontrado");
			}
        }
    }

    public static DaoCitas getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    //El método "clone" es sobreescrito por el siguiente que arroja una excepción:
    @Override
    public Object clone() throws CloneNotSupportedException {
        	throw new CloneNotSupportedException(); 
    }
}
