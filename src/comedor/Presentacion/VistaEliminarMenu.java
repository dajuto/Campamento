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


//import javax.swing.JTable;

public class VistaEliminarMenu extends JFrame implements MenuObserver{
	private JFrame atras;
	private String dia;
	private JComboBox<String> codMenu;
	List<TMenu> listaMenu;
	
	public VistaEliminarMenu(JFrame frame) {
		setTitle("Añadir Menu ");
		this.atras=frame;
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(551,275);
		
		JLabel lblNewLabel = new JLabel("Eliminar Menu: " + dia);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 261, 20);
		getContentPane().add(lblNewLabel);
		
		codMenu = new JComboBox<Integer>();
		codMenu.setBounds(330, 54, 184, 26);
		for(TMenu te: SingletonServiAppMenu.getInstance().getListaMenu()) {
			codMenu.addItem(te.getCodigo());
		}
		getContentPane().add(codMenu);
		
		JLabel lblEliminar = new JLabel("Dia de la semana que quiere eliminar: ");
		lblEliminar.setBounds(27, 57, 314, 20);
		getContentPane().add(lblEliminar);
		
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
				SingletonControllerMenu.getInstance().eliminarMenu(atras, ((int)codMenu.getSelectedItem()));
			}
		});
		boton_Aceptar.setBounds(27, 163, 150, 25);
		getContentPane().add(boton_Aceptar);
		
		setVisible(true);
	}

	
	private JFrame getFrame() {
		return this;
	}
	
	private void update(List<TMenu> listaMenu,  String dia) {
		this.listaMenu = listaMenu;
		this.dia = dia;
	}
	
	@Override
	public void onCrearMenu(List<TMenu> listaMenu, String dia) {
		// TODO Auto-generated method stub
		this.update(listaMenu, dia);
	}

	@Override
	public void onConsultarMenu(List<TMenu> listaMenu, String dia) {
		// TODO Auto-generated method stub
		this.update(listaMenu, dia);
	}

	@Override
	public void onModificarMenu(List<TMenu> listaMenu, String dia) {
		// TODO Auto-generated method stub
		this.update(listaMenu, dia);
	}		
	
	

}




