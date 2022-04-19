package empleados.Negocio;

import java.util.ArrayList;
import java.util.List;

public class TMedico extends Medico{
	public TMedico(String nombre, String puesto,String contrasena, String usuario, int salario, int horario, String vacaciones, List<String> citasPendientes){
		this.nombre = nombre;
		this.puesto = puesto;
		this.usuario = usuario;
		this.contrasena=contrasena;
		this.salario = salario;
		this.horario = horario;
		this.vacaciones = vacaciones;
		this.citasPendientes = new ArrayList<String>(citasPendientes);
	}
}
