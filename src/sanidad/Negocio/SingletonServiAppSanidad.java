package sanidad.Negocio;

import sanidad.Presentacion.ControllerSanidad;

public class SingletonServiAppSanidad {

	private static ServiAppSanidad INSTANCE = null;

    // Private constructor suppresses 
    private SingletonServiAppSanidad(){}

    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple 
    private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new ServiAppSanidad();
        }
    }

    public static ServiAppSanidad getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    //El método "clone" es sobreescrito por el siguiente que arroja una excepción:
    @Override
    public Object clone() throws CloneNotSupportedException {
        	throw new CloneNotSupportedException(); 
    }
}
