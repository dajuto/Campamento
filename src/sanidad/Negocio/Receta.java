package sanidad.Negocio;

import org.json.JSONObject;

import acampados.Negocio.Acampado;
import empleados.Negocio.Empleado;

public class Receta {
	
	protected int codigo;
	protected String medicamento;
	protected String dosis;
	protected Empleado Nombremedico;
	protected Acampado NombreAcampado;
	protected String comprado;
	
	public String toString() {
		return Integer.toString(codigo);
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Acampado getNombreAcampado() {
		return NombreAcampado;
	}

	public void setNombreAcampado(Acampado nombreAcampado) {
		NombreAcampado = nombreAcampado;
	}

	public String getComprado() {
		return comprado;
	}

	public void setComprado(String comprado) {
		this.comprado = comprado;
	}

	public String getMedicamento() {
		return medicamento;
	}
	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}
	public String getDosis() {
		return dosis;
	}
	public void setDosis(String dosis) {
		this.dosis = dosis;
	}
	public Empleado getNombremedico() {
		return Nombremedico;
	}
	public void setNombremedico(Empleado nombremedico) {
		Nombremedico = nombremedico;
	}
	
	
	public JSONObject report() {
		String c = Integer.toString(codigo);
		JSONObject receta = new JSONObject();
		receta.accumulate("type", "receta");
		JSONObject data = new JSONObject();
		data.accumulate("codigo", c);
		data.accumulate("medicamento", this.medicamento);
		data.accumulate("dosis", this.dosis);
		data.accumulate("Nombremedico", this.Nombremedico.getUsuario());
		data.accumulate("NombreAcampado", this.NombreAcampado.getNombre());
		data.accumulate("comprado", this.comprado);
		receta.accumulate("data", data);
		return receta;
	}
	
	

}
