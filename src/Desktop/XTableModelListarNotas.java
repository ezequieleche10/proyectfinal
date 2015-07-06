package Desktop;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Entidades.Alumno;
import Entidades.AlumnoEnEjercicio;
import Entidades.NotaExamenAlumno;

public class XTableModelListarNotas extends AbstractTableModel {

ArrayList<NotaExamenAlumno> datasource;
	
	
	public ArrayList<NotaExamenAlumno> getDatasource() {
		return datasource;
	}

	public void setDatasource(ArrayList<NotaExamenAlumno> datasource) {
		this.datasource = datasource;
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		if (column < 4) {
	            return false;
	        } else {
	       return true;
	        }
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
        
		//datasource.get(row);
	
		
		switch (col) {
		case 0:
			break;
		case 1:
			datasource.get(row).getAlumno().setDni(Integer.parseInt(value.toString()));
			break;
		case 2:
			datasource.get(row).getAlumno().setNombre(value.toString());
			break;
		case 3:
			datasource.get(row).getAlumno().setApellido(value.toString());
			break;
		case 4:
			datasource.get(row).setNota(Float.parseFloat(value.toString()));
			break;
	
		
		default:
		
			break;
		}
		
      //  fireTableCellUpdated(row, col);
		//  fireTableRowsUpdated(0, datasource.size());
    }
	
	@Override
	public Object getValueAt(int arg0, int arg1) {
		NotaExamenAlumno nea= datasource.get(arg0);
		Object o;
		switch (arg1) {
		case 0:
			o=nea.getAlumno().getDni();
			break;
		case 1:
			o=nea.getAlumno().getNombre();
			break;
		case 2:
			o=nea.getAlumno().getApellido();
			break;
		case 3:
			o=nea.getNota();
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
			nom="Nombre";
			break;
		case 2:
			nom="Apellido";
			break;
		case 3:
			nom="Nota";
			break;
		
		default:
			nom="";
			break;
		}
		return nom;
		
	}

}
