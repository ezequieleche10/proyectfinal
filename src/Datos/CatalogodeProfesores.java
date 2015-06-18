/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.Profesor;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucia
 */
public class CatalogodeProfesores  extends DBConexion_1 {
    private ResultSet resu;
    
    public void agregarProfesorEnComision(int cod_profesor, int cod_comision) throws Exception
    {
        try 
        {
            getStmt();
            stmt.executeUpdate("INSERT INTO profesor_en_comision (cod_profesor, cod_comision) VALUES ('"+cod_profesor+"','"+cod_comision+"')");
        }
        catch (Exception ex)
        {
            System.err.println("SQLException: " + ex.getMessage());            
        }
    }
    
    
     public ArrayList<Profesor> getAllProfesores() throws Exception
    {
        try 
        {
             ArrayList<Profesor> profes = new ArrayList<Profesor>();
            getStmt();
            resu = stmt.executeQuery("SELECT * FROM profesor");
            while(resu.next())
               {
                    
                    int cod_profesor = resu.getInt("cod_profesor" );
                    String nomPr = resu.getString("nombre");
                    String apePr = resu.getString("apellido");
                    
                    profes.add(new Profesor(cod_profesor,nomPr,apePr));
                    
                    
                    
               }
            return profes;
        }
        catch (Exception ex)
        {
            System.err.println("SQLException: " + ex.getMessage());
            return null;            
        }
    }
     public void agregarProfesor(String nombre, String apellido, String fec_Nac, String usu, String password) throws Exception
     {
         try 
         {
             getStmt();
             stmt.executeUpdate("INSERT INTO profesor (cod_profesor,nombre,apellido,fecha_Nac,usuario,clave) VALUES (0,'"+nombre+"','"+apellido+"','"+fec_Nac+"','"+usu+"','"+password+"')");
             JOptionPane.showMessageDialog(null,"Se agregó correctamente");
             this.Desconectar();
         }
         catch (Exception ex)
         {
             System.err.println("SQLException: " + ex.getMessage());            
         }
     }
}
