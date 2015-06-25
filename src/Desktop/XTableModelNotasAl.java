package Desktop;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Entidades.Alumno;
import Entidades.AlumnoEnEjercicio;

public class XTableModelNotasAl extends AbstractTableModel {

ArrayList<AlumnoEnEjercicio> datasource;
	
	
	public ArrayList<AlumnoEnEjercicio> getDatasource() {
		return datasource;
	}

	public void setDatasource(ArrayList<AlumnoEnEjercicio> datasource) {
		this.datasource = datasource;
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
	    return true;
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datasource.size();
	}
	
	public void setValueAt(Object value, int row, int col) {
        
		datasource.get(row);
	
		
		switch (col) {
		case 0:
			datasource.get(row).getEjer().setNombre(value.toString());
			break;
		case 1:
			datasource.get(row).getEjer().setCant_items(Integer.parseInt(value.toString()));
			break;
		case 2:
			datasource.get(row).getEjer().setPorcentaje(Integer.parseInt(value.toString()));
			break;
		case 3:
			datasource.get(row).setResultado(Integer.parseInt(value.toString()));
			break;
		case 4:
			datasource.get(row).setNota_parcial(Float.parseFloat(value.toString()));
			break;
		default:
		
			break;
		}
        fireTableCellUpdated(row, col);
    }
	
	@Override
	public Object getValueAt(int arg0, int arg1) {
		AlumnoEnEjercicio alej= datasource.get(arg0);
		Object o;
		switch (arg1) {
		case 0:
			o=alej.getEjer().getNombre();
			break;
		case 1:
			o=alej.getEjer().getCant_items();
			break;
		case 2:
			o=alej.getEjer().getPorcentaje();
			break;
		case 3:
			o=alej.getResultado();
			break;
		case 4:
			o=alej.getNota_parcial();
			break;
		default:
			o=null;
			break;
		}
		return o;
	}
	public String getColumnName( int column)
	{
		String nom="";
		switch (column) {
		case 0:
			nom="Nombre Ejercicio";
			break;
		case 1:
			nom="Items Totales";
			break;
		case 2:
			nom="Peso Ejercicio";
			break;
		case 3:
			nom="Items Correctos";
			break;	
		case 4:
			nom="Nota Parcial";
			break;
		
		default:
			nom="";
			break;
		}
		return nom;
		
	}

}

	
	

