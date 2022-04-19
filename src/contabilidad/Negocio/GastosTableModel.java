package contabilidad.Negocio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;


public class GastosTableModel extends AbstractTableModel implements ContabilidadObserver {
	private static final long serialVersionUID = 1L;
	
		private List<TGastos> list;
		private String[] columnNames = {"Cuenta", "Concepto", "Importe","Fecha de pago", "Empleado"};
		
		public GastosTableModel() {
			list = new ArrayList<TGastos>();
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
			case 0: return list.get(rowIndex).getTipo();
			case 1:	return list.get(rowIndex).getConcepto();
			case 2: return list.get(rowIndex).getImporte();
			case 3: return list.get(rowIndex).getFecha();
			case 4: return list.get(rowIndex).getNombre();
			default: return null;
			}
		}
		
		private void update(List<TGastos> lista) {
			this.list = lista;
			this.fireTableDataChanged();
		}


		@Override
		public void onRegister(List<TGastos> listaGastos, List<TIngresos> listaIngresos, String nombreUsuario) {
			// TODO Auto-generated method stub
			this.update(listaGastos);
		}

		@Override
		public void onCreate(List<TGastos> listaGastos, List<TIngresos> listaIngresos, String nombreUsuario) {
			// TODO Auto-generated method stub
			this.update(listaGastos);
		}

		@Override
		public void onActualizar(List<TGastos> listaGastos, List<TIngresos> listaIngresos, String nombreUsuario) {
			// TODO Auto-generated method stub
			this.update(listaGastos);
		}
		
}
