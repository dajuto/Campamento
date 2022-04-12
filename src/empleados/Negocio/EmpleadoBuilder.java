package empleados.Negocio;

import org.json.JSONObject;

import launcher.Builder;

public class EmpleadoBuilder extends Builder<Object>{
	public EmpleadoBuilder() {
		super("empleado");
	}

	@Override
	protected Object createTheInstance(JSONObject data) {
		return null;
	}

}
