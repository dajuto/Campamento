package sanidad.Presentacion;

import java.awt.Frame;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import acampados.Negocio.TAcampado;
import acampadosPresentacion.SingletonControllerAcampado;
import empleados.Negocio.TEmpleado;
import empleados.Presentacion.SingletonControllerEmpleado;
import launcher.Factory;
import sanidad.Negocio.SanidadObserver;
import sanidad.Negocio.SingletonServiAppSanidad;

public class ControllerSanidad {

	
	public void registraUsuario(String text, char[] password) {
		SingletonServiAppSanidad.getInstance().registraUsuario(text, password);
	}
	
	
	public void registraFactoria(Factory<Object> objetosFactory) {
		SingletonServiAppSanidad.getInstance().registrarFactoria(objetosFactory);
	}

	public void menuSanidad(JFrame frame) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaMenuMedico(frame);
			}
		});
	}
	
	//RECETAS
	
	public void menuRecetas(JFrame frame) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaMenuRecetas(frame);
			}
		});
	}

	
	public void mostrarCrearReceta(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaCrearReceta(frame);
			}
		});
	}

	public void mostrarEliminarReceta(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaEliminarReceta(frame);
			}
		});
	}
	public void mostrarListaRecetas(JFrame frame) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaVerListaRecetas(frame);
			}
		});
	}
	public void mostrarConsultarRecetas(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaConsultarListaRecetas(frame);
			}
		});
	}
	
	public void anadirReceta(JFrame ventanaRecetas, String cod, String medicamento, String dosis, String medicoEmpleado, String Acampado ) {
		// Confirmación sintáctica de los datos:
		boolean isNumericCodigo =  cod.matches("[+-]?\\d*(\\.\\d+)?");
		boolean isNumericMedicamento =  medicamento.matches("[+-]?\\d*(\\.\\d+)?");
		boolean isNumericDosis =  dosis.matches("[+-]?\\d*(\\.\\d+)?");
		if(isNumericCodigo && !isNumericMedicamento && !isNumericDosis) {
			int codigo = Integer.parseInt(cod);
			boolean exito = SingletonServiAppSanidad.getInstance().a�adirReceta(codigo, medicamento, dosis, medicoEmpleado, Acampado);
			if(!exito) {
				JOptionPane.showMessageDialog(ventanaRecetas, "Ya existe una receta con el mismo codigo", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(ventanaRecetas, "Los datos introducidos en el formulario no son validos", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	

	public void eliminarReceta(JFrame ventanaListaAverias, int codigo) {
		boolean exito = SingletonServiAppSanidad.getInstance().eliminarReceta(ventanaListaAverias, codigo);
		if(!exito) {
			JOptionPane.showMessageDialog(ventanaListaAverias, "La receta que desea eliminar no ha sido adquirida por el acampado. Puede eliminarla modificando su estado de compra", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void consultarCompraReceta(Frame ventanaAnterior, int codigo) {
		SingletonServiAppSanidad.getInstance().consultarCompraReceta(codigo);
	}
	
	//CITAS
	
	public void menuCitas(JFrame frame) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaMenuCitas(frame);
			}
		});
	}


	public void mostrarListaCitas(JFrame frame) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaVerListaCitas(frame);
			}
		});
	}
	
	public void mostrarEliminarCita(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaEliminarCita(frame);
			}
		});
	}
	public void mostrarConsultarCitas(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaConsultarListaCitas(frame);
			}
		});
	}



	public void addObserver(SanidadObserver vista) {
		SingletonServiAppSanidad.getInstance().addObserver(vista);
	}


	
	public List<TEmpleado> getListaEmpleados() {
		return SingletonControllerEmpleado.getInstance().getListaEmpleados();
	}
	
	
	public List<TAcampado> getListaAcampados() {
		return SingletonControllerAcampado.getInstance().getListaAcampados();
	}
	

	
}
