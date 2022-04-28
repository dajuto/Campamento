package comedor.Presentacion;


import java.awt.Color;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import comedor.Negocio.MenuObserver;
import comedor.Negocio.TMenu;
import comedor.Negocio.SingletonServiAppMenu;
import sanidad.Negocio.SingletonServiAppSanidad;
import sanidad.Negocio.TCita;
import sanidad.Presentacion.SingletonControllerSanidad;


//import javax.swing.JTable;

public class VistaEliminarMenu extends JFrame implements MenuObserver{
	
	private JFrame atras;
	private String dia;
	private JComboBox<String> diaMenu;
	List<TMenu> listaMenu;
	
	public VistaEliminarMenu(JFrame frame) {
		setTitle("Eliminar Menu ");
		this.atras=frame;
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(551,275);
		
		JLabel lblNewLabel = new JLabel("Eliminar Menu: ");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 261, 20);
		getContentPane().add(lblNewLabel);
		
		diaMenu = new JComboBox<String>();
		diaMenu.setBounds(251, 54, 184, 26);
		for(TMenu te: SingletonServiAppMenu.getInstance().getListaMenu()) {
			diaMenu.addItem(te.getDia());
		}
		getContentPane().add(diaMenu);
		
		JLabel lblEliminar = new JLabel("Dia de la semana que quiere eliminar: ");
		lblEliminar.setBounds(44, 57, 314, 20);
		getContentPane().add(lblEliminar);
		
		JButton boton_Atras = new JButton("Atrás");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				//atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(366, 179, 150, 25);
		getContentPane().add(boton_Atras);
		
		JButton boton_Aceptar = new JButton("Aceptar");
		boton_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerMenu.getInstance().eliminarMenu(atras, ((String)diaMenu.getSelectedItem()));
			}
		});
		boton_Aceptar.setBounds(25, 179, 150, 25);
		getContentPane().add(boton_Aceptar);
		
		setVisible(true);
	}

	
	private JFrame getFrame() {
		return this;
	}
	
	private void update(List<TMenu> listaMenu) {
		this.listaMenu = listaMenu;
		
	}
	
	@Override
	public void onEliminarMenu(List<TMenu> listaMenu) {
		// TODO Auto-generated method stub
		this.update(listaMenu);
	}	
	
	@Override
	public void onCrearMenu(List<TMenu> listaMenu) {
		// TODO Auto-generated method stub
		this.update(listaMenu);
	}

	@Override
	public void onConsultarMenu(List<TMenu> listaMenu) {
		// TODO Auto-generated method stub
		this.update(listaMenu);
	}

	
	

}





