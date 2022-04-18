package gestoria.Negocio;

import org.json.JSONObject;

import empleados.Negocio.Empleado;
import empleados.Negocio.SingletonServiAppEmpleado;
import empleados.Negocio.TEmpleado;
import empleados.Negocio.TEmpleadoLimpieza;
import launcher.Builder;

public class LimpiezaBuilder extends Builder<Object> {

	public LimpiezaBuilder() {
		super("limpieza");
	}

	@Override
	protected TLimpieza createTheInstance(JSONObject data) {
		String codigo = data.getString("Codigo");
		String lugar = data.getString("Lugar");
		String fecha = data.getString("Fecha");
		String hora = data.getString("Hora");
		String empleadoEncargado = data.getString("Empleado");
		TEmpleadoLimpieza empleado = SingletonServiAppEmpleado.getInstance().getEmpleado(empleadoEncargado);
		TLimpieza tlimpieza = new TLimpieza (codigo, lugar, fecha, hora, empleado);
		return tlimpieza;
	}
}
