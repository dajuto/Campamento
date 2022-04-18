package gestoria.Negocio;

import org.json.JSONObject;

import empleados.Negocio.Empleado;
import empleados.Negocio.SingletonServiAppEmpleado;
import empleados.Negocio.TEmpleado;
import launcher.Builder;

public class InstalacionBuilder extends Builder<Object> {

	public InstalacionBuilder() {
		super("instalacion");
	}

	@Override
	protected TInstalacion createTheInstance(JSONObject data) {
		String codigo = data.getString("Codigo");
		String nombre = data.getString("Nombre");
		int superficie = data.getInt("Superficie");
		int precio = data.getInt("Precio");
		String sPagado = data.getString("Pagado");
		boolean pagado = false;
		if (sPagado.equals("Si")) {
			pagado = true;
		}
		String sActividades = data.getString("Actividades");
		boolean actividades = false;
		if (sActividades.equals("Si")) {
			actividades = true;
		}
		TInstalacion tinstalacion = new TInstalacion(codigo, nombre, superficie, precio, pagado, actividades);
		return tinstalacion;
	}
}
