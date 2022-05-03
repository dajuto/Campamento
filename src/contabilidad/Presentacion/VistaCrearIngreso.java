package contabilidad.Presentacion;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
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
import acampados.Negocio.TAcampado;
import contabilidad.Negocio.ContabilidadObserver;
import contabilidad.Negocio.TGastos;
import contabilidad.Negocio.TIngresos;

import javax.swing.DefaultComboBoxModel;

public class VistaCrearIngreso extends JFrame implements ContabilidadObserver{
	private JFrame atras;
	private String nombreUsuario;
	private JTextField concepto_txt; 
	private JTextField importe_txt;
	private JComboBox cuenta_txt; 
	List<TIngresos> listaIngresos;
	List<TAcampado> listaAcampados;
	private JCheckBox contabilizada;
	private boolean boolContabilizada = false;
	private String fecha;
	private String dniAcampado; 
	private int numeroFactura; 
	private String fac; 
	
	public VistaCrearIngreso(JFrame frame) {
		setTitle("Añadir un Ingreso");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,300);
		
		listaIngresos = SingletonControllerContabilidad.getInstance().getListaIngresos();
		//listaAcampados = SingletonControllerAcampado.getInstance().getListaAcampados();
		
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
		
		JLabel labcrear = new JLabel("A\u00F1adir Ingreso");
		labcrear.setFont(new Font("Times New Roman", Font.BOLD, 22));
		labcrear.setBounds(25, 17, 148, 36);
		getContentPane().add(labcrear);
		
		JLabel lblCodigo = new JLabel("Cuenta de Ingreso: ");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodigo.setBounds(25, 83, 148, 25);
		getContentPane().add(lblCodigo);
		
		JLabel lblConcepto = new JLabel("Concepto: ");
		lblConcepto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConcepto.setBounds(25, 121, 86, 25);
		getContentPane().add(lblConcepto);
		
		JLabel lblImporte = new JLabel("Importe:");
		lblImporte.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblImporte.setBounds(25, 156, 69, 25);
		getContentPane().add(lblImporte);
		
		 cuenta_txt = new JComboBox();
	     cuenta_txt.setModel(new DefaultComboBoxModel(new String[] {"Subvenciones, donaciones", "Ingreso por arrendamiento", "Ingresos financieros", "Ingresos gestión"}));
	     cuenta_txt.setBounds(185, 86, 148, 22);
	     getContentPane().add(cuenta_txt);
		
		concepto_txt = new JTextField();
		concepto_txt.setBounds(121, 125, 116, 22);
		getContentPane().add(concepto_txt);
		concepto_txt.setColumns(10);
		
		importe_txt = new JTextField();
		importe_txt.setBounds(110, 160, 116, 22);
		getContentPane().add(importe_txt);
		importe_txt.setColumns(10);	
		
		contabilizada = new JCheckBox("Marca para contabilizar ingreso");
		contabilizada.setBounds(280, 179, 169, 25);
		getContentPane().add(contabilizada);

			
		JButton boton_Crear = new JButton("Crear");
		boton_Crear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String acampado = " ";
				dniAcampado = " "; 
					if (importe_txt.getText().matches("[0-9]*")) {
						String cuenta = (String) cuenta_txt.getSelectedItem();	
							
						if (contabilizada.isSelected()) {
							boolContabilizada = true;
						}	
						
						numeroFactura = 1; 
						for(TIngresos cod: listaIngresos) {
							fac = String.valueOf(numeroFactura);  //pasamos de int a string
							if((cod.getnumeroFactura().equals(fac))) {
								numeroFactura++; 	
						     }	
						}
						fac = String.valueOf(numeroFactura);  //pasamos de int a string
						
						 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							fecha = sdf.format(new Date());
							
						SingletonControllerContabilidad.getInstance().añadirIngreso(cuenta, concepto_txt.getText(), importe_txt.getText(), fecha, acampado, dniAcampado, boolContabilizada , fac,  getFrame());
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