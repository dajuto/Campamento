package comedor.Presentacion;


import java.awt.Color;
import java.awt.Font;
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
		
		JLabel eliminar = new JLabel("Eliminar Menu Campamento");
		eliminar.setFont(new Font("Times New Roman", Font.BOLD, 24));
		eliminar.setBounds(28, 21, 330, 36);
		getContentPane().add(eliminar);
		
		diaMenu = new JComboBox<String>();
		diaMenu.setBounds(316, 73, 184, 26);
		for(TMenu te: SingletonServiAppMenu.getInstance().getListaMenu()) {
			diaMenu.addItem(te.getDia());
		}
		getContentPane().add(diaMenu);
		
		JLabel lblEliminar = new JLabel("Dia de la semana que quiere eliminar: ");
		lblEliminar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEliminar.setBounds(28, 74, 314, 20);
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
		
		JButton boton_Eliminar = new JButton("Eliminar");
		boton_Eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerMenu.getInstance().eliminarMenu(atras, ((String)diaMenu.getSelectedItem()));
			}
		});
		boton_Eliminar.setBounds(28, 117, 159, 26);
		getContentPane().add(boton_Eliminar);
		
		setVisible(true);
	}

	
	private JFrame getFrame() {
		return this;
	}
	
	private void update(List<TMenu> listaMenu) {
		this.listaMenu = listaMenu;
		
	}
	
	@Override
	public void onRegister(List<TMenu> listaMenu) {
		// TODO Auto-generated method stub
		this.update(listaMenu);
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






