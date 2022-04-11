package empleados.Integracion;

import java.io.IOException;

public class SingletonDaoEmpleado {
	private static DaoEmpleado INSTANCE = null;

    // Private constructor suppresses 
    private SingletonDaoEmpleado(){}

    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple 
    private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            try {
				INSTANCE = new DaoEmpleado();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }

    public static DaoEmpleado getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    //El método "clone" es sobreescrito por el siguiente que arroja una excepción:
    @Override
    public Object clone() throws CloneNotSupportedException {
        	throw new CloneNotSupportedException(); 
    }
}
