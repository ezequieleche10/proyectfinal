package Desktop;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Entidades.Alumno;
import Entidades.AlumnoEnEjercicio;

public class XTableModelNotas extends AbstractTableModel {

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
		return 4;
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
			datasource.get(row).getAlumno().setDni(Integer.parseInt(value.toString()));
			break;
		case 1:
			datasource.get(row).getAlumno().setApellido(value.toString());
			break;
		case 2:
			datasource.get(row).getAlumno().setNombre(value.toString());
			break;
		case 3:
			datasource.get(row).setResultado(Integer.parseInt(value.toString()));
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
			o=alej.getAlumno().getDni();
			break;
		case 1:
			o=alej.getAlumno().getApellido();
			break;
		case 2:
			o=alej.getAlumno().getNombre();
			break;
		case 3:
			o=alej.getResultado();
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
			nom="Dni";
			break;
		case 1:
			nom="Apellido";
			break;
		case 2:
			nom="Nombre";
			break;
		case 3:
			nom="Items aprobados";
			break;
	
		default:
			nom="";
			break;
		}
		return nom;
		
	}

}

	
	

