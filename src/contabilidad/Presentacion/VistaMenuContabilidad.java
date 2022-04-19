package contabilidad.Presentacion;

import javax.swing.JFrame;

import contabilidad.Negocio.ContabilidadObserver;
import contabilidad.Negocio.Gastos;
import contabilidad.Negocio.TGastos;
import contabilidad.Negocio.TIngresos;
<<<<<<< HEAD
=======
import gestoria.Presentacion.SingletonControllerGestoria;
>>>>>>> dc9ff1bf0eed17863b4fc8c4c14e9b1d793f2164

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class VistaMenuContabilidad extends JFrame implements ContabilidadObserver{
	
	private static final long serialVersionUID = 1L;
	private JFrame atras;
	private String nombreUsuario;
	
	public VistaMenuContabilidad(JFrame frame) {
		setTitle("Menú de contabilidad");
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
		
		JButton boton_Gastos = new JButton("Gastos");
		boton_Gastos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
<<<<<<< HEAD
				//SingletonControllerGestoria.getInstance().crearEmpleado(getFrame());
=======
				SingletonControllerContabilidad.getInstance().menuGastos(getFrame());
>>>>>>> dc9ff1bf0eed17863b4fc8c4c14e9b1d793f2164
			}
		});
		
		boton_Gastos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		boton_Gastos.setBounds(40, 70, 165, 38);
		getContentPane().add(boton_Gastos);
		
		JButton boton_Ingresos = new JButton("Ingresos");
		boton_Ingresos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
<<<<<<< HEAD
				//SingletonControllerGestoria.getInstance().crearEmpleado(getFrame());
=======
				SingletonControllerContabilidad.getInstance().menuIngresos(getFrame());
>>>>>>> dc9ff1bf0eed17863b4fc8c4c14e9b1d793f2164
			}
		});
		boton_Ingresos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		boton_Ingresos.setBounds(260, 70, 165, 38);
		getContentPane().add(boton_Ingresos);
		
		JButton boton_Rendimiento = new JButton("Rendimiento Neto");
		boton_Rendimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				//SingletonControllerGestoria.getInstance().crearEmpleado(getFrame());
			}
		});
		
		boton_Rendimiento.setFont(new Font("Tahoma", Font.PLAIN, 17));
		boton_Rendimiento.setBounds(148, 153, 172, 38);
		getContentPane().add(boton_Rendimiento);
		
		
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
	public void onCreate(List<TGastos> listaLimpieza, List<TIngresos> listaIngresos, String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
		
	}

	@Override
	public void onActualizar(List<Gastos> listaLimpieza, List<TIngresos> listaIngresos,String nombreUsuario) {	
			this.update(nombreUsuario);
		
	}
}
