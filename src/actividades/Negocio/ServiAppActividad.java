package actividades.Negocio;

import java.util.ArrayList;
import java.util.List;

import launcher.Factory;
import launcher.Observable;

public class ServiAppActividad implements Observable<Actividad>{

	private List<ActividadObserver> observers;
	private List<TActividad> listaActividad;
	private Factory<Object> factoriaTranserObjects;
	private String nombreUsuario;
	private char[] contrasenaUsuario;
	
	public ServiAppActividad() {
		this.listaActividad = new ArrayList<TActividad>();
		this.observers = new ArrayList<ActividadObserver>();
	}
	
	public void updateActividad() {
		
	}
	
	@Override
	public void addObserver(Actividad o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver(Actividad o) {
		// TODO Auto-generated method stub
		
	}


}
