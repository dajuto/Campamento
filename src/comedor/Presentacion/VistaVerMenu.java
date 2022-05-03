package comedor.Presentacion;
import javax.swing.JButton;
import javax.swing.JFrame;

import comedor.Negocio.MenuObserver;
import comedor.Negocio.TMenu;
import empleados.Negocio.TEmpleadoLimpieza;
import gestoria.Negocio.GestoriaObserver;
import gestoria.Negocio.TInstalacion;
import gestoria.Negocio.TLimpieza;
import gestoria.Negocio.TMantenimiento;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VistaVerMenu extends JFrame implements MenuObserver{
	
	private JFrame atras;
	
	public VistaVerMenu(JFrame frame) {
		setTitle("Menu Semanal");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,300);
		
		this.atras = frame;
		
		JButton boton_Atras = new JButton("Atrás");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				atras.setVisible(true);
				//SingletonControllerMenu.getInstance().mostrarMenu(getFrame());
			}
		});
		
		boton_Atras.setBounds(373, 215, 97, 25);
		getContentPane().add(boton_Atras);
		
		JButton boton_VerMenu = new JButton("Ver Menu Semanal");
		boton_VerMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerMenu.getInstance().mostrarListaMenu(getFrame());
			}
		});
		boton_VerMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		boton_VerMenu.setBounds(149, 101, 201, 38);
		getContentPane().add(boton_VerMenu);
		
		setVisible(true);
	}
	
	private JFrame getFrame() {
		return this;
	}
	
	@Override
	public void onRegister(List<TMenu> listaMenu) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onCrearMenu(List<TMenu> listaMenu) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onEliminarMenu(List<TMenu> listaMenu) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void onConsultarMenu(List<TMenu> listaMenu) {
		// TODO Auto-generated method stub
	}


}
