package contabilidad.Negocio;

import org.json.JSONObject;
import launcher.Builder;

public class IngresosBuilder extends Builder<Object> {
	public IngresosBuilder() {
		super("contabilidad"); //ingresos ponia antes
	}

	@Override
	protected TIngresos createTheInstance(JSONObject data) {
		
		String tipo = data.getString("Tipo");
		String concepto = data.getString("Concepto");
		int importe = data.getInt("Importe");
		String fecha = data.getString("Fecha contable");
		JSONObject acampado = data.getJSONObject("Acampado"); 
		String nombreAcampado = acampado.getString("Nombre");
		String dniAcampado = acampado.getString("DNI"); 
			
		String sContabilizada = data.getString("Contabilizada"); 
		boolean conta = false; 
		if(sContabilizada.equals("Si")) {
			conta = true; 
		}
			
		TIngresos contabilidadIngresos = new TIngresos(tipo, concepto, importe, fecha, nombreAcampado, dniAcampado, conta);
		return contabilidadIngresos;
	}
}






