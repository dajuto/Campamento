package empleados.Negocio;

import java.util.ArrayList;
import java.util.List;

public class TEmpleadoLimpieza extends EmpleadoLimpieza{
	public TEmpleadoLimpieza(String usuario, String contrasena, String nombre, String puesto, int salario, int horario, String vacaciones, List<String> listaLimpieza){
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.puesto = puesto;
		this.salario = salario;
		this.horario = horario;
		this.vacaciones = vacaciones;
		this.horariosLimpieza = new ArrayList<String>(listaLimpieza);
	}
}

