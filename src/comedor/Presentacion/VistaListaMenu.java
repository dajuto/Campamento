package comedor.Presentacion;

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

import comedor.Negocio.MenuObserver;
import comedor.Negocio.MenuTableModel;
import comedor.Negocio.TMenu;
import sanidad.Negocio.CitasMedicoTableModel;
import sanidad.Presentacion.SingletonControllerSanidad;

public class VistaListaMenu extends JFrame implements MenuObserver{
	private String dia;
	private JButton crearMenu;
	private JButton eliminarMenu;
	private JFrame atras;
	private Frame ventanaAnterior;
	
	public VistaListaMenu(JFrame frame) {
		setTitle("Menu Semanal");

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
		
		JLabel lblNewLabel = new JLabel("Menu Semanal");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 261, 20);
		getContentPane().add(lblNewLabel);
		
		
		crearMenu = new JButton("Añadir Menu");
		crearMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SingletonControllerMenu.getInstance().mostrarCrearMenu(getFrame());
			}
		});
		crearMenu.setBounds(15, 358, 250, 29);
		getContentPane().add(crearMenu);
		
		eliminarMenu = new JButton("Eliminar Menu");
		eliminarMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SingletonControllerMenu.getInstance().mostrarEliminarMenu(getFrame());
			}
		});
		eliminarMenu.setBounds(265, 358, 249, 29);
		getContentPane().add(eliminarMenu);
		
		
		
		JPanel recetasView = createViewPanel(new JTable(new MenuTableModel()), "Menu Semanal");
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

    private void update (String dia) {
    	this.dia=dia;
    }
	@Override
	public void onRegister(List<TMenu> listaMenu) {
		this.update(dia);
	}

	@Override
	public void onCrearMenu(List<TMenu> listaMenu) {
		this.update(dia);
	}

	@Override
	public void onEliminarMenu(List<TMenu> listaMenu) {
		this.update(dia);
	}
	
	@Override
	public void onConsultarMenu(List<TMenu> listaMenu) {
		// TODO Auto-generated method stub
	}

}
