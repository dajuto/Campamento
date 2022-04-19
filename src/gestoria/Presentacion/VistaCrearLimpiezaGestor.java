package gestoria.Presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;

import empleados.Negocio.TEmpleado;
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

public class VistaCrearLimpiezaGestor extends JFrame implements GestoriaObserver{
	private JFrame atras;
	private String nombreUsuario;
	private JTextField lugar_txt;
	private JTextField fecha_txt;
	private JTextField hora_txt;
	private JTextField codigo_txt;
	private JComboBox<String> empleado;
	
	public VistaCrearLimpiezaGestor(JFrame frame) {
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
		
		JLabel labcrear = new JLabel("Crea horario de limpieza nuevo");
		labcrear.setFont(new Font("Times New Roman", Font.BOLD, 24));
		labcrear.setBounds(25, 14, 330, 36);
		getContentPane().add(labcrear);
		
		JLabel lblLugar = new JLabel("Lugar:");
		lblLugar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLugar.setBounds(25, 101, 69, 25);
		getContentPane().add(lblLugar);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFecha.setBounds(25, 137, 69, 25);
		getContentPane().add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHora.setBounds(25, 175, 69, 25);
		getContentPane().add(lblHora);
		
		JLabel lblEmplead = new JLabel("Emplead@:");
		lblEmplead.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmplead.setBounds(25, 215, 97, 25);
		getContentPane().add(lblEmplead);
		
		empleado = new JComboBox<String>();
		empleado.setBounds(121, 217, 116, 22);
		for(TEmpleado e: SingletonControllerGestoria.getInstance().getListaEmpleados()) {
			if (e.getPuesto().matches("Empleado Limpieza")) {
				empleado.addItem(e.getNombre());
			}
		}
		getContentPane().add(empleado);
		
		lugar_txt = new JTextField();
		lugar_txt.setBounds(121, 103, 116, 22);
		getContentPane().add(lugar_txt);
		lugar_txt.setColumns(10);
		
		fecha_txt = new JTextField();
		fecha_txt.setBounds(121, 139, 116, 22);
		getContentPane().add(fecha_txt);
		fecha_txt.setColumns(10);
		
		hora_txt = new JTextField();
		hora_txt.setBounds(121, 177, 116, 22);
		getContentPane().add(hora_txt);
		hora_txt.setColumns(10);
		
		JButton boton_Crear = new JButton("Crear");
		boton_Crear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fecha_txt.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {
					if (hora_txt.getText().matches("\\d{2}:\\d{2}")) {
						String empleadoString = (String) empleado.getSelectedItem();
						SingletonControllerGestoria.getInstance().añadirLimpieza(codigo_txt.getText(), lugar_txt.getText(), fecha_txt.getText(), hora_txt.getText(), empleadoString, getFrame());
					}
					else JOptionPane.showMessageDialog(atras, "Formato de la hora incorrecto \n HH:MM", "Error", JOptionPane.ERROR_MESSAGE);			
				}
				else JOptionPane.showMessageDialog(atras, "Formato de la fecha incorrecto \n DD/MM/AAAA", "Error", JOptionPane.ERROR_MESSAGE);			
			}
		});
		boton_Crear.setBounds(269, 129, 97, 25);
		getContentPane().add(boton_Crear);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodigo.setBounds(25, 63, 69, 25);
		getContentPane().add(lblCodigo);
		
		codigo_txt = new JTextField();
		codigo_txt.setColumns(10);
		codigo_txt.setBounds(121, 65, 116, 22);
		getContentPane().add(codigo_txt);
		
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
