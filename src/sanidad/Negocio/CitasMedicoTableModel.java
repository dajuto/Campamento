package sanidad.Negocio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import empleados.Negocio.SingletonServiAppEmpleado;
import empleados.Negocio.TEmpleado;
import empleados.Negocio.TMedico;

public class CitasMedicoTableModel extends AbstractTableModel implements SanidadObserver{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<TCita> list;
	private String[] columnNames = {"Codigo", "Acampado","Motivo", "Medico", "Atendido"};
	private String nombreUsuario=SingletonServiAppEmpleado.getInstance().getNombreUsuario();
	private List<TEmpleado> listaEmpleados = SingletonServiAppEmpleado.getInstance().getListaEmpleados();
	private TMedico med;
	
	public CitasMedicoTableModel() {
		for (TEmpleado e: listaEmpleados) {
			if (e.getUsuario().equals(nombreUsuario)) {
				med = (TMedico) e;
			}
		}
		SingletonServiAppSanidad.getInstance().addObserver(this);
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}
	
	@Override
	public int getRowCount() {
		return med.getListaCitas().size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		for (TCita c: list) {
			if (med.getListaCitas().get(rowIndex).equals(c.getCodigo())) {
				if(columnIndex == 0) {
					return c.getCodigo();
				}
				else if(columnIndex == 1) {
					return c.getNombreAcampado();
				}
				else if(columnIndex == 2) {
					return c.getMotivo();
				}
				else if(columnIndex == 3) {
					return c.getNombremedico();
				}
				else {
					return c.getAtendido();
				}
			}
		}
		return null;
	}
	
	private void update(List<TCita> list) {		
		this.list = list;
		this.fireTableDataChanged();
	}

	@Override
	public void onRegister(List<TReceta> listaRecetas, List<TCita> listaCitas, List<TMedico> listaMedicos,
			String nombreUsuario) {
		// TODO Auto-generated method stub
				this.update(listaCitas);
		
	}



	@Override
	public void onEliminar(List<TReceta> listaRecetas, List<TCita> listaCitas, List<TMedico> listaMedicos,
			String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(listaCitas);
	}

	@Override
	public void onConsultar(List<TReceta> listaRecetas, List<TCita> listaCitas, List<TMedico> listaMedicos,
			String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(listaCitas);
	}

	@Override
	public void onCrear(List<TReceta> listaRecetas, List<TCita> listaCitas, List<TMedico> listaMedicos,
			String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(listaCitas);
	}

}
