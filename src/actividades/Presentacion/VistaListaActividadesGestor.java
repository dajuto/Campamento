package actividades.Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import actividades.Negocio.ActividadObserver;
import actividades.Negocio.ActividadTableModel;
import actividades.Negocio.TActividad;
import sanidad.Negocio.CitasMedicoTableModel;
import sanidad.Presentacion.SingletonControllerSanidad;

public class VistaListaActividadesGestor extends JFrame implements ActividadObserver{
	private String nombreUsuario;
	private JButton anadirActividad;
	private JButton modificarActividad;
	private JButton eliminarActividad;
	private JFrame atras;
	private Frame ventanaAnterior;
	
	public VistaListaActividadesGestor(JFrame frame) {
		setTitle("Lista Actividades");

		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(551,501);
		this.atras = frame;
		
		JButton boton_Atras = new JButton("Atras");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(15, 403, 499, 25);
		getContentPane().add(boton_Atras);
		
		JLabel lblNewLabel = new JLabel("Lista Actividades: " + nombreUsuario);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 261, 20);
		getContentPane().add(lblNewLabel);
		
		
		anadirActividad = new JButton("Añadir Actividad");
		anadirActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SingletonControllerActividad.getInstance().mostrarAnadirActividadGestor(getFrame());
			}
		});
		anadirActividad.setBounds(15, 358, 149, 29);
		getContentPane().add(anadirActividad);
		
		modificarActividad = new JButton("Modificar Actividad");
		modificarActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SingletonControllerActividad.getInstance().mostrarModificarActividadGestor(getFrame());
			}
		});
		modificarActividad.setBounds(165, 358, 198, 29);
		getContentPane().add(modificarActividad);
		
		
		eliminarActividad = new JButton("Eliminar Actividad");
		eliminarActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SingletonControllerActividad.getInstance().mostrarEliminarActividadGestor(getFrame());
			}
		});
		eliminarActividad.setBounds(365, 358, 149, 29);
		getContentPane().add(eliminarActividad);
		
		
		
		JPanel recetasView = createViewPanel(new JTable(new ActividadTableModel()), "Lista de Actividades");
		recetasView.setBounds(10, 40, 500, 300);
		getContentPane().add(recetasView);
		
		this.setVisible(true);
	}
	
	private JFrame getFrame() {
		return this;
	}
	
   
    private JPanel createViewPanel(JComponent c, String title) {
		JPanel p = new JPanel( new BorderLayout() );
		p.add(new JScrollPane(c));
		return p;
	}

    private void update (String nombreUsuario) {
    	this.nombreUsuario=nombreUsuario;
    }
	@Override
	public void onRegister(List<TActividad> lista) {
		this.update(nombreUsuario);
	}

	@Override
	public void onCreateActividad(List<TActividad> lista) {
		this.update(nombreUsuario);
	}

	@Override
	public void onEliminarActividad(List<TActividad> lista) {
		this.update(nombreUsuario);
	}

}


