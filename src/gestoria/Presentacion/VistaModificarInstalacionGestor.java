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

public class VistaModificarInstalacionGestor extends JFrame implements GestoriaObserver{
	private JFrame atras;
	private String nombreUsuario;
	private JTextField nombre;
	private JTextField superficie;
	private JTextField precio;
	private String superficieString;
	private String precioString;
	private JComboBox<String> codigo;
	private JCheckBox pagado;
	private JCheckBox actividades;
	List<TInstalacion> listaInstalaciones;
	
	public VistaModificarInstalacionGestor(JFrame frame) {
		setTitle("Modificar horario de Limpieza");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,350);
		
		listaInstalaciones = SingletonControllerGestoria.getInstance().getListainstalaciones();
		
		
		this.atras = frame;
		
		JButton boton_Atras = new JButton("Atras");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(373, 265, 97, 25);
		getContentPane().add(boton_Atras);
		
		JLabel labmodificar = new JLabel("Modificar horario de limpieza");
		labmodificar.setFont(new Font("Times New Roman", Font.BOLD, 24));
		labmodificar.setBounds(25, 14, 341, 36);
		getContentPane().add(labmodificar);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(25, 101, 69, 25);
		getContentPane().add(lblNombre);
		
		JLabel lblSuperficie = new JLabel("Superficie:");
		lblSuperficie.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSuperficie.setBounds(25, 137, 84, 25);
		getContentPane().add(lblSuperficie);
		
		JLabel lblprecio = new JLabel("Precio:");
		lblprecio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblprecio.setBounds(25, 175, 69, 25);
		getContentPane().add(lblprecio);
		
		nombre = new JTextField();
		nombre.setBounds(121, 103, 116, 22);
		nombre.setText(listaInstalaciones.get(0).getNombre());
		getContentPane().add(nombre);
		nombre.setColumns(10);
		
		superficie = new JTextField();
		superficie.setBounds(121, 139, 116, 22);
		superficieString = Integer.toString(listaInstalaciones.get(0).getSuperficie());
		superficie.setText(superficieString);
		getContentPane().add(superficie);
		superficie.setColumns(10);
		
		precio = new JTextField();
		precio.setBounds(121, 177, 116, 22);
		precioString = Integer.toString(listaInstalaciones.get(0).getPrecio());
		precio.setText(precioString);
		getContentPane().add(precio);
		precio.setColumns(10);
		
		JButton boton_modificar = new JButton("Modificar");
		boton_modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (superficie.getText().matches("[0-9]*")) {
					if (precio.getText().matches("[0-9]*")) {
						if (pagado.isSelected()) {
							//TODO ADRI aqui tendria que pagar
						}
						SingletonControllerGestoria.getInstance().modificarInstalacion(codigo.getSelectedItem().toString(), nombre.getText(), superficie.getText(), precio.getText(), pagado.isSelected(), actividades.isSelected(), getFrame());
					}
					else JOptionPane.showMessageDialog(atras, "El precio tiene que ser un numero", "Error", JOptionPane.ERROR_MESSAGE);			
				}
				else JOptionPane.showMessageDialog(atras, "La superficie tiene que ser un numero", "Error", JOptionPane.ERROR_MESSAGE);			
			}
		});
		boton_modificar.setBounds(269, 129, 97, 25);
		getContentPane().add(boton_modificar);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodigo.setBounds(25, 63, 69, 25);
		getContentPane().add(lblCodigo);
		
		codigo = new JComboBox<String>();
		codigo.setBounds(121, 63, 116, 22);
		for(TInstalacion cod: this.listaInstalaciones) {
			codigo.addItem(cod.getCodigo());
		}
		codigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(TInstalacion cod: listaInstalaciones) {
					if (cod.getCodigo().equals(codigo.getSelectedItem().toString())) {
						if (cod.isPagado()) {
							pagado.setEnabled(false);
						}
						else {
							pagado.setEnabled(true);
						}
						pagado.setSelected(cod.isPagado());
						actividades.setSelected(cod.isPuedeActividades());
						nombre.setText(cod.getNombre());
						superficieString = Integer.toString(cod.getSuperficie());
						superficie.setText(superficieString);
						precioString = Integer.toString(cod.getPrecio());
						precio.setText(precioString);
					}
				}
			}
		});
		getContentPane().add(codigo);
		
		
		pagado = new JCheckBox("Marcar para pagar");
		pagado.setBounds(25, 223, 253, 25);
		pagado.setSelected(listaInstalaciones.get(0).isPagado());
		getContentPane().add(pagado);
		if (listaInstalaciones.get(0).isPagado()) {
			pagado.setEnabled(false);
		}
		
		actividades = new JCheckBox("Marcar si es apto para actividades");
		actividades.setBounds(25, 265, 253, 25);
		actividades.setSelected(listaInstalaciones.get(0).isPuedeActividades());
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
