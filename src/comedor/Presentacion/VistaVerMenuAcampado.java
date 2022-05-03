package comedor.Presentacion;


import javax.swing.JButton;
import javax.swing.JFrame;
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

import comedor.Negocio.MenuObserver;
import comedor.Negocio.Menu;
import comedor.Negocio.MenuTableModel;
import comedor.Negocio.TMenu;
import contabilidad.Negocio.TIngresos;

public class VistaVerMenuAcampado extends JFrame implements MenuObserver{
	private JFrame atras;
	private String diaMenu;
	
	public VistaVerMenuAcampado(JFrame frame) {
		setTitle("Menu Campamento");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(624,378);
		
		this.atras = frame;
		
		JButton boton_Atras = new JButton("Atrás");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(500, 291, 97, 25);
		getContentPane().add(boton_Atras);
		
		JLabel labcrear = new JLabel("Menu Semanal");
		labcrear.setFont(new Font("Times New Roman", Font.BOLD, 22));
		labcrear.setBounds(25, 24, 330, 36);
		getContentPane().add(labcrear);
		
		JPanel p2 = createViewPanel(new JTable(new MenuTableModel()), "Menu");
		p2.setBounds(35, 73, 539, 175);
		getContentPane().add(p2);
		
		setVisible(true);
	}
	
	private JPanel createViewPanel(JComponent c, String title) {
		JPanel p = new JPanel( new BorderLayout() );
		p.add(new JScrollPane(c), BorderLayout.CENTER);
		return p;
	}
	
	private void update(String dia) {
		this.diaMenu = diaMenu;
	}
	
	@Override
	public void onRegister(List<TMenu> listaMenu) {
		// TODO Auto-generated method stub
		this.update(diaMenu);
	}
	
	@Override
	public void onCrearMenu(List<TMenu> listaMenu) {
		// TODO Auto-generated method stub
		this.update(diaMenu);
	}

	@Override
	public void onEliminarMenu(List<TMenu> listaMenu) {
		// TODO Auto-generated method stub
		this.update(diaMenu);
	}

	@Override
	public void onConsultarMenu(List<TMenu> listaMenu) {
		// TODO Auto-generated method stub
		this.update(diaMenu);
	}
}
