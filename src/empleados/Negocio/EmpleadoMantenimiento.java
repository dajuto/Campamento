package empleados.Negocio;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public abstract class EmpleadoMantenimiento extends TEmpleado{
	protected List<String> listaAverias;
	
	public List<String> getListaAverias(){
		return this.listaAverias;
	}

	public JSONObject report() {
	JSONObject empleado = new JSONObject();
	empleado.accumulate("type", "Empleado Limpieza");
	JSONObject data = new JSONObject();
	data.accumulate("usuario", this.usuario);
	data.accumulate("contrasena", this.contrasena);
	data.accumulate("nombre", this.nombre);
	data.accumulate("puesto", this.puesto);
	data.accumulate("salario", salario);
	data.accumulate("horario", horario);
	data.accumulate("vacaciones", vacaciones);
	
	JSONObject averias = new JSONObject();
	averias.accumulate("listaAverias", this.getListaAverias());
	
	data.accumulate("trabajo", averias);
	empleado.accumulate("data", data);
	return empleado;
}
}
