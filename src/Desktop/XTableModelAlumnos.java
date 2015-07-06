package Desktop;



import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Entidades.Alumno;

//lucas  

public class XTableModelAlumnos extends AbstractTableModel {

ArrayList<Alumno> datasource;
	
	
	public ArrayList<Alumno> getDatasource() {
		return datasource;
	}

	public void setDatasource(ArrayList<Alumno> datasource) {
		this.datasource = datasource;
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
	    return true;
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 7;
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
			datasource.get(row).setDni(Integer.parseInt(value.toString()));
			break;
		case 1:
			datasource.get(row).setApellido(value.toString());
			break;
		case 2:
			datasource.get(row).setNombre(value.toString());
			break;
		case 3:
			datasource.get(row).setMail(value.toString());
			break;
		case 4:
			datasource.get(row).setIngreso_directo(value.toString());;
			break;
		case 5:
			datasource.get(row).setTurno_eleccion(value.toString());
			break;
		case 6:
			datasource.get(row).setNombre_Carrera(value.toString());
			break;
		default:
		
			break;
		}
        fireTableCellUpdated(row, col);
    }
	
	@Override
	public Object getValueAt(int arg0, int arg1) {
		Alumno al= datasource.get(arg0);
		Object o;
		switch (arg1) {
		case 0:
			o=al.getDni();
			break;
		case 1:
			o=al.getApellido();
			break;
		case 2:
			o=al.getNombre();
			break;
		case 3:
			o=al.getMail();
			break;
		case 4:
			o=al.getIngreso_directo();
			break;
		case 5:
			o=al.getTurno_eleccion();
			break;
		case 6:
			o=al.getNombre_Carrera();
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
			nom="Mail";
			break;
		case 4:
			nom="Ingreso Directo";
		    break;
		case 5:
			nom="Turno elección";
			break;
		case 6:
			nom="Carrera";
			break;
		default:
			nom="";
			break;
		}
		return nom;
		
	}

}

	
	

