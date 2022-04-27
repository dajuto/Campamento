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

public class VistaConsultarMenu extends JFrame implements MenuObserver{
	
	private static final long serialVersionUID = 1L;
	private JFrame atras;
	private String dia;
	private JComboBox<String> diaMenu;
	List<TMenu> listaMenu;

	
	public VistaConsultarMenu(JFrame frame) {
		setTitle("Menu Consultar");
		this.atras=frame;
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(551,275);
		
		JLabel lblNewLabel = new JLabel("Consultar Menu: ");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 261, 20);
		getContentPane().add(lblNewLabel);
		
		
		
		
		diaMenu = new JComboBox<String>();
		diaMenu.setBounds(282, 61, 184, 26);
		for(TMenu te: SingletonServiAppMenu.getInstance().getListaMenu()) {
			diaMenu.addItem(te.getDia());
		}
		getContentPane().add(diaMenu);
		
		JLabel lblMenu = new JLabel("Dia de la semana que quiere ver el menu: ");
		lblMenu.setBounds(45, 58, 423, 32);
		getContentPane().add(lblMenu);
		
		JButton boton_Atras = new JButton("Atras");
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
		boton_Aceptar.setBounds(26, 186, 194, 25);
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
	public void onModificarMenu(List<TMenu> listaMenu) {
		// TODO Auto-generated method stub
		this.update(listaMenu, dia);
	}		
}
