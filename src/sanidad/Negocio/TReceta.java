package sanidad.Negocio;

import acampados.Negocio.Acampado;
import empleados.Negocio.Empleado;

public class TReceta extends Receta{
	
	public TReceta(int codigo, String medicamento, String dosis, Empleado Nombremedico, String comprado, Acampado NombreAcampado){
		this.codigo = codigo;
		this.medicamento = medicamento;
		this.dosis = dosis;
		this.Nombremedico = Nombremedico;
		this.comprado=comprado;
		this.NombreAcampado=NombreAcampado;
	}

}
