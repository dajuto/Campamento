package acampados.Negocio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.json.JSONObject;

import acampados.Integracion.SingletonDaoAcampado;
import empleados.Negocio.TEmpleado;
import launcher.Factory;
import launcher.Observable;

public class ServiAppAcampado implements Observable<AcampadoObserver>{
	private List<AcampadoObserver> observers;
	private List<TAcampado> listaAcampados;
	private Factory<Object> factoriaTranserObjects;
	private String nombreUsuario;
	
	public ServiAppAcampado() {
		this.listaAcampados = new ArrayList<TAcampado>();
		this.observers = new ArrayList<AcampadoObserver>();
	}
	
	
	public List<TAcampado> getListaAcampados() {
		this.updateAcampados();
		return listaAcampados;
	}
	
	public void registrarFactoria(Factory<Object> objetosFactory) {
		this.factoriaTranserObjects = objetosFactory;
	}

	public void registraUsuario(String text) {
		this.nombreUsuario = text;
	}
	
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}
	
	public void updateAcampados() {
		this.listaAcampados = SingletonDaoAcampado.getInstance().leeTodo(this.factoriaTranserObjects);
		
	}
	
	private void guardaAcampado() {
		SingletonDaoAcampado.getInstance().escribeTodo(listaAcampados);
	}
	
	void onCreateAcampado() {
		this.updateAcampados();
		for(AcampadoObserver o: this.observers) {
			o.onCreateAcampado(this.listaAcampados,nombreUsuario);
		}
	}
	
	void onEliminarAcampado() {
		this.updateAcampados();
		for(AcampadoObserver o: this.observers) {
			o.onEliminarAcampado(this.listaAcampados,nombreUsuario);
		}
	}
	
	void onModificarAcampado() {
		this.updateAcampados();
		for(AcampadoObserver o: this.observers) {
			o.onModificarAcampado(this.listaAcampados,nombreUsuario);
		}
	}
	
	public TAcampado getAcampado(String usuarioAcampado) {
		this.updateAcampados();
		for(TAcampado e: this.listaAcampados) {
			if(e.usuario.equals(usuarioAcampado)) {
				return e;
			}
		}
		return null;
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
		o.onRegister(listaAcampados,nombreUsuario);
	}

	public void removeObserver(AcampadoObserver o) {
		this.observers.remove(o);
	}
	
	public boolean anadirAcampado(String usuario, String contrasena, String nombre, String apellidos, String dni, String email, String edad, String telefono, String salud, JFrame frame) {
		this.updateAcampados();
		for(TAcampado te: this.listaAcampados) {
			if(te.usuario.equals(usuario)) {
				JOptionPane.showMessageDialog(frame, "El usuario especificado ya existe", "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else if (te.nombre.equals(nombre)) {
				JOptionPane.showMessageDialog(frame, "El nombre especificado ya existe", "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		
		JSONObject acampado = new JSONObject();
		
		JSONObject data = new JSONObject();
		data.accumulate("Usuario", usuario);
		data.accumulate("Contraseña", contrasena);
		data.accumulate("Nombre", nombre);
		data.accumulate("Apellidos", apellidos);
		data.accumulate("DNI", dni);
		data.accumulate("Email", email);
		int numEdad = Integer.parseInt(edad);
		data.accumulate("Edad", numEdad);
		int numTelefono = Integer.parseInt(telefono);
		data.accumulate("Telefono", numTelefono);
		data.accumulate("Salud", salud);
		data.accumulate("Habitacion", "123");
		JSONObject actividades = new JSONObject();
		data.accumulate("Actividades", actividades);
		data.accumulate("Pagado", "No");
		
		acampado.accumulate("data", data);
		acampado.accumulate("type", "acampado");
		
		TAcampado ta = (TAcampado) this.factoriaTranserObjects.createInstance(acampado);
		listaAcampados.add(ta);
		
		this.guardaAcampado();
		this.onCreateAcampado();
		
		return true;
	}

	
	
	
	
}



