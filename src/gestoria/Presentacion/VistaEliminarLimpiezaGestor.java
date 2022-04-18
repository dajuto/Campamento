package gestoria.Presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;

import empleados.Negocio.TEmpleadoGestoria;
import gestoria.Negocio.GestoriaObserver;
import gestoria.Negocio.TInstalacion;
import gestoria.Negocio.TLimpieza;

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
	private String nombreUsuario;
	private JComboBox codElegido;
	List<TLimpieza> listaLimpieza;
	
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
				SingletonControllerGestoria.getInstance().eliminarLimpieza(frame, (String) codElegido.getSelectedItem());
			}
		});
		boton_Eliminar.setBounds(25, 112, 97, 25);
		getContentPane().add(boton_Eliminar);
		
		codElegido = new JComboBox();
		codElegido.setBounds(25, 73, 239, 22);
		listaLimpieza = SingletonControllerGestoria.getInstance().getListaLimpieza();
		for(TLimpieza cod: this.listaLimpieza) {
			codElegido.addItem(cod.getCodigo());
		}
		getContentPane().add(codElegido);
		
		setVisible(true);
	}
	
	private JFrame getFrame() {
		return this;
	}
	
	private void update(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	@Override
	public void onRegister(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TEmpleadoGestoria> listaEmpleadosLimpieza, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCreate(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TEmpleadoGestoria> listaEmpleadosLimpieza, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEliminar(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TEmpleadoGestoria> listaEmpleadosLimpieza, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onModificar(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TEmpleadoGestoria> listaEmpleadosLimpieza, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}
}
