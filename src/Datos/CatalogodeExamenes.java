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
               // this.Conectar();
            }
    
    public Examen listarExamen(int cod_carrera, int anio) throws Exception
    {
        try 
        {
            getStmt();
            resu = stmt.executeQuery("select * from examen where cod_carrera = '"+cod_carrera+"' and (estado = 'sin generar' or estado='alumnos cargados')");
            resu.first();
            int codEx = resu.getInt("cod_examen" );
            String tipoEx = resu.getString("tipo_examen");
            int anioEx = resu.getInt("anio");
            String esEx = resu.getString("estado");
            String desEx = resu.getString("descripcion");
            Examen ex = new Examen(codEx,tipoEx, anioEx, esEx, desEx);  
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
        {
            getStmt();
            stmt.executeUpdate("INSERT INTO examen (cod_examen, tipo_examen, anio, estado, cod_carrera , descripcion) VALUES (NULL,'"+e.getTipo_examen()+"','"+e.getAnio()+"','"+e.getEstado()+"','"+cod_carrera+"','"+e.getDescripcion()+"')");
            JOptionPane.showMessageDialog(null, "El examen se agrego correctamente!");
            this.Desconectar();
        }
        catch (Exception ex)
        {
            System.err.println("SQLException: " + ex.getMessage());            
        }
    }
     
     public Examen buscarExamen(String tipo_examen, int anio) throws Exception
    {
        try 
        {
            getStmt();
            resu = stmt.executeQuery("SELECT * FROM examen WHERE tipo_examen= '"+tipo_examen+"' AND año = '"+anio+"'");
            resu.first();
            int codEx = resu.getInt("cod_examen" );
            String tipoEx = resu.getString("tipo_examen");
            int anioEx = resu.getInt("anio");
            String esEx = resu.getString("estado");
            String desEx = resu.getString("descripcion");
            Examen ex = new Examen(tipoEx, anioEx, esEx, desEx);       
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
        {
            getStmt();
            resu = stmt.executeQuery("SELECT * FROM examen WHERE cod_examen= '"+cod_examen+"'");
            resu.first();
            int codEx = resu.getInt("cod_examen" );
            String tipoEx = resu.getString("tipo_examen");
            int anioEx = resu.getInt("anio");
            String esEx = resu.getString("estado");
            String desEx = resu.getString("descripcion");
            Examen ex = new Examen(codEx, tipoEx, anioEx, esEx, desEx);       
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
         {
              getStmt();
              stmt.executeUpdate("update examen SET estado= '"+estado+"' WHERE cod_examen= '"+cod_examen+"'");    
         }
         catch (Exception ex)
         {
             System.err.println("SQLException: " + ex.getMessage());
             
         }

          
      }
    
}
