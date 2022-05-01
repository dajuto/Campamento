package comedor.Presentacion;


public class SingletonControllerMenu {

	private static ControllerMenu INSTANCE = null;

    // Private constructor suppresses 
    private SingletonControllerMenu(){}

    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciacion multiple 
    private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new ControllerMenu();
        }
    }

    public static ControllerMenu getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    //El metodo "clone" es sobreescrito por el siguiente que arroja una excepcion:
    @Override
    public Object clone() throws CloneNotSupportedException {
        	throw new CloneNotSupportedException(); 
    }
}
