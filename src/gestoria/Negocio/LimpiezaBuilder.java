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
		String codigo = data.getString("Codigo");
		String lugar = data.getString("Lugar");
		String fecha = data.getString("Fecha");
		String hora = data.getString("Hora");
		String empleadoEncargado = data.getString("Empleado");
		//TEmpleado empleado = SingletonServiAppEmpleado.getInstance().getEmpleado(empleadoEncargado);
		TLimpieza tlimpieza = new TLimpieza (codigo, lugar, fecha, hora, empleadoEncargado);
		return tlimpieza;
	}
}
