package comedor.Integracion;

import java.io.IOException;

public class SingletonDaoMenu {
    private static DaoMenu INSTANCE = null;

    // Private constructor suppresses 
    private SingletonDaoMenu(){}

    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciaciÃ³n mÃºltiple 
    private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            try {
				INSTANCE = new DaoMenu();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("El archivo no se ha encontrado");
			}
        }
    }

    public static DaoMenu getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    //El mÃ©todo "clone" es sobreescrito por el siguiente que arroja una excepciÃ³n:
    @Override
    public Object clone() throws CloneNotSupportedException {
        	throw new CloneNotSupportedException(); 
    }
}
