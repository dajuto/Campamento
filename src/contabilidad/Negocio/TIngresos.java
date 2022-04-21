package contabilidad.Negocio;

public class TIngresos extends Ingresos {

	public TIngresos(String tipo, String concepto, int importe,String fecha, String nombreAcampado, String dniAcampado, boolean contabilizada) {
		
		this.tipo = tipo;
		this.concepto = concepto;
		this.importe = importe;
		this.fechaContable = fecha; 
		this.nombreAcampado = nombreAcampado; 
		this.dniAcampado = dniAcampado; 
		this.contabilizada = contabilizada; 

	}
	
}





