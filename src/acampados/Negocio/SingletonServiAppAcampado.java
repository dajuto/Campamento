package acampados.Negocio;

public class SingletonServiAppAcampado {
	private static ServiAppAcampado INSTANCE = null;

    // Private constructor suppresses 
    private SingletonServiAppAcampado(){}

    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple 
    private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new ServiAppAcampado();
        }
    }

    public static ServiAppAcampado getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    //El método "clone" es sobreescrito por el siguiente que arroja una excepción:
    @Override
    public Object clone() throws CloneNotSupportedException {
        	throw new CloneNotSupportedException(); 
    }
}

