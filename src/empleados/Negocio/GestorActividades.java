package empleados.Negocio;

import java.util.List;

import org.json.JSONObject;

public class GestorActividades extends TEmpleado{

protected List<String> actividades;
	
	public List<String> getListaActividades(){
		return this.actividades;
	}

	public JSONObject report() {
	JSONObject empleado = new JSONObject();
	empleado.accumulate("type", "Gestor Actividades");
	JSONObject data = new JSONObject();
	
	data.accumulate("nombre", this.nombre);
	data.accumulate("puesto", this.puesto);
	data.accumulate("usuario", this.usuario);
	data.accumulate("contrasena", this.contrasena);
	data.accumulate("salario", salario);
	data.accumulate("horario", horario);
	data.accumulate("vacaciones", vacaciones);
	
	JSONObject trabajo = new JSONObject();
	trabajo.accumulate("actividades", this.getListaActividades());
	
	data.accumulate("trabajo", trabajo);
	empleado.accumulate("data", data);
	return empleado;
}
	
	
	
}
