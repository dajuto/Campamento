package gestoria.Negocio;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import empleados.Negocio.TEmpleadoLimpieza;
import gestoria.Integracion.SingletonDaoLimpieza;
import gestoria.Presentacion.SingletonControllerGestoria;
import launcher.Factory;
import launcher.Observable;

public class ServiAppGestoria implements Observable<LimpiezaObserver>{
	private List<LimpiezaObserver> observers;
	private List<TLimpieza> listaLimpieza;
	private List<TEmpleadoLimpieza> listaEmpleadosLimpieza;
	private Factory<Object> factoriaTranserObjects;
	private String nombreUsuario;
	private char[] contrasenaUsuario;
	
	public ServiAppGestoria() {
		this.listaLimpieza = new ArrayList<TLimpieza>();
		this.listaEmpleadosLimpieza = new ArrayList<TEmpleadoLimpieza>();
		this.observers = new ArrayList<LimpiezaObserver>();
	}
	
	public void updateLimpieza() {
		this.listaLimpieza = SingletonDaoLimpieza.getInstance().leeTodo(this.factoriaTranserObjects);
	}
	
//	public void updateEmpleadosLimpieza() { //TODO MIRAR 
//		this.listaEmpleadosLimpieza = SingletonControllerGestoria.getInstance().getListaEmpleadosLimpieza();	
//	}
	
//	public void guardaAverias() { //TODO sobra?
//        SingletonDaoLimpieza.getInstance().escribeTodo(this.listaLimpieza);
//	}
	
	public void registrarFactoria(Factory<Object> objetosFactory) {
		this.factoriaTranserObjects = objetosFactory;
	}

	public void registraUsuario(String text, char[] password) {
		this.nombreUsuario = text;
		this.contrasenaUsuario = password;
	}

	public void mostrarListaLimpiezaEmpleado(String nombreEmpleado) {
		this.updateLimpieza();
	}

	@Override
	public void addObserver(LimpiezaObserver o) {
		this.observers.add(o);
		this.updateLimpieza();
		//TODO this.updateEmpleadosLimpieza();
		o.onRegister(listaLimpieza, listaEmpleadosLimpieza, nombreUsuario);
	}

	@Override
	public void removeObserver(LimpiezaObserver o) {
		this.observers.remove(o);
	}
	
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public List<TLimpieza> getListaLimpiezaGestor() {	
		return listaLimpieza;
	}
	
	public List<TLimpieza> getListaAveriasEmpleado(String usuarioEmpleadoMantenimiento) {
		this.updateLimpieza();
		List<TLimpieza> l = new ArrayList<>();
		for(TLimpieza e: this.listaLimpieza) {
			if(e.empleadoEncargado.getUsuario().equals(usuarioEmpleadoMantenimiento)) {
				l.add(e);
			}
		}
		return l;
	}

	

	
}
