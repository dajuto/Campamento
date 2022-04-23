package comedor.negocio;

import comedor.presentacion.ControllerMenu;

public class SingletonServiAppMenu {

	private static ServiAppMenu INSTANCE = null;

    // Private constructor suppresses 
    private SingletonServiAppMenu(){}

    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple 
    private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new ServiAppMenu();
        }
    }

    public static ServiAppMenu getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    //El método "clone" es sobreescrito por el siguiente que arroja una excepción:
    @Override
    public Object clone() throws CloneNotSupportedException {
        	throw new CloneNotSupportedException(); 
    }
}
