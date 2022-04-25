package contabilidad.Negocio;


public class TGastos extends Gastos{
	public TGastos(String tipo, String concepto, int importe,String fecha, String nombre, boolean contabilizada, String numeroFactura) {
		this.tipo = tipo;
		this.concepto = concepto;
		this.importe = importe;
		this.fecha = fecha; 
		this.nombreEmpleado = nombre; 
		this.contabilizada = contabilizada; 
		this.numeroFactura = numeroFactura; 
	}

}
