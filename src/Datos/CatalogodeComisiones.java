/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.*;
import java.sql.PreparedStatement;



/**
 *
 * @author Lucia
 */
public class CatalogodeComisiones extends DBConexion_1{
    
   public void agregarComision (int cod_comision, String nombre, String descripcion, int cod_examen)
   {
       try 
        {
            Connection conn=this.Conectar();
            String insert="INSERT INTO comision (cod_examen, cod_comision, nombre, descripcion)VALUES(?,?,?,?)";
            PreparedStatement ins= conn.prepareStatement(insert);
            ins.setInt(1,cod_examen);
            ins.setInt(2,cod_comision );
            ins.setString(3,nombre);
            ins.setString(4, descripcion);
            ins.executeUpdate();
        }
        catch (Exception ex)
        {
            System.err.println("SQLException: " + ex.getMessage());
                        
        }
   }
    
}
