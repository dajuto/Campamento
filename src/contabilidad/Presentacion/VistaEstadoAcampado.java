package contabilidad.Presentacion;

import javax.swing.JFrame;

import contabilidad.Negocio.ContabilidadObserver;
import contabilidad.Negocio.TGastos;
import contabilidad.Negocio.TIngresos;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;

import acampados.Negocio.TAcampado;
import acampadosPresentacion.SingletonControllerAcampado;

public class VistaEstadoAcampado extends JFrame implements ContabilidadObserver{
	
	private static final long serialVersionUID = 1L;
	private JFrame atras;
	private String nombreUsuario = SingletonControllerContabilidad.getInstance().getAcampado();
	private boolean pagado; 
	private String estado;
	List<TAcampado> listaAcampados;
	
	public VistaEstadoAcampado(JFrame frame) {
		
		listaAcampados = SingletonControllerAcampado.getInstance().getListaAcampados();
	
		
		for(TAcampado e: listaAcampados) {
			
			if(e.getUsuario().equals(nombreUsuario)) {
				
				pagado = e.isPagado(); 
			}
		}
		
	    if(pagado) {
			
			estado = "IMPORTE PAGADO"; 
		}else {
			estado = "IMPORTE NO PAGADO"; 
		}
	    
		JLabel lblNewLabel = new JLabel(estado);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(111, 29, 239, 42);
		getContentPane().add(lblNewLabel);
		
		setTitle("Estado de cuenta");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(513,300);
		
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
	
		JLabel lblImporte = new JLabel("Importe:  1200 euros ");
		lblImporte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblImporte.setBounds(38, 124, 142, 32);
		getContentPane().add(lblImporte);
		
		JLabel lblPeriodo = new JLabel("Periodo m\u00E1ximo de pago:  15 d\u00EDas antes del inicio del campamento. ");
		lblPeriodo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPeriodo.setBounds(38, 166, 451, 32);
		getContentPane().add(lblPeriodo);
		
		JLabel lblIbanBancarioHappycamp = new JLabel("IBAN Bancario HappyCamp: ES21 1465 0100 72 2030876293");
		lblIbanBancarioHappycamp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIbanBancarioHappycamp.setBounds(38, 82, 397, 32);
		getContentPane().add(lblIbanBancarioHappycamp);
		
		
		this.setVisible(true);
	}
	
	private JFrame getFrame() {
		return this;
	}
	
	private void update(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	   //actualizar lista gastos e ingresos con for
	}
	

	@Override
	public void onRegister(List<TGastos> listaGastos, List<TIngresos> listaIngresos, String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario); 	
	}

	@Override
	public void onCreate(List<TGastos> listaGastos, List<TIngresos> listaIngresos, String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
	}

	@Override
	public void onActualizar(List<TGastos> listaGastos, List<TIngresos> listaIngresos,String nombreUsuario) {	
			this.update(nombreUsuario);	
	}
}
