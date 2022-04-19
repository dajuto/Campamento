package sanidad.Negocio;

import org.json.JSONObject;

import empleados.Negocio.SingletonServiAppEmpleado;
import empleados.Negocio.TEmpleado;
import launcher.Builder;

public class RecetaBuilder extends Builder<Object> {

	protected RecetaBuilder(String type) {
		super("receta");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Object createTheInstance(JSONObject data) {
		String Nombremedico = data.getString("Nombremedico");
		if(SingletonServiAppEmpleado.getInstance().containsEmpleado(Nombremedico)) {
			String c = data.getString("codigo");
			int codigo = Integer.parseInt(c);   
		    String medicamento = data.getString("medicamento");
			String dosis = data.getString("dosis");
			TEmpleado templMedico = SingletonServiAppEmpleado.getInstance().getEmpleado(Nombremedico);
			String comprado = data.getString("comprado");
			TReceta treceta= new TReceta(codigo, medicamento, dosis, templMedico,comprado);
			return treceta;
		}
		else {
			return null;
		}
	}

}
