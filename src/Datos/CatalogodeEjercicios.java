/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.Ejercicio;
import Entidades.Profesor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucia
 */
public class CatalogodeEjercicios extends DBConexion_1 {
    
    private ResultSet resu;
    
    public void agregarEjercicios(ArrayList<Ejercicio> ejercicios, int cod_examen) throws Exception
    {
        try 
        {   this.Conectar();
        	for (int i =0; i<ejercicios.size(); i++)
            {
        		PreparedStatement insert= Cone.prepareStatement("INSERT INTO ejercicio(cod_examen, nombre, descripcion, cant_items, porcentaje) VALUES(?,?,?,?,?)");
        		insert.setInt(1, cod_examen);
        		insert.setString(2, ejercicios.get(i).getNombre());
        		insert.setString(3, ejercicios.get(i).getDescripcion());
        		insert.setInt(4, ejercicios.get(i).getCant_items());
        		insert.setInt(5, ejercicios.get(i).getPorcentaje());
                insert.executeUpdate();
               }
            
            JOptionPane.showMessageDialog(null, "Ejercicios cargados correctamente!");
            this.Desconectar(); 
        	
        	
        	
        }
        catch (Exception ex)
        {
            System.err.println("SQLException: " + ex.getMessage());            
        }
    }

	public int buscarEjercicio(int cod_examen) {
		   
	    try {
	    	this.Conectar();
		    String consulta="SELECT COUNT(cod_ejercicio) as cantidad FROM ejercicio where cod_examen=?";
		    
			PreparedStatement cons= Cone.prepareStatement(consulta);
			cons.setInt(1, cod_examen);
			resu=cons.executeQuery();
			resu.first();
		    int canti = resu.getInt("cantidad" );
		    return canti;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	    
		
	}
    
    
    
    
}
