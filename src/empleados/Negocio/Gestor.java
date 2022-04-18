package empleados.Negocio;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public abstract class Gestor extends TEmpleado{
	protected List<String> horariosLimpieza;
	
	public List<String> getListLimpieza(){
		return this.horariosLimpieza;
	}

	public JSONObject report() {
	JSONObject empleado = new JSONObject();
	empleado.accumulate("type", "Gestor");
	JSONObject data = new JSONObject();
	data.accumulate("usuario", this.usuario);
	data.accumulate("contrasena", this.contrasena);
	data.accumulate("nombre", this.nombre);
	data.accumulate("puesto", this.puesto);
	data.accumulate("salario", salario);
	data.accumulate("horario", horario);
	data.accumulate("vacaciones", vacaciones);
	
	empleado.accumulate("data", data);
	return empleado;
}
}
