package contabilidad.Presentacion;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import empleados.Negocio.TEmpleado;
import empleados.Presentacion.SingletonControllerEmpleado;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import contabilidad.Negocio.ContabilidadObserver;
import contabilidad.Negocio.TGastos;
import contabilidad.Negocio.TIngresos;
import javax.swing.DefaultComboBoxModel;

public class VistaCrearGasto extends JFrame implements ContabilidadObserver{
	private JFrame atras;
	private String nombreUsuario;
	private JTextField concepto_txt;
	private JTextField importe_txt;
	private JComboBox<String> empleado_txt;
	private JComboBox cuenta_txt;
	List<TGastos> listaGastos;
	List<TEmpleado> listaEmpleados;
	private JCheckBox contabilizada;
	private boolean boolContabilizada = false;
	private String fecha; 
	private int numeroFecha; 
	private int numeroFactura; 
	private String fac; 
	
	public VistaCrearGasto(JFrame frame) {
		
		
		setTitle("Añadir un Gasto");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,300);
		
		listaGastos = SingletonControllerContabilidad.getInstance().getListaGastos();
		listaEmpleados = SingletonControllerEmpleado.getInstance().getListaEmpleados();
		
		this.atras = frame;
		
		JButton boton_Atras = new JButton("Atrás");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(373, 215, 97, 25);
		getContentPane().add(boton_Atras);
		
		JLabel labcrear = new JLabel("A\u00F1adir Gasto");
		labcrear.setFont(new Font("Times New Roman", Font.BOLD, 22));
		labcrear.setBounds(25, 20, 330, 36);
		getContentPane().add(labcrear);
		
		JLabel lblCodigo = new JLabel("Cuenta de Gasto: ");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodigo.setBounds(25, 66, 148, 25);
		getContentPane().add(lblCodigo);
		
		JLabel lblConcepto = new JLabel("Concepto: ");
		lblConcepto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConcepto.setBounds(25, 101, 86, 25);
		getContentPane().add(lblConcepto);
		
		JLabel lblImporte = new JLabel("Importe:");
		lblImporte.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblImporte.setBounds(25, 148, 69, 25);
		getContentPane().add(lblImporte);
		
		JLabel lblEmplead = new JLabel("Emplead@:");
		lblEmplead.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmplead.setBounds(25, 183, 97, 25);
		getContentPane().add(lblEmplead);
			
		concepto_txt = new JTextField();
		concepto_txt.setBounds(121, 103, 116, 22);
		getContentPane().add(concepto_txt);
		concepto_txt.setColumns(10);
		
        cuenta_txt = new JComboBox();
        cuenta_txt.setModel(new DefaultComboBoxModel(new String[] {"Sueldos y Salarios", "Arrendamientos", "Reparaciones", "Primas  de seguros", "Suministros", "Compras material", "Servicios internos", "Publicidad"}));
        cuenta_txt.setBounds(167, 69, 141, 22);
		getContentPane().add(cuenta_txt);
		
		importe_txt = new JTextField();
		importe_txt.setBounds(121, 141, 116, 22);
		getContentPane().add(importe_txt);
		importe_txt.setColumns(10);
		
		empleado_txt = new JComboBox<String>();
		empleado_txt.setBounds(121, 186, 116, 22);
		getContentPane().add(empleado_txt);
		for(TEmpleado e: listaEmpleados) {
			empleado_txt.addItem(e.getNombre());
		}
		
		contabilizada = new JCheckBox("Marca para contabilizar gasto");
		contabilizada.setBounds(291, 183, 161, 25);
		getContentPane().add(contabilizada);
		
		cuenta_txt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!((String) cuenta_txt.getSelectedItem()).matches("Sueldos y Salarios")) {
					
					empleado_txt.setVisible(false);
					lblEmplead.setVisible(false);	
				}else {	
					empleado_txt.setVisible(true);
					lblEmplead.setVisible(true);	
				}	
			}
		});
			
		
		JButton boton_Crear = new JButton("Crear");
		boton_Crear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String empleado = "";
				if (((String) cuenta_txt.getSelectedItem()).matches("Sueldos y Salarios")) {
					empleado = (String) empleado_txt.getSelectedItem();
				}	
					if (importe_txt.getText().matches("[0-9]*")) {
						if (contabilizada.isSelected()) {
							boolContabilizada = true;
						}	
						numeroFactura = 1; 
						for(TGastos cod: listaGastos) {
							fac = String.valueOf(numeroFactura);  //pasamos de int a string
							if((cod.getnumeroFactura().equals(fac))) {
								numeroFactura++; 	
						     }	
						}
						fac = String.valueOf(numeroFactura);  //pasamos de int a string
						
						 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							fecha = sdf.format(new Date()); 
						SingletonControllerContabilidad.getInstance().añadirGasto(cuenta_txt.getSelectedItem().toString(), concepto_txt.getText(), importe_txt.getText(), fecha, empleado, boolContabilizada, fac,   getFrame());
					}
					else JOptionPane.showMessageDialog(atras, "El importe debe ser un número", "Error", JOptionPane.ERROR_MESSAGE);	
				
			}
		});
		boton_Crear.setBounds(266, 215, 97, 25);
		getContentPane().add(boton_Crear);
		
		setVisible(true);
	}
	
	private JFrame getFrame() {
		return this;
	}
	
	private void update(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	@Override
	public void onRegister(List<TGastos> listaGastos, List<TIngresos> listaIngresos, String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
	}
	@Override
	public void onCreate(List<TGastos> listaLimpieza, List<TIngresos> listaIngresos, String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
	}
	@Override
	public void onActualizar(List<TGastos> listaLimpieza, List<TIngresos> listaIngresos, String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
	}
}
