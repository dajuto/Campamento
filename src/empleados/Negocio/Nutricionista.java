package empleados.Negocio;

import java.util.List;

import org.json.JSONObject;

public class Nutricionista extends TEmpleado{

protected List<String> menu;
	
	public List<String> getListaMenu(){
		return this.menu;
	}

	public JSONObject report() {
	JSONObject empleado = new JSONObject();
	empleado.accumulate("type", "Nutricionista");
	JSONObject data = new JSONObject();
	
	data.accumulate("nombre", this.nombre);
	data.accumulate("puesto", this.puesto);
	data.accumulate("usuario", this.usuario);
	data.accumulate("contrasena", this.contrasena);
	data.accumulate("salario", salario);
	data.accumulate("horario", horario);
	data.accumulate("vacaciones", vacaciones);
	
	JSONObject trabajo = new JSONObject();
	trabajo.accumulate("actividades", this.getListaMenu());
	
	data.accumulate("trabajo", trabajo);
	empleado.accumulate("data", data);
	return empleado;
}
	
	
	
}
