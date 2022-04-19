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
		JSONObject empleado = data.getJSONObject("Empleado"); 
		String LoEs = empleado.getString("LoEs");
		String nombreEmpleado = "";
		if(LoEs.contentEquals("SI")) {
			nombreEmpleado = empleado.getString("Nombre");
		}
		
		TGastos contabilidadGastos = new TGastos(tipo, concepto, importe,fecha, LoEs, nombreEmpleado);
		return contabilidadGastos;
	}
}


