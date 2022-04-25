package actividades.Presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import actividades.Negocio.ActividadObserver;
import actividades.Negocio.ActividadTableModel;
import actividades.Negocio.TActividad;

public class VistaListaActividadesGestor extends JFrame implements ActividadObserver{
	private String nombreUsuario;
	private JButton anadirActividad;
	private JButton eliminarActividad;
	private JButton atras;
	private Frame ventanaAnterior;
	
	public VistaListaActividadesGestor(JFrame frame) {
		setTitle("Lista Actividades");
		SingletonControllerActividad.getInstance().addObserver(this);
		
		this.ventanaAnterior = frame;
		this.anadirActividad = new JButton("Anadir actividad");
		this.eliminarActividad = new JButton("Eliminar actividad");
		this.atras = new JButton("Atras");
		initGUI();
	}
	
	private Frame getFrame() {
		return this;
	}
	
	private void initGUI() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		this.setContentPane(mainPanel);
		mainPanel.add(new JLabel("Lista Actividades Gestor: " + nombreUsuario), BorderLayout.PAGE_START);
		
		JPanel centralPanel = new JPanel();
		centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
		
		JPanel actividadView = createViewPanel(new JTable(new ActividadTableModel()), "Actividad Gestor");
		actividadView.setPreferredSize(new Dimension(500, 400));
		centralPanel.add(actividadView);
		
		JPanel p = new JPanel(new GridLayout(1, 3));
		p.add(anadirActividad);
		this.anadirActividad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SingletonControllerActividad.getInstance().mostrarAnadirActividadGestor(getFrame());
			}
		});
		p.add(eliminarActividad);
		this.eliminarActividad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SingletonControllerActividad.getInstance().mostrarEliminarActividadGestor(getFrame());
			}
		});
		centralPanel.add(p);
		
		mainPanel.add(centralPanel);
		
		JPanel a = new JPanel(new GridLayout(1, 1));
		a.add(atras);
		this.atras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ventanaAnterior.setVisible(true);
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
    private JPanel createViewPanel(JComponent c, String title) {
		JPanel p = new JPanel( new BorderLayout() );
		p.add(new JScrollPane(c));
		return p;
	}

    private void update (String nombreUsuario) {
    	this.nombreUsuario=nombreUsuario;
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


