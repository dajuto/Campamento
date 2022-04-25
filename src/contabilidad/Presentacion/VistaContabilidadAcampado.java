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
import javax.swing.JPanel;

import acampados.Negocio.TAcampado;
import acampadosPresentacion.SingletonControllerAcampado;

import javax.swing.JLabel;
import java.awt.Color;

public class VistaContabilidadAcampado extends JFrame implements ContabilidadObserver{
	
	private static final long serialVersionUID = 1L;
	private JFrame atras;
	private String nombreUsuario = SingletonControllerContabilidad.getInstance().getAcampado();
	private boolean pagado;   
	List<TAcampado> listaAcampados;
	
	public VistaContabilidadAcampado(JFrame frame) {
		setTitle("Estado de cuentas");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,300);
		
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
		
		JButton boton_Estado = new JButton("Ver Estado");
		boton_Estado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerContabilidad.getInstance().menuVerEstado(getFrame());
			}
		});
			
		boton_Estado.setFont(new Font("Tahoma", Font.PLAIN, 17));
		boton_Estado.setBounds(40, 133, 165, 38);
		getContentPane().add(boton_Estado);
		
		JButton boton_Pagar = new JButton("Pagar");
		boton_Pagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				//SingletonControllerContabilidad.getInstance().menuIngresos(getFrame());
			}
		});
		boton_Pagar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		boton_Pagar.setBounds(261, 133, 165, 38);
		getContentPane().add(boton_Pagar);
		
		JPanel panel = new JPanel();
		panel.setBounds(53, 21, 363, 88);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Como acampado tiene la posibilidad de consultar el estado de sus cuentas. Es decir, ver si el abono del campamento est\u00E1 pagado o no lo est\u00E1. ");
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblNewLabel);
		

		listaAcampados = SingletonControllerAcampado.getInstance().getListaAcampados();
	
		for(TAcampado e: listaAcampados) {	
			if(e.getUsuario().equals(nombreUsuario)) {		
				pagado = e.isPagado(); 
			}
		}
	
	     if(pagado) { //si ha pagado el acampado, no puede darle al boton de pagar	
			boton_Pagar.setEnabled(false);
		}	
		
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
