package contabilidad.Negocio;

public class SingletonServiAppContabilidad {

	private static ServiAppContabilidad INSTANCE = null;

    // Private constructor suppresses 
    private SingletonServiAppContabilidad(){}
 
    private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new ServiAppContabilidad();
        }
    }

    public static ServiAppContabilidad getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    //El método "clone" es sobreescrito por el siguiente que arroja una excepción:
    @Override
    public Object clone() throws CloneNotSupportedException {
        	throw new CloneNotSupportedException(); 
    }
}
