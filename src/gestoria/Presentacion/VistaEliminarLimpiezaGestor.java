package gestoria.Presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;

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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;

public class VistaEliminarLimpiezaGestor extends JFrame implements GestoriaObserver{
	private JFrame atras;
	private JComboBox <String> codElegido;
	List<TLimpieza> listaLimpieza =	SingletonControllerGestoria.getInstance().getListaLimpieza();
;
	
	public VistaEliminarLimpiezaGestor(JFrame frame) {
		setTitle("Eliminar horario limpieza");
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
		
		JLabel eliminar = new JLabel("Eliminar horario de limpieza");
		eliminar.setFont(new Font("Times New Roman", Font.BOLD, 24));
		eliminar.setBounds(25, 24, 330, 36);
		getContentPane().add(eliminar);
		
		JButton boton_Eliminar = new JButton("Eliminar");
		boton_Eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				atras.setVisible(true);
				for (TLimpieza l: listaLimpieza) {
					if (l.getCodigo().equals(codElegido.getSelectedItem().toString())) {
						SingletonControllerGestoria.getInstance().modificarEmpleadoLimpieza(l.getEmpleadoEncargado(), codElegido.getSelectedItem().toString());
					}
				}
				SingletonControllerGestoria.getInstance().eliminarLimpieza(frame, codElegido.getSelectedItem().toString());
			}
		});
		boton_Eliminar.setBounds(25, 112, 97, 25);
		getContentPane().add(boton_Eliminar);
		
		codElegido = new JComboBox<String>();
		codElegido.setBounds(25, 73, 239, 22);
		for(TLimpieza cod: this.listaLimpieza) {
			codElegido.addItem(cod.getCodigo());
		}
		getContentPane().add(codElegido);
		
		setVisible(true);
	}
	
	private JFrame getFrame() {
		return this;
	}
	

	@Override
	public void onRegister(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCreate(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEliminar(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onModificar(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}
	
	
}
