package actividades.Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import actividades.Negocio.ActividadObserver;
import actividades.Negocio.SingletonServiAppActividad;
import actividades.Negocio.TActividad;
import sanidad.Negocio.SingletonServiAppSanidad;
import sanidad.Negocio.TCita;
import sanidad.Presentacion.SingletonControllerSanidad;

public class VistaEliminarActividadGestor extends JFrame implements ActividadObserver{

	private String nombreUsuario;
	private Frame ventanaAnterior;
	private JButton aceptar;
	private JFrame atras;
	
	private JLabel ingresaIdActividad;
	private JComboBox<TActividad> idActividad;
	List<TActividad> listaActividades;
	
	public VistaEliminarActividadGestor(JFrame ventanaListaAverias) {
		setTitle("Eliminar actividad");
		this.ventanaAnterior = ventanaListaAverias;
		
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(551,275);
		this.setLocation(550,10);
		
		
		JLabel lblNewLabel = new JLabel("Eliminar Actividad: " + nombreUsuario);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 261, 20);
		getContentPane().add(lblNewLabel);
		
		idActividad = new JComboBox<TActividad>();
		idActividad.setBounds(330, 54, 184, 26);
		for(TActividad ta: SingletonServiAppActividad.getInstance().getListaActividades()) {
			idActividad.addItem(ta);
		
		}
		getContentPane().add(idActividad);
		
		ingresaIdActividad = new JLabel("Codigo de la Actividad que desea eliminar: ");
		ingresaIdActividad.setBounds(27, 57, 314, 20);
		getContentPane().add(ingresaIdActividad);
		
		JButton boton_Atras = new JButton("Atras");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				//atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(364, 163, 150, 25);
		getContentPane().add(boton_Atras);
		
		JButton boton_Aceptar = new JButton("Aceptar");
		boton_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				/*for (TActividad ta: this.listaActividades) {
					if (ta.getId()==((int)idActividad.getSelectedItem())) {
						
					}
				}*/
				SingletonControllerActividad.getInstance().eliminarActividad(atras, ((int)idActividad.getSelectedItem()));
			}
		});
		boton_Aceptar.setBounds(27, 163, 150, 25);
		getContentPane().add(boton_Aceptar);
		
		this.setVisible(true);
	}
	
	private void quit() {
    	int option = JOptionPane.showOptionDialog(this, "Are you sure you want to quit?", "quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 1); // el 1 es para q x defecto la opcion senalada sea NO
        if (option == 0) {
            System.exit(0);
        }
	}

	private void update (List<TActividad>lista) {
		this.listaActividades=lista;
	}
	@Override
	public void onRegister(List<TActividad> lista) {
		// TODO Auto-generated method stub
		this.update(lista);
	}

	@Override
	public void onCreateActividad(List<TActividad> lista) {
		// TODO Auto-generated method stub
		this.update(lista);

	}

	@Override
	public void onEliminarActividad(List<TActividad> lista) {
		// TODO Auto-generated method stub
		this.update(lista);

	}

}

