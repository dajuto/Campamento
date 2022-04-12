package acampadosPresentacion;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import acampados.Negocio.SingletonServiAppAcampado;
import launcher.Factory;
import subistemaActividad.capaNegocio.SingletonServiAppActividad;
import subsistemaAulas.capaPresentacion.SingletonControllerAulas;
import subsistemaAulas.capaPresentacion.VistaEstudianteAulas;
import subsistemaCoordCovid.CapaNegocio.TEstudianteConfinado;
import subsistemaEstudiante.capaNegocio.SingletonServiAppEstudiante;
import subsistemaEstudiante.capaNegocio.TEstudiante;
import subsistemaLimpieza.capaPresentacion.SingletonControllerLimpieza;

public class ControllerAcampado {

	public void mostrarGeneralAcampado(JFrame f) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaInicioEstudiante(f);
			}
		});
	}
	
	public void mostrarEstudiante(Frame f) {
		String nombreEstudiante = SingletonServiAppAcampado.getInstance().getNombreUsuario();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaEstudiante(f, nombreEstudiante);
			}
		});
	}
	
	public void registraUsuario(String text, char[] password) {
		SingletonServiAppAcampado.getInstance().registraUsuario(text, password);
		SingletonControllerAulas.getInstance().registraUsuario(text, password);
		SingletonControllerLimpieza.getInstance().registraUsuario(text, password);
	}
	
	public void registraFactoria(Factory<Object> factoriaTransferObjects) {
		SingletonServiAppAcampado.getInstance().registrarFactoria(factoriaTransferObjects);
		
	}
	
	public List<TEstudianteConfinado> getListaConfinados() {
		// TODO Auto-generated method stub
		return SingletonServiAppAcampado.getInstance().getListaConfinados();
	}
	public List<TAcampado> getListaNoConfinados() {
		// TODO Auto-generated method stub
		return SingletonServiAppAcampado.getInstance().getListaNoConfinados();
	}

	public void anadeConfinado( String nombreUsuario, int numDias, String infectado, String contacto, String recogidaRopa, String comidayCena) {
		SingletonServiAppAcampado.getInstance().anadirConfinado(nombreUsuario, numDias, infectado, contacto, recogidaRopa, comidayCena);
	}

	public void eliminarconfinado(String nombreUsuario) {
		SingletonServiAppAcampado.getInstance().eliminarConfinado(nombreUsuario);
		
	}

	public void modificaConfinado(String nombreUsuario, int numDias, String infectado, String contacto,
			String recogidaRopa, String comidayCena) {
		SingletonServiAppAcampado.getInstance().modificarConfinado(nombreUsuario, numDias, infectado, contacto, recogidaRopa, comidayCena);
		
	}

	public void mostrarMiInformacion(Frame frame) {
		String nombreUsuario = SingletonServiAppAcampado.getInstance().getNombreUsuario();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaInformacionEstudiante(frame, nombreUsuario);
			}
		});
		
	}

	//falta por hacer
	public void mostrarListaActividadesEstudiante(TAcampado nombreEstudiante, Frame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaActividadesEstudiante(frame, nombreEstudiante);
			}
		});
		
	}
	
	public String getHabitacionEstudiante(String nombreUsuario) {
		String hab = SingletonServiAppAcampado.getInstance().getHabitacionEstudiante(nombreUsuario);
		return hab;
	}
	
	public void mostrarContrato(TAcampado nombreEstudiante, Frame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaContratoEstudiante(frame, nombreEstudiante);
			}
		});
		
	}

	public void modificarContrato(Frame frame, TAcampado nombreEstudiante) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaModificarContratoEstudiante(frame, nombreEstudiante);
			}
		});
	}

	public void mostrarAnadirActividades(Frame frame, TAcampado nombreEstudiante) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaAnadirActEstudiante(frame, nombreEstudiante);
			}
		});
	}

	public void mostrarEliminarActividad(Frame frame, TAcampado nombreEstudiante ) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaEliminarActEstudiante(frame, nombreEstudiante);
			}
		});
	}

	public void modificarContratoEstudiante(Frame ventanaAnterior, String selectedItem, TAcampado nombre) {
		nombre.getContrato().setTipo(selectedItem);	
		 mostrarContrato(nombre, ventanaAnterior);
		
	}

	public void anadirActividad(Frame ventanaAnterior, TAcampado nombreUsuario, String text) {	
		nombreUsuario.getListaactividades().add(text);
		mostrarListaActividadesEstudiante(nombreUsuario, ventanaAnterior);
	}

	public void eliminarActividad(Frame ventanaAnterior, String selectedItem, TAcampado nombreUsuario) {
		for(int i = 0; i < nombreUsuario.getListaactividades().size(); i++) {
			if(nombreUsuario.getListaactividades().get(i).equals(selectedItem)) {	
				nombreUsuario.getListaactividades().remove(i);
				break;
			}
		mostrarListaActividadesEstudiante(nombreUsuario, ventanaAnterior);
		
		
	}

	}

	public void mostrarActividades(Frame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaActEstudiante(frame);
			}
		});
		
	}
	
	public String getNombreUsuarioReserva() {
		String nombreUsuarioReserva = SingletonServiAppAcampado.getInstance().getNombreUsuario();
		return nombreUsuarioReserva;
	}
	
	public void mostrarAulasEstudiante(Frame f) {
		String nombreUsuario = SingletonServiAppAcampado.getInstance().getNombreUsuario();
		String nombreEstudiante = SingletonControllerAulas.getInstance().getNombreUsuarioReserva();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaEstudianteAulas(f);
			}
		});
	}
}
