package contabilidad.Negocio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;


public class IngresosTableModel extends AbstractTableModel implements ContabilidadObserver {
	private static final long serialVersionUID = 1L;
	
		private List<TIngresos> list;
		private String[] columnNames = {"Estado", "Cuenta", "Concepto", "Importe","Fecha contable", "Acampado"};
		
		public IngresosTableModel() {
			list = new ArrayList<TIngresos>();
			SingletonServiAppContabilidad.getInstance().addObserver(this); 
		}
		
		@Override
		public int getColumnCount() {
			return columnNames.length;
		}
		@Override
		public int getRowCount() {
			return list.size();
		}	
		@Override
		public String getColumnName(int columnIndex) {
			return columnNames[columnIndex];
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			switch(columnIndex) {
			case 0: return list.get(rowIndex).isContabilizada(); 
			case 1: return list.get(rowIndex).getTipo();
			case 2:	return list.get(rowIndex).getConcepto();
			case 3: return list.get(rowIndex).getImporte();
			case 4: return list.get(rowIndex).getFecha();
			case 5: return list.get(rowIndex).getNombreAcampado();
			case 6: return list.get(rowIndex).getDniAcampado(); 
			default: return null;
			}
		}
		
		private void update(List<TIngresos> lista) {
			this.list = lista;
			this.fireTableDataChanged();
		}


		@Override
		public void onRegister(List<TGastos> listaGastos, List<TIngresos> listaIngresos, String nombreUsuario) {
			// TODO Auto-generated method stub
			this.update(listaIngresos);
		}

		@Override
		public void onCreate(List<TGastos> listaGastos, List<TIngresos> listaIngresos, String nombreUsuario) {
			// TODO Auto-generated method stub
			this.update(listaIngresos);
		}

		@Override
		public void onActualizar(List<TGastos> listaGastos, List<TIngresos> listaIngresos, String nombreUsuario) {
			// TODO Auto-generated method stub
			this.update(listaIngresos);
		}
		
}
