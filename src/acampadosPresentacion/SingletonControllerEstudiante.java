package acampadosPresentacion;

public class SingletonControllerEstudiante {
	private static ControllerEstudiante INSTANCE = null;

    // Private constructor suppresses 
    private SingletonControllerEstudiante(){}

    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple 
    private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new ControllerEstudiante();
        }
    }

    public static ControllerEstudiante getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    //El método "clone" es sobreescrito por el siguiente que arroja una excepción:
    @Override
    public Object clone() throws CloneNotSupportedException {
        	throw new CloneNotSupportedException(); 
    }
}
