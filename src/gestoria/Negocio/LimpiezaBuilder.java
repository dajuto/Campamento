package gestoria.Negocio;

import org.json.JSONObject;

import empleados.Negocio.Empleado;
import empleados.Negocio.SingletonServiAppEmpleado;
import empleados.Negocio.TEmpleado;
import launcher.Builder;

public class LimpiezaBuilder extends Builder<Object> {

	public LimpiezaBuilder() {
		super("limpieza");
	}

	@Override
	protected TLimpieza createTheInstance(JSONObject data) {
//		String empleadoEncargado = data.getString("usuarioEmpleadoEncargado");
//		if(SingletonServiAppEmpleado.getInstance().containsEmpleado(empleadoEncargado)) {
//			String c = data.getString("codigo");
//			int codigo = Integer.parseInt(c);   
//		    String lugar = data.getString("lugar");
//			String descripcion = data.getString("descripcion");
//			TEmpleado templMantenimiento = SingletonServiAppEmpleado.getInstance().getEmpleado(empleadoEncargado);
//			String estado = data.getString("estado");
//			TLimpieza taveria = new TLimpieza(codigo, lugar, descripcion, templMantenimiento, estado);
//			return taveria;
//		}
//		else {
//			return null;
//		}
		String c = data.getString("codigo");
		int codigo = Integer.parseInt(c);
		String lugar = data.getString("lugar");
		String fecha = data.getString("codigo");
		String hora = data.getString("codigo");
		String empleadoEncargado = data.getString("usuarioEmpleadoEncargado");
		TEmpleado empleado = SingletonServiAppEmpleado.getInstance().getEmpleado(empleadoEncargado);
		TLimpieza tlimpieza = new TLimpieza (codigo, lugar, fecha, hora, empleado);
		return tlimpieza;
	}
}
