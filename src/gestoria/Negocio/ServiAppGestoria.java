package gestoria.Negocio;

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

public class ServiAppGestoria implements Observable<LimpiezaObserver>{
	private List<LimpiezaObserver> observers;
	private List<TLimpieza> listaLimpieza;
	private List<TEmpleadoGestoria> listaEmpleadosLimpieza;
	private Factory<Object> factoriaTranserObjects;
	private String nombreUsuario;
	private char[] contrasenaUsuario;
	
	public ServiAppGestoria() {
		this.listaLimpieza = new ArrayList<TLimpieza>();
		this.listaEmpleadosLimpieza = new ArrayList<TEmpleadoGestoria>();
		this.observers = new ArrayList<LimpiezaObserver>();
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

	public void eliminarLimpieza(JFrame frame, String codigo) {
		for (int i = 0; i < listaLimpieza.size(); i++) {
			if (listaLimpieza.get(i).getCodigo().equals(codigo)) {
				//TODO empleado limpieza aguita de coco
				listaLimpieza.remove(i);
				SingletonDaoLimpieza.getInstance().escribeTodo(listaLimpieza);
				this.updateLimpieza();
			}
		}
		
	}

	public void modificarLimpieza(String codigo, String lugar, String fecha, String hora, String empleado) {
		for (int i = 0; i < listaLimpieza.size(); i++) {
			if (listaLimpieza.get(i).getCodigo().equals(codigo)) {
				listaLimpieza.get(i).codigo = codigo;
				listaLimpieza.get(i).lugar = lugar;
				listaLimpieza.get(i).fecha = fecha;
				listaLimpieza.get(i).hora = hora;
				listaLimpieza.get(i).empleadoEncargado = empleado;
				SingletonDaoLimpieza.getInstance().escribeTodo(listaLimpieza);
				this.updateLimpieza();
			}
		}
		
	}

	

	
}
