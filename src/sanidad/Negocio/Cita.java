package sanidad.Negocio;

import org.json.JSONObject;



public class Cita {
	
	protected int codigo;
	protected String motivo;
	protected String Nombremedico;
	protected String NombreAcampado;
	protected String atendido;
	
	public String toString() {
		return Integer.toString(codigo);
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getAtendido() {
		return atendido;
	}

	public void setAtendido(String atendido) {
		this.atendido = atendido;
	}

	public String getNombreAcampado() {
		return NombreAcampado;
	}

	public void setNombreAcampado(String nombreAcampado) {
		NombreAcampado = nombreAcampado;
	}


	public String getNombremedico() {
		return Nombremedico;
	}
	public void setNombremedico(String nombremedico) {
		Nombremedico = nombremedico;
	}
	
	
	public JSONObject report() {
		String c = Integer.toString(codigo);
		JSONObject receta = new JSONObject();
		receta.accumulate("type", "cita");
		JSONObject data = new JSONObject();
		data.accumulate("codigo", c);
		data.accumulate("motivo", this.motivo);
		data.accumulate("Nombremedico", this.Nombremedico);
		data.accumulate("NombreAcampado", this.NombreAcampado);
		data.accumulate("atendido", this.atendido);
		receta.accumulate("data", data);
		return receta;
	}
	
	

}
