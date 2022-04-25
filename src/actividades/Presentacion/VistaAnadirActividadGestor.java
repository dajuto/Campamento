package actividades.Presentacion;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import actividades.Negocio.ActividadObserver;
import actividades.Negocio.TActividad;

public class VistaAnadirActividadGestor extends JFrame implements ActividadObserver{
	private String nombreUsuario;
	private JButton aceptar;
	private JButton atras;
	private JLabel ingresaId;
	private JTextField id;
	private JLabel ingresaInstalacion;
	private JTextField instalacion;
	private JLabel ingresaNombre;
	private JTextField nombre;
	private JTextField monitor;
	private JLabel ingresaMonitor;
	//private JComboBox<TEmpleado> empleadoEncargado;
	//List<TEmpleado> listaEmpleadosMantenimiento;
	private Frame ventanaAnterior;

	public VistaAnadirActividadGestor(Frame f) {
		setTitle("Crear nueva actividad");
		this.ventanaAnterior = f;
		SingletonControllerActividad.getInstance().addObserver(this);
		this.nombreUsuario = nombreUsuario;
		//this.listaEmpleadosMantenimiento = listaEmpleadosMantenimiento;
		
		this.atras = new JButton("Atras");
		this.aceptar = new JButton("Aceptar");
		
		this.id = new JTextField(5);
		this.instalacion = new JTextField(30);
		this.nombre = new JTextField(50);
		this.monitor = new JTextField(20);
		//this.empleadoEncargado = new JComboBox<TEmpleado>();
		
		this.ingresaId = new JLabel("Id: ");
		this.ingresaNombre = new JLabel("Nombre: ");
		this.ingresaInstalacion = new JLabel("Instalacion: ");
		this.ingresaMonitor = new JLabel("Monitor: ");	
		
		initGUI();
	}

	private void initGUI() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		this.setContentPane(mainPanel);
		mainPanel.add(new JLabel("Anadir actividad Gestor: " + this.nombreUsuario), BorderLayout.PAGE_START);
		
		JPanel p = new JPanel(new GridLayout(4, 2));
		//ingresaUsuario.setBounds(30, 30, 200, 20);
		p.add(this.ingresaId);
		p.add(id);
		p.add(this.ingresaNombre);
		p.add(nombre);
		p.add(this.ingresaInstalacion);
		p.add(instalacion);
		p.add(this.ingresaMonitor);
		p.add(monitor);
		
		
		mainPanel.add(p);
		
		JPanel a = new JPanel(new GridLayout(2, 1));
		a.add(atras);
		this.atras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				//ventanaAnterior.setVisible(true); lo comento pq sigue visible cuando aparece este frame, por tanto no hace falta hacerlo visible cuando cierre este frame
			}
		});
		a.add(aceptar);
		this.aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerActividad.getInstance().anadirActividad(ventanaAnterior, id.getText(), nombre.getText(), instalacion.getText(), monitor.getText());
			}
		});
		mainPanel.add(a, BorderLayout.PAGE_END);
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		this.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {}

            @Override
            public void windowClosing(WindowEvent e) {
                quit();
            }

			@Override
            public void windowClosed(WindowEvent e) {}

            @Override
            public void windowIconified(WindowEvent e) {}

            @Override
            public void windowDeiconified(WindowEvent e) {}

            @Override
            public void windowActivated(WindowEvent e) {}

            @Override
            public void windowDeactivated(WindowEvent e) {}

        });
		
		this.pack();
		this.setVisible(true);
	}
	
	private void quit() {
    	int option = JOptionPane.showOptionDialog(this, "Are you sure you want to quit?", "quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 1); // el 1 es para q x defecto la opcion senalada sea NO
        if (option == 0) {
            System.exit(0);
        }
	}
	
	private void update(String nombreUsuario) {
		this.nombreUsuario=nombreUsuario;
	}

	@Override
	public void onRegister(List<TActividad> lista) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
	}

	@Override
	public void onCreateActividad(List<TActividad> lista) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);

	}

	@Override
	public void onEliminarActividad(List<TActividad> lista) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);

	}
}

