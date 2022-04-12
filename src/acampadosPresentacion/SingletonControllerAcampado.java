package acampadosPresentacion;

public class SingletonControllerAcampado {
	private static ControllerAcampado INSTANCE = null;

    // Private constructor suppresses 
    private SingletonControllerAcampado(){}

    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple 
    private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new ControllerAcampado();
        }
    }

    public static ControllerAcampado getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    //El método "clone" es sobreescrito por el siguiente que arroja una excepción:
    @Override
    public Object clone() throws CloneNotSupportedException {
        	throw new CloneNotSupportedException(); 
    }
}
