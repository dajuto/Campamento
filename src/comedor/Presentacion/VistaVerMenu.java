package comedor.Presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;


import comedor.Negocio.MenuObserver;
import comedor.Negocio.MenuTableModel;
import comedor.Negocio.TMenu;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JComponent;
import javax.swing.JTable;

public class VistaVerMenu extends JFrame implements MenuObserver{
	private JFrame atras;
	private String dia;
	public VistaVerMenu(JFrame frame) {
		setTitle("Menu Semanal");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,300);
		
		this.atras = frame;
		
		JButton boton_Atras = new JButton("Atras");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(373, 215, 97, 25);
		getContentPane().add(boton_Atras);
		
		JLabel labcrear = new JLabel("Lista menu");
		labcrear.setFont(new Font("Times New Roman", Font.BOLD, 24));
		labcrear.setBounds(25, 24, 330, 36);
		getContentPane().add(labcrear);
		
		JPanel p2 = createViewPanel(new JTable(new MenuTableModel()), "Menu");
		p2.setBounds(35, 73, 416, 126);
		getContentPane().add(p2);
		
		setVisible(true);
	}
	
	private JPanel createViewPanel(JComponent c, String title) {
		JPanel p = new JPanel( new BorderLayout() );
		p.add(new JScrollPane(c));
		return p;
	}
	
	private void update(List<TMenu> listaMenu, String dia) {
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
