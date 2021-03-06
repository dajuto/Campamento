package comedor.Presentacion;

import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


import acampados.Negocio.TAcampado;
import acampadosPresentacion.SingletonControllerAcampado;
import empleados.Negocio.SingletonServiAppEmpleado;
import empleados.Negocio.TEmpleado;
import empleados.Presentacion.SingletonControllerEmpleado;
import comedor.Negocio.MenuObserver;
import comedor.Negocio.SingletonServiAppMenu;
import comedor.Negocio.TMenu;
import launcher.Factory;

public class ControllerMenu {

	public void registraUsuario(String text, char[] password) {
		SingletonServiAppMenu.getInstance().registraUsuario(text, password);
	}
	
	
	public void registraFactoria(Factory<Object> objetosFactory) {
		SingletonServiAppMenu.getInstance().registrarFactoria(objetosFactory);
	}

	public void mostrarMenu(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaVerMenu(frame);
			}
		});
	}
	public void mostrarMenuAcampado(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaVerMenuAcampado(frame);
			}
		});
	}
	public void mostrarListaMenu(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaListaMenu(frame);
			}
		});
	}
	
	public void mostrarCrearMenu(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaCrearMenu(frame);
			}
		});
	}

	public void mostrarEliminarMenu(JFrame frame) {
			SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaEliminarMenu(frame);
			}
		});
	}
	
	public void mostrarConsultarMenu(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaConsultarMenu(frame);
			}
		});
	}
	
	
	
	
	public void crearMenu( String dia, String desayuno, String comida, String cena, JFrame frame) {
		boolean existe = SingletonServiAppMenu.getInstance().crearMenu(dia, desayuno, comida, cena);
		if (existe) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					frame.setVisible(false);
					new VistaVerMenu(frame);
				}
			});
		}
		else {
			JOptionPane.showMessageDialog(frame, "Dia no disponible", "Error", JOptionPane.ERROR_MESSAGE);	
		}
	}


	public void eliminarMenu(Frame ventanaListaMenu, String dia) {
		boolean exito = SingletonServiAppMenu.getInstance().eliminarMenu(ventanaListaMenu, dia);
		if(!exito) {
			JOptionPane.showMessageDialog(ventanaListaMenu, "El menu no ha podido ser borrado", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
	public void consultarMenu(Frame ventanaAnterior, String dia) {
		SingletonServiAppMenu.getInstance().consultarMenu(dia);
	}
	
	public void addObserver(MenuObserver vista) {
		SingletonServiAppMenu.getInstance().addObserver(vista);
	}

}
