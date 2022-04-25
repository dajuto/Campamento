package actividades.Negocio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ActividadTableModel extends AbstractTableModel implements ActividadObserver{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<TActividad> list;
	private String[] columnNames = {"Id", "Nombre", "Instalacion", "Monitor"};
	
	public ActividadTableModel() {
		list = new ArrayList<TActividad>();
		SingletonServiAppActividad.getInstance().addObserver(this);
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
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex == 0) {
			return list.get(rowIndex).getId();
		}
		else if(columnIndex == 1) {
			return list.get(rowIndex).getNombre();
		}
		else if(columnIndex == 2) {
			return list.get(rowIndex).getInstalacion();
		}
		else {
			return list.get(rowIndex).getMonitor();
		}
	}

	private void update(List<TActividad> lista) {
		this.list = lista;
		this.fireTableDataChanged();
	}
	
	@Override
	public void onRegister(List<TActividad> lista) {
		this.update(lista);
	}

	@Override
	public void onCreateActividad(List<TActividad> lista) {
		this.update(lista);
	}

	@Override
	public void onEliminarActividad(List<TActividad> lista) {
		this.update(lista);
	}

}
