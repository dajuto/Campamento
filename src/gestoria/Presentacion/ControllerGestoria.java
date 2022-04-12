package gestoria.Presentacion;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import gestoria.Negocio.SingletonServiAppGestoria;
import launcher.Factory;
import launcher.Observable;

public class ControllerGestoria {
	
	public void registraUsuario(String text, char[] password) {
		SingletonServiAppGestoria.getInstance().registraUsuario(text, password);
	}

	public void registraFactoria(Factory<Object> objetosFactory) {
		SingletonServiAppGestoria.getInstance().registrarFactoria(objetosFactory);
	}

	public void menuGestor(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaMenuGestor(frame);
			}
		});
	}

	public void menuLimpiezaGestor(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaMenuLimpiezaGestor(frame);
			}
		});
	}

	
	public void listaLimpezaGestor(Frame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaListaLimpiezaGestor(frame);
			}
		});
	}

	public void mostrarAnadirAveriasGestor(Frame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaAnadirAveriaGestor(frame);
			}
		});
	}

	public void mostrarEliminarAveriasGestor(Frame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaEliminarAveriaGestor(frame);
			}
		});
	}

	public void mostrarModificarEstadoAveriaGestor(Frame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaModificarAveriaGestor(frame);
			}
		});
	}
	public void mostrarModificarEstadoAveriaEmpleado(Frame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaModificarAveriaEmpleado(frame);
			}
		});
	}
	
	public void mostrarAnadirEmpleadoMantenimiento(Frame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaAnadirEmpleadoMantenimiento(frame);
			}
		});
	}


	public void mostrarEliminarEmpleadoMantenimiento(Frame frame) {
		// TODO Auto-generated method stub
		new VistaEliminarEmpleadoMantenimiento(frame);
	}
	
	public void mostrarListaAveriasEmpleadoMantenimiento(Frame ventanaAnterior) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaListaAveriasEmpleadoMantenimiento(ventanaAnterior);
			}
		});
	}


	public void anadirAveria(Frame ventanaListaAverias, String cod, String lugar, String desc, String selectedItem) {
		// Confirmación sintáctica de los datos:
		boolean isNumericCodigo =  cod.matches("[+-]?\\d*(\\.\\d+)?");
		boolean isNumericLugar =  lugar.matches("[+-]?\\d*(\\.\\d+)?");
		boolean isNumericDesc =  desc.matches("[+-]?\\d*(\\.\\d+)?");
		if(isNumericCodigo && !isNumericLugar && !isNumericDesc) {
			int codigoAveria = Integer.parseInt(cod);
			boolean exito = SingletonServiAppGestoria.getInstance().anadirAveria( codigoAveria,  lugar,  desc,  selectedItem);
			if(!exito) {
				JOptionPane.showMessageDialog(ventanaListaAverias, "Ya existe una averia con el mismo codigo", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(ventanaListaAverias, "Los datos introducidos en el formulario no son validos", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}


	public void eliminarAveria(Frame ventanaListaAverias, int codigoAveria) {
		boolean exito = SingletonServiAppGestoria.getInstance().eliminarAveria(ventanaListaAverias, codigoAveria);
		if(!exito) {
			JOptionPane.showMessageDialog(ventanaListaAverias, "La averia que desea eliminar no ha sido reparada. Puede repararla modificando su estado", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}


	public void modificarEstadoAveriaGestor(Frame ventanaAnterior, int codigoAveria) {
		SingletonServiAppGestoria.getInstance().modificarEstadoAveriaGestor(codigoAveria);
	}


	public void anadeAveriaEmpleado(TLimpieza ta) {
		// TODO Auto-generated method stub
		SingletonControllerEmpleado.getInstance().anadeAveriaEmpleado(ta);
	}


	public void eliminaAveriaEmpleado(TLimpieza tAveria) {
		SingletonControllerEmpleado.getInstance().eliminaAveriaEmpleado(tAveria);
	}


	public void anadirEmpleadoMantenimiento (Frame ventanaAnterior, String usuario, String nombre, String salario, String horario,
			String vacaciones) {
		// TODO Auto-generated method stub
		SingletonControllerEmpleado.getInstance().anadirEmpleado(ventanaAnterior, usuario, nombre, "Empleado Mantenimiento", salario, horario, vacaciones);
		SingletonServiAppGestoria.getInstance().actualizarListaEmpleadosMantenimiento();
	}

	public void eliminarEmpleadoMantenimiento(Frame ventanaAnterior, String usuario) {
		// TODO Auto-generated method stub
		SingletonControllerEmpleado.getInstance().eliminarEmpleado(ventanaAnterior, usuario);
		SingletonServiAppGestoria.getInstance().actualizarListaEmpleadosMantenimiento();
	}
	
	public List<TEmpleadoLimpieza> getListaEmpleadosMantenimiento() {
		return SingletonControllerEmpleado.getInstance().getListaEmpleadosMantenimiento();
	}


	public void addObserver(LimpiezaObserver vista) {
		SingletonServiAppGestoria.getInstance().addObserver(vista);
	}

}
