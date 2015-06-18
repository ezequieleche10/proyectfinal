/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.*;



/**
 *
 * @author Lucia
 */
public class CatalogodeComisiones extends DBConexion_1{
	
	 private ResultSet resu;
    
   public int agregarComision (String nombre, String descripcion, int cod_examen)
   {
	  
       try 
        {
            this.Conectar();
            String insert="INSERT INTO comision (cod_examen, nombre, descripcion)VALUES(?,?,?)";
            PreparedStatement ins= Cone.prepareStatement(insert);
            ins.setInt(1,cod_examen);
            ins.setString(2,nombre);
            ins.setString(3, descripcion);
            ins.executeUpdate();
            String cons="SELECT MAX(cod_comision) as cod_comision from comision";
            PreparedStatement consul = Cone.prepareStatement(cons);
            resu = consul.executeQuery();
            resu.first();
            int codCo = resu.getInt("cod_comision" );
            this.Desconectar();
            return codCo;
            
        }
        catch (Exception ex)
        {
            System.err.println("SQLException: " + ex.getMessage());
            return 0;
            
                        
        }
       
       
   }
    
}
