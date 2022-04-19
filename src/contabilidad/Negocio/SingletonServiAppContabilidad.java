package contabilidad.Negocio;

<<<<<<< HEAD
=======
import contabilidad.Presentacion.ControllerContabilidad;
>>>>>>> dc9ff1bf0eed17863b4fc8c4c14e9b1d793f2164

public class SingletonServiAppContabilidad {

	private static ControllerContabilidad INSTANCE = null;

    // Private constructor suppresses 
    private SingletonServiAppContabilidad(){}

    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple 
    private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new ControllerContabilidad();
        }
    }

    public static ControllerContabilidad getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    //El método "clone" es sobreescrito por el siguiente que arroja una excepción:
    @Override
    public Object clone() throws CloneNotSupportedException {
        	throw new CloneNotSupportedException(); 
    }
}
