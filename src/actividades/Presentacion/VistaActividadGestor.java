package actividades.Presentacion;
import javax.swing.JButton;
import javax.swing.JFrame;

import actividades.Negocio.ActividadObserver;
import actividades.Negocio.TActividad;
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

public class VistaActividadGestor extends JFrame implements ActividadObserver{
	
	private JFrame atras;
	
	public VistaActividadGestor(JFrame frame) {
		setTitle("Menu Actividades");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,300);
		
		this.atras = frame;
		
		JButton boton_Atras = new JButton("Atras");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				atras.setVisible(true);
				//SingletonControllerActividad.getInstance().menuGestor();
			}
		});
		boton_Atras.setBounds(373, 215, 97, 25);
		getContentPane().add(boton_Atras);
		
		JButton boton_VerAct = new JButton("Ver Lista de Actividades");
		boton_VerAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerActividad.getInstance().mostrarListaActividadesGestor(getFrame());
			}
		});
		boton_VerAct.setFont(new Font("Tahoma", Font.PLAIN, 14));
		boton_VerAct.setBounds(149, 101, 201, 38);
		getContentPane().add(boton_VerAct);
		
		setVisible(true);
	}
	
	private JFrame getFrame() {
		return this;
	}
	
	

	@Override
	public void onRegister(List<TActividad> lista) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCreateActividad(List<TActividad> lista) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEliminarActividad(List<TActividad> lista) {
		// TODO Auto-generated method stub
		
	}
	


}


