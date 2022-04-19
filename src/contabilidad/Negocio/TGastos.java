package contabilidad.Negocio;


public class TGastos extends Gastos{
	public TGastos(String tipo, String concepto, int importe,String fecha, String LoEs, String nombre) {
		this.tipo = tipo;
		this.concepto = concepto;
		this.importe = importe;
		this.fecha = fecha; 
		this.LoEs = LoEs;
		this.nombre = nombre; 
	}

}
