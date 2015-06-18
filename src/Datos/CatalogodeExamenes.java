/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import Datos.DBConexion_1;
import Entidades.Carrera;
import Entidades.Examen;

import java.sql.ResultSet;
import java.util.ArrayList;

import static java.lang.System.out;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.String;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucia
 */
public class CatalogodeExamenes extends DBConexion_1{
    
    private ResultSet resu;
    
    public CatalogodeExamenes()
            {
          
            }
    
    public Examen listarExamen(int cod_carrera, int anio) throws Exception
    {
        try 
        {   this.Conectar();
            String vsql="SELECT * FROM examen where cod_carrera=? and (estado = 'sin generar' or estado='alumnos cargados')";
            PreparedStatement consulta= Cone.prepareStatement(vsql);
            consulta.setInt(1, cod_carrera);
            resu = consulta.executeQuery();
            resu.first();
            int codEx = resu.getInt("cod_examen" );
            String tipoEx = resu.getString("tipo_examen");
            int anioEx = resu.getInt("anio");
            String esEx = resu.getString("estado");
            String desEx = resu.getString("descripcion");
            Examen ex = new Examen(codEx,tipoEx, anioEx, esEx, desEx);  
            this.Desconectar();
            return ex;
            
        }
        catch (Exception ex)
        {
            System.err.println("SQLException: " + ex.getMessage());
            return null;            
        }
       
    }
    
     public void agregarExamen(Examen e, int cod_carrera) throws Exception
    {
        try 
        {	this.Conectar();
        	String actu = "INSERT INTO examen (tipo_examen, anio, estado, cod_carrera, descripcion) VALUES (?,?,?,?,?)";
        	PreparedStatement inse = Cone.prepareStatement(actu);
            inse.setString(1, e.getTipo_examen());
            inse.setInt(2, e.getAnio());
            inse.setString(3, e.getEstado());
            inse.setInt(4, cod_carrera);
            inse.setString(5, e.getDescripcion());
        	inse.executeUpdate();
            this.Desconectar();
            JOptionPane.showMessageDialog(null, "Se agrego el examen correctamente");
        }
        catch (Exception ex)
        {
            System.err.println("SQLException: " + ex.getMessage());            
        }
        
    }
     
     public Examen buscarExamen(String tipo_examen, int anio) throws Exception
    {
        try 
        {	this.Conectar();
            String consult = "SELECT * FROM examen WHERE tipo_examen = ? AND año=?";
            PreparedStatement consulta= Cone.prepareStatement(consult);
            consulta.setString(1, tipo_examen);
            consulta.setInt(2, anio);
            resu = consulta.executeQuery();
            resu.first();
            int codEx = resu.getInt("cod_examen" );
            String tipoEx = resu.getString("tipo_examen");
            int anioEx = resu.getInt("anio");
            String esEx = resu.getString("estado");
            String desEx = resu.getString("descripcion");
            Examen ex = new Examen(tipoEx, anioEx, esEx, desEx);   
            this.Desconectar();
            return ex;
        }
        catch (Exception ex)
        {
            System.err.println("SQLException: " + ex.getMessage());
            return null;            
        }
    }
     
      public Examen buscaExamen(int cod_examen) throws Exception
    {
        try 
        {	this.Conectar();
	        PreparedStatement consulta= Cone.prepareStatement("SELECT * FROM examen WHERE cod_examen= ?");
	        consulta.setInt(1, cod_examen);
            resu = consulta.executeQuery();
            resu.first();
            int codEx = resu.getInt("cod_examen" );
            String tipoEx = resu.getString("tipo_examen");
            int anioEx = resu.getInt("anio");
            String esEx = resu.getString("estado");
            String desEx = resu.getString("descripcion");
            Examen ex = new Examen(codEx, tipoEx, anioEx, esEx, desEx);  
            this.Desconectar();
            return ex;
        }
        catch (Exception ex)
        {
            System.err.println("SQLException: " + ex.getMessage());
            return null;            
        }
    }
      
      public void cambiarEstado(int cod_examen, String estado) throws Exception
      {
         try
         {    this.Conectar();
         	  PreparedStatement upd = Cone.prepareStatement("UPDATE examen SET estado= ? WHERE cod_examen= ?");
         	  upd.setString(1, estado);
         	  upd.setInt(2, cod_examen);
              upd.executeUpdate();    
              this.Desconectar();
         }
         catch (Exception ex)
         {
             System.err.println("SQLException: " + ex.getMessage());
             
         }
        
          
      }
    
}
