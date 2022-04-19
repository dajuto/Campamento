package contabilidad.Negocio;


import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.json.JSONObject;

import empleados.Negocio.TEmpleadoGestoria;
import gestoria.Integracion.SingletonDaoLimpieza;
import gestoria.Presentacion.SingletonControllerGestoria;
import launcher.Factory;
import launcher.Observable;

public class ServiAppContabilidad implements Observable<ContabilidadObserver>{
	private List<ContabilidadObserver> observers;
	private List <TGastos> listaGastos; 
	private List<TIngresos> listaIngresos;
	private List<TEmpleadoGestoria> listaEmpleadosLimpieza;
	private Factory<Object> factoriaTranserObjects;
	private String nombreUsuario;
	private char[] contrasenaUsuario;
	
	public ServiAppContabilidad() {
		this.listaLimpieza = new ArrayList<TLimpieza>();
		this.listaEmpleadosLimpieza = new ArrayList<TEmpleadoGestoria>();
		this.observers = new ArrayList<ContabilidadObserver>();
	}
	
	public void updateLimpieza() {
		this.listaLimpieza = SingletonDaoLimpieza.getInstance().leeTodo(this.factoriaTranserObjects);
	}
	
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
	public void addObserver(ContabilidadObserver o) {
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
		this.updateLimpieza();
		return listaLimpieza;
	}
	
	public void guardaLimpieza() {
        SingletonDaoLimpieza.getInstance().escribeTodo(this.listaLimpieza);
	}

	public boolean añadirLimpieza(String codigo, String lugar, String fecha, String hora, String empleado, JFrame frame) {
		this.updateLimpieza();
		for(TLimpieza ta: this.listaLimpieza) {
			if(ta.codigo.equals(codigo)) {
				return false;
			}
		}
		JSONObject limpieza = new JSONObject();
		JSONObject data = new JSONObject();
		data.accumulate("Codigo", codigo);
		data.accumulate("Lugar", lugar);
		data.accumulate("Fecha", fecha);
		data.accumulate("Hora", hora);
		data.accumulate("Empleado", empleado);
		
		limpieza.accumulate("data", data);
		limpieza.accumulate("type", "limpieza");
		
		TLimpieza tLimpieza = (TLimpieza) this.factoriaTranserObjects.createInstance(limpieza);
		this.listaLimpieza.add(tLimpieza);
		this.guardaLimpieza();
		this.updateLimpieza();
		
		return true;
	}


	
}
