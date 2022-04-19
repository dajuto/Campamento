package empleados.Negocio;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import launcher.Builder;

public class EmpleadoMantenimientoBuilder extends Builder<Object>{

	public EmpleadoMantenimientoBuilder() {
		super("Empleado Mantenimiento");
	}

	@Override
	protected TEmpleadoMantenimiento createTheInstance(JSONObject data) {
		String usuario = data.getString("usuario");
		String contrasena = data.getString("contrasena");
		String nombre = data.getString("nombre");
		String puesto = data.getString("puesto");
		int salario = data.getInt("salario");
		int horario = data.getInt("horario");
		String vacaciones = data.getString("vacaciones");
		JSONObject averias = data.getJSONObject("trabajo");
		List<String> listaAverias = new ArrayList<String>();
		if(averias.has("listaAverias")) {
			JSONArray limpiezaAsignada = averias.getJSONArray("listaAverias");
			for(int i = 0; i < limpiezaAsignada.length(); i++) {
	        	listaAverias.add(limpiezaAsignada.getString(i));
	        }  
		}
		TEmpleadoMantenimiento empleadoMantenimiento = new TEmpleadoMantenimiento(usuario, contrasena, nombre, puesto, salario, horario, vacaciones, listaAverias);
		return empleadoMantenimiento;
	}

}
