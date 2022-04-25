package sanidad.Negocio;

import acampados.Negocio.Acampado;
import empleados.Negocio.Empleado;

public class TCita extends Cita{
	
	public TCita(int codigo, String motivo, String Nombremedico, String atendido, String NombreAcampado){
		this.codigo = codigo;
		this.motivo = motivo;
		this.Nombremedico = Nombremedico;
		this.atendido=atendido;
		this.NombreAcampado=NombreAcampado;
	}

}