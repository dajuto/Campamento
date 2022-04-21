package gestoria.Negocio;

import org.json.JSONObject;

import empleados.Negocio.Empleado;
import empleados.Negocio.SingletonServiAppEmpleado;
import empleados.Negocio.TEmpleado;
import empleados.Negocio.TEmpleadoLimpieza;
import empleados.Presentacion.SingletonControllerEmpleado;
import launcher.Builder;

public class LimpiezaBuilder extends Builder<Object> {

	public LimpiezaBuilder() {
		super("limpieza");
	}

	@Override
	protected TLimpieza createTheInstance(JSONObject data) {
		String codigo = data.getString("Codigo");
		String lugar = data.getString("Lugar");
		String dia = data.getString("Dia");
		String hora = data.getString("Hora");
		String empleado = data.getString("Empleado");
		TLimpieza tlimpieza = new TLimpieza (codigo, lugar, dia, hora, empleado);
		return tlimpieza;
	}
}
