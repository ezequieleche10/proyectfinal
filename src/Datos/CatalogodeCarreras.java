/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import Datos.DBConexion_1;
import Entidades.Carrera;
import java.sql.ResultSet;
import java.util.ArrayList;
import static java.lang.System.out;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.String;

/**
 *
 * @author Lucia
 */
public class CatalogodeCarreras  extends DBConexion_1 {
    
    private ResultSet resu;
    
    public CatalogodeCarreras()
            {
                this.Conectar();
            }
    
    public Carrera buscarCarrera(int cod_carrera) throws Exception
    {
        try 
        {
            
            getStmt();
            resu = stmt.executeQuery("SELECT * FROM CARRERA WHERE cod_carrera = '"+cod_carrera+"'");
            int codCa = resu.getInt("cod_carrera" );
            String nomCa = resu.getString("nombre");
            String desCa = resu.getString("descripcion");
            Carrera ca = new Carrera(codCa, nomCa, desCa);       
            return ca;
        }
        catch (Exception ex)
        {
            System.err.println("SQLException: " + ex.getMessage());
            return null;            
        }
    }
    
     public ArrayList<Carrera> buscarCarreras() throws Exception
    {
        try 
        {
             ArrayList<Carrera> carreras = new ArrayList<Carrera>();
            getStmt();
            resu = stmt.executeQuery("SELECT * FROM CARRERA");
            while(resu.next())
               {
                    int codCa = resu.getInt("cod_carrera" );
                    String nomCa = resu.getString("nombre");
                    String desCa = resu.getString("descripcion");
                    Carrera ca = new Carrera(codCa, nomCa, desCa); 
                    carreras.add(ca); 
               }
            return carreras;
        }
        catch (Exception ex)
        {
            System.err.println("SQLException: " + ex.getMessage());
            return null;            
        }
    }
    
     public void agregarCarrera(String nombre, String descripcion) throws Exception
    {
        try 
        {
            getStmt();
            stmt.executeUpdate("INSERT INTO carrera (cod_carrera, nombre, descripcion) VALUES (NULL,'"+nombre+"','"+descripcion+"')");
        }
        catch (Exception ex)
        {
            System.err.println("SQLException: " + ex.getMessage());            
        }
    }
     
     
}

