package acampados.Negocio;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import launcher.Factory;
import launcher.Observable;
import subsistemaCoordCovid.CapaNegocio.EstudianteConfinadoBuilder;
import subsistemaCoordCovid.CapaNegocio.TEstudianteConfinado;
import subsistemaCoordCovid.capaPresentacion.SingletonControllerCoordCovid;
import subsistemaEstudiante.capaIntegracion.SingletonDaoEstudiante;
import subsistemaLimpieza.capaNegocio.LimpiezaObserver;
import subsistemaLimpieza.capaNegocio.TLimpieza;

public class ServiAppAcampado implements Observable<AcampadoObserver>{
	private List<AcampadoObserver> observers;
	private List<TAcampado> listaEstudiantes;
	private List<TAcampado> listaEstudiantesNoConfinados;
	private Factory<Object> factoriaTranserObjects;
	private String nombreUsuario;
	private char[] contrasenaUsuario;
	
	public ServiAppAcampado() {
		this.listaEstudiantesNoConfinados= new ArrayList<TAcampado>();
		this.listaEstudiantes = new ArrayList<TAcampado>();
		this.observers = new ArrayList<AcampadoObserver>();
	}
	
	public void updateEstudiantes() {
		this.listaEstudiantes = SingletonDaoAcampado.getInstance().leeTodo(this.factoriaTranserObjects);
		
	}
	
	public void registrarFactoria(Factory<Object> objetosFactory) {
		this.factoriaTranserObjects = objetosFactory;
	}

	public void registraUsuario(String text, char[] password) {
		this.nombreUsuario = text;
		this.contrasenaUsuario = password;
	}
	
	public void eliminarConfinado(String nombreUsuario) {
		
		for(int i=0;i<this.listaEstudiantes.size();i++) {
			
			if(listaEstudiantes.get(i).getNombre().equals(nombreUsuario)) {
				String nombre  = this.listaEstudiantes.get(i).getNombre();
				String usuario  = this.listaEstudiantes.get(i).getUsuario();
				
				JSONObject desconfinado = new JSONObject();
				desconfinado.accumulate("type", "estudiante");
				
				JSONObject data = new JSONObject();
				data.accumulate("nombre", nombre);
				data.accumulate("usuario", usuario);
				data.accumulate("confinado", "No");
				
				data.accumulate("habitacion", this.listaEstudiantes.get(i).getHabitacion());
				/*JSONArray actividades = new JSONArray();
				for(int j = 0; j < this.listaEstudiantes.get(i).listaactividades.size(); j++) {
					actividades.put((String) this.listaEstudiantes.get(i).getListaactividades().get(j));
				}*/
				
				String actividades = "[";
				for(int j = 0; j < this.listaEstudiantes.get(i).listaactividades.size(); j++) {
					actividades += "\"" + this.listaEstudiantes.get(i).getListaactividades().get(j) +  "\"";
					if(j!= this.listaEstudiantes.get(i).listaactividades.size() - 1 ) {
						actividades += ",";
					}
				}
				actividades += "]";
				//JSONArray act = new JSONArray(new JSONTokener(actividades));
				data.accumulate("listaActividades", new JSONArray(actividades));
				JSONObject contrato1 = new JSONObject();
				contrato1.accumulate("coste", listaEstudiantes.get(i).getContrato().getCoste());
				contrato1.accumulate("tipo", listaEstudiantes.get(i).getContrato().getTipo());
				data.accumulate("contrato", contrato1);
				desconfinado.accumulate("data", data);
				
				TAcampado te = (TAcampado)this.factoriaTranserObjects.createInstance(desconfinado);
				this.listaEstudiantes.remove(i);
				this.listaEstudiantes.add(te);
				this.guardaEstudiantes();
				this.onCreateEstudiante();
			}
		}
		
		
		
		
		
		/*for(int i=0;i<this.listaEstudiantes.size();i++) {
			if(listaEstudiantes.get(i).getNombre().equals(nombreUsuario)) {
				if(listaEstudiantes.get(i).isConfinado()) {
					
					this.listaEstudiantes.get(i).setConfinado(false);
					
					this.listaEstudiantesNoConfinados.add(listaEstudiantes.get(i));
					
					this.guardaEstudiantes();
					this.onEliminarEstudiante();
				}
			}
			
		}*/
		
	}
	
	public void anadirConfinado(String nombreUsuario, int numDias, String infectado, String contacto, String recogidaRopa, String comidayCena) {
		
		for(int i=0;i<this.listaEstudiantes.size();i++) {
			
			if(listaEstudiantes.get(i).getNombre().equals(nombreUsuario)) {
				String nombre  = this.listaEstudiantes.get(i).getNombre();
				String usuario  = this.listaEstudiantes.get(i).getUsuario();
				
				JSONObject confinado = new JSONObject();
				
				JSONObject data = new JSONObject();
				data.accumulate("nombre", nombre);
				data.accumulate("usuario", usuario);
				data.accumulate("confinado", "Si");
				
				JSONObject detallesConfinado = new JSONObject();
				detallesConfinado.accumulate("diasCuarentena", numDias);
				detallesConfinado.accumulate("infectado", infectado);
				detallesConfinado.accumulate("contacto", contacto);
				detallesConfinado.accumulate("recogidaRopa", recogidaRopa);
				detallesConfinado.accumulate("comidayCena", comidayCena);
				
				data.accumulate("detallesConfinado", detallesConfinado);
				data.accumulate("habitacion", this.listaEstudiantes.get(i).getHabitacion());
				
				/*JSONArray actividades = new JSONArray();
				for(int j = 0; j < this.listaEstudiantes.get(i).listaactividades.size(); j++) {
					String actividad = this.listaEstudiantes.get(i).getListaactividades().get(j);
					actividades.put(actividad);
				}*/
				String actividades = "[";
				for(int j = 0; j < this.listaEstudiantes.get(i).listaactividades.size(); j++) {
					actividades += "\"" + this.listaEstudiantes.get(i).getListaactividades().get(j) +  "\"";
					if(j!= this.listaEstudiantes.get(i).listaactividades.size() - 1 ) {
						actividades += ",";
					}
				}
				actividades += "]";
				//JSONArray act = new JSONArray(new JSONTokener(actividades));
				data.accumulate("listaActividades", new JSONArray(actividades));
				JSONObject contrato1 = new JSONObject();
				contrato1.accumulate("coste", listaEstudiantes.get(i).getContrato().getCoste());
				contrato1.accumulate("tipo", listaEstudiantes.get(i).getContrato().getTipo());
				data.accumulate("contrato", contrato1);
				confinado.accumulate("data", data);
				confinado.accumulate("type", "estudianteConfinado");
				TEstudianteConfinado tc = (TEstudianteConfinado)this.factoriaTranserObjects.createInstance(confinado);
				this.listaEstudiantes.remove(i);
				this.listaEstudiantes.add(tc);
				SingletonControllerCoordCovid.getInstance().anadeConfinadoALista(tc);
				this.guardaEstudiantes();
				this.onCreateEstudiante();
			}
		}
		
	}
	
	public void modificarConfinado(String nombreUsuario, int numDias, String infectado, String contacto,
			String recogidaRopa, String comidayCena) {
		
		
		for(int i=0;i<this.listaEstudiantes.size();i++) {
			
			if(listaEstudiantes.get(i).getNombre().equals(nombreUsuario)) {
				String nombre  = this.listaEstudiantes.get(i).getNombre();
				String usuario  = this.listaEstudiantes.get(i).getUsuario();
				
				JSONObject confinado = new JSONObject();
				
				confinado.accumulate("type", "estudianteConfinado");
				
				JSONObject data = new JSONObject();
				data.accumulate("nombre", nombre);
				data.accumulate("usuario", usuario);
				data.accumulate("confinado", "Si");
				
				JSONObject detallesConfinado = new JSONObject();
				detallesConfinado.accumulate("diasCuarentena", numDias);
				detallesConfinado.accumulate("infectado", infectado);
				detallesConfinado.accumulate("contacto", contacto);
				detallesConfinado.accumulate("recogidaRopa", recogidaRopa);
				detallesConfinado.accumulate("comidayCena", comidayCena);
				
				data.accumulate("detallesConfinado", detallesConfinado);
				data.accumulate("habitacion", this.listaEstudiantes.get(i).getHabitacion());
				/*JSONArray actividades = new JSONArray();
				for(int j = 0; j < this.listaEstudiantes.get(i).listaactividades.size(); j++) {
					actividades.put(this.listaEstudiantes.get(i).getListaactividades().get(j));
				}*/
				String actividades = "[";
				for(int j = 0; j < this.listaEstudiantes.get(i).listaactividades.size(); j++) {
					actividades += "\"" + this.listaEstudiantes.get(i).getListaactividades().get(j) +  "\"";
					if(j!= this.listaEstudiantes.get(i).listaactividades.size() - 1 ) {
						actividades += ",";
					}
				}
				actividades += "]";
				//JSONArray act = new JSONArray(new JSONTokener(actividades));
				data.accumulate("listaActividades", new JSONArray(actividades));
				JSONObject contrato1 = new JSONObject();
				contrato1.accumulate("coste", listaEstudiantes.get(i).getContrato().getCoste());
				contrato1.accumulate("tipo", listaEstudiantes.get(i).getContrato().getTipo());
				data.accumulate("contrato", contrato1);
				confinado.accumulate("data", data);
				
				
				TEstudianteConfinado tc = (TEstudianteConfinado) this.factoriaTranserObjects.createInstance(confinado);
				this.listaEstudiantes.remove(i);
				this.listaEstudiantes.add(tc);
				SingletonControllerCoordCovid.getInstance().anadeConfinadoALista(tc);
				this.guardaEstudiantes();
				this.onModificarEstudiante();
			}
		}
		
		
	}
	void onCreateEstudiante() {
		this.updateEstudiantes();
		for(AcampadoObserver o: this.observers) {
			o.onCreateEstudiante(this.listaEstudiantes);
		}
	}
	void onEliminarEstudiante() {
		this.updateEstudiantes();
		for(AcampadoObserver o: this.observers) {
			o.onEliminarEstudiante(this.listaEstudiantes);
		}
	}
	void onModificarEstudiante() {
		this.updateEstudiantes();
		for(AcampadoObserver o: this.observers) {
			o.onModificarEstudiante(this.listaEstudiantes);
		}
	}

	@Override
	public void addObserver(AcampadoObserver o) {
		this.observers.add(o);
		this.updateEstudiantes();
		o.onRegister(listaEstudiantes);
	}

	@Override
	public void removeObserver(AcampadoObserver o) {
		this.observers.remove(o);
	}
	
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public List<TAcampado> getListaEstudiantes() {
		this.updateEstudiantes();
		return this.listaEstudiantes;
	}
	
	public List<TAcampado> getListaNoConfinados() {
		this.updateEstudiantes();
		List<TAcampado> lnc = new ArrayList<TAcampado>();
		for(TAcampado te: this.listaEstudiantes) {
			if(!te.isConfinado()) {
				lnc.add((TAcampado) te);
			}
		}
		return lnc;
	}

	public List<TEstudianteConfinado> getListaConfinados() {
		this.updateEstudiantes();
		List<TEstudianteConfinado> l = new ArrayList<TEstudianteConfinado>();
		for(TAcampado te: this.listaEstudiantes) {
			if(te.isConfinado()) {
				//TEstudianteConfinado ti = new TEstudianteConfinado(te.getNombre(), te.getUsuario(), true, 10, false, false, false, false, te.getHabitacion(), te.getListaactividades(), te.getContrato());
				l.add((TEstudianteConfinado) te);
			}
		}
		return l;
	}
	
	public void guardaEstudiantes() {
        SingletonDaoAcampado.getInstance().escribeTodo(this.listaEstudiantes);
	}

	public String getHabitacionEstudiante(String nombreUsuario) {
		this.updateEstudiantes();
		String hab = null;
		for(int i = 0; i < this.listaEstudiantes.size(); i++) {
			if(listaEstudiantes.get(i).getUsuario().equals(nombreUsuario)) {
				hab = listaEstudiantes.get(i).getHabitacion();
			}
		}
		return hab;
	}

	
}



