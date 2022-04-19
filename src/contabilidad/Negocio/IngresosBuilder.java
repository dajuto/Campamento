package contabilidad.Negocio;

import org.json.JSONObject;
import launcher.Builder;

public class IngresosBuilder extends Builder<Object> {
	public IngresosBuilder() {
		super("ingresos");
	}

	@Override
	protected TIngresos createTheInstance(JSONObject data) {

		
		String tipo = data.getString("Tipo");
		String concepto = data.getString("Concepto");
		int importe = data.getInt("Importe");
		String fecha = data.getString("Fecha de pago");
		JSONObject acampado = data.getJSONObject("Acampado"); 
		String LoEs = acampado.getString("LoEs");
		String nombreAcampado = "";
		String dniAcampado = ""; 
		if(LoEs.contentEquals("SI")) {
			nombreAcampado = acampado.getString("Nombre");
			dniAcampado = acampado.getString("DNI"); 	
		}
		
		TIngresos contabilidadIngresos = new TIngresos(tipo, concepto, importe, fecha, LoEs, nombreAcampado, dniAcampado);
		return contabilidadIngresos;
	}
}






