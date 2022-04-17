package acampados.Negocio;

import java.util.ArrayList;
import java.util.List;

import acampados.Integracion.SingletonDaoAcampado;
import empleados.Negocio.EmpleadoObserver;
import empleados.Negocio.TEmpleado;
import launcher.Factory;
import launcher.Observable;

public class ServiAppAcampado implements Observable<AcampadoObserver>{
	private List<AcampadoObserver> observers;
	private List<TAcampado> listaAcampados;
	private Factory<Object> factoriaTranserObjects;
	private String nombreUsuario;
	private char[] contrasenaUsuario;
	
	public ServiAppAcampado() {
		this.listaAcampados = new ArrayList<TAcampado>();
		this.observers = new ArrayList<AcampadoObserver>();
	}
	
	public void registrarFactoria(Factory<Object> objetosFactory) {
		this.factoriaTranserObjects = objetosFactory;
	}

	public void registraUsuario(String text, char[] password) {
		this.nombreUsuario = text;
		this.contrasenaUsuario = password;
	}
	
	public void updateAcampados() {
		this.listaAcampados = SingletonDaoAcampado.getInstance().leeTodo(this.factoriaTranserObjects);
		
	}
	
	public boolean existeAcampado(String usuario, String password) {
		this.updateAcampados();
		for(TAcampado a: this.listaAcampados) {
			if(a.usuario.equals(usuario) && a.contrasena.equals(password)) {
				return true;
			}
		}
		return false;
	}

	public void addObserver(AcampadoObserver o) {
		this.observers.add(o);
		this.updateAcampados();
		o.onRegister(listaAcampados);
	}

	public void removeObserver(AcampadoObserver o) {
		this.observers.remove(o);
	}
	
	
	
}



