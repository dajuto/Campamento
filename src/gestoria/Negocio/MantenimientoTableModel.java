package gestoria.Negocio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import empleados.Negocio.TEmpleadoLimpieza;


public class MantenimientoTableModel extends AbstractTableModel implements GestoriaObserver {
	private static final long serialVersionUID = 1L;
	
		private List<TMantenimiento> list;
		private String[] columnNames = {"Codigo", "Lugar","Coste", "Empleado", "Estado"};
		
		public MantenimientoTableModel() {
			list = new ArrayList<TMantenimiento>();
			SingletonServiAppGestoria.getInstance().addObserver(this);
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
			case 0: return list.get(rowIndex).getCodigo();
			case 1: return list.get(rowIndex).getLugar();
			case 2: return list.get(rowIndex).getCoste();
			case 3: return list.get(rowIndex).getEmpleado();
			case 4: return list.get(rowIndex).getEstado();
			default: return null;
			}
		}
		
		private void update(List<TMantenimiento> lista) {
			this.list = lista;
			this.fireTableDataChanged();
		}

		@Override
		public void onRegister(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
				List<TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza,
				String nombreUsuario) {
			// TODO Auto-generated method stub
			this.update(listaAverias);
		}

		@Override
		public void onCreate(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
				List<TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza,
				String nombreUsuario) {
			// TODO Auto-generated method stub
			this.update(listaAverias);
		}

		@Override
		public void onEliminar(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
				List<TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza,
				String nombreUsuario) {
			// TODO Auto-generated method stub
			this.update(listaAverias);
		}

		@Override
		public void onModificar(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
				List<TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza,
				String nombreUsuario) {
			// TODO Auto-generated method stub
			this.update(listaAverias);
		}

		
		

		
}
