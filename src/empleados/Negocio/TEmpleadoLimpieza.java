package empleados.Negocio;

import java.util.ArrayList;
import java.util.List;

public class TEmpleadoLimpieza extends EmpleadoLimpieza{
	public TEmpleadoLimpieza(int codigo, String nombre, String puesto, int salario, int horario, String vacaciones, List<String> averiasPendientes){
		this.codigo = codigo;
		this.nombre = nombre;
		this.puesto = puesto;
		this.salario = salario;
		this.horario = horario;
		this.vacaciones = vacaciones;
		this.horariosLimpieza = new ArrayList<String>(averiasPendientes);
	}
}

