package empleados.Negocio;

import java.util.ArrayList;
import java.util.List;

public class TGestorActividades extends GestorActividades{
	public TGestorActividades(String nombre, String puesto,String contrasena, String usuario, int salario, int horario, String vacaciones, List<String> actividades){
		this.nombre = nombre;
		this.puesto = puesto;
		this.usuario = usuario;
		this.contrasena=contrasena;
		this.salario = salario;
		this.horario = horario;
		this.vacaciones = vacaciones;
		this.actividades = new ArrayList<String>(actividades);
	}
}
