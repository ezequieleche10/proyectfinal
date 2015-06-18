/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.Ejercicio;
import java.sql.ResultSet;

/**
 *
 * @author Lucia
 */
public class CatalogodeEjercicios extends DBConexion_1 {
    
    private ResultSet resu;
    
    public void agregarEjercicio(int cod_examen, Ejercicio ej) throws Exception
    {
        try 
        {
            getStmt();
            stmt.executeUpdate("INSERT INTO ejercicio (cod_examen, cod_ejercicio, nombre, descripcion, cant_items , porcentaje) VALUES ('"+cod_examen+"',NULL,'"+ej.getNombre()+"','"+ej.getDescripcion()+"','"+ej.getCant_items()+"','"+ej.getPorcentaje()+"')");
        }
        catch (Exception ex)
        {
            System.err.println("SQLException: " + ex.getMessage());            
        }
    }
    
    
}
