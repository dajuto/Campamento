package empleados.Negocio;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import empleados.Integracion.SingletonDaoEmpleado;
import launcher.Factory;
import launcher.Observable;

public class ServiAppEmpleado implements Observable<EmpleadoObserver>{
	private List<EmpleadoObserver> observers;
	private Factory<Object> factoriaTransferObjects;
	private String nombreUsuario;
	private char[] contrasenaUsuario;
	private List<TEmpleado> listaEmpleados;
	
	public ServiAppEmpleado() {
		this.listaEmpleados = new ArrayList<TEmpleado>();
		this.observers = new ArrayList<EmpleadoObserver>();

	}
	
	public void registraFactoria(Factory<Object> factoriaTransferObjects) {
		this.factoriaTransferObjects = factoriaTransferObjects;
	}
	
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void registraUsuario(String text, char[] password) {
		this.nombreUsuario = text;
		this.contrasenaUsuario = password;
	}
	
	public void updateEmpleados() {
		this.listaEmpleados = SingletonDaoEmpleado.getInstance().leeTodo(this.factoriaTransferObjects);
	}
	
	public boolean existeEmpleado(String usuario, String password) {
		this.updateEmpleados();
		for(TEmpleado e: this.listaEmpleados) {
			if(e.usuario.equals(usuario) && e.contrasena.equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsEmpleado(String usuarioEmpleadoEncargado) {
		this.updateEmpleados();
		for(TEmpleado e: this.listaEmpleados) {
			if(e.usuario.equals(usuarioEmpleadoEncargado)) {
				return true;
			}
		}
		return false;
	}

	public TEmpleado getEmpleado(String usuarioEmpleadoEncargado) {
		this.updateEmpleados();
		for(TEmpleado e: this.listaEmpleados) {
			if(e.usuario.equals(usuarioEmpleadoEncargado)) {
				return e;
			}
		}
		return null;
	}

	public List<TEmpleadoLimpieza> getListaEmpleadosMantenimiento() {
		this.updateEmpleados();
		List<TEmpleadoLimpieza> l = new ArrayList<>();
		for(TEmpleado e: this.listaEmpleados) {
			if(e.puesto.equals("Empleado Mantenimiento")) {
				l.add((TEmpleadoLimpieza) e);
			}
		}
		return l;
	}
	
	public void guardaEmpleados() {
        SingletonDaoEmpleado.getInstance().escribeTodo(listaEmpleados);
	}
	
	
	void onEliminarEmpleado() {
		this.updateEmpleados();
		for(EmpleadoObserver o: this.observers) {
			o.onEliminarEmpleado(this.listaEmpleados,nombreUsuario);
		}
	}
	
	void onCreateEmpleado() {
		this.updateEmpleados();
		for(EmpleadoObserver o: this.observers) {
			o.onCreateEmpleado(this.listaEmpleados,nombreUsuario);
		}
	}
	void onModificarEmpleado() {
		this.updateEmpleados();
		for(EmpleadoObserver o: this.observers) {
			o.onModificarEmpleado(this.listaEmpleados,nombreUsuario);
		}
	}

	public void addObserver(EmpleadoObserver o) {
		this.observers.add(o);
		this.updateEmpleados();
		o.onRegister(listaEmpleados,nombreUsuario);
	}

	public void removeObserver(EmpleadoObserver o) {
		this.observers.remove(o);
	}
	

	public List<TEmpleado> getListaEmpleados() {
		this.updateEmpleados();
		return listaEmpleados;
	}

	public boolean anadirEmpleado(String usuario, String contrasena, String nombre, String puesto) {
		this.updateEmpleados();
		for(TEmpleado te: this.listaEmpleados) {
			if(te.usuario.equals(usuario)) {
				return false;
			}
		}
		JSONObject empleado = new JSONObject();
		JSONObject data = new JSONObject();
		data.accumulate("usuario", usuario);
		data.accumulate("contrasena", contrasena);
		data.accumulate("nombre", nombre);
		data.accumulate("puesto", puesto);
		
		if (puesto.equals("Empleado Limpieza")) {
			data.accumulate("salario", 1400);
			data.accumulate("horario", 8);
			data.accumulate("vacaciones", "Navidades");
			JSONObject trabajo = new JSONObject();
			data.accumulate("trabajo", trabajo);
			empleado.accumulate("data", data);
			empleado.accumulate("type", "Empleado Limpieza");
			TEmpleadoLimpieza tEmpleado = (TEmpleadoLimpieza) this.factoriaTransferObjects.createInstance(empleado);
			this.listaEmpleados.add(tEmpleado);
		}
		else if (puesto.equals("Gestor")) {
			data.accumulate("salario", 3500);
			data.accumulate("horario", 8);
			data.accumulate("vacaciones", "Todo el verano");
			empleado.accumulate("data", data);
			empleado.accumulate("type", "Gestor");
			TGestor tEmpleado = (TGestor) this.factoriaTransferObjects.createInstance(empleado);
			this.listaEmpleados.add(tEmpleado);
		}
		
		this.guardaEmpleados();
	    this.onCreateEmpleado();
		return true;
	}
	
		
	
	
	}
