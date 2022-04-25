package sanidad.Negocio;

import org.json.JSONObject;

import acampados.Negocio.SingletonServiAppAcampado;
import acampados.Negocio.TAcampado;
import empleados.Negocio.SingletonServiAppEmpleado;
import empleados.Negocio.TEmpleado;
import launcher.Builder;

public class CitaBuilder extends Builder<Object> {

	public CitaBuilder() {
		super("cita");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Object createTheInstance(JSONObject data) {
		String Nombremedico = data.getString("Nombremedico");
		if(SingletonServiAppEmpleado.getInstance().containsEmpleado(Nombremedico)) {
			String c = data.getString("codigo");
			int codigo = Integer.parseInt(c);   
		    String motivo = data.getString("motivo");
			String NombreAcampado = data.getString("NombreAcampado");
			String atendido = data.getString("atendido");
			TCita tcita= new TCita(codigo, motivo, Nombremedico,atendido,NombreAcampado);
			return tcita;
		}
		else {
			return null;
		}
	}

}
