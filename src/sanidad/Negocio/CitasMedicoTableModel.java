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
	private List<TCita> listaCitas;
	private String[] columnNames = {"Codigo", "Acampado","Motivo", "Medico", "Atendido"};
	
	public CitasMedicoTableModel() {
		SingletonServiAppSanidad.getInstance().addObserver(this);
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}
	
	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex == 0) {
			return list.get(rowIndex).getCodigo();
		}
		else if(columnIndex == 1) {
			return list.get(rowIndex).getNombreAcampado();
		}
		else if(columnIndex == 2) {
			return list.get(rowIndex).getMotivo();
		}
		else if(columnIndex == 3) {
			return list.get(rowIndex).getNombremedico();
		}
		else {
			return list.get(rowIndex).getAtendido();
		}
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
