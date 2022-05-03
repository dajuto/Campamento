package contabilidad.Presentacion;

import javax.swing.JFrame;

import contabilidad.Negocio.ContabilidadObserver;
import contabilidad.Negocio.TGastos;
import contabilidad.Negocio.TIngresos;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

import acampados.Negocio.TAcampado;
import acampadosPresentacion.SingletonControllerAcampado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;

public class VistaContabilidadAcampado extends JFrame implements ContabilidadObserver{
	
	private static final long serialVersionUID = 1L;
	private JFrame atras;
	private String nombreUsuario = SingletonControllerContabilidad.getInstance().getAcampado();
	private boolean pagado;   
	List<TAcampado> listaAcampados;
	private String nombreCompleto;
	private String dniAcampado; 
	private int numeroFactura; 
	private String fac; 
	List<TIngresos> listaIngresos;
	private String fecha;
	JButton boton_Pagar; 
	
	
	public VistaContabilidadAcampado(JFrame frame) {
		
		listaIngresos = SingletonControllerContabilidad.getInstance().getListaIngresos();
		
		
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
		boton_Estado.setBounds(39, 100, 165, 38);
		getContentPane().add(boton_Estado);
		
		
		
		JButton boton_Pagar = new JButton("Pagar");
		boton_Pagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				exitAction();
			}
		});
		boton_Pagar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		boton_Pagar.setBounds(268, 100, 165, 38);
		getContentPane().add(boton_Pagar);
		

		listaAcampados = SingletonControllerAcampado.getInstance().getListaAcampados();
	
		for(TAcampado e: listaAcampados) {	
			if(e.getUsuario().equals(nombreUsuario)) {		
				pagado = e.isPagado(); 
				nombreCompleto = e.getNombreCompleto(); 
				dniAcampado = e.getDni(); 
				String nombre = e.getNombre(); 
				String apellido = e.getApellidos(); 
				int edad = e.getEdad(); 
				
			}
		}
	
	     if(pagado) { //si ha pagado el acampado, no puede darle al boton de pagar	
			boton_Pagar.setEnabled(false);
		}	
		
		this.setVisible(true);
	}
	

	public void exitAction(){
		Object[] options = {"Pagar", "Cancelar Pago"};
		  int sel = JOptionPane.showOptionDialog(this, "¿Está seguro que desea pagar el abono?", "Salir", JOptionPane.YES_NO_OPTION,
		  JOptionPane.WARNING_MESSAGE, null, options, null);
		  if(sel == 0) {
			  
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
			
			    SingletonControllerContabilidad.getInstance().añadirIngresoAcam("Ventas", "Abono acampado", "1200" ,fecha, nombreCompleto, dniAcampado, true, fac, atras);
			  
			    SingletonControllerAcampado.getInstance().cambiarIsPagado(true); 
			  
			   
				SingletonControllerContabilidad.getInstance().estadoCuentasAcampado(atras);
		  }if(sel == 1) {
			  
			  setVisible(true); 
		  }
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
