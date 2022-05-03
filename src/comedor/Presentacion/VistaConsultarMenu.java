package comedor.Presentacion;


import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JScrollPane;



import comedor.Negocio.MenuObserver;
import comedor.Negocio.TMenu;
import comedor.Negocio.SingletonServiAppMenu;

public class VistaConsultarMenu extends JFrame implements MenuObserver{
	
	private static final long serialVersionUID = 1L;
	private JFrame atras;
	private String dia;
	private JComboBox<String> diaMenu;
	List<TMenu> listaMenu;

	
	public VistaConsultarMenu(JFrame frame) {
		setTitle("Consultar Menu Campamento");
		this.atras=frame;
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(551,275);
		
		JLabel labNewLabel = new JLabel("Consultar Menu: ");
		labNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		labNewLabel.setBounds(25, 14, 330, 36);
		getContentPane().add(labNewLabel);
		
		
		
		diaMenu = new JComboBox<String>();
		diaMenu.setBounds(331, 79, 184, 26);
		for(TMenu te: SingletonServiAppMenu.getInstance().getListaMenu()) {
			diaMenu.addItem(te.getDia());
		}
		getContentPane().add(diaMenu);
		
		JLabel lblMenu = new JLabel("Dia de la semana que quiere ver el menu: ");
		lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMenu.setBounds(25, 74, 423, 32);
		getContentPane().add(lblMenu);
		
		JButton boton_Atras = new JButton("Atrás");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				//atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(368, 186, 138, 25);
		getContentPane().add(boton_Atras);
		
		JButton boton_Aceptar = new JButton("Aceptar");
		boton_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerMenu.getInstance().consultarMenu(atras, (String) diaMenu.getSelectedItem());
			}
		});
		boton_Aceptar.setBounds(25, 123, 194, 25);
		getContentPane().add(boton_Aceptar);
		
		setVisible(true);
	}

	
	private JPanel createViewPanel(JComponent c, String title) {
		JPanel p = new JPanel( new BorderLayout() );
		p.add(new JScrollPane(c), BorderLayout.CENTER);
		return p;
	}
	
	private void update(List<TMenu> listaMenu,  String dia) {
		this.listaMenu = listaMenu;
		this.dia = dia;
	}

	@Override
	public void onRegister(List<TMenu> listaMenu) {
		// TODO Auto-generated method stub
		this.update(listaMenu,dia);
	}
	
	@Override
	public void onCrearMenu(List<TMenu> listaMenu) {
		// TODO Auto-generated method stub
		this.update(listaMenu, dia);
	}

	@Override
	public void onEliminarMenu(List<TMenu> listaMenu) {
		// TODO Auto-generated method stub
		this.update(listaMenu, dia);
	}

	@Override
	public void onConsultarMenu(List<TMenu> listaMenu) {
		// TODO Auto-generated method stub
		this.update(listaMenu, dia);
	}	
		
}
