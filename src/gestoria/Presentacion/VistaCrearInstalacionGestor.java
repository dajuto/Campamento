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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class VistaCrearInstalacionGestor extends JFrame implements GestoriaObserver{
	private JFrame atras;
	private String nombreUsuario;
	private JTextField nombre_txt;
	private JTextField superficie_txt;
	private JTextField precio_txt;
	private JTextField codigo_txt;
	private boolean boolactividades = false;
	private JCheckBox actividades;
	
	public VistaCrearInstalacionGestor(JFrame frame) {
		setTitle("Crear horario de Limpieza");
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
		
		JLabel labAñadir = new JLabel("A\u00F1adir una nueva Instalacion");
		labAñadir.setFont(new Font("Times New Roman", Font.BOLD, 24));
		labAñadir.setBounds(25, 14, 330, 36);
		getContentPane().add(labAñadir);
		
		JLabel lblLugar = new JLabel("Nombre:");
		lblLugar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLugar.setBounds(25, 101, 69, 25);
		getContentPane().add(lblLugar);
		
		JLabel lblSuperficie = new JLabel("Superficie:");
		lblSuperficie.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSuperficie.setBounds(25, 137, 97, 25);
		getContentPane().add(lblSuperficie);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrecio.setBounds(25, 175, 69, 25);
		getContentPane().add(lblPrecio);
		
		codigo_txt = new JTextField();
		codigo_txt.setColumns(10);
		codigo_txt.setBounds(121, 65, 116, 22);
		getContentPane().add(codigo_txt);
		
		nombre_txt = new JTextField();
		nombre_txt.setBounds(121, 103, 116, 22);
		getContentPane().add(nombre_txt);
		nombre_txt.setColumns(10);
		
		superficie_txt = new JTextField();
		superficie_txt.setBounds(121, 139, 116, 22);
		getContentPane().add(superficie_txt);
		superficie_txt.setColumns(10);
		
		precio_txt = new JTextField();
		precio_txt.setBounds(121, 177, 116, 22);
		getContentPane().add(precio_txt);
		precio_txt.setColumns(10);
		
		JButton boton_Crear = new JButton("Crear");
		boton_Crear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (superficie_txt.getText().matches("[0-9]*")) {
					if (precio_txt.getText().matches("[0-9]*")) {
						if (actividades.isSelected()) {
							boolactividades = true;
						}
						SingletonControllerGestoria.getInstance().añadirInstalacion(codigo_txt.getText(), nombre_txt.getText(), superficie_txt.getText(), precio_txt.getText(), boolactividades, getFrame());
					}
					else JOptionPane.showMessageDialog(atras, "El precio tiene que ser un numero", "Error", JOptionPane.ERROR_MESSAGE);			
				}
				else JOptionPane.showMessageDialog(atras, "La superficie tiene que ser un numero", "Error", JOptionPane.ERROR_MESSAGE);			
			}
		});
		boton_Crear.setBounds(269, 129, 97, 25);
		getContentPane().add(boton_Crear);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodigo.setBounds(25, 63, 69, 25);
		getContentPane().add(lblCodigo);
		
		actividades = new JCheckBox("Marca si es apto para actividades");
		actividades.setBounds(25, 215, 229, 25);
		getContentPane().add(actividades);
		
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
