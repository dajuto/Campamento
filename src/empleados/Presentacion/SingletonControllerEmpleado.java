package empleados.Presentacion;

public class SingletonControllerEmpleado {
	private static ControllerEmpleado INSTANCE = null;

    // Private constructor suppresses 
    private SingletonControllerEmpleado(){}

    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple 
    private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new ControllerEmpleado();
        }
    }

    public static ControllerEmpleado getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    //El método "clone" es sobreescrito por el siguiente que arroja una excepción:
    @Override
    public Object clone() throws CloneNotSupportedException {
        	throw new CloneNotSupportedException(); 
    }
}
