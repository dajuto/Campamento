package empleados.Presentacion;

import java.awt.Frame;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import empleados.Negocio.SingletonServiAppEmpleado;
import launcher.Factory;

public class ControllerEmpleado {

	public void registraFactoria(Factory<Object> factoriaTransferObjects) {
		SingletonServiAppEmpleado.getInstance().registraFactoria(factoriaTransferObjects);
	}

	public void mostrarInformacionEmpleadoMantenimiento(String nombreEmpleado) {
		// TODO Auto-generated method stub
		
	}
	public void mostrarInformacionEmpleado(Frame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaInformacionEmpleado(frame);
			}
		});
	}
	
	public boolean contieneEmpleado(String nombreEmpleado) {
		return SingletonServiAppEmpleado.getInstance().containsEmpleado(nombreEmpleado);
	}


	public void mostrarGeneralEmpleado(Frame f) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaGeneralEmpleado(f);
			}
		});
	}
	
	public void mostrarGestor(Frame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaGestor(frame);
			}
		});
	}
	
	public void mostrarEmpleadoMantenimiento(Frame f) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaEmpleadoMantenimiento(f);
			}
		});
	}

	public void mostrarInicioGestor(Frame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaInicioGestor(frame);
			}
		});
	}
	
	public void mostrarInicioEmpleadoMantenimiento(Frame f) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaInicioEmpleadoMantenimiento(f);
			}
		});
	}
	
	public void mostrarInicioEmpleadoContable(Frame f) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaInicioEmpleadoContable(f);
			}
		});
	}
	
	public void mostrarInicioEmpleadoDirectorRRHH(Frame f) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaInicioEmpleadoDirectorRRHH(f);
			}
		});
	}
	
	public void mostrarInicioEmpleadoCoordinadorCovid(Frame f) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaInicioEmpleadoCoordinadorCovid(f);
			}
		});
	}
	
	public void mostrarInicioEmpleadoLimpieza(Frame f) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaInicioEmpleadoLimpieza(f);
			}
		});
	}

	public void registraUsuario(String text, char[] password) {
		SingletonServiAppEmpleado.getInstance().registraUsuario(text, password);
		SingletonControllerMantenimiento.getInstance().registraUsuario(text, password);
		SingletonControllerAulas.getInstance().registraUsuario(text, password);
		SingletonControllerLimpieza.getInstance().registraUsuario(text, password);
	}

	public void mostrarEmpleadoLimpieza(Frame f) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaEmpleadoLimpieza(f);
			}
		});
	}

	public void mostrarEmpleadoDirectorRRHH(Frame f) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaEmpleadoDirectorRRHH(f);
			}
		});
	}

	public void mostrarEmpleadoCoordinadorCovid(Frame f) {
		String nombreEmpleado = SingletonServiAppEmpleado.getInstance().getNombreUsuario();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaEmpleadoCoordinadorCovid(f, nombreEmpleado);
			}
		});
	}

	public void mostrarEmpleadoContable(Frame f) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaEmpleadoContable(f);
			}
		});
	}

	
	
	public void mostrarListaEmpleados(Frame frame) {
		SingletonServiAppEmpleado.getInstance().updateEmpleados();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaListaEmpleados(frame);
			}
		});
	}
	
	public void mostrarAnadirEmpleado(Frame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaAnadirEmpleado(frame);
			}
		});
	}
	


	public void mostrarListaContable(Frame frame) {
		SingletonServiAppEmpleado.getInstance().updateEmpleados();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaListaContable(frame);
			}
		});
	}

	public List<TEmpleadoLimpieza> getListaEmpleadosMantenimiento() {
		return SingletonServiAppEmpleado.getInstance().getListaEmpleadosMantenimiento();
	}
	


	public void anadirEmpleado(Frame ventanaAnterior, String usuario, String nombre, String puesto, String salario, String horario, String vacaciones) {
		boolean isNumericNombre =  nombre.matches("[+-]?\\d*(\\.\\d+)?");
		boolean isNumericSalario =  salario.matches("[+-]?\\d*(\\.\\d+)?");
		boolean isNumericHorario =  horario.matches("[+-]?\\d*(\\.\\d+)?");
		boolean isNumericVacaciones =  vacaciones.matches("[+-]?\\d*(\\.\\d+)?");

		if(!isNumericNombre && isNumericSalario && isNumericHorario && isNumericVacaciones) {
			int sal = Integer.parseInt(salario);
			int hor = Integer.parseInt(horario);
			int vac = Integer.parseInt(vacaciones);

			boolean exito = SingletonServiAppEmpleado.getInstance().anadirEmpleado( usuario,  nombre,  puesto, sal, hor, vac);
			if(!exito) {
				JOptionPane.showMessageDialog(ventanaAnterior, "Ya existe un empleaado con este usuario", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(ventanaAnterior, "Los datos introducidos en el formulario no son validos", "Error", JOptionPane.ERROR_MESSAGE);
		}		
	}

	public void eliminarEmpleado(Frame ventanaAnterior, String usuario) {
		boolean exito = SingletonServiAppEmpleado.getInstance().eliminarEmpleado(ventanaAnterior, usuario);
		if(!exito) {
			//modificado
			JOptionPane.showMessageDialog(ventanaAnterior, "No se puede eliminar un empleado de mantenimiento con averias pendientes", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void mostrarEliminarEmpleado(Frame frame) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaEliminarEmpleado(frame);
			}
		});
	}
	
	public void mostrarModificarEmpleado(Frame frame) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaModificarEmpleado(frame);
			}
		});
		
	}

	public void mostrarAulasGestor(Frame f) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaGestorAulas(f);
			}
		});
		
	}
	
	public void addObserver(EmpleadoObserver vista) {
		SingletonServiAppEmpleado.getInstance().addObserver(vista);
	}
	

	public void mostrarListaConfinados(Frame frame) {
		SingletonControllerCoordCovid.getInstance().mostrarListaConfinados(frame);
	}

	public void mostrarListaActividades(Frame frame) {
		SingletonControllerCoordCovid.getInstance().mostrarListaActividades(frame);
	}

	public void mostrarMiInformacion(Frame frame) {
		
	}

	public void anadeAveriaEmpleado(TAveria ta) {
		SingletonServiAppEmpleado.getInstance().anadeAveriaEmpleado(ta);
	}

	public void eliminaAveriaEmpleado(TAveria tAveria) {
		// TODO Auto-generated method stub
		SingletonServiAppEmpleado.getInstance().eliminaAveriaEmpleado(tAveria);
	}

	public void mostrarListaAveriasEmpleadoMantenimiento(Frame ventanaAnterior) {
		SingletonControllerMantenimiento.getInstance().mostrarListaAveriasEmpleadoMantenimiento(ventanaAnterior);
	}

	public void modificarEmpleado(Frame ventanaAnterior, String nombre ,String usuario, String pu, String salario, String horario,
			String vacaciones) {
		
		boolean isNumericNombre =  nombre.matches("[+-]?\\d*(\\.\\d+)?");
		boolean isNumericSalario =  salario.matches("[+-]?\\d*(\\.\\d+)?");
		boolean isNumericHorario =  horario.matches("[+-]?\\d*(\\.\\d+)?");
		boolean isNumericVacaciones =  vacaciones.matches("[+-]?\\d*(\\.\\d+)?");

		if(!isNumericNombre && isNumericSalario && isNumericHorario && isNumericVacaciones) {
			int sal = Integer.parseInt(salario);
			int hor = Integer.parseInt(horario);
			int vac = Integer.parseInt(vacaciones);

			SingletonServiAppEmpleado.getInstance().modificarEmpleado( usuario,  nombre,  pu, sal, hor, vac);
			
		}
		else {
			JOptionPane.showMessageDialog(ventanaAnterior, "Los datos introducidos en el formulario no son validos", "Error", JOptionPane.ERROR_MESSAGE);
		}	
		
	}
	
	public String getNombreUsuarioGestor() {
		String nombreUsuarioGestor = SingletonServiAppEmpleado.getInstance().getNombreUsuario();
		return nombreUsuarioGestor;
	}

	public void mostrarLimpiezasEmpleado(Frame frame) {
		SingletonControllerLimpieza.getInstance().mostrarLimpiezaEmpleado(frame);
	}
}
