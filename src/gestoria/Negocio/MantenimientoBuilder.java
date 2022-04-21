package gestoria.Negocio;

import org.json.JSONObject;

import empleados.Negocio.Empleado;
import empleados.Negocio.SingletonServiAppEmpleado;
import empleados.Negocio.TEmpleado;
import empleados.Negocio.TEmpleadoLimpieza;
import empleados.Presentacion.SingletonControllerEmpleado;
import launcher.Builder;

public class MantenimientoBuilder extends Builder<Object> {

	public MantenimientoBuilder() {
		super("averia");
	}

	@Override
	protected TMantenimiento createTheInstance(JSONObject data) {
		String codigo = data.getString("Codigo");
		String descripcion = data.getString("Descripcion");
		String lugar = data.getString("Lugar");
		int coste = data.getInt("Coste");
		String empleado = data.getString("Empleado");
		String estado = data.getString("Estado");
		
		TMantenimiento tmant = new TMantenimiento (codigo, descripcion, lugar, coste, empleado, estado);
		return tmant;
	}
}
