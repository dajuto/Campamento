package launcher;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SuperVista extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public SuperVista() {
		super("Gestion de Campamento");
		this.subsEmpleado = new JButton("Empleados");
		this.subsEstudiante = new JButton("Acampados");
		//initGUI();
	}

	/**
	 * Create the frame.
	 */
	public SuperVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
