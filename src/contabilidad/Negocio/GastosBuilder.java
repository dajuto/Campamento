package contabilidad.Negocio;

import org.json.JSONObject;

import launcher.Builder;

public class GastosBuilder extends Builder<Object> {

	public GastosBuilder() {
		super("gastos");
	}

	@Override
	protected TGastos createTheInstance(JSONObject data) {

		String tipo = data.getString("Tipo");
		String concepto = data.getString("Concepto");
		int importe = data.getInt("Importe");
		String fecha = data.getString("Fecha de pago");
		String nombreEmpleado = data.getString("Empleado"); 
		TGastos contabilidadGastos = new TGastos(tipo, concepto, importe,fecha, nombreEmpleado);
		return contabilidadGastos;
	}
}


