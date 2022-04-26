package empleados.Negocio;

import java.util.ArrayList;
import java.util.List;

public class TNutricionista extends Nutricionista{
	public TNutricionista(String nombre, String puesto,String contrasena, String usuario, int salario, int horario, String vacaciones, List<String> citasPendientes){
		this.nombre = nombre;
		this.puesto = puesto;
		this.usuario = usuario;
		this.contrasena=contrasena;
		this.salario = salario;
		this.horario = horario;
		this.vacaciones = vacaciones;
		this.menu = new ArrayList<String>(menu);
	}
}
