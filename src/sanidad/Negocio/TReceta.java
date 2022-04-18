package sanidad.Negocio;

import empleados.Negocio.Empleado;

public class TReceta extends Receta{
	
	public TReceta(int codigo, String medicamento, String dosis, Empleado Nombremedico, String comprado){
		this.codigo = codigo;
		this.medicamento = medicamento;
		this.dosis = dosis;
		this.Nombremedico = Nombremedico;
		this.comprado=comprado;
	}

}
